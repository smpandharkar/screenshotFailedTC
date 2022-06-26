package ListenerDemo;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	
	public static void initialize() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
	}
	
	public void FailedScreenshot(String testMethodName) {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();

		String TimeStamp = d.toString().replace(":", "_").replace(" ", "_");
		try {
			
			FileUtils.copyFile(srcFile, new File("C:/Users/swati/eclipse-workspace/screenshotFailedTC/Screenshots/"+
			testMethodName + "_" + TimeStamp + ".png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
