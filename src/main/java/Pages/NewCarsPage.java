package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;

public class NewCarsPage extends BasePage{

	public NewCarsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@title='Hyundai']")
	public WebElement hyundai;

	@FindBy(xpath = "//a[@title='Maruti Suzuki']")
	public WebElement maruti;

	@FindBy(xpath = "//a[@title='Toyota']")
	public WebElement toyota;

	@FindBy(xpath = "//a[@title='Kia']")
	public WebElement kia;

	public void selectMarutiCar() {
		maruti.click();
//		car.getCarTitle();
	}

	public void selectToyotaCar() {
		toyota.click();
	}

	public void selectHyundaiCar() {
		hyundai.click();
	}

	public void selectKiaCar() {
		kia.click();
	}

}
