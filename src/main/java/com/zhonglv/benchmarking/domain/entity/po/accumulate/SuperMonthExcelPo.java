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
@ApiModel(value = "按月累计系列为1的数据")
public class SuperMonthExcelPo extends MonthExcelPo {
    /**
     * 三级指标序号
     */
    @ExcelProperty(value = {"500kA系列指标体系表", "序号", "序号"})
    @ApiModelProperty(value = "序号")
    @ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.LEFT, verticalAlignment = VerticalAlignmentEnum.CENTER,
            wrapped = BooleanEnum.TRUE, borderTop = BorderStyleEnum.THIN, borderBottom = BorderStyleEnum.THIN,
            borderLeft = BorderStyleEnum.THIN, borderRight = BorderStyleEnum.THIN)
    private String number;

    /**
     * 工序分类
     */
    @ExcelProperty(value = {"500kA系列指标体系表", "工序分类", "工序分类"})
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "工序分类")
    private String workingProcedureClassification;

    /**
     * 指标类别
     */
    @ExcelProperty(value = {"500kA系列指标体系表", "指标类别", "指标类别"})
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "指标类别")
    private String categoryOfIndicators;

    /**
     * 指标
     */
    @ExcelProperty(value = {"500kA系列指标体系表", "指标", "指标"})
    @ColumnWidth(value = 26)
    @ApiModelProperty(value = "指标")
    private String indicatorsName;

    /**
     * 单位
     */
    @ExcelProperty(value = {"500kA系列指标体系表", "单位", "单位"})
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "单位")
    private String unit;

    /**
     * 指标等级
     */
    @ExcelProperty(value = {"500kA系列指标体系表", "指标等级", "指标等级"})
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "指标等级")
    private String indicatorsGrade;
    /**
     * 标杆企业
     */
    @ApiModelProperty(value = "标杆企业")
    @ExcelProperty(value = {"500kA系列指标体系表", "标杆企业", "标杆企业"})
    @ColumnWidth(value = 15)
    private String benchmarkingEnterprise;

    /**
     * 公司年平均水平基准值
     */
    @ExcelProperty(value = {"500kA系列指标体系表", "2021年公司年平均水平基准值", "2021年公司年平均水平基准值"})
    @ColumnWidth(value = 18)
    @ApiModelProperty(value = "2021年公司年平均水平基准值")
    private String averageReferenceValue;

    @ExcelProperty(value = {"500kA系列指标体系表", "山西中润（500kA）", "一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "一月份")
    private String shanXi50001;

    @ExcelProperty(value = {"500kA系列指标体系表", "山西中润（500kA）", "二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "二月份")
    private String shanXi50002;

    @ExcelProperty(value = {"500kA系列指标体系表", "山西中润（500kA）", "三月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "三月份")
    private String shanXi50003;

    @ExcelProperty(value = {"500kA系列指标体系表", "山西中润（500kA）", "四月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "四月份")
    private String shanXi50004;

    @ExcelProperty(value = {"500kA系列指标体系表", "山西中润（500kA）", "五月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "五月份")
    private String shanXi50005;

    @ExcelProperty(value = {"500kA系列指标体系表", "山西中润（500kA）", "六月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "六月份")
    private String shanXi50006;

    @ExcelProperty(value = {"500kA系列指标体系表", "山西中润（500kA）", "七月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "七月份")
    private String shanXi50007;

    @ExcelProperty(value = {"500kA系列指标体系表", "山西中润（500kA）", "八月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "八月份")
    private String shanXi50008;

    @ExcelProperty(value = {"500kA系列指标体系表", "山西中润（500kA）", "九月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "九月份")
    private String shanXi50009;

    @ExcelProperty(value = {"500kA系列指标体系表", "山西中润（500kA）", "十月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十月份")
    private String shanXi50010;

    @ExcelProperty(value = {"500kA系列指标体系表", "山西中润（500kA）", "十一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十一月份")
    private String shanXi50011;

    @ExcelProperty(value = {"500kA系列指标体系表", "山西中润（500kA）", "十二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十二月份")
    private String shanXi50012;

    @ExcelProperty(value = {"500kA系列指标体系表", "山西中润（500kA）", "累计"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "累计")
    private String shanXi500accumulative;

    @ExcelProperty(value = {"500kA系列指标体系表", "内蒙古华云（500kA）", "一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "一月份")
    private String huaYun50001;

    @ExcelProperty(value = {"500kA系列指标体系表", "内蒙古华云（500kA）", "二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "二月份")
    private String huaYun50002;

    @ExcelProperty(value = {"500kA系列指标体系表", "内蒙古华云（500kA）", "三月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "三月份")
    private String huaYun50003;

    @ExcelProperty(value = {"500kA系列指标体系表", "内蒙古华云（500kA）", "四月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "四月份")
    private String huaYun50004;

    @ExcelProperty(value = {"500kA系列指标体系表", "内蒙古华云（500kA）", "五月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "五月份")
    private String huaYun50005;

    @ExcelProperty(value = {"500kA系列指标体系表", "内蒙古华云（500kA）", "六月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "六月份")
    private String huaYun50006;

    @ExcelProperty(value = {"500kA系列指标体系表", "内蒙古华云（500kA）", "七月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "七月份")
    private String huaYun50007;

    @ExcelProperty(value = {"500kA系列指标体系表", "内蒙古华云（500kA）", "八月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "八月份")
    private String huaYun50008;

    @ExcelProperty(value = {"500kA系列指标体系表", "内蒙古华云（500kA）", "九月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "九月份")
    private String huaYun50009;

    @ExcelProperty(value = {"500kA系列指标体系表", "内蒙古华云（500kA）", "十月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十月份")
    private String huaYun50010;

    @ExcelProperty(value = {"500kA系列指标体系表", "内蒙古华云（500kA）", "十一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十一月份")
    private String huaYun50011;

    @ExcelProperty(value = {"500kA系列指标体系表", "内蒙古华云（500kA）", "十二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十二月份")
    private String huaYun50012;

    @ExcelProperty(value = {"500kA系列指标体系表", "内蒙古华云（500kA）", "累计"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "累计")
    private String huaYun500accumulative;

    @ExcelProperty(value = {"500kA系列指标体系表", "连城分公司（500kA）", "一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "一月份")
    private String lianCheng50001;

    @ExcelProperty(value = {"500kA系列指标体系表", "连城分公司（500kA）", "二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "二月份")
    private String lianCheng50002;

    @ExcelProperty(value = {"500kA系列指标体系表", "连城分公司（500kA）", "三月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "三月份")
    private String lianCheng50003;

    @ExcelProperty(value = {"500kA系列指标体系表", "连城分公司（500kA）", "四月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "四月份")
    private String lianCheng50004;

    @ExcelProperty(value = {"500kA系列指标体系表", "连城分公司（500kA）", "五月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "五月份")
    private String lianCheng50005;

    @ExcelProperty(value = {"500kA系列指标体系表", "连城分公司（500kA）", "六月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "六月份")
    private String lianCheng50006;

    @ExcelProperty(value = {"500kA系列指标体系表", "连城分公司（500kA）", "七月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "七月份")
    private String lianCheng50007;

    @ExcelProperty(value = {"500kA系列指标体系表", "连城分公司（500kA）", "八月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "八月份")
    private String lianCheng50008;

    @ExcelProperty(value = {"500kA系列指标体系表", "连城分公司（500kA）", "九月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "九月份")
    private String lianCheng50009;

    @ExcelProperty(value = {"500kA系列指标体系表", "连城分公司（500kA）", "十月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十月份")
    private String lianCheng50010;

    @ExcelProperty(value = {"500kA系列指标体系表", "连城分公司（500kA）", "十一月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十一月份")
    private String lianCheng50011;

    @ExcelProperty(value = {"500kA系列指标体系表", "连城分公司（500kA）", "十二月份"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "十二月份")
    private String lianCheng50012;

    @ExcelProperty(value = {"500kA系列指标体系表", "连城分公司（500kA）", "累计"})
    @ColumnWidth(value = 15)
    @ApiModelProperty(value = "累计")
    private String lianCheng500accumulative;
}
