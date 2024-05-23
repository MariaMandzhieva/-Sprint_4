package ru.qa.scooter.praktikum.services.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForWhomSamokat {

    // поле ввода Имя
    private final By name = By.xpath(".//input[@placeholder='* Имя']");
    // поле ввода Фамилия
    private final By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    // поле ввода Адрес
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // поле ввода Станции метро
    private final By metro = By.xpath(".//input[@placeholder='* Станция метро']");

    // поле ввода Телефон
    private final By tel = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //.//button[@class='Button_Button__ra12g Button_Middle__1CSJM']
    // кнопка Далее
    private final By buttonFurther = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private final WebDriver webDriver;
    public ForWhomSamokat(WebDriver webDriver) {
        this.webDriver=webDriver;
    }
    public By getName(){
        return name;
    }
    public By getSurname(){
        return surname;
    }
    public By getAddress(){
        return address;
    }
    public By getMetro(){
        return metro;
    }
    public By getTel(){
        return tel;
    }
    public By getButtonFurther(){
        return buttonFurther;
    }
}
