package com.zhonglv.benchmarking.service;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhonglv.benchmarking.common.ConstantType;
import com.zhonglv.benchmarking.common.Result;
import com.zhonglv.benchmarking.domain.entity.SeriesInfo;
import com.zhonglv.benchmarking.domain.entity.UserInfo;
import com.zhonglv.benchmarking.domain.entity.dto.UserDto;
import com.zhonglv.benchmarking.domain.entity.dto.UserInfoDto;
import com.zhonglv.benchmarking.domain.mapper.SeriesInfoMapper;
import com.zhonglv.benchmarking.domain.mapper.UserInfoMapper;
import com.zhonglv.benchmarking.service.impl.UserInfoService;
import com.zhonglv.benchmarking.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author yangj
 */
@Service
@Slf4j
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private SeriesInfoMapper seriesInfoMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * login
     *
     * @param userName username
     * @param password password
     * @return CommonResponse
     */
    @Override
    public Result<UserDto> login(String userName, String password) {
        LambdaQueryWrapper<UserInfo> userInfoWrapper = new LambdaQueryWrapper<>();
        userInfoWrapper.eq(UserInfo::getUserName, userName).last("limit 1");
        UserInfo userInfo = userInfoMapper.selectOne(userInfoWrapper);
        if (userInfo == null) {
            log.info("Username [{}] does not exist.", userName);
            return new Result<UserDto>().toInvalidParam("Username does not exist.");
        }
        // 密码是否正确
        if (!password.equals(userInfo.getPwd())) {
            log.info("[{}] wrong password.", userName);
            return new Result<UserDto>().toInvalidParam("Wrong password.");
        }
        // 查询用户信息和数据权限
        List<SeriesInfo> seriesInfoList = seriesInfoMapper.selectSeriesByGroupId(userInfo.getGroupId());
        Map<String, List<SeriesInfo>> listMap = seriesInfoList.stream().collect(Collectors.groupingBy(seriesInfo -> String.valueOf(seriesInfo.getSeriesType())));
        // 生成token
        String token = JwtUtils.generateToken(userInfo.getUserName());

        UserInfoDto userInfoDto = new UserInfoDto();
        BeanUtils.copyProperties(userInfo, userInfoDto);
        userInfoDto.setSeriesMap(listMap);

        // 设置redis
        stringRedisTemplate.opsForValue().set(ConstantType.TOKEN_KEY + token,
                JSONUtil.toJsonStr(userInfoDto), ConstantType.TOKEN_EXPIRE_MINUTES, TimeUnit.MINUTES);
        UserDto userDto = new UserDto()
                .setUserInfoDto(userInfoDto)
                .setToken(token);
        return new Result<UserDto>().toSuccess(userDto);
    }
}
