package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_project.*;

public class Homepage extends Baseclass {

	@FindBy(xpath="//div[@class='nav-line-1-container']") private WebElement AccountBtn;
	@FindBy(id="ap_email_login-name") private WebElement EmailInput;
	@FindBy(xpath="//input[@class='a-button-input']") private WebElement EmailNext;
	@FindBy(id="ap_password") private WebElement PwdInput;
	@FindBy(id="signInSubmit") private WebElement SignInBtn;
	
	@FindBy(linkText="Mobiles") private WebElement mobileBtn;
	@FindBy(linkText="Smartphones & Basic Mobiles") private WebElement smartBtn;
	@FindBy(linkText="iQOO Z9x 5G (Tornado Green, 6GB RAM, 128GB Storage) | Snapdragon 6 Gen 1 with 560K+ AnTuTu Score | 6000 mAh Battery with 7.99mm Slim design | 44W FlashCharge") 
				private WebElement prodOne;
	@FindBy(linkText="Redmi 12 5G Jade Black 6GB RAM 128GB ROM") 
	private WebElement prodTwo;
	@FindBy(xpath="//*[@id=\"add-to-cart-button\"]") private WebElement addToCart;
	
	public Homepage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ToLogin() {
		AccountBtn.click();
	}
	
	public void toMobile()
	{
		mobileBtn.click();
			}
	public void toSmartMobile()
	{
		toMobile();
		smartBtn.click();
	}
	public void toProd()
	{
		toSmartMobile();
		prodOne.click();
			}
	
}
