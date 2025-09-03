package org.functionalities;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import orgs.tutorialsNinja.base.NinjaTutorialBase;

public class RegisterFunctionality extends NinjaTutorialBase {

	public RegisterFunctionality(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[starts-with(@class,'caret')]")
	private WebElement dropDownBtn;

	public Actions dropdownAction(String elementName) {
		dropDownBtn.click();
		WebElement eles = driver.findElements(By.tagName("a")).stream().filter(f -> f.getText().contains(elementName))
				.findFirst().orElse(null);
		actions = new Actions(driver);
		actions.moveToElement(eles).click().build().perform();
		return actions;
	}


	public void RegisterForm(String firstName,String lastName,String emailid,String telephoneNum,String password,String confirmPassword) {

		List<WebElement>els = driver.findElements(By.tagName("input"));
		List<WebElement>radios = driver.findElements(By.xpath("//*[starts-with(@name,'newsletter')]"));
		els.stream().forEach((p)->{
			if (p.getAttribute("name").contains("firstname")) {
				p.sendKeys(firstName);
				logs.warn("First Name Inserted Successfully!!");
			}
			else if(p.getAttribute("name").contains("lastname")) {
				p.sendKeys(lastName);
				logs.warn("Last Name Inserted Successfully!!");
			}
			else if(p.getAttribute("name").contains("emai")) {
				p.sendKeys(emailid);
				logs.warn("Email Id Inserted Successfully!!");
			}
			else if(p.getAttribute("name").contains("telephone")) {
				p.sendKeys(telephoneNum);
				logs.warn("Telephone Number Inserted Successfully!!");
			}
			else if(p.getAttribute("name").contains("password")) {
				p.sendKeys(password);
				logs.warn("Password Inserted Successfully!!!");
			}
			else if(p.getAttribute("name").contains("confirm")) {
				p.sendKeys(confirmPassword);
				logs.info("Confirm Password Inserted Successfully!!");
			}
			else if(p.getAttribute("name").contains("agree")) {
				p.click();
			}
			else if(p.getAttribute("value").contains("Continue")){
				p.click();
			}
		});
		radios.forEach((a)->{
			if (a.getAttribute("value").contains("1")) {
				a.click();
			}
		});
	}

}
