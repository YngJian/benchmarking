package com.zhonglv.benchmarking.common;

/**
 * @author : Yang Jian
 * @date : 2021/7/4 0004 17:40
 */
public interface ConstantType {
    String JWT_SECRET = "VAYNeeXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9";

    String TOKEN_KEY = "token:";

    long TOKEN_EXPIRE_MINUTES = 30;

    String SUPER_EXCEL_PO = "1";

    String MEDIUM_EXCEL_PO = "2";

    String LOW_EXCEL_PO = "3";

    String SUPER_SYSTEM = "500kA指标体系";

    String MEDIUM_SYSTEM = "300-400kA指标体系";

    String LOW_SYSTEM = "240kA及以下指标体系";

    String SUPER_SYSTEM_MODEL = "山西中润500kA";

    String MEDIUM_SYSTEM_MODEL = "山西新材料电解二系列300kA";

    String LOW_SYSTEM_MODEL = "连城分公司200kA";

    String INDEX_SERIAL_NUMBER = "序号";

    String PROCESS_CLASSIFICATION = "工序分类";

    String INDICATOR_CATEGORY = "指标类别";

    String INDEX = "指标";

    String UNIT = "单位";

    String INDEX_LEVEL = "指标等级";

    String REFERENCE_VALUE = "2021年公司平均水平基准值";

    String BENCHMARK_VALUE = "标杆值";

    String COMPLETION_VALUE = "完成值";

    String STANDARD_DEVIATION = "标准差";

    String WEIGHTS = "权重";

    String SINGLE_INDEX = "单项指标能力指数";

    String COMPREHENSIVE_INDEX = "工序综合能力指数";

    String SERIES_INDEX = "系列综合能力指数";
}
