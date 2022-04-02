package com.zhonglv.benchmarking.common;

import java.util.HashMap;
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

        MODEL_MAP.put("500kA指标体系","山西中润500kA");
        MODEL_MAP.put("300-400kA指标体系","山西新材料300kA");
        MODEL_MAP.put("240kA及以下指标体系","连城分公司200kA");
    }

}
