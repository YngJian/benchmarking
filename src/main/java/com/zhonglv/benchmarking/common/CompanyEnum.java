package com.zhonglv.benchmarking.common;

import lombok.Getter;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 15:48
 */
@Getter
public enum CompanyEnum {
    /**
     * 连城分公司500kA
     */
    LIAN_CHENG_500("连城分公司500kA"),
    /**
     * 山西中润500kA
     */
    SHANG_XI_ZHONG_RUN_500("山西中润500kA"),
    /**
     * 内蒙古华云500kA
     */
    HUA_YUN_500("内蒙古华云500kA"),
    /**
     * 山西新材料电解二系列300kA
     */
    SHAN_XI_ER_300("山西新材料电解二系列300kA"),
    /**
     * 包头铝业400kA
     */
    BAO_TOU_400("包头铝业400kA"),
    /**
     * 内蒙古华云390kA
     */
    HUA_YUN_390("内蒙古华云390kA"),
    /**
     * 兰州分公司375kA
     */
    LAN_ZHOU_375("兰州分公司375kA"),
    /**
     * 内蒙古华云500kA
     */
    SHAN_XI_YI_300("山西新材料电解一系列300kA"),
    /**
     * 连城分公司200kA
     */
    LIAN_CHENG_200("连城分公司200kA"),
    /**
     * 包头铝业240kA
     */
    BAO_TOU_240("包头铝业240kA"),
    /**
     * 包头铝业200kA
     */
    BAO_TOU_200("包头铝业200kA"),
    /**
     * 兰州分公司200kA
     */
    LAN_ZHOU_200("兰州分公司200kA"),
    /**
     * 青海分公司240kA
     */
    QING_HAI_240("青海分公司240kA"),
    /**
     * 青海分公司200kA
     */
    QING_HAI_200("青海分公司200kA"),
    /**
     * 青海分公司18kA
     */
    QING_HAI_180("青海分公司18kA");

    private final String name;

    CompanyEnum(String name) {
        this.name = name;
    }
}
