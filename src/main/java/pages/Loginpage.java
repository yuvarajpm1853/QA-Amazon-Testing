package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_project.Baseclass;
import generic_project.BrowserFactory;

public class Loginpage extends Baseclass {
	@FindBy(xpath="//input[@type='email']") private WebElement EmailInput;
	@FindBy(xpath="//input[@class='a-button-input']") private WebElement EmailNext;
	@FindBy(id="ap_password") private WebElement PwdInput;
	@FindBy(id="signInSubmit") private WebElement SignInBtn;
	
	@FindBy(xpath="//div[@class='a-box a-alert-inline a-alert-inline-error a-spacing-top-small']") private WebElement errorMsg;
	
//	WebElement errorMsg;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public Loginpage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void enterCred(String cred) {
		
		BrowserFactory.waitDriver(driver);
		EmailInput.sendKeys(cred);
		BrowserFactory.waitDriver(driver);
		EmailNext.click();
		BrowserFactory.waitDriver(driver);
	}
	
	public void enterPWD(String pwd) {
		BrowserFactory.waitDriver(driver);
		PwdInput.sendKeys(pwd);
		SignInBtn.click();
		BrowserFactory.waitDriver(driver);
	}
	public String verifyURL()
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	public String getErrorMsg()
	{
//		errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a-box a-alert-inline a-alert-inline-error a-spacing-top-small']")));
		return errorMsg.getText();
	}
}