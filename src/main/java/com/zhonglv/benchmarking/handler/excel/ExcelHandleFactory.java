package com.zhonglv.benchmarking.handler.excel;

import com.zhonglv.benchmarking.common.CompanyEnum;
import com.zhonglv.benchmarking.common.ConstantType;
import com.zhonglv.benchmarking.handler.excel.low.*;
import com.zhonglv.benchmarking.handler.excel.medium.*;
import com.zhonglv.benchmarking.handler.excel.supers.HuaYun500Handler;
import com.zhonglv.benchmarking.handler.excel.supers.LianCheng500Handler;
import com.zhonglv.benchmarking.handler.excel.supers.ShanXi500Handler;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 15:45
 */
@Slf4j
public class ExcelHandleFactory {
    private static final Map<String, Class<? extends ExcelDataHandler>> HANDLER_MAPS = new ConcurrentHashMap<>();

    private static final Map<String, Class<? extends ExcelDataHandler>> ASSEMBLY_MAPS = new ConcurrentHashMap<>();

    //初始化map，存放策略
    static {
        HANDLER_MAPS.put(CompanyEnum.HUA_YUN_500.getName(), HuaYun500Handler.class);
        HANDLER_MAPS.put(CompanyEnum.LIAN_CHENG_500.getName(), LianCheng500Handler.class);
        HANDLER_MAPS.put(CompanyEnum.SHANG_XI_ZHONG_RUN_500.getName(), ShanXi500Handler.class);
        HANDLER_MAPS.put(CompanyEnum.BAO_TOU_400.getName(), BaoTou400Handler.class);
        HANDLER_MAPS.put(CompanyEnum.SHAN_XI_ER_300.getName(), ShanXiEr300Handler.class);
        HANDLER_MAPS.put(CompanyEnum.HUA_YUN_390.getName(), HuaYun390Handler.class);
        HANDLER_MAPS.put(CompanyEnum.LAN_ZHOU_375.getName(), LanZhou375Handler.class);
        HANDLER_MAPS.put(CompanyEnum.SHAN_XI_YI_300.getName(), ShanXiYi300Handler.class);
        HANDLER_MAPS.put(CompanyEnum.LIAN_CHENG_200.getName(), LianCheng200Handler.class);
        HANDLER_MAPS.put(CompanyEnum.BAO_TOU_200.getName(), BaoTou200Handler.class);
        HANDLER_MAPS.put(CompanyEnum.BAO_TOU_240.getName(), BaoTou240Handler.class);
        HANDLER_MAPS.put(CompanyEnum.LAN_ZHOU_200.getName(), LanZhou200Handler.class);
        HANDLER_MAPS.put(CompanyEnum.QING_HAI_180.getName(), QingHai180Handler.class);
        HANDLER_MAPS.put(CompanyEnum.QING_HAI_200.getName(), QingHai200Handler.class);
        HANDLER_MAPS.put(CompanyEnum.QING_HAI_240.getName(), QingHai240Handler.class);
        ASSEMBLY_MAPS.put(ConstantType.SUPER_EXCEL_PO, SuperExcelDefaultDataHandler.class);
        ASSEMBLY_MAPS.put(ConstantType.MEDIUM_EXCEL_PO, MediumExcelDefaultDataHandler.class);
        ASSEMBLY_MAPS.put(ConstantType.LOW_EXCEL_PO, LowExcelDefaultDataHandler.class);
    }

    /**
     * 获取策略
     *
     * @param companyName companyName
     * @return Optional<ExcelDataHandler>
     */
    public static Optional<ExcelDataHandler> getByCompanyName(String companyName) {
        try {
            Class<? extends ExcelDataHandler> excelHandle = HANDLER_MAPS.get(companyName);
            return Optional.of(excelHandle.newInstance());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Optional.empty();
        }
    }

    /**
     * 获取策略
     *
     * @param seriesType seriesType
     * @return Optional<ExcelDataHandler>
     */
    public static Optional<ExcelDataHandler> getAssemblyHandle(String seriesType) {
        try {
            Class<? extends ExcelDataHandler> excelHandle = ASSEMBLY_MAPS.get(seriesType);
            return Optional.of(excelHandle.newInstance());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Optional.empty();
        }
    }
}
