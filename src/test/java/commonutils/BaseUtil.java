package commonutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtil {
	public static WebDriver driver;
	public static PropertiesReader props;
	
	public static void setBrowser() {
	    ChromeOptions chromeOptions = new ChromeOptions();
	    EdgeOptions edgeOptions = new EdgeOptions();

	    if (Contstants.BROWSER_NAME.trim().equalsIgnoreCase("Chrome")) {
	        WebDriverManager.chromedriver().setup();
	        if(Contstants.BROWSER_HEADLESS) {
	        	chromeOptions.addArguments("--headless");
	        }
	        driver = new ChromeDriver(chromeOptions);
	    } else if (Contstants.BROWSER_NAME.trim().equalsIgnoreCase("Edge")) {
	        WebDriverManager.edgedriver().setup();
	        if(Contstants.BROWSER_HEADLESS) {
	        	edgeOptions.addArguments("--headless");
	        }
	        if(Contstants.EDGE_IE_MODE) {
		        edgeOptions.addArguments("--ie-mode");
	        }
	        driver = new EdgeDriver(edgeOptions);
	    } else {
	        throw new IllegalArgumentException("Unsupported browser: " + Contstants.BROWSER_NAME);
	    }
	    driver.manage().window().maximize();
	    Contstants.driver = driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
