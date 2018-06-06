import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class DataConvert{
	public static void main(String[] args)throws IOException{
	String sno;
	String name;
	String city;
	String mobile;
	List list=new ArrayList();
		
	try {

        FileInputStream file = new FileInputStream(new File("G:\\nag.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        while(rowIterator.hasNext())
        {
            Row row = rowIterator.next();
            //For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();

            while(cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                //This will change all Cell Types to String
                cell.setCellType(Cell.CELL_TYPE_STRING);
                switch(cell.getCellType()) 
                {
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.println("boolean===>>>"+cell.getBooleanCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:

                        break;
                    case Cell.CELL_TYPE_STRING:

                       list.add(cell.getStringCellValue());

                                                 break;
                }


            }
            sno=row.getCell(0).getStringCellValue();
            name=row.getCell(1).getStringCellValue();
            city=row.getCell(2).getStringCellValue();
            mobile=row.getCell(3).getStringCellValue();
            System.out.println(sno+name+city+mobile);
            DBOperations.InsertRowInDB(sno,name,city,mobile);
            System.out.println("");


        }
        file.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
    public void InsertRowInDB(String name,String empid,String add,String mobile) throws SQLException{
try
{
    	Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.
       getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
        PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?,?)");
        ps.setString(1, name);
        ps.setString(2, empid);
        ps.setString(3, add);
        ps.setString(4, mobile);
    ps.executeUpdate();
}
catch(Exception e) {
	

    System.out.println("Values Inserted Successfully");
e.printStackTrace();    
}
}
}