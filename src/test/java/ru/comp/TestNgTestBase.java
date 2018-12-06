package ru.comp;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import ru.comp.pages.FormPage;
import ru.comp.pages.HomePage;


/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

    protected WebDriver driver;
    /** Свойство - объект стартовой страницы*/
    protected HomePage homePage;
    /** Свойство - объект страницы с формой*/
    protected FormPage formPage;

    @BeforeClass
    public void initTestSuite() {
        driver = new ChromeDriver();
        //устанавливаем неявный таймаут ожидания для драйвера 30 секунд
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //во весь экран
        driver.manage().window().maximize();

        homePage = PageFactory.initElements(driver, HomePage.class);
        formPage = PageFactory.initElements(driver, FormPage.class);
    }

    public void login(String login, String password) {
        homePage.getLoginField().sendKeys(login);
        homePage.getPasswordField().sendKeys(password);
        homePage.submit();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
    driver.quit();
  }
}
