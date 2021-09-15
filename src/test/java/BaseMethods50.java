import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseMethods50 {
	
	public static WebDriver driver;

	// browserlaunch
	public static void getDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = (WebDriver) new ChromeDriverInfo();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("invalid browser");
		}
	}

	// geturl
	public static void geturl(String url) {
		driver.get(url);
	}

	// gettitle
	public static String gettitle() {
		String title = driver.getTitle();
		return title;
	}

	// getcurrenttitle
	public static String getcurrenttitle() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// close
	public static void close() {
		driver.close();
	}

	// quit
	public static void quit() {
		driver.quit();
	}

	// maximize
	public static void maximize() {
		driver.manage().window().maximize();
	}

	// windowhandle
	public static String windowhandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;

	}

	// windowhandles
	public static Set<String> windowhandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	// navigateforward
	public static void navigateforward() {
		driver.navigate().forward();
	}

	// navigatebackward
	public static void navigateback() {
		driver.navigate().back();
	}

	// navigaterefresh
	public static void navigaterefresh() {
		driver.navigate().refresh();
	}

	// click
	public static void click(WebElement element) {
		element.click();
	}

	// entertext
	public static void entertext(WebElement element, String value) {
		element.sendKeys(value);
	}

	// gettext
	public static String gettext(WebElement element) {
		String text = element.getText();
		return text;
	}

	// getattribute
	public static String getattribute(WebElement element, String value) {
		String text = element.getAttribute("value");
		return text;
	}

	// locators
	public static WebElement locators(String locators, String value) {
		WebElement element;
		if (locators.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(value));
			return element;
		} else if (locators.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(value));
			return element;
		} else {
			element = driver.findElement(By.xpath(value));
			return element;
		}
	}

	// movetoelement
	public static void movetoelement(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	// contextclick
	public static void contextclick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	// draganddrop
	public static void draganddrop(WebElement element, WebElement element1) {
		Actions act = new Actions(driver);
		act.dragAndDrop(element, element1).perform();
	}

	// actionskeydown
	public static void actionskeydown(WebElement element) {
		Actions act = new Actions(driver);
		act.keyDown(element, Keys.SHIFT).perform();
	}

	// actionskeyup
	public static void actionskeyup(WebElement element) {
		Actions act = new Actions(driver);
		act.keyUp(element, Keys.SHIFT).perform();
	}

	// robotpress
	public static void robotrelease() throws AWTException {
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);

	}// robotkeypress

	public static void robotpress() throws AWTException {
		Robot rob = new Robot();
		rob.keyRelease(KeyEvent.VK_ENTER);
	}

	// simplealert
	public static void simplealert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// confirmalert
	public static void confirmalert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// promptalert
	public static String promptalert() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		return text;
	}

	// selectbyindex
	public static void selectionbyindex(WebElement element, int num) {
		Select sel = new Select(element);
		sel.selectByIndex(num);

	}

	// selectbyvalue
	public static void selectionbyvalue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	// selectbyvisibletext
	public static void selectionbyvisibletext(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);

	}

	// insertvalusetfromexcel
	public static String getdatafromExcel(String path, String sheetname, int num, int num2) throws IOException {
		String data = null;

		File file = new File(path);
		FileInputStream fileinput = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileinput);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(num);
		Cell cell = (Cell) row.getCell(num2);
		int cellType = ((org.apache.poi.ss.usermodel.Cell) cell).getCellType();
		if (cellType == 1) {
			data = ((org.apache.poi.ss.usermodel.Cell) cell).getStringCellValue();
			return data;
		} else if (DateUtil.isCellInternalDateFormatted((org.apache.poi.ss.usermodel.Cell) cell)) {
			Date dd = (Date) cell.getValue();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			data = dateformat.format(dd);
			return data;

		} else {
			double numericCellValue = ((org.apache.poi.ss.usermodel.Cell) cell).getNumericCellValue();
			long l = (long) numericCellValue;
			data = String.valueOf(l);
			return data;
		}
	}

	public static String givedatatoExcel(String path, String sheetname, int num, int num2, String data)
			throws IOException {
		File file = new File(path);
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet createSheet = workbook.createSheet(sheetname);
		Row createRow = createSheet.createRow(num);
		Cell createCell = (Cell) createRow.createCell(num2);
		((org.apache.poi.ss.usermodel.Cell) createCell).setCellValue(data);
		FileOutputStream stream2 = new FileOutputStream(file);
		workbook.write(stream2);
		return data;
	}

	// implicit wait
	public static void implicit() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	

	



		
	}

}
