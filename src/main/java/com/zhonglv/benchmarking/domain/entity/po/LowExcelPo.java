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
@ApiModel(value = "系列为3的数据")
public class LowExcelPo extends ExcelPo {
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
    private String baoTou240CompletionValue;

    /**
     * 单项指标能力指数
     */
    @ExcelProperty(value = "单项指标能力指数", index = 9)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "单项指标能力指数")
    private String baoTou240SingleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @ExcelProperty(value = "工序综合能力指数", index = 10)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "工序综合能力指数")
    private String baoTou240ProcessComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @ExcelProperty(value = "系列综合能力指数", index = 11)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "系列综合能力指数")
    private String baoTou240SeriesComprehensiveCapabilityIndex;

    /**
     * 完成值
     */
    @ExcelProperty(value = "完成值", index = 12)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "完成值")
    private String baoTou200CompletionValue;

    /**
     * 单项指标能力指数
     */
    @ExcelProperty(value = "单项指标能力指数", index = 13)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "单项指标能力指数")
    private String baoTou200SingleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @ExcelProperty(value = "工序综合能力指数", index = 14)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "工序综合能力指数")
    private String baoTou200ProcessComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @ExcelProperty(value = "系列综合能力指数", index = 15)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "系列综合能力指数")
    private String baoTou200SeriesComprehensiveCapabilityIndex;

    /**
     * 完成值
     */
    @ExcelProperty(value = "完成值", index = 16)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "完成值")
    private String lanZhou200CompletionValue;

    /**
     * 单项指标能力指数
     */
    @ExcelProperty(value = "单项指标能力指数", index = 17)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "单项指标能力指数")
    private String lanZhou200SingleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @ExcelProperty(value = "工序综合能力指数", index = 18)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "工序综合能力指数")
    private String lanZhou200ProcessComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @ExcelProperty(value = "系列综合能力指数", index = 19)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "系列综合能力指数")
    private String lanZhou200SeriesComprehensiveCapabilityIndex;

    /**
     * 完成值
     */
    @ExcelProperty(value = "完成值", index = 20)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "完成值")
    private String qingHai240CompletionValue;

    /**
     * 单项指标能力指数
     */
    @ExcelProperty(value = "单项指标能力指数", index = 21)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "单项指标能力指数")
    private String qingHai240SingleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @ExcelProperty(value = "工序综合能力指数", index = 22)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "工序综合能力指数")
    private String qingHai240ProcessComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @ExcelProperty(value = "系列综合能力指数", index = 23)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "系列综合能力指数")
    private String qingHai240SeriesComprehensiveCapabilityIndex;

    /**
     * 完成值
     */
    @ExcelProperty(value = "完成值", index = 24)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "完成值")
    private String qingHai200CompletionValue;

    /**
     * 单项指标能力指数
     */
    @ExcelProperty(value = "单项指标能力指数", index = 25)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "单项指标能力指数")
    private String qingHai200SingleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @ExcelProperty(value = "工序综合能力指数", index = 26)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "工序综合能力指数")
    private String qingHai200ProcessComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @ExcelProperty(value = "系列综合能力指数", index = 27)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "系列综合能力指数")
    private String qingHai200SeriesComprehensiveCapabilityIndex;

    /**
     * 完成值
     */
    @ExcelProperty(value = "完成值", index = 28)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "完成值")
    private String qingHai180CompletionValue;

    /**
     * 单项指标能力指数
     */
    @ExcelProperty(value = "单项指标能力指数", index = 29)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "单项指标能力指数")
    private String qingHai180SingleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @ExcelProperty(value = "工序综合能力指数", index = 30)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "工序综合能力指数")
    private String qingHai180ProcessComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @ExcelProperty(value = "系列综合能力指数", index = 31)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "系列综合能力指数")
    private String qingHai180SeriesComprehensiveCapabilityIndex;
}
