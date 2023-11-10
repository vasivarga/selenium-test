package web;


import browsersupport.DriverFactory;
import java.time.*;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage {

  protected WebDriver driver;
  protected Logger log;
  protected JavascriptExecutor executor;

  protected BasePage(final WebDriver driver) {
    log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    this.driver = DriverFactory.getDriver();
    PageFactory.initElements(driver, this);
    executor = (JavascriptExecutor) this.driver;
  }

  public abstract void waitForPageToLoad();

  public WebElement find(By selector) {
    return driver.findElement(selector);
  }

  public void type(WebElement element, String text) {
    log.info("Typing " + "[" + text + "]" + " on " + getWebElementString(element));
    element.sendKeys(text);
  }

  public void waitForElementToBePresent(final By locator, int timeInSeconds) {
    log.info("Waiting for element to be present: " + locator);
    final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  public void waitForElementToBeVisible(WebElement element, int timeInSeconds) {
    log.info("Waiting for element to be visible: " + getWebElementString(element));
    final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public void waitForElementToBeInvisible(WebElement element, int timeInSeconds) {
    log.info("Waiting for element to be invisible: " + getWebElementString(element));
    final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
    wait.until(ExpectedConditions.invisibilityOf(element));
  }

  public void click(WebElement element) {
    log.info("Click on element: " + getWebElementString(element));
    waitForElementToBeVisible(element, 1);
    element.click();
  }

  protected String getWebElementString(WebElement element) {
    String stringToReturn;
    if (element.toString().contains("->")) {
      stringToReturn = StringUtils.substringAfter(element.toString(), "-> ");
    } else {
      stringToReturn = element.toString();
    }
    return StringUtils.truncate(stringToReturn, stringToReturn.length() - 1);
  }
}
