package web;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

  private static final By bundlesOptionBy =
      By.cssSelector("div.farefinder-package.farefinder-content");
  private static final By suggestions = By.cssSelector("ul.dropdown-menu.large");

  @FindBy(xpath = "//div[@data-bdd='farefinder-option-bundles']")
  public WebElement bundlesOption;

  @FindBy(xpath = "//input[@data-bdd='farefinder-package-origin-location-input']")
  public WebElement flyFromInput;

  @FindBy(xpath = "//input[@data-bdd='farefinder-package-destination-location-input']")
  public WebElement flyToInput;

  @FindBy(xpath = "//div[@data-bdd='farefinder-package-startdate-input']")
  public WebElement departureInput;

  @FindBy(className = "datepicker")
  public WebElement calendar;

  @FindBy(xpath = "//div[@class='day-availability']/div")
  public List<WebElement> availableDays;

  @FindBy(xpath = "//button[@data-bdd='farefinder-package-search-button']")
  public WebElement findADealButton;

  protected HomePage(WebDriver driver) {
    super(driver);
  }

  @Override
  public void waitForPageToLoad() {
    waitForElementToBeVisible(bundlesOption, 3);
  }

  public void clickBundlesOption() {
    click(bundlesOption);
  }

  public void typeOnFlyFromInput(String text) {
    type(flyFromInput, text);
    waitForElementToBePresent(suggestions, 3);
  }

  public void typeOnFlyToInput(String text) {
    type(flyToInput, text);
    waitForElementToBePresent(suggestions, 3);
  }

  public void openCalendar() {
    click(departureInput);
  }

  public void waitForCalendarToBeVisible() {
    waitForElementToBeVisible(calendar, 1);
  }

  public void defocusFromInput() {
    flyFromInput.sendKeys(Keys.ENTER);
  }

  public void defocusToInput() {
    flyToInput.sendKeys(Keys.ENTER);
  }

  public void waitForBundlesFormOptionsToLoad() {
    waitForElementToBePresent(bundlesOptionBy, 1);
  }

  public void selectDateForTomorrow() {
    click(availableDays.get(1));
  }

  public void selectDate20DaysFromTomorrow() {
    click(availableDays.get(21));
  }

  public void clickFindADealButton() {
    click(findADealButton);
  }

  public void waitForCalendarToBeClosed() {
    waitForElementToBeInvisible(calendar, 1);
  }
}
