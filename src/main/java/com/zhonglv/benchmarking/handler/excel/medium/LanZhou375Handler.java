package com.zhonglv.benchmarking.handler.excel.medium;

import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.single.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.MediumExcelPo;
import com.zhonglv.benchmarking.handler.excel.MediumExcelDataHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
@Slf4j
public class LanZhou375Handler extends MediumExcelDataHandler {
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
        mediumExcelPo.setLanZhou375CompletionValue(indicatorsDto.getCompletionValue())
                .setLanZhou375SingleIndexCapabilityIndex(indicatorsDto.getSingleIndexCapabilityIndex())
                .setLanZhou375SeriesComprehensiveCapabilityIndex(indicatorsDto.getSeriesComprehensiveCapabilityIndex())
                .setLanZhou375ProcessComprehensiveCapabilityIndex(indicatorsDto.getProcessComprehensiveCapabilityIndex());
        return mediumExcelPo;
    }
}
