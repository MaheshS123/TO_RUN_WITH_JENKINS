package FacebookPOM_MVN;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.Reader;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class FacebookCommenMethod 
{
	
	

	//Excel reading
	public static String ExcelSheetReading(int row,int cell) throws EncryptedDocumentException, IOException
	{
		File MyFile=new File("D:\\javaSelenium\\My Excel.xlsx");
	
	String Value=WorkbookFactory.create(MyFile).getSheet("Sheet7").getRow(row).getCell(cell).getStringCellValue();
	Reporter.log("Entered data is "+Value, true);
	return Value;
	}
	
	//ScreenShot
	public static void SS(WebDriver driver,String SSName) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("D:\\javaSelenium"+SSName+".png");
	
		String rnd=RandomString.make(2);
		
		FileHandler.copy(src, dest);
		Reporter.log("Screenshot is taken at"+dest+""+rnd, true);
		Reporter.log("Name of taken Screenshot is "+SSName, true);
		
	}
	
	//ImplicitWait
	public static void time(WebDriver driver,int wait)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(wait));
		Reporter.log("Imlicit wait is appplyed ", true);
		Reporter.log(" appplyed wait is "+wait+"ms", true);
		
	}
	
	//Properties
	public static String PropertiesFileReading(String key) throws IOException
	{
	Properties prop=new Properties();
	
	FileInputStream fIS=new FileInputStream("C:\\Users\\Mahesh Shelke\\eclipse-workspace\\FaceBook\\src\\MyProperties.properties");
	
	prop.load(fIS);
	
	String value = prop.getProperty(key);
	Reporter.log("Reading data from peroperty file", true);
	Reporter.log("data is "+value, true);
	return value;

	}
			
}
