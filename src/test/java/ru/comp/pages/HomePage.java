package ru.comp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;


public class HomePage extends Page{
    /**
     * * Список ошибок валидации
     */
    private HashMap<String, String> validationErrors = new HashMap<>();

    /**
     * Конструктор
     * @param driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
        validationErrors.put("email", "emailFormatError");
        validationErrors.put("emailorpass", "invalidEmailPassword");
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

    /**
     * Нажать вход
     */
    public void submit() {
        driver.findElement(By.id("authButton")).click();
    }

    public WebElement getValidationMessageByType(String type) {
        return driver.findElement(By.id(validationErrors.get(type)));
    }

    /**
     * Очистить поля ввода
     */
    public void clearForm(){
        driver.navigate().refresh();
    }
}