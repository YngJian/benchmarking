package com.zhonglv.benchmarking.handler.excel;

import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.zhonglv.benchmarking.common.CacheMap;
import com.zhonglv.benchmarking.common.CompanyEnum;
import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.MediumMonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.MonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.MediumExcelPo;
import com.zhonglv.benchmarking.utils.ExcelFillRowMergeStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
@Slf4j
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
     * @param indicesMap  indicesMap
     * @param excelPoList excelPoList
     */
    @Override
    public void assemblyMonthExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<MonthExcelPo> excelPoList) {
        Map<String, MediumMonthExcelPo> monthExcelPoMap = new LinkedHashMap<>(128);
        for (Map<String, List<IndicatorsDto>> value : indicesMap.values()) {
            for (Map.Entry<String, List<IndicatorsDto>> stringListEntry : value.entrySet()) {
                for (int i = 0; i < stringListEntry.getValue().size(); i++) {
                    IndicatorsDto indicatorsDto = stringListEntry.getValue().get(i);
                    String iNumber = indicatorsDto.getINumber();
                    MediumMonthExcelPo mediumMonthExcelPo = monthExcelPoMap.get(iNumber);
                    if (mediumMonthExcelPo == null) {
                        mediumMonthExcelPo = new MediumMonthExcelPo();
                        dataProcessing(stringListEntry.getKey(), mediumMonthExcelPo, indicatorsDto);
                        monthExcelPoMap.put(iNumber, mediumMonthExcelPo);
                    } else {
                        dataProcessing(stringListEntry.getKey(), mediumMonthExcelPo, indicatorsDto);
                    }
                }
            }
        }
        excelPoList.addAll(monthExcelPoMap.values());
    }

    /**
     * 数据处理
     *
     * @param mediumMonthExcelPo mediumMonthExcelPo
     * @param indicatorsDto      indicatorsDto
     * @return ExcelPo ExcelPo
     */
    @Override
    public MonthExcelPo dataProcessing(String companyName, MediumMonthExcelPo mediumMonthExcelPo, IndicatorsDto indicatorsDto) {
        if (StringUtils.isBlank(mediumMonthExcelPo.getNumber())) {
            BeanUtils.copyProperties(indicatorsDto, mediumMonthExcelPo);
            mediumMonthExcelPo.setNumber(indicatorsDto.getINumber());
        }
        try {
            Method method = mediumMonthExcelPo.getClass().getDeclaredMethod("set" + CompanyEnum.getCapitalName(companyName)
                    + "accumulative", String.class);
            method.invoke(mediumMonthExcelPo, indicatorsDto.getAccumulation() == null ? "" : indicatorsDto.getAccumulation().toString());

            Method method1 = mediumMonthExcelPo.getClass().getDeclaredMethod("set" + CompanyEnum.getCapitalName(companyName)
                            + indicatorsDto.getMonth(),
                    String.class);
            method1.invoke(mediumMonthExcelPo, indicatorsDto.getCompletionValue());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            log.error(e.getMessage(), e);
        }
        return mediumMonthExcelPo;
    }

    @Override
    public Set<String> excludeHead(Set<String> excludeHeads, Set<String> months) {
        // 根据用户传入字段 假设我们只要导出 date
        Set<String> keySet = CacheMap.MONTH_MAP.keySet();
        Set<String> strings = new HashSet<>(keySet);
        strings.removeAll(months);

        strings.forEach(month -> {
            excludeHeads.add(CompanyEnum.SHAN_XI_ER_300.getShortName() + month);
            excludeHeads.add(CompanyEnum.LAN_ZHOU_375.getShortName() + month);
            excludeHeads.add(CompanyEnum.BAO_TOU_400.getShortName() + month);
            excludeHeads.add(CompanyEnum.HUA_YUN_390.getShortName() + month);
        });

        return excludeHeads;
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
