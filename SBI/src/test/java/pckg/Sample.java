package pckg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	
	@Test
	public void test1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String sessionId=driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.youtube.com/channel/UCutQjK5N6zIT-vXqXa4WI0A");
		String title=driver.findElement(By.id("text")).getText();
		System.out.println("Youtube channel title :" + title);
		driver.switchTo().window(sessionId);
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("the techie automation labs  selenium java by bakkappa");
		
		Thread.sleep(4000);
		driver.close();
		
	}

}
