package pageObject;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CalendarEventsPage extends BasePage {

   public CalendarEventsPage(WebDriver driver) {
      super(driver);
   }


   @FindBy(css = "div.dod_new-events__list.js-dod_new_events")
   private WebElement calendarEventsElement;
   @FindBy(xpath = "//*[contains(@class,'dod_new-events__list')]//a")
   private List<WebElement> countCalendarEvents;


   @FindBys(@FindBy(xpath = "//span[contains(@class,'dod_new-event__calendar-icon')]/following-sibling::span"))
   private List<WebElement> dates;
   @FindBy(css = "span.dod_new-events-dropdown__input-selected")
   private WebElement openDayDropDownMenuButton;
   @FindBy(css = ".dod_new-events-dropdown__list-item[title='ДОД']")
   private WebElement openDayEventTitle;
   @FindBy(css = "div.dod_new-type__text")
   private WebElement openDayEventResult;
   @FindBys(@FindBy(css = "div.dod_new-type__text"))
   private List<WebElement> openDayEventResults;

   @FindBy(css = "div.footer2__links.footer2__links_center")
   private WebElement footer;
   @FindBy(xpath = "//*[contains(@class,'dod_new-events__list')]//a[contains(@href,'https://otus.ru/lessons/android-professional/#event-2093')]")
   private WebElement lastEventHref;

   @FindBy(xpath = "(//div[contains(@class, 'dod_new-events-dropdown__input')])[1]")
   private WebElement eventsTypeSelector;

   @FindBy(xpath = "(//a[contains(@title, 'Открытый вебинар')])[1]")
   private WebElement eventType;

   public void clickOnCalendarEventsElement() {
      calendarEventsElement.click();
   }

   public void getSumEventsElemets() {
      logger.info("Количество отображаемых карточек на вебстранице равно: " + countCalendarEvents.size());
   }

   public void openEventsTypeSelector() {
      actions.moveToElement(eventsTypeSelector).build().perform();
      eventsTypeSelector.click();
   }

   public void selectEventType() {
      //String element = ("(//a[contains(@title, 'Открытый вебинар')])[1]");
      actions.moveToElement(eventType).click().build().perform();
      //eventType.click();
   }


   private String getCurrentData() {
      Calendar cal = Calendar.getInstance();
      String currentData = new SimpleDateFormat("dd MMMM", new Locale("ru")).format(cal.getTime());
      //System.out.println(month);
      logger.info("Текущая дата: " + currentData);
      return currentData;
   }

   public String getEventDays() {
      List<WebElement> elements = driver.findElements(By.xpath(" //span[contains(@class,'dod_new-event__calendar-icon')]/following-sibling::span"));
      String cardDate = null;
      for (WebElement element : elements) {
         cardDate = element.getText();
         String today = getCurrentData();
         //String after = DateofEvent.JUNE7.getDateOfEvent();

         if (today.equals(cardDate)) {
            logger.info("Данное мероприятие равно текущей дате " + today);
         } else {
            logger.info("Данное мероприятие больше текущей даты " + today);
         }
      }

      return cardDate;
   }

}
