package com.zhonglv.benchmarking.handler.excel;

import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.LowExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.MediumExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.SuperExcelPo;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
public interface ExcelDataHandler {
    /**
     * 数据处理
     *
     * @param superExcelDto superExcelDto
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    default ExcelPo dataProcessing(SuperExcelPo superExcelDto, IndicatorsDto indicatorsDto) {
        return superExcelDto;
    }

    /**
     * 数据处理
     *
     * @param mediumExcelPo mediumExcelPo
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    default ExcelPo dataProcessing(MediumExcelPo mediumExcelPo, IndicatorsDto indicatorsDto) {
        return mediumExcelPo;
    }

    /**
     * 数据处理
     *
     * @param lowExcelPo    lowExcelPo
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    default ExcelPo dataProcessing(LowExcelPo lowExcelPo, IndicatorsDto indicatorsDto) {
        return lowExcelPo;
    }

    /**
     * 数据处理
     *
     * @param indicesMap  indicesMap
     * @param excelPoList excelPoList
     */
    void assemblySuperExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<ExcelPo> excelPoList);

    /**
     * 数据处理
     *
     * @param write write
     */
    void writeExcelHandle(ExcelWriterBuilder write);
}
