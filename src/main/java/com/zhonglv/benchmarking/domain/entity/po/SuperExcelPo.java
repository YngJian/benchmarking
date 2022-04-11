package com.zhonglv.benchmarking.domain.entity.po;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Administrator
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SuperExcelPo extends ExcelPo {
    /**
     * 公司年平均水平基准值
     */
    @ExcelProperty(value = "公司年平均水平基准值", index = 6)
    private String averageReferenceValue;

    /**
     * 标杆值
     */
    @ExcelProperty(value = "标杆值", index = 7)
    @ColumnWidth(value = 23)
    private String benchmarkValue;

    /**
     * 完成值
     */
    @ExcelProperty(value = "完成值", index = 8)
    @ColumnWidth(value = 12)
    private String huaYun500CompletionValue;

    /**
     * 单项指标能力指数
     */
    @ExcelProperty(value = "单项指标能力指数", index = 9)
    private String huaYun500SingleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @ExcelProperty(value = "工序综合能力指数", index = 10)
    private String huaYun500ProcessComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @ExcelProperty(value = "系列综合能力指数", index = 11)
    private String huaYun500SeriesComprehensiveCapabilityIndex;

    /**
     * 完成值
     */
    @ExcelProperty(value = "完成值", index = 12)
    @ColumnWidth(value = 12)
    private String lianCheng500CompletionValue;

    /**
     * 单项指标能力指数
     */
    @ExcelProperty(value = "单项指标能力指数", index = 13)
    private String lianCheng500SingleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @ExcelProperty(value = "工序综合能力指数", index = 14)
    private String lianCheng500ProcessComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @ExcelProperty(value = "系列综合能力指数", index = 15)
    private String lianCheng500SeriesComprehensiveCapabilityIndex;
}
