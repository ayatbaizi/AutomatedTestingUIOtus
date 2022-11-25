package pageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCardPage extends BasePage{

   public TestCardPage(WebDriver driver) {
      super(driver);
   }
   public void getTitleCard5() {
      String titleCard1Actual = driver.findElement(By.cssSelector(".course-header2__title")).getText();
      String titleCard1Expected = "Автоматизация тестирования OpenStack";
      Assertions.assertEquals(titleCard1Expected, titleCard1Actual);
      logger.info("Название: " + titleCard1Expected);
   }
   public void getDescriptionCard5() {
      String descriptionActual = driver.findElement(By.cssSelector(".course-header2__subtitle")).getText();
      String descriptionExpected = "Лучшие практики по автоматизации тестирования облачной платформы OpenStack на Tempest";
      Assertions.assertEquals(descriptionExpected, descriptionActual);
      logger.info("Описание курса: " + descriptionExpected);
   }
   public void getDurationCard5() {
      String durationCard4Actual = driver.findElement(By.xpath("//*[contains(@class,'container__col_md-4')]//p[contains(@class,'course-header2-bottom__item-text')]")).getText();
      String durationCard4Expected = "4 месяца";
      Assertions.assertEquals(durationCard4Expected, durationCard4Actual);
      logger.info("Длительность: " + durationCard4Expected);
   }
   public void getFormatCard5() {
      String formatCard3Actual = driver.findElement(By.xpath("//*[contains(@class,'container__col_md-2')]//*[contains(@class,'course-header2-bottom__item-text')]")).getText();
      String formatCard3Expected = "Online";
      Assertions.assertEquals(formatCard3Expected, formatCard3Actual);
      logger.info("Формат: " + formatCard3Expected);
   }

}
