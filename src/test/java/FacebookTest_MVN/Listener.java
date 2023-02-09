package FacebookTest_MVN;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import FacebookBase.LounchingFacebookApp;
import net.bytebuddy.utility.RandomString;

public class Listener extends LounchingFacebookApp  implements ITestListener
{

	public void onTestFailure(ITestResult result) {
		Reporter.log("TC "+result.getName()+" is Fail", true);	
		try {
			String rnd=RandomString.make(2);
			FacebookPOM_MVN.FacebookCommenMethod.SS(driver,"TC "+result.getName()+" is Fail "+rnd);
		} catch (IOException e) {
			
			e.printStackTrace();
	}
	}
	public void onTestSuccess(ITestResult result) {
		
		Reporter.log("TC "+result.getName()+" is passed successfully", true);  	
		
	}
	
	public void onTestSkipped(ITestResult result) {
		
		Reporter.log("TC "+result.getName()+" is Skipped check it ", true);
		
	}
	
}
