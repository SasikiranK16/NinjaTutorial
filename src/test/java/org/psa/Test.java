package org.psa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;

import orgs.tutorialsNinja.base.NinjaTutorialBase;

public class Test extends NinjaTutorialBase {

	@BeforeSuite
	public void launch() {
		getPropertiesDetails("pro");
		optBrowser(properties.getProperty("browser"));
		logs.info("Before Suite Successfully Running.....");
	}
	public static final Logger logs = LoggerFactory.getLogger(Test.class);
	@org.testng.annotations.Test
	public void testName() throws Exception {
		logs.info("Entered into :"+logs.getName());
		logs.warn("Test Case Passed Successfully");
		logs.warn("hello");
//		driver.findElements(By.tagName("a")).forEach(p->System.out.println(p.getAttribute("innerText")));
	}
	@org.testng.annotations.Test
	public void registerFunctionality001() throws Exception {
		
		registerFunctionality.dropdownAction("Register");
		registerFunctionality.RegisterForm("Hello","World","Hello@gmail.com","248195","Hello","Hello");
		Float a;
	}
	
}
