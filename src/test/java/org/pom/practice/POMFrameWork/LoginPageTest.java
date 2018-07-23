package org.pom.practice.POMFrameWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pom.practice.Base.Base;
import org.pom.practice.locators.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {
	public static File file;
	public static Workbook w;
	public static FileInputStream stream;
	public static LoginPage page;

	public LoginPageTest() throws IOException {
		super();//Loads property file
	}

	@BeforeMethod
	public void setup() throws IOException {
		getDriver(prop.getProperty("homeUrl"));
		page = new LoginPage();

		Sheet s = readExcel(prop.getProperty("fileLocation"), prop.getProperty("sheetName"));

		Cell c = s.getRow(1).getCell(2);
		String username = c.getStringCellValue();
		type(page.getTxtUsername(), username);// Locator,value

		Cell c2 = s.getRow(1).getCell(3);
		String password = c2.getStringCellValue();
		type(page.getTxtPassword(), password);

		screenshot(driver, "login");

		btnClick(page.getBtnLogin());
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test
	public void loginSuccess() throws IOException {
		screenshot(driver, "afterLogin");
	}
	
	@Test
	public void usernameCheck() {
			WebElement user = driver.findElement(By.xpath("//input[@id=\"username_show\"]"));
			if(user.getAttribute("value").contains("suseendran")) {
				System.out.println("Correct user");
			}
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser(driver);
	}
}
