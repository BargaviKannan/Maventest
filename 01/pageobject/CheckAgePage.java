package com.sample.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckAgePage {

	public CheckAgePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ".//*[@id='form--lion-agegate']/fieldset[1]/div[1]/input")
	WebElement field_digit1;

	@FindBy(xpath = ".//*[@id='form--lion-agegate']/fieldset[1]/div[2]/input")
	WebElement field_digit2;

	@FindBy(xpath = ".//*[@id='form--lion-agegate']/fieldset[1]/div[3]/input")
	WebElement field_digit3;

	@FindBy(xpath = ".//*[@id='form--lion-agegate']/fieldset[1]/div[4]/input")
	WebElement field_digit4;

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
}