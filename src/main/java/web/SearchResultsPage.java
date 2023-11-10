package web;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

  @FindBy(xpath = "//section[@data-stid='desktop-sidebar']")
  public WebElement filters;

  @FindBy(xpath = "//a[@data-stid='open-hotel-information']")
  public List<WebElement> hotelsLinkList;

  protected SearchResultsPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public void waitForPageToLoad() {
    waitForElementToBeVisible(filters, 10);
  }

  public boolean areAnyResultsDisplayed() {
    return !hotelsLinkList.isEmpty();
  }
}
