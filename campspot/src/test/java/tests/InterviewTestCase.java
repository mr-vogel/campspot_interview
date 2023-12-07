package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.SearchResultsPage;

public class InterviewTestCase extends BaseTest{


    @Test
    public void searchResultsTest() {
        // This test case tests the following:
        // Verify a user can successfully search for a campground via
        // location, dates, and guests to get campground results

        LandingPage l = new LandingPage(driver);
        SearchResultsPage s;
        l.enterLocation("Lodi, California"); //enter location text
        l.enterCheckInDate(); //select check in date
        l.enterCheckOutDate(); //select checkout date
        // guests is defaulted to 2
        s = l.clickSearch();
        String results = s.getSearchResults();
        Assert.assertFalse(results.isEmpty());
        Assert.assertFalse(results.contains("Sorry, there are no campgrounds available matching your current search."));
        //The following assert methods test that the results returned are not empty
        //We are also checking that they don't contain the empty results text
        //Thus we can assume that by the text not being empty, and not being the no results message, that results were returned
    }

    @Test
    public void noSearchResultsTest(){
        // This test case tests the following:
        // Verify a user can successfully search for a campground via
        // location, dates, and guests and get no results, but rather
        // get a useful message telling the user no results found

        LandingPage l = new LandingPage(driver);
        SearchResultsPage s;
        l.enterLocation("Port Huron, Michigan"); //enter location text
        // dates are optional, skipping date entry
        // guests is defaulted to 2
        s = l.clickSearch();
        String results = s.getEmptySearchText();
        Assert.assertTrue(results.contains("Sorry, there are no campgrounds available matching your current search."));
        //The following asserts that we found the text that is returned when there are no search results
    }

//    @Test
//    public void searchRequirementsTest(){
        // This is an example of where I would expand on the test cases
        // I would verify the optional / required fields. Make sure the location and dates field are optional, and the guests field is required.
//    }

//    @Test
//    public void formRequirementsTest(){
        // This is another example of where I would expand the test cases
        // This test could be used to text the placeholder text, and other acceptance criteria
//    }
}