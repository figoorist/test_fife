package ru.comp;

import org.testng.Assert;
import org.testng.annotations.*;


public class LoginTest extends TestNgTestBase {
  @BeforeClass
  @Parameters({"siteUrl"})
  public void initPageObjects(String siteUrl) {
    //заходим на страницу
    driver.get(siteUrl);
  }

  @BeforeMethod
  public void clearForm() {
      homePage.clearForm();
  }

  @Test
  public void testEmptyFields() {
      login("", "");
      Assert.assertTrue(homePage.getValidationMessageByType("email").isDisplayed());
  }

  @Test
  @Parameters({"invalidEmail1"})
  public void testInvalidEmail1(String invalidEmail1) {
      login(invalidEmail1, "");
      Assert.assertTrue(homePage.getValidationMessageByType("email").isDisplayed());
  }

  @Test
  @Parameters({"invalidEmail2"})
  public void testInvalidEmail2(String invalidEmail2) {
      login(invalidEmail2, "");
      Assert.assertTrue(homePage.getValidationMessageByType("email").isDisplayed());
  }

  @Test
  @Parameters({"password"})
  public void testWrongEmail(String password) {
      login("test@test.test", password);
      Assert.assertTrue(homePage.getValidationMessageByType("emailorpass").isDisplayed());
  }

  @Test
  @Parameters({"login"})
  public void testWrongPass(String login) {
      login(login, "pas");
      Assert.assertTrue(homePage.getValidationMessageByType("emailorpass").isDisplayed());
  }

  @Test
  public void testWrongEmailPass() {
      login("test@test.test", "pas");
      Assert.assertTrue(homePage.getValidationMessageByType("emailorpass").isDisplayed());
  }

  @Test
  @Parameters({"login", "password"})
  public void testLogin(String login, String password) {
      login(login, password);
      //показалась форма анкеты
      Assert.assertTrue(formPage.getEmailField().isDisplayed());
  }
}