package com.zhonglv.benchmarking.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhonglv.benchmarking.domain.entity.Indicators;
import com.zhonglv.benchmarking.domain.entity.SeriesInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * @param startTime startTime
     * @param endTime endTime
     * @return List<Indicators>
     */
    List<Indicators> selectIndicators(@Param("seriesNames") List<String> seriesNames,
                                      @Param("startTime") String startTime,
                                      @Param("endTime")  String endTime);
}
