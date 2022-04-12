package com.zhonglv.benchmarking.utils;


import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;


/**
 * 四个参数分别代表:
 * cellNum:表示要冻结的列数；
 * rowNum:表示要冻结的行数；
 * firstCellNum:表示被固定列右边第一列的列号；
 * firstRollNum :表示被固定行下边第一列的行号;
 *
 * @author yangj
 */
public class ExcelFreezeStrategy implements SheetWriteHandler {
    private int cellNum;
    private int rowNum;
    private int firstCellNum;
    private int firstRollNum;

    public ExcelFreezeStrategy() {
    }

    public ExcelFreezeStrategy(int cellNum, int rowNum, int firstCellNum, int firstRollNum) {
        this.cellNum = cellNum;
        this.rowNum = rowNum;
        this.firstCellNum = firstCellNum;
        this.firstRollNum = firstRollNum;
    }

    @Override
    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
        writeSheetHolder.getSheet().createFreezePane(cellNum, rowNum, firstCellNum, firstRollNum);
    }
}
