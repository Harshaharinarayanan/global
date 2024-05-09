package org.execute;

import java.io.IOException;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.page.LoginPage;

public class TestScript {
public static void main(String[] args) throws IOException, InterruptedException {
		
		BaseClass base= new BaseClass();
		base.getDriver(base.readexcel(1, 0));
		base.getUrl(base.readexcel(1, 1));
		base.winmax();
		LoginPage login = new LoginPage();
		
WebElement username = login.getUsername();	
username.sendKeys(base.readexcel(1, 2));
		
WebElement password = login.getPassword();
password.sendKeys(base.readexcel(1, 3));
		 
WebElement submit = base.element("//input[@type='submit']");
submit.click();
		
WebElement item1 = base.element("(//button[@class='btn_primary btn_inventory'])[1]");		
item1.click();
base.sync(2000);

		
WebElement item2 = base.element("(//button[@class='btn_primary btn_inventory'])[1]");		
item2.click();
base.sync(2000);

WebElement item3 = base.element("(//button[@class='btn_primary btn_inventory'])[1]");	
item3.click();
base.sync(2000);

WebElement item4 = base.element("(//button[@class='btn_primary btn_inventory'])[2]");		
item4.click();
base.sync(2000);


WebElement item5 = base.element("(//button[@class='btn_primary btn_inventory'])[1]");		
item5.click();
base.sync(2000);


WebElement item6 = base.element("//button[text()='ADD TO CART']");		
item6.click();
base.sync(2000);

WebElement cart = base.element("//a[@class='shopping_cart_link fa-layers fa-fw']");
cart.click();

WebElement remove1 = base.element("(//button[@class='btn_secondary cart_button'])[1]");
remove1.click();
		
WebElement remove2 = base.element("(//button[@class='btn_secondary cart_button'])[2]");
remove2.click();

WebElement remove3 = base.element("(//button[@class='btn_secondary cart_button'])[1]");
remove3.click();

WebElement remove4 = base.element("(//button[@class='btn_secondary cart_button'])[1]");
remove4.click();

WebElement remove5 = base.element("(//button[@class='btn_secondary cart_button'])[1]");
remove5.click();

WebElement remove6 = base.element("(//button[@class='btn_secondary cart_button'])[1]");
remove6.click();

WebElement logout = base.element("//a[@class='btn_action checkout_button']");
logout.click();

WebElement firstname = base.element("//input[@id='first-name']")	;
firstname.sendKeys("harsha");

WebElement lastname = base.element("//input[@id='last-name']");
lastname.sendKeys("hari");		
		
WebElement code = base.element("//input[@id='postal-code']");
code.sendKeys("600091");		
		
WebElement select = base.element("//input[@type='submit']");
select.click();

WebElement finish = base.element("//a[@class='btn_action cart_button']");
finish.click();

WebElement menu = base.element("//button[text()='Open Menu']");
menu.click();

WebElement logout1 = base.element("//a[@id='logout_sidebar_link']");
logout1.click();

base.refresh();

 WebElement user2 = base.element("//input[@name='user-name']");
user2.sendKeys(base.readexcel(2, 1));

WebElement pass2 = base.element("//input[@type='password']");
pass2.sendKeys(base.readexcel(2, 2));

WebElement submit2 = base.element("//input[@type='submit']");
submit2.click();

	}
}
