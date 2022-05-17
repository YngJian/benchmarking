package com.zhonglv.benchmarking.handler.excel.medium;

import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.single.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.MediumExcelPo;
import com.zhonglv.benchmarking.handler.excel.MediumExcelDataHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
public class BaoTou400Handler extends MediumExcelDataHandler {
    /**
     * 数据处理
     *
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    @Override
    public ExcelPo dataProcessing(MediumExcelPo mediumExcelPo, IndicatorsDto indicatorsDto) {
        if (StringUtils.isBlank(mediumExcelPo.getNumber())) {
            BeanUtils.copyProperties(indicatorsDto, mediumExcelPo);
            mediumExcelPo.setNumber(indicatorsDto.getINumber());
        }
        mediumExcelPo.setBaoTou400CompletionValue(indicatorsDto.getCompletionValue())
                .setBaoTou400SingleIndexCapabilityIndex(indicatorsDto.getSingleIndexCapabilityIndex())
                .setBaoTou400SeriesComprehensiveCapabilityIndex(indicatorsDto.getSeriesComprehensiveCapabilityIndex())
                .setBaoTou400ProcessComprehensiveCapabilityIndex(indicatorsDto.getProcessComprehensiveCapabilityIndex());
        return mediumExcelPo;
    }
}
