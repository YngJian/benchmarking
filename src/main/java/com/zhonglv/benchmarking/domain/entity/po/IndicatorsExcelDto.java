package com.zhonglv.benchmarking.domain.entity.po;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import com.alibaba.excel.enums.poi.VerticalAlignmentEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@HeadStyle(horizontalAlignment = HorizontalAlignmentEnum.CENTER, verticalAlignment = VerticalAlignmentEnum.CENTER)//表头样式
@ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.CENTER, verticalAlignment = VerticalAlignmentEnum.CENTER)
//内容样式
public class IndicatorsExcelDto {
    /**
     * 三级指标序号
     */
    @ExcelProperty("序号")
    private String iNumber;

    /**
     * 工序分类
     */
    @ExcelProperty("工序分类")
    @ColumnWidth(value = 30)
    private String workingProcedureClassification;

    /**
     * 指标类别
     */
    @ExcelProperty("指标类别")
    @ColumnWidth(value = 30)
    private String categoryOfIndicators;

    /**
     * 指标
     */
    @ExcelProperty("指标")
    @ColumnWidth(value = 30)
    private String indicatorsName;

    /**
     * 单位
     */
    @ExcelProperty("单位")
    private String unit;

    /**
     * 指标等级
     */
    @ExcelProperty("指标等级")
    private String indicatorsGrade;

    /**
     * 标杆值
     */
    @ExcelProperty(index = 6)
    private String benchmarkValue;

    /**
     * 完成值
     */
    @ExcelProperty(index = 7)
    private String completionValue;

    /**
     * 标准差
     */
    @ExcelProperty(index = 8)
    private String standardDeviation;

    /**
     * 权重
     */
    @ExcelProperty("权重")
    private String weight;

    /**
     * 单项指标能力指数
     */
    @ExcelProperty("单项指标能力指数")
    private String singleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @ExcelProperty("工序综合能力指数")
    private String processComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @ExcelProperty("系列综合能力指数")
    private String seriesComprehensiveCapabilityIndex;
}
