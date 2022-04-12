package com.zhonglv.benchmarking.common;

import com.zhonglv.benchmarking.domain.entity.po.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.LowExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.MediumExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.SuperExcelPo;
import org.apache.commons.compress.utils.Lists;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3>benchmarking</h3>
 * <p>CacheMap</p>
 *
 * @author : Yang Jian
 * @date : 2022/4/2 16:05
 */
public class CacheMap {
    public final static Map<String, String> MONTH_MAP = new HashMap<>();
    public final static Map<String, String> MODEL_MAP = new HashMap<>();
    public final static Map<String, String> GRADE_MAP = new HashMap<>();
    public final static Map<String, List<List<String>>> HEAD_MAP = new HashMap<>();
    public final static Map<String, Class<? extends ExcelPo>> EXCEL_WRITE_CLASS_MAP = new HashMap<>();

    static {
        MONTH_MAP.put("01", "一月");
        MONTH_MAP.put("02", "二月");
        MONTH_MAP.put("03", "三月");
        MONTH_MAP.put("04", "四月");
        MONTH_MAP.put("05", "五月");
        MONTH_MAP.put("06", "六月");
        MONTH_MAP.put("07", "七月");
        MONTH_MAP.put("08", "八月");
        MONTH_MAP.put("09", "九月");
        MONTH_MAP.put("10", "十月");
        MONTH_MAP.put("11", "十一月");
        MONTH_MAP.put("12", "十二月");

        MODEL_MAP.put(ConstantType.SUPER_SYSTEM, ConstantType.SUPER_SYSTEM_MODEL);
        MODEL_MAP.put(ConstantType.MEDIUM_SYSTEM, ConstantType.MEDIUM_SYSTEM_MODEL);
        MODEL_MAP.put(ConstantType.LOW_SYSTEM, ConstantType.LOW_SYSTEM_MODEL);

        GRADE_MAP.put(ConstantType.SUPER_EXCEL_PO, ConstantType.SUPER_SYSTEM);
        GRADE_MAP.put(ConstantType.MEDIUM_EXCEL_PO, ConstantType.MEDIUM_SYSTEM);
        GRADE_MAP.put(ConstantType.LOW_EXCEL_PO, ConstantType.LOW_SYSTEM);

        HEAD_MAP.put(ConstantType.SUPER_EXCEL_PO, superHead());
        HEAD_MAP.put(ConstantType.MEDIUM_EXCEL_PO, mediumHead());
        HEAD_MAP.put(ConstantType.LOW_EXCEL_PO, lowHead());

        EXCEL_WRITE_CLASS_MAP.put(ConstantType.SUPER_EXCEL_PO, SuperExcelPo.class);
        EXCEL_WRITE_CLASS_MAP.put(ConstantType.MEDIUM_EXCEL_PO, MediumExcelPo.class);
        EXCEL_WRITE_CLASS_MAP.put(ConstantType.LOW_EXCEL_PO, LowExcelPo.class);
    }

    private static List<List<String>> superHead() {
        List<List<String>> headTitles = Lists.newArrayList();
        String superSystem = ConstantType.SUPER_SYSTEM;
        commonHead(headTitles, superSystem);
        headTitles.add(Arrays.asList(superSystem, CompanyEnum.SHANG_XI_ZHONG_RUN_500.getName(), ConstantType.BENCHMARK_VALUE));
        headTitles.add(Arrays.asList(superSystem, CompanyEnum.HUA_YUN_500.getName(), ConstantType.COMPLETION_VALUE));
        headTitles.add(Arrays.asList(superSystem, CompanyEnum.HUA_YUN_500.getName(), ConstantType.SINGLE_INDEX));
        headTitles.add(Arrays.asList(superSystem, CompanyEnum.HUA_YUN_500.getName(), ConstantType.COMPREHENSIVE_INDEX));
        headTitles.add(Arrays.asList(superSystem, CompanyEnum.HUA_YUN_500.getName(), ConstantType.SERIES_INDEX));
        headTitles.add(Arrays.asList(superSystem, CompanyEnum.LIAN_CHENG_500.getName(), ConstantType.COMPLETION_VALUE));
        headTitles.add(Arrays.asList(superSystem, CompanyEnum.LIAN_CHENG_500.getName(), ConstantType.SINGLE_INDEX));
        headTitles.add(Arrays.asList(superSystem, CompanyEnum.LIAN_CHENG_500.getName(), ConstantType.COMPREHENSIVE_INDEX));
        headTitles.add(Arrays.asList(superSystem, CompanyEnum.LIAN_CHENG_500.getName(), ConstantType.SERIES_INDEX));
        return headTitles;
    }

