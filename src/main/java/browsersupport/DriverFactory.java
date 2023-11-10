package browsersupport;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {
  static Logger log = LoggerFactory.getLogger("DriverFactory");
  private static RemoteWebDriver driver = null;

  public static RemoteWebDriver setUpWebDriver(String browser) {
    log.info("Setting up the WebDriver...");

    if (null == browser || browser.contains("chrome")) {
      WebDriverManager.chromedriver().setup();
      driver = (RemoteWebDriver) WebDriverManager.chromedriver().create();
    } else if (browser.contains("firefox")) {
      WebDriverManager.firefoxdriver().setup();
      driver = (RemoteWebDriver) WebDriverManager.firefoxdriver().create();
    }
    logDriverInfo();
    return driver;
  }

  private static void logDriverInfo() {
    log.info("[Driver]: " + driver);
    log.info("[Driver session]: " + getSessionId());
  }

  public static WebDriver getDriver() {
    return driver;
  }

  public static String getSessionId() {
    return driver.getSessionId().toString();
  }
}
