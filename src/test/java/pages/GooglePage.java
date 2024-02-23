package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonutils.BaseUiActions;

public class GooglePage extends BaseUiActions {
	
	public GooglePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Google']")
	public WebElement googleLogo;

	@FindBy(xpath = "//textarea[@name='q']")
	public WebElement searchTextBox;

	@FindBy(xpath = "(//input[@name='btnK'])[2]")
	public WebElement searchButton;

	@FindBy(xpath = "//div[@id='rcnt']")
	public WebElement searchResultDiv;
	
	public void launchGoogle() {
		driver.get(props.getValue("googleURL"));
	}
}
