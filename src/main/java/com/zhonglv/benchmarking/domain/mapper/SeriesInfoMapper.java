package com.zhonglv.benchmarking.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhonglv.benchmarking.domain.entity.Indicators;
import com.zhonglv.benchmarking.domain.entity.SeriesInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author yangj
 */
@Mapper
public interface SeriesInfoMapper extends BaseMapper<SeriesInfo> {

    /**
     * selectSeriesByGroupId
     *
     * @param groupId groupId
     * @return List<SeriesInfo>
     */
    List<SeriesInfo> selectSeriesByGroupId(@Param("groupId") Long groupId);

    /**
     * selectIndicators
     *
     * @param seriesNames seriesNames
     * @return List<Indicators>
     */
    List<Indicators> selectIndicators(@Param("seriesNames") List<String> seriesNames);
}
