import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.helper.DataUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
WebDriver driver;
WebElement element;

public WebDriver browserlanch() {
	WebDriverManager.chromedriver().setup();
	return driver=new ChromeDriver();
}
public void getUrl(String Url) {
driver.get(Url);
driver.manage().window().maximize();
}
public String getData(int rownum ,int cellnum) throws IOException, InterruptedException {
String data = null;
File file=new File("D:\\FrameWork\\ExcelSheet\\adactinHotal.xlsx");
FileInputStream stream = new FileInputStream(file);
Workbook workbook = new XSSFWorkbook(stream);
Sheet sheet = workbook.getSheet("Sheet1");
Row row = sheet.getRow(rownum);
Cell cell = row.getCell(cellnum);
int cellType = cell.getCellType();
if (cellType==1) {
data = cell.getStringCellValue();


if (cellType==0) {
if (DateUtil.isCellDateFormatted(cell)) {
Date date = cell.getDateCellValue();
SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MMM-yy");
data = dateFormat.format(date);
}
}
}
else {
double d = cell.getNumericCellValue();
long l = (long)d;
data = String.valueOf(l);
}

return data;
}
public void loadUrl(String url) {
driver.get(url);
driver.manage().window().maximize();



}
public String Send(WebElement element , String value) {
element.sendKeys(value);
return value;
}
public void click(WebElement element) {
element.click();
}

public  String getAttribut(WebElement element) {
String attribute = element.getAttribute("value");
return attribute;

}
public String Sendtxt(WebElement element , String value) {
element.sendKeys(value);
return value;
}
public void Click(WebElement element) {
element.click();
}
public String getAttribute(WebElement element) {
String attribute = element.getAttribute("value");
return attribute;

}
public void Select(WebElement element,String data) {
	Select select = new Select(element);
	select.selectByVisibleText(data);
}
}






















