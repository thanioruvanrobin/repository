import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainClass {

	public static void main(String[] args) throws IOException, InterruptedException {
	WebDriver driver=null;
		BaseClass b=new BaseClass();
		
		b.browserlanch();
		b.getUrl("https://adactinhotelapp.com/");
		
		WebElement txtUserName =b.driver.findElement(By.id("username"));
		String data = b.getData(1, 0);
		b.Sendtxt(txtUserName, data);
		
		WebElement txtPassword = b.driver.findElement(By.id("password"));
		String data2 = b.getData(1, 1);
		b.Sendtxt(txtPassword,data2);
		
		WebElement btnLogin = b.driver.findElement(By.id("login"));
		b.Click(btnLogin);
		
		WebElement Ddnclink = b.driver.findElement(By.id("location"));
		b.click(Ddnclink);
        String data3 = b.getData(1, 2);
       b.Select(Ddnclink, data3);
        b.click(Ddnclink);
        
        WebElement dDnHotal = b.driver.findElement(By.id("hotels"));
        b.click(dDnHotal);
        String hotal = b.getData(1, 3);

       b.Select(dDnHotal, hotal);
        b.click(dDnHotal);

        WebElement dDnHotaltype = b.driver.findElement(By.id("room_type"));
        b.click(dDnHotaltype);
        String hotaltype = b.getData(1, 4);
        b.Select(dDnHotaltype, hotaltype);
        b.click(dDnHotaltype);

        WebElement dDnrome = b.driver.findElement(By.id("room_nos"));
        b.click(dDnrome);
        String roomtype = b.getData(1, 5);
       b.Select(dDnrome, roomtype);
        b.click(dDnrome);

        WebElement checkInDate = b.driver.findElement(By.id("datepick_in"));
        String chindate = b.getData(1, 6);

        b.Send(checkInDate, chindate);

        WebElement checkOutDate = b.driver.findElement(By.id("datepick_out"));
        String choutDate = b.getData(1, 7);

        b.Send(checkOutDate, choutDate);

        WebElement dDnAdultRoom = b.driver.findElement(By.id("adult_room"));
        b.click(dDnAdultRoom);
        String adultRoom = b.getData(1, 8);
        b.Select(dDnAdultRoom, adultRoom);
        b.click(dDnAdultRoom);

        WebElement dDnchild = b.driver.findElement(By.id("child_room"));
        b.click(dDnchild);
        String childRoom = b.getData(1, 9);
      b.Select(dDnchild, childRoom);
        b.click(dDnchild);

        WebElement btnSearch = b.driver.findElement(By.id("Submit"));
        b.click(btnSearch);

        WebElement radiobtn = b.driver.findElement(By.id("radiobutton_0"));
        b.click(radiobtn);

        WebElement btnClick = b.driver.findElement(By.id("continue"));
        b.click(btnClick);

        WebElement txtFirstName = b.driver.findElement(By.id("first_name"));
        String first = b.getData( 1, 10);
        b.Send(txtFirstName, first);

        WebElement txtlastName = b.driver.findElement(By.id("last_name"));
        String last = b.getData( 1, 11);
        b.Send(txtlastName, last);


        WebElement txtadd = b.driver.findElement(By.id("address"));
        String add = b.getData(1, 12);
        b.Send(txtadd, add);


        WebElement txtcredit = b.driver.findElement(By.id("cc_num"));
        String creditCard = b.getData(1, 13);
        b.Send(txtcredit, creditCard);


        WebElement dDnCreditCard = b.driver.findElement(By.id("cc_type"));
        String typeofCreditCard = b.getData(1, 14);
        b.Send(dDnCreditCard, typeofCreditCard);

        WebElement dDnexpdatemon = b.driver.findElement(By.id("cc_exp_month"));
        String cardexm = b.getData(1, 15);
        b.Send(dDnexpdatemon, cardexm);

        WebElement dDnexpYear = b.driver.findElement(By.id("cc_exp_year"));
        String cardexyear = b.getData(1, 16 );

        b.Send(dDnexpYear, cardexyear);

        WebElement txtcvv = b.driver.findElement(By.id("cc_cvv"));
        String cvv = b.getData(1, 17);
        b.Send(txtcvv, cvv);

        WebElement Submit = b.driver.findElement(By.id("book_now"));
        b.click(Submit);
        Thread.sleep(8000);
        WebElement orderno = b.driver.findElement(By.xpath("(//input[@type='text'])[16]"));
        String text = b.getAttribut(orderno);
        System.out.println(text);



        
        
        
        
        
        
        
        
        
        
		
	
		
			
		
		
	}
}