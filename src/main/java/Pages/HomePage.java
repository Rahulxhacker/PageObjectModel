package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath ="//div[normalize-space()='NEW CARS']" )
	public WebElement newCars;
	
	@FindBy(xpath ="//div[contains(text(),'Find New Cars')]")
	public WebElement findNewCars;
	
	public NewCarsPage findNewCar() {
		Actions a = new Actions(driver);
		a.moveToElement(newCars).perform();
		findNewCars.click();
		
		return new NewCarsPage(driver);
	}
	
}
