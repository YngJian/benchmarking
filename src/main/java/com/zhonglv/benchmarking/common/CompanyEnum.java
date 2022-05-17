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
    LIAN_CHENG_500("连城分公司500kA", "lianCheng500"),
    /**
     * 山西中润500kA
     */
    SHANG_XI_ZHONG_RUN_500("山西中润500kA", "shanXi500"),
    /**
     * 内蒙古华云500kA
     */
    HUA_YUN_500("内蒙古华云500kA", "huaYun500"),
    /**
     * 山西新材料电解二系列300kA
     */
    SHAN_XI_ER_300("山西新材料电解二系列300kA", "shanXiEr300"),
    /**
     * 包头铝业400kA
     */
    BAO_TOU_400("包头铝业400kA", "baoTou400"),
    /**
     * 内蒙古华云390kA
     */
    HUA_YUN_390("内蒙古华云390kA", "huaYun390"),
    /**
     * 兰州分公司375kA
     */
    LAN_ZHOU_375("兰州分公司375kA", "lanZhou375"),
    /**
     * 内蒙古华云500kA
     */
    SHAN_XI_YI_300("山西新材料电解一系列300kA", "shanXiYi300"),
    /**
     * 连城分公司200kA
     */
    LIAN_CHENG_200("连城分公司200kA", "lianCheng200"),
    /**
     * 包头铝业240kA
     */
    BAO_TOU_240("包头铝业240kA", "baoTou240"),
    /**
     * 包头铝业200kA
     */
    BAO_TOU_200("包头铝业200kA", "baoTou200"),
    /**
     * 兰州分公司200kA
     */
    LAN_ZHOU_200("兰州分公司200kA", "lanZhou200"),
    /**
     * 青海分公司240kA
     */
    QING_HAI_240("青海分公司240kA", "qingHai240"),
    /**
     * 青海分公司200kA
     */
    QING_HAI_200("青海分公司200kA", "qingHai200"),
    /**
     * 青海分公司180kA
     */
    QING_HAI_180("青海分公司180kA", "qingHai180");

    private final String name;
    private final String shortName;

    CompanyEnum(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public static String getShortName(String name) {
        for (CompanyEnum value : CompanyEnum.values()) {
            if (value.getName().equals(name)) {
                return value.getShortName();
            }
        }
        return "";
    }
}
