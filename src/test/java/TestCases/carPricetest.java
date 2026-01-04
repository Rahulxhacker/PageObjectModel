package TestCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import Base.BasePage;
import Base.TestBase;
import Pages.HomePage;
import utilities.TestUtils;

public class carPricetest extends TestBase {
	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void findCarTest(Hashtable<String, String> data) throws InterruptedException, IOException {

		if (data.get("runMode").equals("N")) {
			throw new SkipException("Skipping this testCase as runMode is NO");
		}

		setUp(data.get("browser"));

		if (data.get("brandName").equals("Hyundai")) {
			HomePage home = new HomePage(driver);
			home.findNewCar().selectHyundaiCar();
			System.out.println(BasePage.car.getCarTitle());
			BasePage.car.getCarNameAndPrice();

		} else if (data.get("brandName").equals("Kia")) {
			HomePage home = new HomePage(driver);
			home.findNewCar().selectKiaCar();
			System.out.println(BasePage.car.getCarTitle());
			BasePage.car.getCarNameAndPrice();

		} else if (data.get("brandName").equals("Toyota")) {
			HomePage home = new HomePage(driver);
			home.findNewCar().selectToyotaCar();
			System.out.println(BasePage.car.getCarTitle());
			BasePage.car.getCarNameAndPrice();

		} else if (data.get("brandName").equals("Maruti")) {
			HomePage home = new HomePage(driver);
			home.findNewCar().selectMarutiCar();
			System.out.println(BasePage.car.getCarTitle());
			BasePage.car.getCarNameAndPrice();
		}

	}
}
