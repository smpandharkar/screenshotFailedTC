package ListenerDemo;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestStatusListener extends Base implements ITestListener{

	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test case failed");
		try 
		{
			FailedScreenshot(result.getName());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

}
