package com.zhonglv.benchmarking.handler.excel;

import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.LowExcelPo;
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
public class LowExcelDefaultDataHandler extends LowExcelDataHandler {
    /**
     * 数据处理
     *
     * @param indicesMap  indicesMap
     * @param excelPoList excelPoList
     */
    @Override
    public void assemblySuperExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<ExcelPo> excelPoList) {
        Map<String, LowExcelPo> lowExcelPoMap = new HashMap<>();
        for (Map<String, List<IndicatorsDto>> value : indicesMap.values()) {
            for (Map.Entry<String, List<IndicatorsDto>> stringListEntry : value.entrySet()) {
                for (int i = 0; i < stringListEntry.getValue().size(); i++) {
                    LowExcelPo lowExcelPo = new LowExcelPo();
                    IndicatorsDto indicatorsDto = stringListEntry.getValue().get(i);
                    String iNumber = indicatorsDto.getINumber();
                    if (!lowExcelPoMap.containsKey(iNumber)) {
                        assemblyData(stringListEntry.getKey(), lowExcelPo, indicatorsDto);
                        lowExcelPoMap.put(iNumber, lowExcelPo);
                    }else {
                        lowExcelPo = lowExcelPoMap.get(iNumber);
                        assemblyData(stringListEntry.getKey(), lowExcelPo, indicatorsDto);
                    }
                    if (StringUtils.isNotBlank(lowExcelPo.getNumber())) {
                        excelPoList.add(lowExcelPo);
                    }
                }
            }
        }
    }

    /**
     * 组装数据处理
     *
     * @param companyName   companyName
     * @param lowExcelPo    lowExcelPo
     * @param indicatorsDto indicatorsDto
     */
    public static void assemblyData(String companyName, LowExcelPo lowExcelPo, IndicatorsDto indicatorsDto) {
        Optional<ExcelDataHandler> excelDataHandler = ExcelHandleFactory.getByCompanyName(companyName);
        if (!excelDataHandler.isPresent()) {
            return;
        }
        excelDataHandler.get().dataProcessing(lowExcelPo, indicatorsDto);
    }
}
