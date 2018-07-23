package org.pom.practice.locators;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pom.practice.Base.Base;

public class LoginPage extends Base {

	@FindBy(id = "username")
	private WebElement txtUsername;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(xpath = "//input[@id='login']")
	private WebElement btnLogin;

	public LoginPage() throws IOException { // Constructor
		PageFactory.initElements(driver, this);
	}

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

}
