package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.r2k.utilities.ExcelReader;

public class TestBase {

	/*
	 * WebDriver Properties Logs ExtentReports DB Excel Mail ReportNG ExtentReports
	 * Jenkins
	 */

	public WebDriver driver;
	public Properties config = new Properties();
	public Properties OR = new Properties();
	public FileInputStream fis;
	public Logger log = LogManager.getLogger("devpinoyLogger");
	public ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");

	public WebDriverWait wait;
	public String browser;


	public void setUp(String browserName) throws IOException {

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");

		EdgeOptions Eops = new EdgeOptions();
		Eops.addArguments("--disable-notifications");

		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		log.debug("Config file is loaded");

		if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
			browser = System.getenv("browser");
		} else {
			browser = config.getProperty("browser");
		}
		config.setProperty("browser", browser);

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver(ops);
			log.debug("Chrome launched");
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver(Eops);
		}
		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigating to :" + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

//	public static boolean isElementPresent(By by) {
//		try {
//			driver.findElement(by);
//			return true;
//		} catch (NoSuchElementException e) {
//			// TODO: handle exception
//			return false;
//
//		}
//	}

	public String srcFileName;

	public void captureScreenShot(String b) throws IOException {
		Date d = new Date();
		srcFileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./PageObjectFailedSS/" + b + srcFileName));
	}

	public void captureElementScreenShot(WebElement element) throws IOException {
		Date d = new Date();
		srcFileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		File f = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./PageObjectFailedSS/" + srcFileName));
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		log.debug("Test execution completed");
	}

}
