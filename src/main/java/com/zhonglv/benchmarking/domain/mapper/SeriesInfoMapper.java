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
     * selectSeries
     *
     * @return List<SeriesInfo>
     */
    List<SeriesInfo> selectSeries();

    /**
     * selectIndicators
     *
     * @param seriesNames     seriesNames
     * @param indicatorsNames indicatorsNames
     * @param seriesType      seriesType
     * @param countYear       countYear
     * @param startTime       startTime
     * @param endTime         endTime
     * @return List<Indicators>
     */
    List<Indicators> selectIndicators(@Param("seriesNames") List<String> seriesNames,
                                      @Param("indicatorsNames") List<String> indicatorsNames,
                                      @Param("seriesType") String seriesType,
                                      @Param("countYear") String countYear,
                                      @Param("startTime") String startTime,
                                      @Param("endTime") String endTime);
}
