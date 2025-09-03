package orgs.tutorialsNinja.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.functionalities.RegisterFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NinjaTutorialBase {

	public static final Logger logs = LoggerFactory.getLogger(NinjaTutorialBase.class);
	public static Properties properties;
	public static FileInputStream fileInputStream;
	public static WebDriver driver;
	public static RegisterFunctionality registerFunctionality;
	public static Actions actions;
	public static WebDriver commnonDrivers(WebDriver driver) {
		registerFunctionality = new RegisterFunctionality(driver);
		return driver;
	}
	public static Properties getPropertiesDetails(String fileName) {
		properties = new Properties();
		try {
			fileInputStream = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\org\\utils\\" + fileName + ".properties");
			properties.load(fileInputStream);
			logs.info("Properties Files Loaded Successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}

	public static WebDriver optBrowser(String browserName) {
		if (browserName.toLowerCase().equals("chrome")) {
			driver = new ChromeDriver();
			logs.info("Chrome Driver Started");
		} else {
			driver = new FirefoxDriver();
			logs.info("Firefox Driver Started");
		}
		driver.get(properties.getProperty("url"));
		logs.info("Navigating to the URL Link");
		commnonDrivers(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}

}
