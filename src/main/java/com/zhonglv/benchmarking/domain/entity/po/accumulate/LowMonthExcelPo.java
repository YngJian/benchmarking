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
public class LowMonthExcelPo extends MonthExcelPo {
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
    private String lianCheng20001;

    @ExcelProperty(value = "二月份", index = 9)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "二月份")
    private String lianCheng20002;

    @ExcelProperty(value = "三月份", index = 10)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "三月份")
    private String lianCheng20003;

    @ExcelProperty(value = "四月份", index = 11)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "四月份")
    private String lianCheng20004;

    @ExcelProperty(value = "五月份", index = 12)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "五月份")
    private String lianCheng20005;

    @ExcelProperty(value = "六月份", index = 13)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "六月份")
    private String lianCheng20006;

    @ExcelProperty(value = "七月份", index = 14)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "七月份")
    private String lianCheng20007;

    @ExcelProperty(value = "八月份", index = 15)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "八月份")
    private String lianCheng20008;

    @ExcelProperty(value = "九月份", index = 16)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "九月份")
    private String lianCheng20009;

    @ExcelProperty(value = "十月份", index = 17)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十月份")
    private String lianCheng20010;

    @ExcelProperty(value = "十一月份", index = 18)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十一月份")
    private String lianCheng20011;

    @ExcelProperty(value = "十二月份", index = 19)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十二月份")
    private String lianCheng20012;

    @ExcelProperty(value = "一月份", index = 20)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "一月份")
    private String qingHai18001;

    @ExcelProperty(value = "二月份", index = 21)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "二月份")
    private String qingHai18002;

    @ExcelProperty(value = "三月份", index = 22)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "三月份")
    private String qingHai18003;

    @ExcelProperty(value = "四月份", index = 23)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "四月份")
    private String qingHai18004;

    @ExcelProperty(value = "五月份", index = 24)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "五月份")
    private String qingHai18005;

    @ExcelProperty(value = "六月份", index = 25)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "六月份")
    private String qingHai18006;

    @ExcelProperty(value = "七月份", index = 26)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "七月份")
    private String qingHai18007;

    @ExcelProperty(value = "八月份", index = 27)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "八月份")
    private String qingHai18008;

    @ExcelProperty(value = "九月份", index = 28)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "九月份")
    private String qingHai18009;

    @ExcelProperty(value = "十月份", index = 29)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十月份")
    private String qingHai18010;

    @ExcelProperty(value = "十一月份", index = 30)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十一月份")
    private String qingHai18011;

    @ExcelProperty(value = "十二月份", index = 31)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十二月份")
    private String qingHai18012;

    @ExcelProperty(value = "一月份", index = 32)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "一月份")
    private String qingHai20001;

    @ExcelProperty(value = "二月份", index = 33)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "二月份")
    private String qingHai20002;

    @ExcelProperty(value = "三月份", index = 34)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "三月份")
    private String qingHai20003;

    @ExcelProperty(value = "四月份", index = 35)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "四月份")
    private String qingHai20004;

    @ExcelProperty(value = "五月份", index = 36)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "五月份")
    private String qingHai20005;

    @ExcelProperty(value = "六月份", index = 37)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "六月份")
    private String qingHai20006;

    @ExcelProperty(value = "七月份", index = 38)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "七月份")
    private String qingHai20007;

    @ExcelProperty(value = "八月份", index = 39)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "八月份")
    private String qingHai20008;

    @ExcelProperty(value = "九月份", index = 40)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "九月份")
    private String qingHai20009;

    @ExcelProperty(value = "十月份", index = 41)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十月份")
    private String qingHai20010;

    @ExcelProperty(value = "十一月份", index = 42)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十一月份")
    private String qingHai20011;

    @ExcelProperty(value = "十二月份", index = 43)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十二月份")
    private String qingHai20012;

    @ExcelProperty(value = "一月份", index = 44)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "一月份")
    private String lanZhou20001;

    @ExcelProperty(value = "二月份", index = 45)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "二月份")
    private String lanZhou20002;

    @ExcelProperty(value = "三月份", index = 46)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "三月份")
    private String lanZhou20003;

    @ExcelProperty(value = "四月份", index = 47)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "四月份")
    private String lanZhou20004;

    @ExcelProperty(value = "五月份", index = 48)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "五月份")
    private String lanZhou20005;

    @ExcelProperty(value = "六月份", index = 49)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "六月份")
    private String lanZhou20006;

    @ExcelProperty(value = "七月份", index = 50)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "七月份")
    private String lanZhou20007;

    @ExcelProperty(value = "八月份", index = 51)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "八月份")
    private String lanZhou20008;

    @ExcelProperty(value = "九月份", index = 52)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "九月份")
    private String lanZhou20009;

    @ExcelProperty(value = "十月份", index = 53)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十月份")
    private String lanZhou20010;

    @ExcelProperty(value = "十一月份", index = 54)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十一月份")
    private String lanZhou20011;

    @ExcelProperty(value = "十二月份", index = 55)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十二月份")
    private String lanZhou20012;

    @ExcelProperty(value = "一月份", index = 44)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "一月份")
    private String baoTou20001;

    @ExcelProperty(value = "二月份", index = 45)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "二月份")
    private String baoTou20002;

    @ExcelProperty(value = "三月份", index = 46)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "三月份")
    private String baoTou20003;

    @ExcelProperty(value = "四月份", index = 47)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "四月份")
    private String baoTou20004;

    @ExcelProperty(value = "五月份", index = 48)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "五月份")
    private String baoTou20005;

    @ExcelProperty(value = "六月份", index = 49)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "六月份")
    private String baoTou20006;

    @ExcelProperty(value = "七月份", index = 50)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "七月份")
    private String baoTou20007;

    @ExcelProperty(value = "八月份", index = 51)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "八月份")
    private String baoTou20008;

    @ExcelProperty(value = "九月份", index = 52)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "九月份")
    private String baoTou20009;

    @ExcelProperty(value = "十月份", index = 53)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十月份")
    private String baoTou20010;

    @ExcelProperty(value = "十一月份", index = 54)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十一月份")
    private String baoTou20011;

    @ExcelProperty(value = "十二月份", index = 55)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十二月份")
    private String baoTou20012;

    @ExcelProperty(value = "一月份", index = 44)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "一月份")
    private String baoTou24001;

    @ExcelProperty(value = "二月份", index = 45)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "二月份")
    private String baoTou24002;

    @ExcelProperty(value = "三月份", index = 46)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "三月份")
    private String baoTou24003;

    @ExcelProperty(value = "四月份", index = 47)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "四月份")
    private String baoTou24004;

    @ExcelProperty(value = "五月份", index = 48)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "五月份")
    private String baoTou24005;

    @ExcelProperty(value = "六月份", index = 49)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "六月份")
    private String baoTou24006;

    @ExcelProperty(value = "七月份", index = 50)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "七月份")
    private String baoTou24007;

    @ExcelProperty(value = "八月份", index = 51)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "八月份")
    private String baoTou24008;

    @ExcelProperty(value = "九月份", index = 52)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "九月份")
    private String baoTou24009;

    @ExcelProperty(value = "十月份", index = 53)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十月份")
    private String baoTou24010;

    @ExcelProperty(value = "十一月份", index = 54)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十一月份")
    private String baoTou24011;

    @ExcelProperty(value = "十二月份", index = 55)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "十二月份")
    private String baoTou24012;
}
