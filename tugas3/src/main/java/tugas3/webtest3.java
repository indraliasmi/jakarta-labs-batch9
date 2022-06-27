package tugas3;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProfilePage;

public class webtest3 extends BaseWebTest3 {
	LoginPage loginpage = new LoginPage(driver, explicitWait);
	ProfilePage coba1 = new ProfilePage(driver, explicitWait);
	
	
	
	
	@Test
	public void login() {
		//login
		loginpage.loginWeb("standard_user", "secret_sauce");
		//profilepage
		driver.get().findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
		driver.get().findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.get().findElement(By.xpath("//button[@id='checkout']")).click();
		coba1.loginWeb("indra", "asmi", "234234");
		//checkout
		driver.get().findElement(By.xpath("//button[@id='finish']")).click();
		
		
		String actualText = driver.get().findElement(By.xpath("//h2[@class='complete-header']")).getText();
		String expectedText = "THANK YOU FOR YOUR ORDER";

		Assert.assertTrue(actualText.contains(expectedText));
	}
}
