package FacebookTest_MVN;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import FacebookBase.LounchingFacebookApp;

import FacebookPOM_MVN.FacebookHomePage;


@Listeners(FacebookTest_MVN.Listener.class)
public class ValidatingUserName extends LounchingFacebookApp
{
	FacebookPOM_MVN.FacebookLoginPage LP;
	FacebookPOM_MVN.FacebookHomePage HP;
  
	@BeforeMethod
  public void lounchFacebook() throws EncryptedDocumentException, IOException, InterruptedException {
		LounchFB();
		FacebookPOM_MVN.FacebookCommenMethod.time(driver, 1000);
		LP=new FacebookPOM_MVN.FacebookLoginPage(driver);
		HP=new FacebookHomePage(driver);
		
	
  }
	
	@Test(dataProvider = "FB_Data")
  public void ValidatingUserName(String ID,String Pass,String UN) throws EncryptedDocumentException, IOException, InterruptedException 
{	
		LP.EnterID(ID);

		LP.EnterPass(Pass);

		LP.ClickOnSignIn();

		Thread.sleep(1000);


		HP.ClickOnProfile1(driver);

		Reporter.log("Clicked1", true);

		
		System.out.println(HP.UserName());
		
		Assert.assertEquals(HP.UserName(),UN ,"Actual & expected UserName Are not matching TC fail");

	//	FacebookCommenMethod.SS(driver, FacebookCommenMethod.ExcelSheetReading(0, 3));
}
	@AfterMethod
	public void LogOutFromFacebook() throws InterruptedException
	{
//		HP.LogOut(driver);
		Thread.sleep(2000);
		driver.close();
	}
	
	@DataProvider(name = "FB_Data")
	public String[][] LogIndataFORFacebook() throws InterruptedException
	{
		String[][] Data= {{"9156892856","Suhas@123","Suhas Powar (Son of surekha)"}};
		return Data;
		
	}
}
