package stepDefs;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import commonutils.BaseUtil;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class commonStepDefs extends BaseUtil{

	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] filecontent = FileUtils.readFileToByteArray(screenshot);
		scenario.attach(filecontent, "image/png", "screenshot");
	}

}
