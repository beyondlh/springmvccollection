package lh;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by minim on 2016/8/31.
 */
public class Test {
    private static int rowNum = 6;
    private static int currentRowNum = 5;

    public static void mm() throws Exception {
        if (currentRowNum >= rowNum && rowNum > 6) {
            return;
        }
        String filePath = "D:/路况评定去掉下行数据与长短链.xls";
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filePath));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(1);
        rowNum = sheet.getLastRowNum();
        double finalValue = 0.0;
        for (int i = currentRowNum; i < rowNum; i++) {
            HSSFRow row = sheet.getRow(i);
            HSSFRow rowNext = sheet.getRow(i + 1);
            if (row != null && rowNext != null) {

                String LXBM = row.getCell((short) 2).getStringCellValue();
                String LXBMNext = rowNext.getCell((short) 2).getStringCellValue();


                HSSFCell cellQDZH = row.getCell((short) 4);
                HSSFCell cellZDZH = row.getCell((short) 5);

                HSSFCell cellQDZHNext = rowNext.getCell((short) 4);
                HSSFCell cellZDZHNext = rowNext.getCell((short) 5);

                HSSFCell cellSXX = row.getCell((short) 6);
                HSSFCell cellNextSXX = rowNext.getCell((short) 6);
                double zdzh = cellZDZH.getNumericCellValue();//止点桩号
//            double zdzh = cellZDZH.getNumericCellValue();//止点桩号
                double qdzh = cellQDZH.getNumericCellValue();//止点桩号
                double qdzhNext = cellQDZHNext.getNumericCellValue();//起点桩号
/*                if (LXBM.equals(LXBMNext) && new Double(qdzh).equals(new Double(qdzhNext))) {
                    String iscl = row.getCell(20).getStringCellValue().trim();
                    if (iscl.indexOf("长链")==0) {
                        sheet.removeRow(row);
                    } else {
                        sheet.removeRow(rowNext);
                    }
                }*/
                if (new Double(qdzhNext).equals(new Double(zdzh)) && LXBM.equals(LXBMNext)) {

                    cellNextSXX.setCellValue(cellSXX.getStringCellValue());
                }
                currentRowNum = currentRowNum + 1;
            }
        }
        OutputStream os = new FileOutputStream("D:/路况评定去掉下行数据与长短链.xls");
        wb.write(os);
        os.close();
        wb.close();
    }

}