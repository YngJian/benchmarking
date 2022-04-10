package com.zhonglv.benchmarking.utils;


import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.RowWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.List;

public class ExcelFillRowMergeStrategy implements RowWriteHandler {
    // 需要从第几行开始合并，0表示第1行
    private int mergeRowIndex;
    // 合并的哪些列，比如为4时，当前行id和上一行id相同则合并前五列
    private int mergeColumnRegion;

    public ExcelFillRowMergeStrategy() {
    }

    public ExcelFillRowMergeStrategy(int mergeRowIndex, int mergeColumnRegion) {
        this.mergeRowIndex = mergeRowIndex;
        this.mergeColumnRegion = mergeColumnRegion;
    }

    @Override
    public void afterRowDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Integer relativeRowIndex, Boolean isHead) {
        //当前行
        int curRowIndex = row.getRowNum();
        if (curRowIndex > mergeRowIndex) {
            Row preRow = row.getSheet().getRow(curRowIndex - 1);
            mergeWithPreviousRow(writeSheetHolder, row, preRow);
        }
    }

    /**
     * 当前单元格向上合并：当前行的id和上一行的id相同则合并前面（mergeColumnRegion+1）列
     *
     * @param writeSheetHolder writeSheetHolder
     */
    private void mergeWithPreviousRow(WriteSheetHolder writeSheetHolder, Row curRow, Row preRow) {
        // 当前行的第一个Cell
        Cell curFirstCell = curRow.getCell(1);
        Object curFirstData = curFirstCell.getCellType() == CellType.STRING ? curFirstCell.getStringCellValue() : curFirstCell.getNumericCellValue();
        // 上一行的第一个Cell
        Cell preFirstCell = preRow.getCell(1);
        Object preFirstData = preFirstCell.getCellType() == CellType.STRING ? preFirstCell.getStringCellValue() : preFirstCell.getNumericCellValue();

        // 当前行的第一个Cell
        Cell curFirstCell1 = curRow.getCell(mergeColumnRegion);
        Object curFirstData1 = curFirstCell1.getCellType() == CellType.STRING ? curFirstCell1.getStringCellValue() : curFirstCell1.getNumericCellValue();
        // 上一行的第一个Cell
        Cell preFirstCell1 = preRow.getCell(mergeColumnRegion);
        Object preFirstData1 = preFirstCell1.getCellType() == CellType.STRING ? preFirstCell1.getStringCellValue() : preFirstCell1.getNumericCellValue();

        // 当前行的id和上一行的id相同则合并前面（mergeColumnRegion+1）列
        if (curFirstData.equals(preFirstData) && curFirstData1.equals(preFirstData1)) {
            Sheet sheet = writeSheetHolder.getSheet();
            List<CellRangeAddress> mergeRegions = sheet.getMergedRegions();
            boolean isMerged = false;
            for (int i = 0; i < mergeRegions.size() && !isMerged; i++) {
                CellRangeAddress cellRangeAddr = mergeRegions.get(i);
                // 若上一个单元格已经被合并，则先移出原有的合并单元，再重新添加合并单元
                if (cellRangeAddr.isInRange(curRow.getRowNum() - 1, mergeColumnRegion)) {
                    sheet.removeMergedRegion(i);
                    cellRangeAddr.setLastRow(curRow.getRowNum());
                    sheet.addMergedRegion(cellRangeAddr);
                    isMerged = true;
                }
            }
            // 若上一个单元格未被合并，则新增合并单元
            if (!isMerged) {
                CellRangeAddress cellRangeAddress = new CellRangeAddress(curRow.getRowNum() - 1, curRow.getRowNum(), mergeColumnRegion, mergeColumnRegion);
                sheet.addMergedRegion(cellRangeAddress);
            }
        }
    }
}
