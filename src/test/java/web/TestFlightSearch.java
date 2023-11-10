package web;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFlightSearch extends BaseTest {

  @Test
  public void testSearchResults() {
    HomePage homePage = new HomePage(driver);
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    homePage.waitForPageToLoad();
    homePage.clickBundlesOption();
    homePage.waitForBundlesFormOptionsToLoad();
    homePage.typeOnFlyFromInput("SFO");
    homePage.defocusFromInput();
    homePage.typeOnFlyToInput("LAX");
    homePage.defocusToInput();
    homePage.openCalendar();
    homePage.waitForCalendarToBeVisible();
    homePage.selectDateForTomorrow();
    homePage.selectDate20DaysFromTomorrow();
    homePage.waitForCalendarToBeClosed();
    homePage.clickFindADealButton();

    searchResultsPage.waitForPageToLoad();
    Assert.assertTrue(searchResultsPage.areAnyResultsDisplayed(), "There are no results displayed");
  }
}
