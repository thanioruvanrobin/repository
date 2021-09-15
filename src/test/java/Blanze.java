import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;

public class Blanze extends BaseClass1 {
	public static void main(String[] args) throws IOException {
		browserLanuch("https://blazedemo.com/");
		Pom pm = new Pom();
		WebElement source = pm.getSource();
		entertext(source, excelRead("D:\\FrameWork\\ExcelSheet\\adactinHotal.xlsx", "sheet1", 0, 1));
		WebElement destination = pm.getDestination();
		entertext(destination, excelRead("D:\\FrameWork\\ExcelSheet\\adactinHotal.xlsx", "sheet1", 1, 1));
		pm.getLogin().click();
		blaze1 c=new blaze1();
		c.getChoose().click();
		
	}
}
