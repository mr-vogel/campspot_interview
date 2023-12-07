package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage{

    public LandingPage(WebDriver driver){
        super(driver);
    }

    public enum PageElements {
        locationField,
        checkInField,
        checkInDate,
        checkOutField,
        checkOutDate,
        searchButton
    }

    public By by(PageElements elements){
        switch (elements){
            case locationField: return By.cssSelector("location-search > div > input");
            case checkInField: return By.cssSelector("div.aggredator-field > div:nth-child(1) > button");
            case checkInDate: return By.cssSelector("div.aggredator-dropdown-calendar-month.app-month-12 > table > tr:nth-child(4) > td.aggredator-dropdown-calendar-month-table-day.app-day-18.mod-date > button");
            case checkOutField: return By.cssSelector("div.aggredator-field > div:nth-child(3) > button");
            case checkOutDate: return By.cssSelector("div.aggredator-dropdown-calendar-month.app-month-1 > table > tr:nth-child(4) > td.aggredator-dropdown-calendar-month-table-day.app-day-24.mod-date > button");
            case searchButton: return By.cssSelector("div.home-hero-search-form-submit > button");
            default: return null;
        }
    }


    public void enterLocation(String loc){
        try {
            clickElement(by(PageElements.locationField));
            enterText(by(PageElements.locationField),loc);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Issue finding or entering text in location field");
        }
    }

    public void enterCheckInDate(){
        try {
            clickElement(by(PageElements.checkInField));
            clickElement(by(PageElements.checkInDate));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Issue getting Check In date field");
        }
    }

    public void enterCheckOutDate(){
        try {
            clickElement(by(PageElements.checkOutField));
            clickElement(by(PageElements.checkOutDate));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Issue getting Check Out date field");
        }
    }

    public SearchResultsPage clickSearch(){
        try {
            clickElement(by(PageElements.searchButton));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Issue interacting with Search button");
        }
        return new SearchResultsPage(driver);
    }
}