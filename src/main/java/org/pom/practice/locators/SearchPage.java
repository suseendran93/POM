package org.pom.practice.locators;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pom.practice.Base.Base;

public class SearchPage extends Base {

	@FindBy(xpath = "//select[@name='location']")
	private WebElement location;

	@FindBy(xpath = "//select[@name='hotels']")
	private WebElement hotels;

	@FindBy(xpath = "//select[@name='room_type']")
	private WebElement room_type;

	@FindBy(xpath = "//select[@name='room_nos']")
	private WebElement room_nos;

	@FindBy(xpath = "//input[@name='datepick_in']")
	private WebElement datepick_in;

	@FindBy(xpath = "//input[@name='datepick_out']")
	private WebElement datepick_out;

	@FindBy(xpath = "//select[@name='adult_room']")
	private WebElement adult_room;

	@FindBy(xpath = "//select[@name='child_room']")
	private WebElement child_room;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement search;

	@FindBy(xpath = "//input[@name='radiobutton_0']")
	private WebElement radiobutton_0;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submit;

	public SearchPage() throws IOException {

		PageFactory.initElements(driver, this);
	}

	public WebElement getLocation() {
		return location;

	}

	public WebElement getRoomType() {
		return room_type;
	}

}
