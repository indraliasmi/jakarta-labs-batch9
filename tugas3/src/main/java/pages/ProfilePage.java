package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage{

	By item = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
	By icon = By.xpath("//a[@class='shopping_cart_link']");
	By checkout = By.xpath("//button[@id='checkout']\"");
	By firstname = By.xpath("//input[@id='first-name']");
	By lastname = By.xpath("//input[@id='last-name']");
	By postcode = By.xpath("//input[@id='postal-code']");
	By continu = By.xpath("//input[@id='continue']");
	
	public ProfilePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}

	public void loginWeb(String user, String pass, String number) {
		setText (firstname, user);
		setText (lastname, user);
		setText (postcode, user);
		clickAndWait(continu);
		
		
		
	}
	
}
