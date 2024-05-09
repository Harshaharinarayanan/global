package org.page;


import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
		 public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		 
		 @FindBy(xpath="//input[@type='text']")
		 private WebElement username;

		public WebElement getUsername() {
			return username;
		}
		@FindBy(xpath="//input[@type='password']")
		private WebElement password;

		public WebElement getPassword() {
			return password;
		}

	}
