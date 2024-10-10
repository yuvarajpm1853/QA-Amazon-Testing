package generic_project;

import java.io.*;
import java.util.Properties;
import org.testng.annotations.DataProvider;

public class utilityclass extends Baseclass {

	public static String readPDFData(String key) throws IOException
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//TestData//config.properties");
		Properties prop = new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		return value;
	}
		
	@DataProvider(name="credentials")
	public Object[][] getData() throws IOException
	{
		XLUtility excel = new XLUtility(System.getProperty("user.dir")+"//TestData//TestData.xlsx");
		Object[][] data= excel.twoDArray("loginCredentials");
		return data;
	}
	
//	public static void main(String[] args) throws IOException {
//		XLUtility excel = new XLUtility(System.getProperty("user.dir")+"//TestData//TestData.xlsx");
//		Object[][] data= excel.twoDArray("loginCredentials");
//		
//	}
	
//	System.out.print(getCellData(sheet, i, j)+"  ");
}
