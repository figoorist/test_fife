package ru.comp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page{
  /**
   * Конструктор
   * @param driver
   */
  public HomePage(WebDriver driver) {
    super(driver);
  }

  /**
   * Получить WebElement - поле для ввода логина
   * @return
   */
  public WebElement getLoginField(){
    return driver.findElement(By.id("loginEmail"));
  }

  /**
   * Получить WebElement - поле для ввода пароля
   * @return
   */
  public WebElement getPasswordField(){
    return driver.findElement(By.id("loginPassword"));
  }


}