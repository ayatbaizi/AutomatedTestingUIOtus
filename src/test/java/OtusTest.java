import Utils.BaseTest;
import data.CoursesData;
import data.MainMenuData;
import org.junit.jupiter.api.*;


public class OtusTest extends BaseTest {


   @Test
   public void test() {
      //Проверка количества курсов в разделе тестирование:
      //1 Пользователь переходит в разделе тестирование
      //2 На странице отображаются карточки курсов. Количество карточек равно 14


      mainPage.clickMainMenuCourses(MainMenuData.Cources.Cources);
      mainPage.clickCoursesByName(CoursesData.TESTING);

      testingPage.cardsCounter();
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

      testingPage.clickOnCard5();
      testCardPage.getTitleCard5();
      testCardPage.getDescriptionCard5();
      testCardPage.getDurationCard5();
      testCardPage.getFormatCard5();
   }


   @Test
   public void test3() {


      //Валидация дат предстоящих мероприятий:
      //    1 Пользователь переходит в раздел События -> Календарь мероприятий
      //    2 На странице отображаются карточки предстоящих мероприятий.
      //    3 Даты проведения мероприятий больше или равны текущей дате

      mainPage.clickOnEventsButton();
      mainPage.clickOnCalendarButton();

      calendarEventsPage.clickOnCalendarEventsElement();
      calendarEventsPage.getSumEventsElemets();
      calendarEventsPage.getEventDays();
   }

   @Test
   public void test4() {
      //Просмотр мероприятий по типу:
      //    1 Пользователь переходит в раздел События -> Календарь мероприятий
      //    2 Пользователь сортирует мероприятия по типу Открытые вебинары
      //    3 На странице отображаются карточки предстоящих мероприятий. На каждой карточке в типе указанно "Открытый вебинар"

      mainPage.clickOnEventsButton();
      mainPage.clickOnCalendarButton();
      //calendarEventsPage.moveToEventsTypeSelector();
      calendarEventsPage.openEventsTypeSelector();
      calendarEventsPage.selectEventType();


   }
}

