package ru.comp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;

public class FormPage extends Page {
    /**
     * Конструктор
     * @param driver
     */
    public FormPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Получить WebElement - поле для ввода емэйла
     * @return
     */
    public WebElement getEmailField() {
        return driver.findElement(By.id("dataEmail"));
    }

    /**
     * Получить WebElement - поле для ввода имени
     * @return
     */
    public WebElement getNameField() {
        return driver.findElement(By.id("dataName"));
    }

    /**
     * Установить пол
     * @return
     */
    public void setSetField(String text) {
        Select dataGender = new Select(driver.findElement(By.id("dataGender")));
        dataGender.selectByVisibleText(text);

    }

    public WebElement getCheckboxByN(int number) {
        return driver.findElement(By.id(id))
    }
}
