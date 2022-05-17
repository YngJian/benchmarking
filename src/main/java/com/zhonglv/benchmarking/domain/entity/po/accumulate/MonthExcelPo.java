package com.zhonglv.benchmarking.domain.entity.po.accumulate;

import com.alibaba.excel.annotation.write.style.*;
import com.alibaba.excel.enums.BooleanEnum;
import com.alibaba.excel.enums.poi.BorderStyleEnum;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import com.alibaba.excel.enums.poi.VerticalAlignmentEnum;
import io.swagger.annotations.ApiModel;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/5/17 18:23
 */
@HeadStyle(horizontalAlignment = HorizontalAlignmentEnum.CENTER, verticalAlignment = VerticalAlignmentEnum.CENTER,
        fillBackgroundColor = 1)
@ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.CENTER, verticalAlignment = VerticalAlignmentEnum.CENTER,
        wrapped = BooleanEnum.TRUE, borderTop = BorderStyleEnum.THIN, borderBottom = BorderStyleEnum.THIN,
        borderLeft = BorderStyleEnum.THIN, borderRight = BorderStyleEnum.THIN)
@ContentRowHeight(value = 20)
@HeadRowHeight(value = 35)
@HeadFontStyle(fontHeightInPoints = 13)
@ContentFontStyle(fontName = "宋体")
@ApiModel(value = "系列excel的数据")
public class MonthExcelPo {
}
