package generic_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.edge.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class BrowserFactory {
	
	public WebDriver driver;
	
	public static  void waitDriver(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	}
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
    	
        if (browserName.equalsIgnoreCase("chrome")) {
        	WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
        	WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
        	WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }else if (browserName.equalsIgnoreCase("edge")) {
        	WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else {
            System.out.println("Does not support this browser");
            return null;
        }

//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(appURL);
        return driver;
    }

    public static void quitBrowser(WebDriver driver) {
        driver.quit();
    }
}
