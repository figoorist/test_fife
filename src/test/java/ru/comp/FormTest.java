package ru.comp;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.ArrayList;


public class FormTest extends TestNgTestBase {

    private ArrayList<ArrayList<String>> table;

    @BeforeClass
    @Parameters({"siteUrl"})
    public void initPageObjects(String siteUrl) {
        table = new ArrayList<>();
        //заходим на страницу
        driver.get(siteUrl);
    }

    @BeforeMethod
    @Parameters({"login", "password"})
    public void clearForm(String login, String password) {
        formPage.clearForm();
        login(login, password);
    }

    @Test
    public void testEmpty() {
        formPage.submit();
        Assert.assertTrue(formPage.getValidationMessageByType("email").isDisplayed());
    }

    @Test
    public void testEmptyName() {
        formPage.getEmailField().sendKeys("test@test.test");
        formPage.submit();
        Assert.assertTrue(formPage.getValidationMessageByType("blankName").isDisplayed());
    }

    @Test
    @Parameters({"invalidEmail1"})
    public void testEmailValidation1(String invalidEmail1) {
        formPage.getEmailField().sendKeys(invalidEmail1);
        formPage.submit();
        Assert.assertTrue(formPage.getValidationMessageByType("email").isDisplayed());
    }

    @Test
    @Parameters({"invalidEmail2"})
    public void testEmailValidation2(String invalidEmail2) {
        formPage.getEmailField().sendKeys(invalidEmail2);
        formPage.getNameField().sendKeys("Vitya");
        formPage.submit();
        Assert.assertTrue(formPage.getValidationMessageByType("email").isDisplayed());
    }

    @Test
    public void testAddItem() throws InterruptedException {
        formPage.getEmailField().sendKeys("test@test.test");
        formPage.getNameField().sendKeys("Vitya");
        formPage.setSexSelect("Мужской");
        formPage.submit();
        formPage.confirm();

        ArrayList<String> row = new ArrayList<String>() {{
            add("test@test.test");
            add("Vitya");
            add("Мужской");
            add("Нет");
            add("");
        }};
        table.add(row);

        Assert.assertTrue(formPage.verifyTable(table));
    }
}
