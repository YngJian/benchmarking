package com.zhonglv.benchmarking.domain.entity.po.accumulate;

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
@ApiModel(value = "按月累计系列为1的数据")
public class MediumMonthExcelPo extends MonthExcelPo {
    /**
     * 标杆企业
     */
    @ApiModelProperty(value = "标杆企业")
    @ExcelProperty(value = "标杆企业", index = 6)
    private String benchmarkingEnterprise;

    /**
     * 公司年平均水平基准值
     */
    @ExcelProperty(value = "2021年公司年平均水平基准值", index = 7)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "2021年公司年平均水平基准值")
    private String averageReferenceValue;

    @ExcelProperty(value = "一月份", index = 8)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "一月份")
    private String shanXiEr30001;

    @ExcelProperty(value = "二月份", index = 9)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "二月份")
    private String shanXiEr30002;

    @ExcelProperty(value = "三月份", index = 10)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "三月份")
    private String shanXiEr30003;

    @ExcelProperty(value = "四月份", index = 11)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "四月份")
    private String shanXiEr30004;

    @ExcelProperty(value = "五月份", index = 12)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "五月份")
    private String shanXiEr30005;

    @ExcelProperty(value = "六月份", index = 13)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "六月份")
    private String shanXiEr30006;

    @ExcelProperty(value = "七月份", index = 14)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "七月份")
    private String shanXiEr30007;

    @ExcelProperty(value = "八月份", index = 15)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "八月份")
    private String shanXiEr30008;

    @ExcelProperty(value = "九月份", index = 16)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "九月份")
    private String shanXiEr30009;

    @ExcelProperty(value = "十月份", index = 17)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十月份")
    private String shanXiEr30010;

    @ExcelProperty(value = "十一月份", index = 18)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十一月份")
    private String shanXiEr30011;

    @ExcelProperty(value = "十二月份", index = 19)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十二月份")
    private String shanXiEr30012;

    @ExcelProperty(value = "一月份", index = 20)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "一月份")
    private String lanZhou37501;

    @ExcelProperty(value = "二月份", index = 21)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "二月份")
    private String lanZhou37502;

    @ExcelProperty(value = "三月份", index = 22)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "三月份")
    private String lanZhou37503;

    @ExcelProperty(value = "四月份", index = 23)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "四月份")
    private String lanZhou37504;

    @ExcelProperty(value = "五月份", index = 24)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "五月份")
    private String lanZhou37505;

    @ExcelProperty(value = "六月份", index = 25)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "六月份")
    private String lanZhou37506;

    @ExcelProperty(value = "七月份", index = 26)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "七月份")
    private String lanZhou37507;

    @ExcelProperty(value = "八月份", index = 27)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "八月份")
    private String lanZhou37508;

    @ExcelProperty(value = "九月份", index = 28)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "九月份")
    private String lanZhou37509;

    @ExcelProperty(value = "十月份", index = 29)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十月份")
    private String lanZhou37510;

    @ExcelProperty(value = "十一月份", index = 30)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十一月份")
    private String lanZhou37511;

    @ExcelProperty(value = "十二月份", index = 31)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十二月份")
    private String lanZhou37512;

    @ExcelProperty(value = "一月份", index = 32)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "一月份")
    private String baoTou40001;

    @ExcelProperty(value = "二月份", index = 33)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "二月份")
    private String baoTou40002;

    @ExcelProperty(value = "三月份", index = 34)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "三月份")
    private String baoTou40003;

    @ExcelProperty(value = "四月份", index = 35)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "四月份")
    private String baoTou40004;

    @ExcelProperty(value = "五月份", index = 36)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "五月份")
    private String baoTou40005;

    @ExcelProperty(value = "六月份", index = 37)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "六月份")
    private String baoTou40006;

    @ExcelProperty(value = "七月份", index = 38)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "七月份")
    private String baoTou40007;

    @ExcelProperty(value = "八月份", index = 39)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "八月份")
    private String baoTou40008;

    @ExcelProperty(value = "九月份", index = 40)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "九月份")
    private String baoTou40009;

    @ExcelProperty(value = "十月份", index = 41)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十月份")
    private String baoTou40010;

    @ExcelProperty(value = "十一月份", index = 42)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十一月份")
    private String baoTou40011;

    @ExcelProperty(value = "十二月份", index = 43)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十二月份")
    private String baoTou40012;

    @ExcelProperty(value = "一月份", index = 44)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "一月份")
    private String huaYun39001;

    @ExcelProperty(value = "二月份", index = 45)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "二月份")
    private String huaYun39002;

    @ExcelProperty(value = "三月份", index = 46)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "三月份")
    private String huaYun39003;

    @ExcelProperty(value = "四月份", index = 47)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "四月份")
    private String huaYun39004;

    @ExcelProperty(value = "五月份", index = 48)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "五月份")
    private String huaYun39005;

    @ExcelProperty(value = "六月份", index = 49)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "六月份")
    private String huaYun39006;

    @ExcelProperty(value = "七月份", index = 50)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "七月份")
    private String huaYun39007;

    @ExcelProperty(value = "八月份", index = 51)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "八月份")
    private String huaYun39008;

    @ExcelProperty(value = "九月份", index = 52)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "九月份")
    private String huaYun39009;

    @ExcelProperty(value = "十月份", index = 53)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十月份")
    private String huaYun39010;

    @ExcelProperty(value = "十一月份", index = 54)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十一月份")
    private String huaYun39011;

    @ExcelProperty(value = "十二月份", index = 55)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十二月份")
    private String huaYun39012;
}
