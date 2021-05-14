package utils;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import static config.ConfigurationManager.configuration;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;


public class ExcelDataUtils {
	
	private static final Logger logger = LogManager.getLogger(ExcelDataUtils.class);

    private static Sheet ExcelWSheet;
    private static Workbook ExcelWBook;
    private static Cell Cell;


    public static Object[][] getExcelData() throws Exception {

        String[][] dataArray = null;

        try {
            logger.info(configuration().excelDataFile());
            FileInputStream ExcelFile = new FileInputStream(configuration().excelDataFile());
            ExcelWBook = WorkbookFactory.create(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(configuration().excelDataSheet());

            int startRow = 1;
            int startCol = 0;
            int ci, cj;
            int totalRows = ExcelWSheet.getLastRowNum();
            int totalCols = Integer.parseInt(configuration().excelTotalCols());
            dataArray = new String[totalRows][totalCols];

            ci = 0;
            for (int i = startRow; i <= totalRows; i++, ci++) {
                cj = 0;
                for (int j = startCol; j < totalCols; j++, cj++) {
                    dataArray[ci][cj] = getCellData(i, j);
                    logger.info(dataArray[ci][cj]);
                }
            }

        } catch (FileNotFoundException e) {
            logger.error("Excel Data File not found. Check file location", e);
        } catch (IOException e) {
            logger.error("Could not read the Excel sheet", e);
        }

        return (dataArray);

    }


    public static String getCellData (int RowNum, int ColNum) throws Exception {

        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            String CellData = Cell.getStringCellValue();
            return CellData;

        } catch (Exception e) {
            logger.error(e.getMessage());
            throw (e);
        }

    }

}




