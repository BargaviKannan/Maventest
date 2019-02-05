package com.sample.test;

import static org.testng.Assert.assertTrue;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.sample.pageobject.CheckAgePage;
import com.sample.pageobject.ValidAgePage;

/**
 * @author Bargavi Kannan
 *
 *         Selenium Web Driver / JUnit test class for Agegate validations in
 *         https://ironjack.com.au/
 * 
 */

public class IronJackAgeTest {
	private static final String IRONJACK_URL = "https://ironjack.com.au/";
	private static final String IRONJACK_AGE_GATE_URL = "https://ironjack.com.au/agegate/";
	private static final String DRINKWISE_URL = "https://drinkwise.org.au/";
	WebDriver driver;

	/**
	 * Construct all web driver related objects in setup method.
	 */

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kannanb\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(IRONJACK_AGE_GATE_URL);
	}

	/**
	 * Clean up test objects.
	 */
	@AfterMethod
	public void close() {
		driver.close();
	}


	
	// @Test
	public void ageTest_valid() {
		try {
			ValidAgePage validAgePage = new ValidAgePage(driver);
			validAgePage.selectdigit1("2");
			validAgePage.selectdigit2("0");
			validAgePage.selectdigit3("0");
			validAgePage.selectdigit4("0");
			validAgePage.selectdob_day("29");
			validAgePage.selectdob_month("10");
			validAgePage.selectdob_year("2000");
			validAgePage.clicksubmit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * End to end test to validate the age before 18 years.
	 */

	@Test
	public void ageTest_before18Years() {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Calendar currentDate = Calendar.getInstance();
			Calendar previousDate = Calendar.getInstance();
			currentDate.setTime(new Date());
			// Set Date to -18 years
			previousDate.set(currentDate.get(Calendar.YEAR) - 18, currentDate.get(Calendar.MONTH),
					currentDate.get(Calendar.DAY_OF_MONTH));
			Date dateBefore18Years = previousDate.getTime();
			String year = formatter.format(dateBefore18Years).substring(6);
			String month = formatter.format(dateBefore18Years).substring(3, 5);
			String day = formatter.format(dateBefore18Years).substring(0, 2);
			ValidAgePage validAgePage = new ValidAgePage(driver);
			validAgePage.selectdigit1(year.substring(0, 1));
			validAgePage.selectdigit2(year.substring(1, 2));
			validAgePage.selectdigit3(year.substring(2, 3));
			validAgePage.selectdigit4(year.substring(3));
			validAgePage.selectdob_day(day);
			validAgePage.selectdob_month(month);
			validAgePage.selectdob_year(year);
			validAgePage.clicksubmit();
			// Verify URL after final redirection.
			assertTrue(driver.getCurrentUrl().contains(DRINKWISE_URL));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * End to end test to validate the age before 18 years plus one(with tomorrow's
	 * date).
	 */

	@Test
	public void ageTest_before18Yearsplusone() {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Calendar currentDate = Calendar.getInstance();
			currentDate.add(Calendar.DATE, 1);
			System.out.println("Yesterday's date was " + formatter.format(currentDate.getTime()));
			Calendar previousDate = currentDate.getInstance();
			// Set Date to -18 years plus one
			previousDate.set(currentDate.get(Calendar.YEAR) - 18, currentDate.get(Calendar.MONTH),
					currentDate.get(Calendar.DAY_OF_MONTH));
			Date dateBefore18Years = previousDate.getTime();
			System.out.println("Yesterday's date was " + formatter.format(previousDate.getTime()));
			String year = formatter.format(dateBefore18Years).substring(6);
			String month = formatter.format(dateBefore18Years).substring(3, 5);
			String day = formatter.format(dateBefore18Years).substring(0, 2);
			ValidAgePage validAgePage = new ValidAgePage(driver);
			validAgePage.selectdigit1(year.substring(0, 1));
			validAgePage.selectdigit2(year.substring(1, 2));
			validAgePage.selectdigit3(year.substring(2, 3));
			validAgePage.selectdigit4(year.substring(3));
			validAgePage.selectdob_day(day);
			validAgePage.selectdob_month(month);
			validAgePage.selectdob_year(year);
			validAgePage.clicksubmit();
			// Verify URL after final redirection.
			assertTrue(driver.getCurrentUrl().contains(DRINKWISE_URL));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * End to end test to validate the age before 18 years plus one(with yesterday's
	 * date).
	 */

	@Test
	public void ageTest_before18Yearsminusone() {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Calendar currentDate = Calendar.getInstance();
			currentDate.add(Calendar.DATE, -1);
			System.out.println("Yesterday's date was " + formatter.format(currentDate.getTime()));
			Calendar previousDate = currentDate.getInstance();
			// Set Date to -18 years minus one
			previousDate.set(currentDate.get(Calendar.YEAR) - 18, currentDate.get(Calendar.MONTH),
					currentDate.get(Calendar.DAY_OF_MONTH));
			Date dateBefore18Years = previousDate.getTime();
			System.out.println("Yesterday's date was " + formatter.format(previousDate.getTime()));
			String year = formatter.format(dateBefore18Years).substring(6);
			String month = formatter.format(dateBefore18Years).substring(3, 5);
			String day = formatter.format(dateBefore18Years).substring(0, 2);
			ValidAgePage validAgePage = new ValidAgePage(driver);
			validAgePage.selectdigit1(year.substring(0, 1));
			validAgePage.selectdigit2(year.substring(1, 2));
			validAgePage.selectdigit3(year.substring(2, 3));
			validAgePage.selectdigit4(year.substring(3));
			validAgePage.selectdob_day(day);
			validAgePage.selectdob_month(month);
			validAgePage.selectdob_year(year);
			validAgePage.clicksubmit();
			// Verify URL after final redirection.
			assertTrue(driver.getCurrentUrl().contains(IRONJACK_URL));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
