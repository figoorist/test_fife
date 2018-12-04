package ru.comp;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ru.comp.pages.FormPage;


public class LoginTest extends TestNgTestBase {
  @BeforeClass
  @Parameters({"siteUrl"})
  public void initPageObjects(String siteUrl) {
    //заходим на страницу
    driver.get(siteUrl);
  }

  @Test
  @Parameters({"login", "password"})
  public void testLogin(String login, String password) {
    login(login, password);
  }


}