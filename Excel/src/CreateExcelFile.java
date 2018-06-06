import java.io.File;
import java.io.FileOutputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelFile{
   public static void main(String[] args) throws Exception {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection connect = DriverManager.getConnection( 
    		  "jdbc:oracle:thin:@localhost:1521:XE","system","12345");
      
      Statement statement = connect.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from users");
      XSSFWorkbook workbook = new XSSFWorkbook(); 
      XSSFSheet spreadsheet = workbook.createSheet("teja");
      
      XSSFRow row = spreadsheet.createRow(1);
      XSSFCell cell;
      cell = row.createCell(1);
      cell.setCellValue("sno");
      cell = row.createCell(2);
      cell.setCellValue("name");
      cell = row.createCell(3);
      cell.setCellValue("city");
      cell = row.createCell(4);
      cell.setCellValue("mobile");
       int i = 2;

      while(resultSet.next()) {
         row = spreadsheet.createRow(i);
         cell = row.createCell(1);
         cell.setCellValue(resultSet.getInt("sno"));
         cell = row.createCell(2);
         cell.setCellValue(resultSet.getString("name"));
         cell = row.createCell(3);
         cell.setCellValue(resultSet.getString("city"));
         cell = row.createCell(4);
         cell.setCellValue(resultSet.getString("mobile"));
         i++;
      }

      FileOutputStream out = new FileOutputStream(new File("G:\\teja.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println("exceldatabase.xlsx written successfully");
   }
}