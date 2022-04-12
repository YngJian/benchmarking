package com.zhonglv.benchmarking.domain.entity.po;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "系列为1的数据")
public class SuperExcelPo extends ExcelPo {
    /**
     * 公司年平均水平基准值
     */
    @ExcelProperty(value = "2021年公司年平均水平基准值", index = 6)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "2021年公司年平均水平基准值")
    private String averageReferenceValue;

    /**
     * 标杆值
     */
    @ExcelProperty(value = "标杆值", index = 7)
    @ColumnWidth(value = 18)
    @ApiModelProperty(value = "标杆值")
    private String benchmarkValue;

    /**
     * 完成值
     */
    @ExcelProperty(value = "完成值", index = 8)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "完成值")
    private String huaYun500CompletionValue;

    /**
     * 单项指标能力指数
     */
    @ExcelProperty(value = "单项指标能力指数", index = 9)
    @ApiModelProperty(value = "单项指标能力指数")
    @ColumnWidth(value = 12)
    private String huaYun500SingleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @ExcelProperty(value = "工序综合能力指数", index = 10)
    @ApiModelProperty(value = "工序综合能力指数")
    @ColumnWidth(value = 12)
    private String huaYun500ProcessComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @ExcelProperty(value = "系列综合能力指数", index = 11)
    @ApiModelProperty(value = "系列综合能力指数")
    @ColumnWidth(value = 12)
    private String huaYun500SeriesComprehensiveCapabilityIndex;

    /**
     * 完成值
     */
    @ExcelProperty(value = "完成值", index = 12)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "完成值")
    private String lianCheng500CompletionValue;

    /**
     * 单项指标能力指数
     */
    @ExcelProperty(value = "单项指标能力指数", index = 13)
    @ApiModelProperty(value = "单项指标能力指数")
    @ColumnWidth(value = 12)
    private String lianCheng500SingleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @ExcelProperty(value = "工序综合能力指数", index = 14)
    @ApiModelProperty(value = "工序综合能力指数")
    @ColumnWidth(value = 12)
    private String lianCheng500ProcessComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @ExcelProperty(value = "系列综合能力指数", index = 15)
    @ApiModelProperty(value = "系列综合能力指数")
    @ColumnWidth(value = 12)
    private String lianCheng500SeriesComprehensiveCapabilityIndex;
}
