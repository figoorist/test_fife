package ru.comp;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.comp.pages.FormPage;
import ru.comp.pages.HomePage;

public class FormTest extends TestNgTestBase {
    /** Свойство - объект страницы с формой*/
    private FormPage formPage;

    @BeforeClass
    @Parameters({"siteUrl", "login", "password"})
    public void initPageObjects(String siteUrl, String login, String password) {
        formPage = PageFactory.initElements(driver, FormPage.class);
        //заходим на страницу
        driver.get(siteUrl);
        login(login, password);
    }

    @Test
    @Parameters({"login", "password"})
    public void testEmailValidation() {
        login(login, password);
    }
}
