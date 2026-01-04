package Base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarsBase {

	public WebDriver driver;

	public CarsBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div[2]/section/header/h1")
	public WebElement carTitle;

	public String getCarTitle() {

		return carTitle.getText();
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div[3]/div[1]/section/div/div[2]/ul/li/div/div/div/div/div[3]/div/span/span[1]")
	public List<WebElement> carPrice;

	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div[3]/div[1]/section/div/div[2]/ul/li/div/div/div/div/a/h3")
	public List<WebElement> carNames;

	public void getCarNameAndPrice() {

		for (int i = 0; i < carNames.size(); i++) {

			String text = carNames.get(i).getText();
			System.out.println(text);
		}

		for (int i = 0; i < carPrice.size(); i++) {

			String text = carPrice.get(i).getText();

			System.out.println(text);
		}
	}

}
