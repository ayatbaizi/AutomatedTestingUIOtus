package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
   public LoginPage(WebDriver driver) {
      super(driver);
   }

   private final static String LOGIN = System.getProperty("login");
   private final static String PASSWORD = System.getProperty("password");

   @FindBy(xpath ="//button[contains(@data-modal-id, 'new-log-reg')]" )
   private WebElement newLoginButton;

   @FindBy(xpath = "//input[@type='text'][contains(@class,'email')]")
   private WebElement loginField;

   @FindBy(xpath = "//input[@type='password'][contains(@class,'new-input')]")
   private WebElement passwordField;

   @FindBy(xpath = "//button[contains(text(),'Войти')]")
   private WebElement enterButton;

   public void clickNewLoginButton() {
      newLoginButton.click();
   }

   public void inputLogin() {
      loginField.sendKeys(LOGIN);
   }

   public void inputPassword() {
      passwordField.sendKeys(PASSWORD);
   }


   public MainPage clickEnterButton(){
      enterButton.click();
      return new MainPage(driver);
   }
}
