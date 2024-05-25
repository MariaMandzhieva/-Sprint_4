package ru.qa.scooter.praktikum.services.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Steps {
    private final WebDriver webDriver;

    public Steps(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Steps open(String url) {
        webDriver.get(url);
        return this;
    }

    public Steps click(By element) {
        webDriver.findElement(element).click();
        return this;
    }

    public Steps input(By element, String text) {
        webDriver.findElement(element).sendKeys(text);
        return this;
    }

}
