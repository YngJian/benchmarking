package com.zhonglv.benchmarking.domain.entity.po.accumulate;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.enums.BooleanEnum;
import com.alibaba.excel.enums.poi.BorderStyleEnum;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import com.alibaba.excel.enums.poi.VerticalAlignmentEnum;
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
@ApiModel(value = "按月累计系列为3的数据")
public class LowMonthExcelPo extends MonthExcelPo {
    /**
     * 三级指标序号
     */
    @ExcelProperty(value = {"240kA以下系列指标体系表", "序号", "序号"})
    @ApiModelProperty(value = "序号")
    @ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.LEFT, verticalAlignment = VerticalAlignmentEnum.CENTER,
            wrapped = BooleanEnum.TRUE, borderTop = BorderStyleEnum.THIN, borderBottom = BorderStyleEnum.THIN,
            borderLeft = BorderStyleEnum.THIN, borderRight = BorderStyleEnum.THIN)
    private String number;

    /**
     * 工序分类
     */
    @ExcelProperty(value = {"240kA以下系列指标体系表", "工序分类", "工序分类"})
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "工序分类")
    private String workingProcedureClassification;

    /**
     * 指标类别
     */
    @ExcelProperty(value = {"240kA以下系列指标体系表", "指标类别", "指标类别"})
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "指标类别")
    private String categoryOfIndicators;

    /**
     * 指标
     */
    @ExcelProperty(value = {"240kA以下系列指标体系表", "指标", "指标"})
    @ColumnWidth(value = 26)
    @ApiModelProperty(value = "指标")
    private String indicatorsName;

    /**
     * 单位
     */
    @ExcelProperty(value = {"240kA以下系列指标体系表", "单位", "单位"})
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "单位")
    private String unit;

    /**
     * 指标等级
     */
    @ExcelProperty(value = {"240kA以下系列指标体系表", "指标等级", "指标等级"})
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "指标等级")
    private String indicatorsGrade;

    /**
     * 标杆企业
     */
    @ApiModelProperty(value = "标杆企业")
    @ExcelProperty(value = {"240kA以下系列指标体系表", "标杆企业", "标杆企业"})
    @ColumnWidth(value = 22)
    private String benchmarkingEnterprise;

    /**
     * 公司年平均水平基准值
     */
    @ExcelProperty(value = {"240kA以下系列指标体系表", "2021年公司年平均水平基准值", "2021年公司年平均水平基准值"})
    @ColumnWidth(value = 18)
    @ApiModelProperty(value = "2021年公司年平均水平基准值")
    private String averageReferenceValue;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "连城分公司（200KA）", "一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "一月份")
    private String lianCheng20001;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "连城分公司（200KA）", "二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "二月份")
    private String lianCheng20002;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "连城分公司（200KA）", "三月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "三月份")
    private String lianCheng20003;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "连城分公司（200KA）", "四月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "四月份")
    private String lianCheng20004;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "连城分公司（200KA）", "五月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "五月份")
    private String lianCheng20005;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "连城分公司（200KA）", "六月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "六月份")
    private String lianCheng20006;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "连城分公司（200KA）", "七月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "七月份")
    private String lianCheng20007;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "连城分公司（200KA）", "八月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "八月份")
    private String lianCheng20008;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "连城分公司（200KA）", "九月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "九月份")
    private String lianCheng20009;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "连城分公司（200KA）", "十月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十月份")
    private String lianCheng20010;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "连城分公司（200KA）", "十一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十一月份")
    private String lianCheng20011;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "连城分公司（200KA）", "十二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十二月份")
    private String lianCheng20012;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "连城分公司（200KA）", "累计"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "累计")
    private String lianCheng200accumulative;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（180KA）", "一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "一月份")
    private String qingHai18001;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（180KA）", "二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "二月份")
    private String qingHai18002;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（180KA）", "三月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "三月份")
    private String qingHai18003;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（180KA）", "四月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "四月份")
    private String qingHai18004;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（180KA）", "五月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "五月份")
    private String qingHai18005;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（180KA）", "六月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "六月份")
    private String qingHai18006;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（180KA）", "七月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "七月份")
    private String qingHai18007;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（180KA）", "八月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "八月份")
    private String qingHai18008;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（180KA）", "九月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "九月份")
    private String qingHai18009;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（180KA）", "十月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十月份")
    private String qingHai18010;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（180KA）", "十一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十一月份")
    private String qingHai18011;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（180KA）", "十二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十二月份")
    private String qingHai18012;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（180KA）", "累计"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "累计")
    private String qingHai180accumulative;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（200KA）", "一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "一月份")
    private String qingHai20001;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（200KA）", "二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "二月份")
    private String qingHai20002;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（200KA）", "三月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "三月份")
    private String qingHai20003;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（200KA）", "四月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "四月份")
    private String qingHai20004;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（200KA）", "五月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "五月份")
    private String qingHai20005;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（200KA）", "六月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "六月份")
    private String qingHai20006;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（200KA）", "七月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "七月份")
    private String qingHai20007;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（200KA）", "八月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "八月份")
    private String qingHai20008;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（200KA）", "九月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "九月份")
    private String qingHai20009;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（200KA）", "十月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十月份")
    private String qingHai20010;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（200KA）", "十一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十一月份")
    private String qingHai20011;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（200KA）", "十二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十二月份")
    private String qingHai20012;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（200KA）", "累计"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "累计")
    private String qingHai200accumulative;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（240KA）", "一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "一月份")
    private String qingHai24001;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（240KA）", "二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "二月份")
    private String qingHai24002;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（240KA）", "三月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "三月份")
    private String qingHai24003;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（240KA）", "四月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "四月份")
    private String qingHai24004;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（240KA）", "五月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "五月份")
    private String qingHai24005;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（240KA）", "六月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "六月份")
    private String qingHai24006;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（240KA）", "七月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "七月份")
    private String qingHai24007;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（240KA）", "八月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "八月份")
    private String qingHai24008;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（240KA）", "九月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "九月份")
    private String qingHai24009;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（240KA）", "十月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十月份")
    private String qingHai24010;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（240KA）", "十一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十一月份")
    private String qingHai24011;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（240KA）", "十二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十二月份")
    private String qingHai24012;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "青海分公司（240KA）", "累计"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "累计")
    private String qingHai240accumulative;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "兰州铝业（200KA）", "一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "一月份")
    private String lanZhou20001;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "兰州铝业（200KA）", "二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "二月份")
    private String lanZhou20002;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "兰州铝业（200KA）", "三月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "三月份")
    private String lanZhou20003;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "兰州铝业（200KA）", "四月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "四月份")
    private String lanZhou20004;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "兰州铝业（200KA）", "五月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "五月份")
    private String lanZhou20005;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "兰州铝业（200KA）", "六月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "六月份")
    private String lanZhou20006;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "兰州铝业（200KA）", "七月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "七月份")
    private String lanZhou20007;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "兰州铝业（200KA）", "八月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "八月份")
    private String lanZhou20008;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "兰州铝业（200KA）", "九月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "九月份")
    private String lanZhou20009;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "兰州铝业（200KA）", "十月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十月份")
    private String lanZhou20010;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "兰州铝业（200KA）", "十一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十一月份")
    private String lanZhou20011;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "兰州铝业（200KA）", "十二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十二月份")
    private String lanZhou20012;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "兰州铝业（200KA）", "累计"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "累计")
    private String lanZhou200accumulative;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（200KA）", "一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "一月份")
    private String baoTou20001;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（200KA）", "二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "二月份")
    private String baoTou20002;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（200KA）", "三月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "三月份")
    private String baoTou20003;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（200KA）", "四月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "四月份")
    private String baoTou20004;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（200KA）", "五月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "五月份")
    private String baoTou20005;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（200KA）", "六月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "六月份")
    private String baoTou20006;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（200KA）", "七月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "七月份")
    private String baoTou20007;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（200KA）", "八月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "八月份")
    private String baoTou20008;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（200KA）", "九月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "九月份")
    private String baoTou20009;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（200KA）", "十月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十月份")
    private String baoTou20010;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（200KA）", "十一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十一月份")
    private String baoTou20011;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（200KA）", "十二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十二月份")
    private String baoTou20012;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（200KA）", "累计"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "累计")
    private String baoTou200accumulative;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（240KA）", "一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "一月份")
    private String baoTou24001;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（240KA）", "二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "二月份")
    private String baoTou24002;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（240KA）", "三月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "三月份")
    private String baoTou24003;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（240KA）", "四月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "四月份")
    private String baoTou24004;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（240KA）", "五月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "五月份")
    private String baoTou24005;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（240KA）", "六月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "六月份")
    private String baoTou24006;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（240KA）", "七月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "七月份")
    private String baoTou24007;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（240KA）", "八月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "八月份")
    private String baoTou24008;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（240KA）", "九月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "九月份")
    private String baoTou24009;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（240KA）", "十月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十月份")
    private String baoTou24010;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（240KA）", "十一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十一月份")
    private String baoTou24011;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（240KA）", "十二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十二月份")
    private String baoTou24012;

    @ExcelProperty(value = {"240kA以下系列指标体系表", "包头铝业（240KA）", "累计"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "累计")
    private String baoTou240accumulative;
}
