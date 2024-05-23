package ru.qa.scooter.praktikum.services.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutRent {
    public final By deliveryDateField = By.xpath(".//div[@class='react-datepicker__input-container']");
    public final By deliveryDateInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodField = By.xpath(".//div[@class='Dropdown-control']");
    private final By comment = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='Комментарий для курьера']");
    private final By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    private final WebDriver webDriver;
    public AboutRent(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public By getRentalPeriodField(){
        return rentalPeriodField;
    }
    public By getComment(){
        return comment;
    }
    public By getButtonOrder(){
        return buttonOrder;
    }

}

