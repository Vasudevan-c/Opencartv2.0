package baseClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {

	public WebDriver driver;
	public static Logger logger;
	public Properties p;

	@BeforeClass(groups = {"Sanity","Regression","Master"})
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {

		logger = LogManager.getLogger(this.getClass());

		FileReader file = new FileReader("./src//test//resources//config.properties");

		p = new Properties();
		p.load(file);

		switch (br.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Browser");
			return;

		}
		// driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
		// driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass(groups = {"Sanity","Regression","Master"})

	public void tearDown() {
		driver.quit();

	}

	public String randomString() {

		String generateStringEmail = RandomStringUtils.randomAlphabetic(5);

		return generateStringEmail;
	}

	public String randomNumber() {

		String generateNumber = RandomStringUtils.randomNumeric(9);
		return generateNumber;

	}

	public String randomPassword() {

		String generatepassword = RandomStringUtils.randomAlphabetic(5);
		String generateNumPassword = RandomStringUtils.randomNumeric(3);

		return (generatepassword + '$' + generateNumPassword);
	}
	
	
	public String captureScreen(String tname) throws IOException {

	    String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File sourceFile = ts.getScreenshotAs(OutputType.FILE);

	    String screenshotDir = System.getProperty("user.dir") + "\\screenshots\\";
	    File targetDir = new File(screenshotDir);
	    if (!targetDir.exists()) {
	        targetDir.mkdirs(); // Create the screenshots directory if it doesn't exist
	    }

	    String targetFilePath = screenshotDir + tname + "_" + timestamp + ".png";
	    File targetFile = new File(targetFilePath);

	    // This is reliable
	    FileUtils.copyFile(sourceFile, targetFile);

	    return targetFilePath;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
