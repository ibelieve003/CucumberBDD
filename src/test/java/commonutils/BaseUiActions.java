package commonutils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUiActions extends BaseUtil{

	public static WebDriver driver;

	public BaseUiActions() {
		driver = getDriver();
	}
	
	public void setImplicitWaitTime(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	
	public void explicitlyWait(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(element),
				ExpectedConditions.elementToBeClickable(element)));
	}

	// uses WebElement
	public void jseClick(WebElement element) {
		explicitlyWait(element,60);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
	}
	
	
	public void click(WebElement element) {
		explicitlyWait(element,60);
		element.click();
	}
	
	
	public void sendKeys(WebElement element,String text) {
		explicitlyWait(element,60);
		element.sendKeys(text);
	}
	
	
	// uses By
	public void explicitlyWait(By by, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfElementLocated(by),
				ExpectedConditions.elementToBeClickable(by)));
	}
	
	public void jseClick(By by) {
		explicitlyWait(by,60);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(by);
		jse.executeScript("arguments[0].click();", ele);
	}
	
	public void click(By by) {
		explicitlyWait(by,60);
		driver.findElement(by).click();
	}
	
	public void sendKeys(By by,String text) {
		explicitlyWait(by,60);
		driver.findElement(by).sendKeys(text);
	}
	
}
