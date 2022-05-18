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
@ApiModel(value = "按月累计系列为2的数据")
public class MediumMonthExcelPo extends MonthExcelPo {
    /**
     * 三级指标序号
     */
    @ExcelProperty(value = {"300-400kA系列指标体系表", "序号", "序号"})
    @ApiModelProperty(value = "序号")
    @ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.LEFT, verticalAlignment = VerticalAlignmentEnum.CENTER,
            wrapped = BooleanEnum.TRUE, borderTop = BorderStyleEnum.THIN, borderBottom = BorderStyleEnum.THIN,
            borderLeft = BorderStyleEnum.THIN, borderRight = BorderStyleEnum.THIN)
    private String number;

    /**
     * 工序分类
     */
    @ExcelProperty(value = {"300-400kA系列指标体系表", "工序分类", "工序分类"})
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "工序分类")
    private String workingProcedureClassification;

    /**
     * 指标类别
     */
    @ExcelProperty(value = {"300-400kA系列指标体系表", "指标类别", "指标类别"})
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "指标类别")
    private String categoryOfIndicators;

    /**
     * 指标
     */
    @ExcelProperty(value = {"300-400kA系列指标体系表", "指标", "指标"})
    @ColumnWidth(value = 26)
    @ApiModelProperty(value = "指标")
    private String indicatorsName;

    /**
     * 单位
     */
    @ExcelProperty(value = {"300-400kA系列指标体系表", "单位", "单位"})
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "单位")
    private String unit;

    /**
     * 指标等级
     */
    @ExcelProperty(value = {"300-400kA系列指标体系表", "指标等级", "指标等级"})
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "指标等级")
    private String indicatorsGrade;
    /**
     * 标杆企业
     */
    @ApiModelProperty(value = "标杆企业")
    @ExcelProperty(value = {"300-400kA系列指标体系表", "标杆企业", "标杆企业"})
    @ColumnWidth(value = 22)
    private String benchmarkingEnterprise;

    /**
     * 公司年平均水平基准值
     */
    @ExcelProperty(value = {"300-400kA系列指标体系表", "2021年公司年平均水平基准值", "2021年公司年平均水平基准值"})
    @ColumnWidth(value = 18)
    @ApiModelProperty(value = "2021年公司年平均水平基准值")
    private String averageReferenceValue;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "山西新材料（300KA）", "一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "一月份")
    private String shanXiEr30001;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "山西新材料（300KA）", "二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "二月份")
    private String shanXiEr30002;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "山西新材料（300KA）", "三月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "三月份")
    private String shanXiEr30003;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "山西新材料（300KA）", "四月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "四月份")
    private String shanXiEr30004;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "山西新材料（300KA）", "五月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "五月份")
    private String shanXiEr30005;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "山西新材料（300KA）", "六月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "六月份")
    private String shanXiEr30006;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "山西新材料（300KA）", "七月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "七月份")
    private String shanXiEr30007;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "山西新材料（300KA）", "八月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "八月份")
    private String shanXiEr30008;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "山西新材料（300KA）", "九月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "九月份")
    private String shanXiEr30009;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "山西新材料（300KA）", "十月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十月份")
    private String shanXiEr30010;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "山西新材料（300KA）", "十一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十一月份")
    private String shanXiEr30011;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "山西新材料（300KA）", "十二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十二月份")
    private String shanXiEr30012;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "山西新材料（300KA）", "累计"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "累计")
    private String shanXiEr300accumulative;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "兰州铝业（375KA）", "一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "一月份")
    private String lanZhou37501;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "兰州铝业（375KA）", "二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "二月份")
    private String lanZhou37502;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "兰州铝业（375KA）", "三月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "三月份")
    private String lanZhou37503;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "兰州铝业（375KA）", "四月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "四月份")
    private String lanZhou37504;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "兰州铝业（375KA）", "五月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "五月份")
    private String lanZhou37505;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "兰州铝业（375KA）", "六月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "六月份")
    private String lanZhou37506;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "兰州铝业（375KA）", "七月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "七月份")
    private String lanZhou37507;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "兰州铝业（375KA）", "八月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "八月份")
    private String lanZhou37508;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "兰州铝业（375KA）", "九月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "九月份")
    private String lanZhou37509;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "兰州铝业（375KA）", "十月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十月份")
    private String lanZhou37510;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "兰州铝业（375KA）", "十一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十一月份")
    private String lanZhou37511;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "兰州铝业（375KA）", "十二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十二月份")
    private String lanZhou37512;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "兰州铝业（375KA）", "累计"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "累计")
    private String lanZhou375accumulative;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "包头铝业（400KA）", "一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "一月份")
    private String baoTou40001;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "包头铝业（400KA）", "二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "二月份")
    private String baoTou40002;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "包头铝业（400KA）", "三月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "三月份")
    private String baoTou40003;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "包头铝业（400KA）", "四月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "四月份")
    private String baoTou40004;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "包头铝业（400KA）", "五月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "五月份")
    private String baoTou40005;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "包头铝业（400KA）", "六月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "六月份")
    private String baoTou40006;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "包头铝业（400KA）", "七月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "七月份")
    private String baoTou40007;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "包头铝业（400KA）", "八月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "八月份")
    private String baoTou40008;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "包头铝业（400KA）", "九月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "九月份")
    private String baoTou40009;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "包头铝业（400KA）", "十月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十月份")
    private String baoTou40010;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "包头铝业（400KA）", "十一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十一月份")
    private String baoTou40011;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "包头铝业（400KA）", "十二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十二月份")
    private String baoTou40012;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "包头铝业（400KA）", "累计"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "累计")
    private String baoTou400accumulative;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "内蒙古华云（390KA）", "一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "一月份")
    private String huaYun39001;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "内蒙古华云（390KA）", "二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "二月份")
    private String huaYun39002;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "内蒙古华云（390KA）", "三月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "三月份")
    private String huaYun39003;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "内蒙古华云（390KA）", "四月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "四月份")
    private String huaYun39004;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "内蒙古华云（390KA）", "五月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "五月份")
    private String huaYun39005;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "内蒙古华云（390KA）", "六月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "六月份")
    private String huaYun39006;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "内蒙古华云（390KA）", "七月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "七月份")
    private String huaYun39007;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "内蒙古华云（390KA）", "八月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "八月份")
    private String huaYun39008;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "内蒙古华云（390KA）", "九月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "九月份")
    private String huaYun39009;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "内蒙古华云（390KA）", "十月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十月份")
    private String huaYun39010;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "内蒙古华云（390KA）", "十一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十一月份")
    private String huaYun39011;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "内蒙古华云（390KA）", "十二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十二月份")
    private String huaYun39012;

    @ExcelProperty(value = {"300-400kA系列指标体系表", "内蒙古华云（390KA）", "累计"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "累计")
    private String huaYun390accumulative;

}
