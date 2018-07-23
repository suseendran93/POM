package org.pom.practice.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Base {
	public static WebDriver driver;
	public static File file;
	public static Workbook w;
	public static FileInputStream stream;
	public static Properties prop;
	
	//Load property file
	public Base() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\ssndr\\eclipse-workspace\\POMFrameWork\\src\\resources\\"
				+ "java\\org\\pom\\practice\\config\\config.properties");
		prop.load(ip);
	}
	//Get driver and Url
	public static void getDriver(String url) throws IOException {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	//Send keys
	public static void type(WebElement element, String name) {
		element.clear();
		element.sendKeys(name);
	}
	//Select
	public static void select(WebElement element, String name) {
		Select select = new Select(element);
		select.selectByVisibleText(name);
	}
	//Click
	public static void btnClick(WebElement element) {
		element.click();

	}

	// Read excel file
	public static Sheet readExcel(String fileLoc, String sheetName) throws IOException {
		file = new File(fileLoc);
		stream = new FileInputStream(file);
		w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet(sheetName);
		System.out.println("Excel Read successful\n");
		return s;

	}
	//Screenshot
	public static void screenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\ssndr\\eclipse-workspace\\POMFrameWork\\Screenshots\\" + name + ".png");
		FileUtils.copyFile(src, dest);
	}
	//Quit
	public static void quitBrowser(WebDriver driver) {
		driver.quit();

	}
}
