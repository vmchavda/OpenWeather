package com.openweathermap.www.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.openweathermap.www.base.TestBase;
import com.openweathermap.www.pages.OpenWeatherHomePage;

public class EndToEndScenario extends TestBase {

	@Test
	public void HomePageValidation() {
		OpenWeatherHomePage openWeatherHomePage = new OpenWeatherHomePage();

		Assert.assertTrue(openWeatherHomePage.element_Logo.isDisplayed(),"Home Page is  Logo not loaded");
		Reporter.log("Home Page Logo is shown");

		Assert.assertTrue(openWeatherHomePage.element_Weather_Widget.isDisplayed(),"Home Page Weather Widget is missing");
		Reporter.log(" Home page weather widget is loaded");

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", openWeatherHomePage.element_Weather_Graphic);
		Assert.assertTrue(openWeatherHomePage.element_Weather_Graphic.isDisplayed(),"Home page Weather Graph is missing");
		Reporter.log("Home Page Graph is dispaying");

		Assert.assertTrue(openWeatherHomePage.links_List.size()>=42,"Number of links in the page is a mismatch");
		Reporter.log("Number of links in the page are correct");

	}

	@Test
	public void InValidCitySearch(){
		OpenWeatherHomePage openWeatherHomePage = new OpenWeatherHomePage();

		openWeatherHomePage.input_Search_Box.sendKeys("openWeatherHomePage");
		Reporter.log("openWeatherHomePage city searching");

		openWeatherHomePage.button_Search.click();
		Assert.assertTrue(openWeatherHomePage.textNotFound.getText().contains("Not found"),"Not Found Worning message dispalying");
		Reporter.log("Not Found Worning message dispalying");


	}
	@Test
	public void test_03(){
		OpenWeatherHomePage openWeatherHomePage = new OpenWeatherHomePage();

		openWeatherHomePage.input_Search_Box.sendKeys("Bangalore");
		Reporter.log("Bangalore city searching");

		openWeatherHomePage.button_Search.click();
		Assert.assertTrue(openWeatherHomePage.link_CityName.getText().contains("Bangalore"),"Bangalore Weather dispalying");
		Reporter.log("Bangalore Weather dispayed");

	}
	@Test
	public void ZipCodeSearch(){
		OpenWeatherHomePage openWeatherHomePage = new OpenWeatherHomePage();

		openWeatherHomePage.input_Search_Box.sendKeys("560037");
		Reporter.log("Bangalore city zipcode searching");

		openWeatherHomePage.button_Search.click();
		if(openWeatherHomePage.links_CityName.size()>1)
		{
			Reporter.log("Multiple City Search Results are displayed");
		}
		else
		{
			Assert.assertTrue(false," Multiple Cities not displayed in Search results");
		}
		Reporter.log("Bangalore city Weather dispayed");

	}
}

