package com.zhonglv.benchmarking.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhonglv.benchmarking.common.ConstantType;
import com.zhonglv.benchmarking.common.Result;
import com.zhonglv.benchmarking.domain.entity.SeriesInfo;
import com.zhonglv.benchmarking.domain.entity.UserInfo;
import com.zhonglv.benchmarking.domain.entity.dto.LoginDto;
import com.zhonglv.benchmarking.domain.entity.dto.UserDto;
import com.zhonglv.benchmarking.domain.entity.dto.UserInfoDto;
import com.zhonglv.benchmarking.domain.mapper.SeriesInfoMapper;
import com.zhonglv.benchmarking.domain.mapper.UserInfoMapper;
import com.zhonglv.benchmarking.service.UserInfoService;
import com.zhonglv.benchmarking.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        // ??????????????????
        if (!password.equals(userInfo.getPwd())) {
            log.info("[{}] wrong password.", userName);
            return new Result<UserDto>().toInvalidParam("Wrong password.");
        }
        // ?????????????????????????????????
        List<SeriesInfo> seriesInfoList = seriesInfoMapper.selectSeries();
        Map<String, List<SeriesInfo>> listMap = seriesInfoList.stream().collect(Collectors.groupingBy(seriesInfo -> String.valueOf(seriesInfo.getSeriesType())));
        // ??????token
        String token = JwtUtils.generateToken(String.valueOf(userInfo.getId()));

        UserInfoDto userInfoDto = new UserInfoDto();
        BeanUtils.copyProperties(userInfo, userInfoDto);
        userInfoDto.setSeriesMap(listMap);

        // ??????redis
        stringRedisTemplate.opsForValue().set(ConstantType.TOKEN_KEY + token,
                JSONUtil.toJsonStr(userInfoDto), ConstantType.TOKEN_EXPIRE_MINUTES, TimeUnit.MINUTES);
        UserDto userDto = new UserDto()
                .setUserInfoDto(userInfoDto)
                .setToken(token);
        return new Result<UserDto>().toSuccess(userDto);
    }

    /**
     * changePassword
     *
     * @param token    token
     * @param loginDto loginDto
     * @return Result
     */
    @Override
    public Result<Object> changePassword(String token, LoginDto loginDto) {
        Claims claims = JwtUtils.getClaimsByToken(token);
        if (claims == null) {
            log.info("Your login has expired, please log in again! token: {}", token);
            return new Result<>().toFailed("Your login has expired, please log in again!");
        }

        String id = claims.getSubject();
        UserInfo userInfo = userInfoMapper.selectById(Long.valueOf(id));
        String pwd = userInfo.getPwd();
        String password = loginDto.getPassword();
        if (password.equals(pwd)) {
            log.info("The password cannot be the same before and after the modification! token: {}", token);
            return new Result<>().toFailed("The password cannot be the same before and after the modification!");
        }

        UserInfo user = UserInfo.builder()
                .id(Long.valueOf(id))
                .pwd(password)
                .updateTime(new Date())
                .build();
        userInfoMapper.updateById(user);
        stringRedisTemplate.delete(ConstantType.TOKEN_KEY + token);

        return new Result<>().toSuccess();
    }
}
