package com.sample.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidAgePage {

	WebDriver driver;

	public ValidAgePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = ".//*[@id='form--lion-agegate']/fieldset[1]/div[1]/input")
	WebElement field_digit1;

	@FindBy(xpath = ".//*[@id='form--lion-agegate']/fieldset[1]/div[2]/input")
	WebElement field_digit2;

	@FindBy(xpath = ".//*[@id='form--lion-agegate']/fieldset[1]/div[3]/input")
	WebElement field_digit3;

	@FindBy(xpath = ".//*[@id='form--lion-agegate']/fieldset[1]/div[4]/input")
	WebElement field_digit4;

	@FindBy(xpath = ".//*[@id='form--lion-agegate']/fieldset[2]/input[1]")
	WebElement field_dob_day;

	@FindBy(xpath = ".//*[@id='form--lion-agegate']/fieldset[2]/input[2]")
	WebElement field_dob_month;

	@FindBy(xpath = ".//*[@id='form--lion-agegate']/fieldset[2]/input[3]")
	WebElement field_dob_year;

	@FindBy(xpath = ".//*[@id='form--lion-agegate']/fieldset[2]/button")
	WebElement field_submit;

	public void selectdigit1(String digit1value) {
		field_digit1.sendKeys(digit1value);
	}

	public void selectdigit2(String digit2value) {
		field_digit2.sendKeys(digit2value);
	}

	public void selectdigit3(String digit3value) {
		field_digit3.sendKeys(digit3value);
	}

	public void selectdigit4(String digit4value) {
		field_digit4.sendKeys(digit4value);
	}

	public void selectdob_day(String dob_day) {
		field_dob_day.sendKeys(dob_day);
	}

	public void selectdob_month(String dob_month) {
		field_dob_month.sendKeys(dob_month);
	}

	public void selectdob_year(String dob_year) {
		field_dob_year.sendKeys(dob_year);
	}

	public void clicksubmit() {
		field_submit.click();
	}
}