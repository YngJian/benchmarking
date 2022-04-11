package com.zhonglv.benchmarking.handler.excel;

import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.MediumExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.SuperExcelPo;
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
public class SuperExcelDefaultDataHandler extends SuperExcelDataHandler {
    /**
     * 数据处理
     *
     * @param indicesMap  indicesMap
     * @param excelPoList excelPoList
     */
    @Override
    public void assemblySuperExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<ExcelPo> excelPoList) {
        Map<String, SuperExcelPo> superExcelPoMap = new HashMap<>();
        for (Map<String, List<IndicatorsDto>> value : indicesMap.values()) {
            for (Map.Entry<String, List<IndicatorsDto>> stringListEntry : value.entrySet()) {
                for (int i = 0; i < stringListEntry.getValue().size(); i++) {
                    SuperExcelPo superExcelPo = new SuperExcelPo();
                    IndicatorsDto indicatorsDto = stringListEntry.getValue().get(i);
                    String iNumber = indicatorsDto.getINumber();
                    if (!superExcelPoMap.containsKey(iNumber)) {
                        assemblyData(stringListEntry.getKey(), superExcelPo, indicatorsDto);
                        superExcelPoMap.put(iNumber, superExcelPo);
                    }else {
                        superExcelPo = superExcelPoMap.get(iNumber);
                        assemblyData(stringListEntry.getKey(), superExcelPo, indicatorsDto);
                    }
                    if (StringUtils.isNotBlank(superExcelPo.getNumber())) {
                        excelPoList.add(superExcelPo);
                    }
                }
            }
        }
    }

    /**
     * 组装数据处理
     *
     * @param companyName   companyName
     * @param superExcelPo  superExcelPo
     * @param indicatorsDto indicatorsDto
     */
    public static void assemblyData(String companyName, SuperExcelPo superExcelPo, IndicatorsDto indicatorsDto) {
        Optional<ExcelDataHandler> excelDataHandler = ExcelHandleFactory.getByCompanyName(companyName);
        if (!excelDataHandler.isPresent()) {
            return;
        }
        excelDataHandler.get().dataProcessing(superExcelPo, indicatorsDto);
    }
}
