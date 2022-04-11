package com.zhonglv.benchmarking.handler.excel;

import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.LowExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.MediumExcelPo;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
public class MediumExcelDefaultDataHandler extends MediumExcelDataHandler {
    /**
     * 数据处理
     *
     * @param indicesMap  indicesMap
     * @param excelPoList excelPoList
     */
    @Override
    public void assemblySuperExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<ExcelPo> excelPoList) {
        Map<String, MediumExcelPo> mediumExcelPoMap = new HashMap<>();
        for (Map<String, List<IndicatorsDto>> value : indicesMap.values()) {
            for (Map.Entry<String, List<IndicatorsDto>> stringListEntry : value.entrySet()) {
                for (int i = 0; i < stringListEntry.getValue().size(); i++) {
                    MediumExcelPo mediumExcelPo = new MediumExcelPo();
                    IndicatorsDto indicatorsDto = stringListEntry.getValue().get(i);
                    String iNumber = indicatorsDto.getINumber();
                    if (!mediumExcelPoMap.containsKey(iNumber)) {
                        assemblyData(stringListEntry.getKey(), mediumExcelPo, indicatorsDto);
                        mediumExcelPoMap.put(iNumber, mediumExcelPo);
                    }else {
                        mediumExcelPo = mediumExcelPoMap.get(iNumber);
                        assemblyData(stringListEntry.getKey(), mediumExcelPo, indicatorsDto);
                    }
                    if (StringUtils.isNotBlank(mediumExcelPo.getNumber())) {
                        excelPoList.add(mediumExcelPo);
                    }
                }
            }
        }
    }

    /**
     * 组装数据处理
     *
     * @param companyName   companyName
     * @param mediumExcelPo mediumExcelPo
     * @param indicatorsDto indicatorsDto
     */
    public static void assemblyData(String companyName, MediumExcelPo mediumExcelPo, IndicatorsDto indicatorsDto) {
        Optional<ExcelDataHandler> excelDataHandler = ExcelHandleFactory.getByCompanyName(companyName);
        if (!excelDataHandler.isPresent()) {
            return;
        }
        excelDataHandler.get().dataProcessing(mediumExcelPo, indicatorsDto);
    }
}
