import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class blanz2 extends BaseClass1 {
	public blanz2() {
		PageFactory.initElements(driver, this);
	}
@FindBy(id="inputName")
private WebElement name;
@FindBy(id="address")
private WebElement address;
@FindBy(id="")
}
