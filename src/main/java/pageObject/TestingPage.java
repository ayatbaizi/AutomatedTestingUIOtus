package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TestingPage extends BasePage {



   public TestingPage(WebDriver driver) {
      super(driver);
   }

   @FindBy(css = "div.lessons>.js-stats:nth-child(5)")
   public WebElement card5;


   public void cardsCounter() {
      int xpathCount = driver.findElements(By.xpath("//*[contains(@class, 'lessons__new-item_hovered')]")).size();
      logger.info("Количество карточек на вебстранице равно: " + xpathCount);
   }

   public TestCardPage clickOnCard5 () {

      card5.click();

      logger.info("Карточка №5 открыта");

      return new TestCardPage(driver);
   }
}