    private static List<List<String>> mediumHead() {
        List<List<String>> headTitles = Lists.newArrayList();
        String mediumSystem = ConstantType.MEDIUM_SYSTEM;
        commonHead(headTitles, mediumSystem);
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.SHAN_XI_ER_300.getName(), ConstantType.BENCHMARK_VALUE));
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.BAO_TOU_400.getName(), ConstantType.COMPLETION_VALUE));
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.BAO_TOU_400.getName(), ConstantType.SINGLE_INDEX));
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.BAO_TOU_400.getName(), ConstantType.COMPREHENSIVE_INDEX));
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.BAO_TOU_400.getName(), ConstantType.SERIES_INDEX));
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.HUA_YUN_390.getName(), ConstantType.COMPLETION_VALUE));
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.HUA_YUN_390.getName(), ConstantType.SINGLE_INDEX));
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.HUA_YUN_390.getName(), ConstantType.COMPREHENSIVE_INDEX));
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.HUA_YUN_390.getName(), ConstantType.SERIES_INDEX));
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.LAN_ZHOU_375.getName(), ConstantType.COMPLETION_VALUE));
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.LAN_ZHOU_375.getName(), ConstantType.SINGLE_INDEX));
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.LAN_ZHOU_375.getName(), ConstantType.COMPREHENSIVE_INDEX));
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.LAN_ZHOU_375.getName(), ConstantType.SERIES_INDEX));
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.SHAN_XI_YI_300.getName(), ConstantType.COMPLETION_VALUE));
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.SHAN_XI_YI_300.getName(), ConstantType.SINGLE_INDEX));
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.SHAN_XI_YI_300.getName(), ConstantType.COMPREHENSIVE_INDEX));
        headTitles.add(Arrays.asList(mediumSystem, CompanyEnum.SHAN_XI_YI_300.getName(), ConstantType.SERIES_INDEX));
        return headTitles;
    }

    private static List<List<String>> lowHead() {
        List<List<String>> headTitles = Lists.newArrayList();
        String lowSystem = ConstantType.LOW_SYSTEM;
        commonHead(headTitles, lowSystem);
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.LIAN_CHENG_200.getName(), ConstantType.BENCHMARK_VALUE));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.BAO_TOU_240.getName(), ConstantType.COMPLETION_VALUE));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.BAO_TOU_240.getName(), ConstantType.SINGLE_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.BAO_TOU_240.getName(), ConstantType.COMPREHENSIVE_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.BAO_TOU_240.getName(), ConstantType.SERIES_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.BAO_TOU_200.getName(), ConstantType.COMPLETION_VALUE));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.BAO_TOU_200.getName(), ConstantType.SINGLE_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.BAO_TOU_200.getName(), ConstantType.COMPREHENSIVE_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.BAO_TOU_200.getName(), ConstantType.SERIES_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.LAN_ZHOU_200.getName(), ConstantType.COMPLETION_VALUE));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.LAN_ZHOU_200.getName(), ConstantType.SINGLE_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.LAN_ZHOU_200.getName(), ConstantType.COMPREHENSIVE_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.LAN_ZHOU_200.getName(), ConstantType.SERIES_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.QING_HAI_240.getName(), ConstantType.COMPLETION_VALUE));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.QING_HAI_240.getName(), ConstantType.SINGLE_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.QING_HAI_240.getName(), ConstantType.COMPREHENSIVE_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.QING_HAI_240.getName(), ConstantType.SERIES_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.QING_HAI_200.getName(), ConstantType.COMPLETION_VALUE));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.QING_HAI_200.getName(), ConstantType.SINGLE_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.QING_HAI_200.getName(), ConstantType.COMPREHENSIVE_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.QING_HAI_200.getName(), ConstantType.SERIES_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.QING_HAI_180.getName(), ConstantType.COMPLETION_VALUE));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.QING_HAI_180.getName(), ConstantType.SINGLE_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.QING_HAI_180.getName(), ConstantType.COMPREHENSIVE_INDEX));
        headTitles.add(Arrays.asList(lowSystem, CompanyEnum.QING_HAI_180.getName(), ConstantType.SERIES_INDEX));
        return headTitles;
    }

    private static void commonHead(List<List<String>> headTitles, String system) {
        headTitles.add(Arrays.asList(system, ConstantType.INDEX_SERIAL_NUMBER, ConstantType.INDEX_SERIAL_NUMBER));
        headTitles.add(Arrays.asList(system, ConstantType.PROCESS_CLASSIFICATION, ConstantType.PROCESS_CLASSIFICATION));
        headTitles.add(Arrays.asList(system, ConstantType.INDICATOR_CATEGORY, ConstantType.INDICATOR_CATEGORY));
        headTitles.add(Arrays.asList(system, ConstantType.INDEX, ConstantType.INDEX));
        headTitles.add(Arrays.asList(system, ConstantType.UNIT, ConstantType.UNIT));
        headTitles.add(Arrays.asList(system, ConstantType.INDEX_LEVEL, ConstantType.INDEX_LEVEL));
        headTitles.add(Arrays.asList(system, ConstantType.REFERENCE_VALUE, ConstantType.REFERENCE_VALUE));
    }

}
