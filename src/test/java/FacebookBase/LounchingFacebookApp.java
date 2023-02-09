package FacebookBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

public class LounchingFacebookApp 
{
	protected static WebDriver driver;
	
	public void LounchFB() {
	System.setProperty("webdriver.chrome.driver", "D:\\javaSelenium\\chromedriver.exe");
	ChromeOptions CO=new ChromeOptions();
	CO.addArguments("--disable-notifications");
	driver=new ChromeDriver(CO);
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	Reporter.log("Lounching Facebook Application ", true);
	}

}
