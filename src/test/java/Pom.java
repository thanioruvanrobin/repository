import org.apache.poi.ss.formula.functions.Choose;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom extends BaseClass1 {

	public Pom() {
		PageFactory.initElements(driver, this);

	}
@FindBy(name="fromPort")
private WebElement Source;
@FindBy(xpath="(//select[@class='form-inline'])[2]")
private WebElement destination;
@FindBy(xpath="//input[@class='btn btn-primary']")
private WebElement login;

public WebElement getSource() {
	return Source;
}
public WebElement getDestination() {
	return destination;
}
public WebElement getLogin() {
	return login;
}


}

	

	
	
	
	
	
	
	
}
