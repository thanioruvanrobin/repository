import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class blaze1 extends BaseClass1{
	public blaze1() {
		PageFactory.initElements(driver, this);
		

	}
	@FindBy(xpath="(//input[@class='btn btn-small'])[3]")
	private WebElement choose;
	public WebElement getChoose() {
		return choose;
	
	}
	

}
