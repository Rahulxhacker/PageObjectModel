package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public WebDriver driver;

	public static CarsBase car;

	public BasePage(WebDriver driver) {
		
		this.driver = driver;

		car = new CarsBase(driver);

		PageFactory.initElements(driver, this);
	}

}
