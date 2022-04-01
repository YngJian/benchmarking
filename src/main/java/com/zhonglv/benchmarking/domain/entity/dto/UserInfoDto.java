package com.zhonglv.benchmarking.domain.entity.dto;

import com.zhonglv.benchmarking.domain.entity.SeriesInfo;
import com.zhonglv.benchmarking.domain.entity.UserGroup;
import com.zhonglv.benchmarking.domain.entity.UserInfo;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yangj
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户信息表")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto extends UserInfo {
    private UserGroup userGroup;
    private List<SeriesInfo> seriesInfoList;
}
