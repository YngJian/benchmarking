package com.zhonglv.benchmarking.handler.excel;

import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.single.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.MediumExcelPo;
import com.zhonglv.benchmarking.utils.ExcelFillRowMergeStrategy;

import java.util.LinkedHashMap;
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
    public void assemblyExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<ExcelPo> excelPoList) {
        Map<String, MediumExcelPo> mediumExcelPoMap = new LinkedHashMap<>(128);
        for (Map<String, List<IndicatorsDto>> value : indicesMap.values()) {
            for (Map.Entry<String, List<IndicatorsDto>> stringListEntry : value.entrySet()) {
                for (int i = 0; i < stringListEntry.getValue().size(); i++) {
                    IndicatorsDto indicatorsDto = stringListEntry.getValue().get(i);
                    String iNumber = indicatorsDto.getINumber();
                    MediumExcelPo mediumExcelPo = mediumExcelPoMap.get(iNumber);
                    if (mediumExcelPo == null) {
                        mediumExcelPo = new MediumExcelPo();
                        assemblyData(stringListEntry.getKey(), mediumExcelPo, indicatorsDto);
                        mediumExcelPoMap.put(iNumber, mediumExcelPo);
                    } else {
                        assemblyData(stringListEntry.getKey(), mediumExcelPo, indicatorsDto);
                    }
                }
            }
        }
        excelPoList.addAll(mediumExcelPoMap.values());
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

    /**
     * 数据处理
     *
     * @param write write
     */
    @Override
    public void writeExcelHandle(ExcelWriterBuilder write) {
        int[] integers = {11, 15, 19, 23};
        SuperExcelDefaultDataHandler.registerHandler(write, integers);

        write.registerWriteHandler(new ExcelFillRowMergeStrategy(3, 18));
        write.registerWriteHandler(new ExcelFillRowMergeStrategy(3, 22));
    }
}
