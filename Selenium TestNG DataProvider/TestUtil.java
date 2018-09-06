package ReadingDataFromFile;

import java.util.ArrayList;

public class TestUtil {
	
	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel() {
	
		       ArrayList<Object[]> myData = new ArrayList<Object[]>(); 
		       try 
		       {
		    	   reader = new Xls_Reader("E://Testdata_From_Excel.xlsx");	   
		       }catch (Exception e)
		       {
		    	   e.printStackTrace();
		       }
		       for (int rowNum = 2; rowNum <= reader.getRowCount("Sheet1");rowNum++) 
		       {
		    	   String Firstname = reader.getCellData("Sheet1", "Firstname", rowNum);
		    	   String Lastname = reader.getCellData("Sheet1", "Lastname", rowNum);
		    	   String Company = reader.getCellData("Sheet1", "Company", rowNum);
		    	   String Address = reader.getCellData("Sheet1", "Address", rowNum);
		    	   String Address2 = reader.getCellData("Sheet1", "Address2", rowNum);
		    	   String City = reader.getCellData("Sheet1", "City", rowNum);
		    	   String PostalCode = reader.getCellData("Sheet1", "PostalCode", rowNum);
		    	   String Other = reader.getCellData("Sheet1", "Other", rowNum);
		    	   String Homephone = reader.getCellData("Sheet1", "Homephone", rowNum);
		    	   String Mobilephone = reader.getCellData("Sheet1", "Mobilephone", rowNum);
		    	   String Alias = reader.getCellData("Sheet1", "Alias", rowNum);
		    	   String Password = reader.getCellData("Sheet1", "Password", rowNum);
		    	   String Email = reader.getCellData("Sheet1", "Email", rowNum);
		    	   
		    	   Object ob[] = {Firstname, Lastname, Company, Address, Address2, City, PostalCode, Other, Homephone, Mobilephone, Alias, Password, Email};
		    	   myData.add(ob);	       
	              }
                   return myData;
                   
        }
	
}
