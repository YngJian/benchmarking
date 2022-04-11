package com.zhonglv.benchmarking.handler.excel.medium;

import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.MediumExcelPo;
import com.zhonglv.benchmarking.handler.excel.MediumExcelDataHandler;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
public class HuaYun390Handler extends MediumExcelDataHandler {
    /**
     * 数据处理
     *
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    @Override
    public ExcelPo dataProcessing(MediumExcelPo mediumExcelPo, IndicatorsDto indicatorsDto) {
        mediumExcelPo.setHuaYun390CompletionValue(indicatorsDto.getCompletionValue())
                .setHuaYun390SingleIndexCapabilityIndex(indicatorsDto.getSingleIndexCapabilityIndex())
                .setHuaYun390SeriesComprehensiveCapabilityIndex(indicatorsDto.getSeriesComprehensiveCapabilityIndex())
                .setHuaYun390ProcessComprehensiveCapabilityIndex(indicatorsDto.getProcessComprehensiveCapabilityIndex());
        return mediumExcelPo;
    }
}
