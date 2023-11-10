package web;

import browsersupport.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class BaseTest {

  public static final String BASE_URL = "https://www.hotwire.com/";
  protected WebDriver driver;
  protected Logger log;

  @Parameters({"browser"})
  @BeforeMethod(alwaysRun = true)
  public void setUpClass(@Optional String browser) {
    log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    driver = DriverFactory.setUpWebDriver(browser);
    driver.get(BASE_URL);
    driver.manage().window().maximize();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDownClass() {
    driver.close();
    driver.quit();
  }
}
