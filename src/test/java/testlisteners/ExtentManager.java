package testlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance() {
		String projectPath = System.getProperty("user.dir");
		String reportFile = projectPath + "/reports/extent-html-report/extentReporter.html";
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFile);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("ExtendReporter.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("GenAI UW-Copilot");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		return extent;
	}
}