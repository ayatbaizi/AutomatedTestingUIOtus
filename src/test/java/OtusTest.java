import data.CoursesData;
import data.MainMenuData;
import pageObject.*;
import utils.BaseTest;
import org.junit.jupiter.api.*;


public class OtusTest extends BaseTest {


   @Test
   public void test() {

      //Проверка количества курсов в разделе тестирование:
      //1 Пользователь переходит в разделе тестирование
      //2 На странице отображаются карточки курсов. Количество отображаемых карточек

      new MainPage(driver)
              .clickButtonLogin();

      new LoginPage(driver)
              .waitVisibleInputBox()
              .authorizationUser()
              .waitModalWindowInvisible();

      new MainPage(driver)
              .clickMainMenuCourses(MainMenuData.COURCES)
              .clickCoursesByName(CoursesData.TESTING);

      new TestingPage(driver)
              .cardsCounter();
   }

   @Test
   public void test2() {

      //Просмотр карточки курса:
      //    1 Пользователь переходит на карточку курса
      //    2 В карточке указана информация о курсе:
      //    Название
      //    Описание
      //    Длительность обучения
      //    Формат // Минимально достаточное - проверить одну карточку.

      new MainPage(driver)
              .clickButtonLogin();

      new LoginPage(driver)
              .waitVisibleInputBox()
              .authorizationUser()
              .waitModalWindowInvisible();

      new TestingPage(driver)
              .open("/categories/testing/");
      new TestingPage(driver)
              .clickOnCard5();
      new TestCardPage(driver)
              .getTitleCard5()
              .getDescriptionCard5()
              .getDurationCard5()
              .getFormatCard5();
   }
   @Test
   public void test3() {

      //Валидация дат предстоящих мероприятий:
      //    1 Пользователь переходит в раздел События -> Календарь мероприятий
      //    2 На странице отображаются карточки предстоящих мероприятий.
      //    3 Даты проведения мероприятий больше или равны текущей дате

      new MainPage(driver)
              .clickOnEventsButton()
              .clickOnCalendarButton();

      new CalendarEventsPage(driver)
              //.clickOnCalendarEventsElement()
              .getSumEventsElemets()
              .getEventDays();
   }

   @Test
   public void test4() {
      //Просмотр мероприятий по типу:
      //    1 Пользователь переходит в раздел События -> Календарь мероприятий
      //    2 Пользователь сортирует мероприятия по типу Открытые вебинары
      //    3 На странице отображаются карточки предстоящих мероприятий. На каждой карточке в типе указанно "Открытый вебинар"

      new MainPage(driver)
              .clickOnEventsButton()
              .clickOnCalendarButton();

      new CalendarEventsPage(driver)
              .openEventsTypeSelector()
              .selectEventType();
   }
}

