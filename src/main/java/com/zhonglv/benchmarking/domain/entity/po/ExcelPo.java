package com.zhonglv.benchmarking.domain.entity.po;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.*;
import com.alibaba.excel.enums.BooleanEnum;
import com.alibaba.excel.enums.poi.BorderStyleEnum;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import com.alibaba.excel.enums.poi.VerticalAlignmentEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@HeadStyle(horizontalAlignment = HorizontalAlignmentEnum.CENTER, verticalAlignment = VerticalAlignmentEnum.CENTER,
        fillBackgroundColor = 1)
@ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.CENTER, verticalAlignment = VerticalAlignmentEnum.CENTER,
        wrapped = BooleanEnum.TRUE, borderTop = BorderStyleEnum.THIN, borderBottom = BorderStyleEnum.THIN,
        borderLeft = BorderStyleEnum.THIN, borderRight = BorderStyleEnum.THIN)
@ContentRowHeight(value = 20)
@ContentFontStyle(fontName = "宋体")
@ApiModel(value = "系列excel的数据")
public class ExcelPo {
    /**
     * 三级指标序号
     */
    @ExcelProperty(value = "序号", index = 0)
    @ApiModelProperty(value = "序号")
    private String number;

    /**
     * 工序分类
     */
    @ExcelProperty(value = "工序分类",index = 1)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "工序分类")
    private String workingProcedureClassification;

    /**
     * 指标类别
     */
    @ExcelProperty(value = "指标类别",index = 2)
    @ColumnWidth(value = 20)
    @ApiModelProperty(value = "指标类别")
    private String categoryOfIndicators;

    /**
     * 指标
     */
    @ExcelProperty(value = "指标",index = 3)
    @ColumnWidth(value = 26)
    @ApiModelProperty(value = "指标")
    private String indicatorsName;

    /**
     * 单位
     */
    @ExcelProperty(value = "单位",index = 4)
    @ColumnWidth(value = 12)
    @ApiModelProperty(value = "单位")
    private String unit;

    /**
     * 指标等级
     */
    @ExcelProperty(value = "指标等级", index = 5)
    @ApiModelProperty(value = "指标等级")
    private String indicatorsGrade;
}
