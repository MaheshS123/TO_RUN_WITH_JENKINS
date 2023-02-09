package FacebookPOM_MVN;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class FacebookLoginPage {

	@FindBy(id = "email") private WebElement IDTab;
	@FindBy(id = "pass") private WebElement PassTab;
	@FindBy(xpath = "//button[@value='1']") private WebElement LoginButton;
	
	public FacebookLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void EnterID(String ID) throws EncryptedDocumentException, IOException {
		
		IDTab.sendKeys(ID);
		Reporter.log("Mobile number entered", true);
	}
public void EnterPass(String Pass) throws EncryptedDocumentException, IOException {
		
		PassTab.sendKeys(Pass);
		
	}
public void ClickOnSignIn()  {
	
	LoginButton.click();
}
	
	
}
