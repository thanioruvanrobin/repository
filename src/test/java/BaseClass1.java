import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {

	private static final Object Locators = null;
	private static final String Format = null;
	static WebDriver driver;
	static WebElement element;

	public static void browserLanuch(String url) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	public WebElement locators(WebElement element) {
		String value = null;
		if (Locators.equals("id")) {
			WebElement element1 = driver.findElement(By.id(value));
			return element;
		} else if (Locators.equals("name")) {
			WebElement element1 = driver.findElement(By.id("name"));
			return element1;
		} else {
			WebElement element2 = driver.findElement(By.xpath(value));
			return element;

		}
	}

	public static void ButtonClick(WebElement element) {
		element.click();
	}

	public static void entertext(WebElement element, String data) {
		element.sendKeys(data);
	}

	public static void selectByVisibleText(WebElement element, String data) {
Select s =new Select(element);
s.selectByVisibleText(data);

	}

	public static String excelRead(String path, String sheetname, int rownum, int cellnum) throws IOException {
		File f = new File(path);
		FileInputStream stream = new FileInputStream(f);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		int cellType = cell.getCellType();
		if (cellType == 1) {
			String data = cell.getStringCellValue();
			return data;
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
			sim.format(dateCellValue);
			return Format;
		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			String valueOf = String.valueOf(1);
			return valueOf;
		
	}
}
}
