package ru.comp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FormPage extends Page {
    /**
     * Список ошибок валидации
     */
    private HashMap<String, String> validationErrors = new HashMap<>();

    /**
     * Конструктор
     * @param driver
     */
    public FormPage(WebDriver driver) {
        super(driver);
        validationErrors.put("email", "emailFormatError");
        validationErrors.put("blankName", "blankNameError");
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
     * Установить Select по id
     */
    public void setSexSelect(String text) {
        Select dataGender = new Select(driver.findElement(By.id("dataGender")));
        dataGender.selectByVisibleText(text);

    }

    /**
     * Взять чекбокс по номеру
     * @return
     */
    public WebElement getCheckboxByNumber(Integer number) {
        return driver.findElement(By.id("dataCheck1" + number.toString()));
    }

    /**
     * Взять радиобаттон по номеру
     * @return
     */
    public WebElement getRadioByNumber(Integer number) {
        return driver.findElement(By.id("dataSelect2" + number.toString()));
    }

    /**
     * Отправить форму
     */
    public void submit() {
        driver.findElement(By.id("dataSend")).click();
    }

    /**
     * Очистить поля ввода
     */
    public void clearForm(){
        driver.navigate().refresh();
    }

    public WebElement getValidationMessageByType(String type) {
        return driver.findElement(By.id(validationErrors.get(type)));
    }

    public boolean verifyTable(ArrayList<ArrayList<String>> table) {
        Boolean result = true;
        Integer rowsCount = driver.findElements(By.tagName("tr")).size() - 1;
        Integer colCount = driver.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).size();
        for(Integer i = 1; i <= rowsCount; i++){
            for (Integer j = 1; j <= colCount; j++){
                if(!driver.findElement(By.xpath("//table//tr[" + i.toString() + "]/td[" + j.toString() + "]")).getText()
                                .equals(table.get(i-1).get(j-1))){
                    result = false;
                }
            }//*[@id="dataTable"]/tbody/tr[1]/td[1]
        }
        return result;
    }

    public void confirm() {
        driver.findElement(By.xpath("//button[contains(text(), 'Ok')]")).click();
    }
}