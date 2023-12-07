package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage{

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public enum PageElements {
        searchResults,
        emptySearchText
    }

    public By by(PageElements elements){
        switch (elements){
            case searchResults: By.cssSelector("li.app-park-search-result-list-item.app-search-result-1.app-search-result-row.search-results-list-item > a");
            case emptySearchText: By.cssSelector("div.search-results-none.app-no-search-results");
            default: return null;
        }
    }

    public String getSearchResults(){
        String searchText = null;
        try {
            searchText = getText(by(PageElements.searchResults));
            System.out.println("Search Results: " + searchText);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Issue getting search results");
        }
        return searchText;
    }

    public String getEmptySearchText(){
        String results = null;
        try {
            results = getText(by(PageElements.emptySearchText));
            System.out.println("Search Results: " + results);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Issue getting empty search results");
        }
        return results;
    }
}