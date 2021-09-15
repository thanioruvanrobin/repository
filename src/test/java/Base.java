import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	WebDriver driver;
	WebElement elemenet;
	
	public WebDriver browserLanch() {
		WebDriverManager.chromedriver().setup();
		return driver= new ChromeDriver();
	}
	public String gettext(WebElement element, String data) {
		String text = element.getText();
		return null;
			
		}

	}

