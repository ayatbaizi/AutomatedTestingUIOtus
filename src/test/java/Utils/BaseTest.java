package Utils;

import driverFactory.WebDriverFactory;
import exceptions.BrowserNotSupportedExeception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pageObject.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BaseTest {
   public LoginPage loginPage;
   public MainPage mainPage;
   public TestingPage testingPage;
   public TestCardPage testCardPage;
   public CalendarEventsPage calendarEventsPage;
   public WebDriver driver;



   @BeforeAll
   public static void initDriver() throws BrowserNotSupportedExeception {
      new WebDriverFactory().initDriver();

   }

   @BeforeEach
   public void initDriverOptions() throws BrowserNotSupportedExeception {
      List<String> options = new ArrayList<>();
      options.add("--start-maximized");
      driver = new WebDriverFactory().create(WebDriverFactory.setDriverType(), options);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      new MainPage(driver).open("/");
      //logger.info("Logs on");
      loginPage = new LoginPage(driver);
      mainPage = new MainPage(driver);
      testingPage = new TestingPage(driver);
      testCardPage = new TestCardPage(driver);
      calendarEventsPage = new CalendarEventsPage(driver);


   }

   @AfterEach
   public void close() {
      if (driver != null) {
         driver.close();
         driver.quit();
      }

   }
}
