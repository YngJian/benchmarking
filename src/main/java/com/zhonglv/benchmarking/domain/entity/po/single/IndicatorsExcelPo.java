package com.zhonglv.benchmarking.domain.entity.po.single;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndicatorsExcelPo extends ExcelPo {
    /**
     * 标杆值
     */
    @ExcelProperty(index = 6)
    @ColumnWidth(value = 23)
    private String benchmarkValue;

    /**
     * 完成值
     */
    @ExcelProperty(index = 7)
    @ColumnWidth(value = 12)
    private String completionValue;

    /**
     * 标准差
     */
    @ExcelProperty(index = 8)
    @ColumnWidth(value = 12)
    private String standardDeviation;

    /**
     * 权重
     */
    @ExcelProperty(value = "权重",index = 9)
    private String weight;

    /**
     * 单项指标能力指数
     */
    @ExcelProperty(value = "单项指标能力指数", index = 10)
    @ColumnWidth(value = 12)
    private String singleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @ExcelProperty(value = "工序综合能力指数", index = 11)
    @ColumnWidth(value = 12)
    private String processComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @ExcelProperty(value = "系列综合能力指数", index = 12)
    @ColumnWidth(value = 12)
    private String seriesComprehensiveCapabilityIndex;
}
