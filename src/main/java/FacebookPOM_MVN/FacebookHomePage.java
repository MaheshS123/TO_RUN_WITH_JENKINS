package FacebookPOM_MVN;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class FacebookHomePage 
{
	@FindBy(xpath = "//span[text()='Suhas Powar']")private  WebElement ProfileButton1;

	@FindBy(xpath = "//h1[text()='Suhas Powar']")private  WebElement ActualUserNameText;

	//@FindBy(xpath = "(//div[@class='xu06os2 x1ok221b'])[33]")private  WebElement LogoutButton;

	@FindBy(xpath = "(//div[@class='x1rg5ohu x1n2onr6 x3ajldb x1ja2u2z'])[1]")private  WebElement cornarButton;
	
	@FindBy(xpath = "(//div[@class])[568]")private  WebElement LogoutButton;
	
	
	public FacebookHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnProfile1(WebDriver driver) {
		FacebookCommenMethod.time(driver, 10000);
		ProfileButton1.click();
		FacebookCommenMethod.time(driver, 10000);
	}
	
	public String UserName() {
		String Value = ActualUserNameText.getText();
		return Value;
	}
	
	public void LogOut(WebDriver driver) throws InterruptedException {
		FacebookCommenMethod.time(driver, 5000);
		cornarButton.click();
		Reporter.log("Clicked on corner button");
		Thread.sleep(4000);
		LogoutButton.click();
		Reporter.log("Clicked on log out button");
	}
}
