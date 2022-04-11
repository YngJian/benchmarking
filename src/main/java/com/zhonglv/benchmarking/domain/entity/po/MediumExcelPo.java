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
public class MediumExcelPo extends ExcelPo {
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
    private String baoTou400CompletionValue;

    /**
     * 单项指标能力指数
     */
    @ExcelProperty(value = "单项指标能力指数", index = 9)
    private String baoTou400SingleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @ExcelProperty(value = "工序综合能力指数", index = 10)
    private String baoTou400ProcessComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @ExcelProperty(value = "系列综合能力指数", index = 11)
    private String baoTou400SeriesComprehensiveCapabilityIndex;

    /**
     * 完成值
     */
    @ExcelProperty(value = "完成值", index = 12)
    @ColumnWidth(value = 12)
    private String huaYun390CompletionValue;

    /**
     * 单项指标能力指数
     */
    @ExcelProperty(value = "单项指标能力指数", index = 13)
    private String huaYun390SingleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @ExcelProperty(value = "工序综合能力指数", index = 14)
    private String huaYun390ProcessComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @ExcelProperty(value = "系列综合能力指数", index = 15)
    private String huaYun390SeriesComprehensiveCapabilityIndex;

    /**
     * 完成值
     */
    @ExcelProperty(value = "完成值", index = 16)
    @ColumnWidth(value = 12)
    private String lanZhou375CompletionValue;

    /**
     * 单项指标能力指数
     */
    @ExcelProperty(value = "单项指标能力指数", index = 17)
    private String lanZhou375SingleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @ExcelProperty(value = "工序综合能力指数", index = 18)
    private String lanZhou375ProcessComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @ExcelProperty(value = "系列综合能力指数", index = 19)
    private String lanZhou375SeriesComprehensiveCapabilityIndex;

    /**
     * 完成值
     */
    @ExcelProperty(value = "完成值", index = 20)
    @ColumnWidth(value = 12)
    private String shanXiYi300CompletionValue;

    /**
     * 单项指标能力指数
     */
    @ExcelProperty(value = "单项指标能力指数", index = 21)
    private String shanXiYi300SingleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @ExcelProperty(value = "工序综合能力指数", index = 22)
    private String shanXiYi300ProcessComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @ExcelProperty(value = "系列综合能力指数", index = 23)
    private String shanXiYi300SeriesComprehensiveCapabilityIndex;
}
