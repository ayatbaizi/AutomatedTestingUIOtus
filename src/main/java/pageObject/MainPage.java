package pageObject;

import data.CoursesData;
import data.MainMenuData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
   public MainPage(WebDriver driver) {
      super(driver);
   }

   @FindBy(xpath = "//*[contains(@class, 'header2-menu_main')]/*[contains(@class, 'header2-menu__item')][.//*[text()='Курсы']]")
   public WebElement coursesButton;

   @FindBy(xpath = "//*[contains(@class,'header2-menu__item header2-menu__item_dropdown header2-menu__item_open')]//*[contains(@title,'Тестирование')])")
   public WebElement dropDownTesting;

   @FindBy(xpath = "//div[contains(@class,'header2-menu_main')]//p[contains(@class,'header2-menu__item-text')][contains(text(),'События')]")
   public WebElement eventsButton;

   @FindBy(xpath = "//div[contains(@class,'header2-menu_main')]//a[@title='Календарь мероприятий'][contains(text(),'Календарь мероприятий')]")
   public WebElement dropDownCalendar;

   private String mainMenuLocator = "//*[contains(@class, 'header2-menu_main')]/*[contains(@class, 'header2-menu__item')][.//*[text()='%s']]";

   private String subMenuLocator = mainMenuLocator + "//a[@title='%s']";

   public MainPage clickMainMenuCourses(MainMenuData mainMenuData) {
      String locator = String.format(mainMenuLocator, mainMenuData.getName());

      WebElement mainMenu = driver.findElement(By.xpath(locator));
      actions.moveToElement(mainMenu).build().perform();

      return this;
   }

   public MainPage clickCoursesByName(CoursesData coursesData) {
      String locator = String.format(subMenuLocator, MainMenuData.Cources.getName(), coursesData.getName());
      WebElement subMenu = driver.findElement(By.xpath(locator));
      actions.moveToElement(subMenu).click().build().perform();

      return this;
   }


   /*public void clickOnCoursesButton() {
      actions.moveToElement(mainMenuLocator).build().perform();
      coursesButton.click();
   }*/

   /*public TestingPage clickCoursesTesting() {
      dropDownTesting.click();
      return new TestingPage(driver);
   }*/

   public void clickOnEventsButton() {
      eventsButton.click();
   }

   public CalendarEventsPage clickOnCalendarButton() {
      dropDownCalendar.click();

      return new CalendarEventsPage(driver);
   }
}
