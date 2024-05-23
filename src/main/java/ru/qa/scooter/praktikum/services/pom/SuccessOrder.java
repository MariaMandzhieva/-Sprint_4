package ru.qa.scooter.praktikum.services.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessOrder {
    // сообщение о том, что заказ оформлен
    private final By successOrderMessage = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    private final WebDriver webDriver;

    public SuccessOrder(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public By getSuccessOrderMessage() {
        return successOrderMessage;
    }
}

