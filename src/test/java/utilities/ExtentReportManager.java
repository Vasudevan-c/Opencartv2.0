package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseClass.TestBase;

public class ExtentReportManager implements ITestListener {

	ExtentSparkReporter sparkReporter;
	ExtentReports extents;
	ExtentTest test;
	String repName;

	public void onStart(ITestContext testcontext) {
		
		

		String timeStamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\" + repName);
		sparkReporter.config().setDocumentTitle("Opencart_V_1.00 Report ");
		sparkReporter.config().setReportName("Opencart Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);

		extents = new ExtentReports();
		extents.attachReporter(sparkReporter);
		extents.setSystemInfo("Application", "opencart");
		extents.setSystemInfo("Module", "Admin");
		extents.setSystemInfo("Sub Module", "Customers");
		extents.setSystemInfo("User Name", System.getProperty("user.name"));
		extents.setSystemInfo("Environment", "QA");

		String os = testcontext.getCurrentXmlTest().getParameter("os");
		extents.setSystemInfo("Operating System", os);

		String browser = testcontext.getCurrentXmlTest().getParameter("browser");
		extents.setSystemInfo("Browser", browser);

		List<String> includedGroups = testcontext.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			extents.setSystemInfo("Groups", includedGroups.toString());
		}

	}

	public void onTestSuccess(ITestResult result) {

		test = extents.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() + "got successfully excuted");

	}

	public void onTestFailure(ITestResult result) {

		test = extents.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() + "got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());

		try {
			String impath = new TestBase().captureScreen(result.getName());
			test.addScreenCaptureFromPath(impath);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		test = extents.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + "got Skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());

	}

	public void onFinish(ITestContext context) {

		extents.flush();
		String pathExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
		File extentReport = new File(pathExtentReport);

		try {

			Desktop.getDesktop().browse(extentReport.toURI());

		} catch (IOException e1) {
			e1.printStackTrace();

		}

	}

}
