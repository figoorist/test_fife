package ru.comp.pages;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/** Абстрактный класс страницы веб-приложения*/
public abstract class Page {
  /** Член класса - драйвер веб-браузера*/
  protected final WebDriver driver;

  /**
   * @param driver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
    this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  /** Метод получения заголовка страницы
   * @return текст заголовка страницы
   * */
  public String getTitle() {
    return driver.getTitle();
  }

  public abstract void clearForm();
}