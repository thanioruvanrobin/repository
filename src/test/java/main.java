import java.io.IOException;

import org.openqa.selenium.WebElement;

public class main extends BaseClase {
	
	public static void main(String[] args) throws IOException {
		browserLaunch("https://adactinhotelapp.com/SearchHotel.php");
		AdactinPom ad =new AdactinPom();
		WebElement username = ad.getUsername();	
		enterText(username, excelRead("D:\\FrameWork\\ExcelSheet\\adactinHotal.xlsx", "sheet1", 0, 1));
		WebElement password = ad.getPassword();
		enterText(password,excelRead("D:\\FrameWork\\ExcelSheet\\adactinHotal.xlsx", "sheet1", 1, 1));
		ad.getLogin().click();
		WebElement location = ad.getLocation();
		enterText(location, excelRead("D:\\FrameWork\\ExcelSheet\\adactinHotal.xlsx", "sheet1", 1, 2));
		WebElement hotals = ad.getHotals();
		enterText(hotals, excelRead("D:\\FrameWork\\ExcelSheet\\adactinHotal.xlsx", "sheet1", 1, 3));
		WebElement room_type = ad.getRoom_type();
		enterText(room_type, excelRead("D:\\FrameWork\\ExcelSheet\\adactinHotal.xlsx", "sheet1", 1, 4));

		WebElement room_nos = ad.getRoom_nos();
		enterText(room_nos, excelRead("D:\\FrameWork\\ExcelSheet\\adactinHotal.xlsx", "sheet1", 1, 5));
		WebElement datepick_in = ad.getDatepick_in();
		enterText(datepick_in, excelRead("D:\\FrameWork\\ExcelSheet\\adactinHotal.xlsx", "sheet1", 1, 6));
		WebElement datepick_out = ad.getDatepick_out();
		enterText(datepick_out, excelRead("D:\\FrameWork\\ExcelSheet\\adactinHotal.xlsx", "sheet1", 1, 7));
		WebElement adult_room = ad.getAdult_room();
		enterText(adult_room, excelRead("D:\\FrameWork\\ExcelSheet\\adactinHotal.xlsx", "sheet1", 1, 8));
		WebElement child_room = ad.getChild_room();
		enterText(child_room, excelRead("D:\\FrameWork\\ExcelSheet\\adactinHotal.xlsx", "sheet1", 1, 9));
	     ad.getSubmit().click();
	}
}
		 


	
	
	
	