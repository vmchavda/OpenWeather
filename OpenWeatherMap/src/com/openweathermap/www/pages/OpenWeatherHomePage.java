package com.openweathermap.www.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import com.openweathermap.www.base.TestBase;

import java.util.List;

public class OpenWeatherHomePage extends TestBase{

    public OpenWeatherHomePage() {
        PageFactory.initElements(driver, this);
    }

        @FindBy(xpath="//div[@class='form-group search-cities__block']//input[@id='q']")
        public WebElement input_Search_Box;

        @FindBy(xpath="//button[@type='submit' and @class='btn btn-orange']")
        public WebElement button_Search;

        @FindBy(xpath="//img[contains(@src,'logo_OpenWeatherMap_orange.svg')]")
        public WebElement element_Logo;

        @FindBy(how= How.ID,using="imperial")
        public WebElement  swatch_DegreeF;

        @FindBy(how=How.ID,using="metric")
        public WebElement swatch_DegreeC;

        @FindBy(how=How.ID,using="weather-widget")
        public WebElement element_Weather_Widget;


        @FindBy(how=How.CLASS_NAME,using="widget__graphic")
        public WebElement element_Weather_Graphic;

        @FindBy(how=How.CLASS_NAME,using="weather-forecast-list")
        public WebElement element_Weather_List;

        @FindBy(how=How.TAG_NAME,using="li")
        public List <WebElement> links_List ;

        @FindBy(xpath="//a[contains(@href,'city/')]")
        public WebElement link_CityName;

        @FindBy(xpath="//h3[@class='weather-widget__temperature']")
        public WebElement element_CityTemp;

        @FindBy(how=How.CLASS_NAME,using="weather-widget__city-name")
        public WebElement element_CityName;

        @FindBy(xpath="//a[contains(@href,'city/')]")
        public List<WebElement> links_CityName;

        
        @FindBy(xpath="//div[text()='Not found']")
        public WebElement textNotFound;






}
