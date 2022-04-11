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
public class LanZhou375Handler extends MediumExcelDataHandler {
    /**
     * 数据处理
     *
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    @Override
    public ExcelPo dataProcessing(MediumExcelPo mediumExcelPo, IndicatorsDto indicatorsDto) {
        mediumExcelPo.setLanZhou375CompletionValue(indicatorsDto.getCompletionValue())
                .setLanZhou375SingleIndexCapabilityIndex(indicatorsDto.getSingleIndexCapabilityIndex())
                .setLanZhou375SeriesComprehensiveCapabilityIndex(indicatorsDto.getSeriesComprehensiveCapabilityIndex())
                .setLanZhou375ProcessComprehensiveCapabilityIndex(indicatorsDto.getProcessComprehensiveCapabilityIndex());
        return mediumExcelPo;
    }
}
