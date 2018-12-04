package ru.comp;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.comp.pages.HomePage;


/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

  protected WebDriver driver;
  /** Свойство - объект стартовой страницы*/
  private HomePage homepage;

  @BeforeSuite
  public void initTestSuite() {
    driver = new ChromeDriver();
    //устанавливаем неявный таймаут ожидания для драйвера 30 секунд
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //во весь экран
    driver.manage().window().maximize();
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    driver.quit();
  }

  public void login(String login, String password) {
    homepage.getLoginField().sendKeys(login);
    homepage.getPasswordField().sendKeys(password);
  }
}
