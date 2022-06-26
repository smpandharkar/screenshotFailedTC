package ListenerDemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners (ListenerDemo.TestStatusListener.class)
public class Testcases extends Base {
	@BeforeTest
	public void setup() {
		initialize();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void ScreenshotTest1() {
		driver.findElement(By.linkText("Best Sellers")).click();
	}
		
	@Test
	public void ScreenshotTest2() {
		//Test case will fail as expected and actual title are not matching
		Assert.assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile");
	} 
		
}

