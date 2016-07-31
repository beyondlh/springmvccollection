package lh;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        POIFSFileSystem fs=new POIFSFileSystem(new FileInputStream("E:/双闵材料表.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        int rowcount = sheet.getLastRowNum() + 1;
        double finalValue = 0.0;
        for(int i=1;i<rowcount;i++){
            HSSFRow row = sheet.getRow(i);
            HSSFCell cell = row.getCell((short) 8);
            HSSFCellStyle style =  cell.getCellStyle();
           double cellValue =  cell.getNumericCellValue();
            if(style.getFillForegroundColor() == 64){
                finalValue = finalValue + cellValue;
            }else{
                cell.setCellValue(finalValue);
                finalValue = 0.0;
            }
        }
        OutputStream os= new FileOutputStream("D:/3.xls");
        wb.write(os);
        os.close();
        wb.close();
    }
}
