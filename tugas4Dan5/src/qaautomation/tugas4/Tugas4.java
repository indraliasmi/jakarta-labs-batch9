package qaautomation.tugas4;


import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Tugas4 {
	@Test
	public void testIframe() {
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://yopmail.com/en/");
		driver.findElement(By.xpath("//input[@id='login']")).sendKeys("automationtest");
		driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
		//Iframe1
		driver.switchTo().frame("ifinbox");
		driver.findElement(By.xpath("//div[normalize-space()='Your monthly subscription invoice']")).click();
		//Iframe2
		driver.switchTo().parentFrame();
		driver.switchTo().frame("ifmail");
		String text = driver.findElement(By.xpath("//div[@class='ellipsis nw b f18']")).getText();
		System.out.println(text);
		
		
		
	}

}
