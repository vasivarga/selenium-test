package testlisteners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

public class DefaultTestListener implements ITestListener, IInvokedMethodListener {
  Logger log = LoggerFactory.getLogger("TestListener");

  private static String getTestMethodName(ITestResult result) {
    return result.getMethod().getConstructorOrMethod().getName();
  }

  @Override
  public void onTestStart(ITestResult result) {
    log.info("Test started: [" + getTestMethodName(result) + "]");
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    log.info("Test passed: [" + getTestMethodName(result) + "]");
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    log.info("Test skipped: [" + getTestMethodName(result) + "]");
  }

  @Override
  public void onTestFailure(ITestResult result) {
    log.info("Test failed: [" + getTestMethodName(result) + "]");
  }
}
