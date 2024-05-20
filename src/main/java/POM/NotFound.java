package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotFound {
    private final WebDriver webDriver;
    // сообщение о том, что такого заказа нет
    private final By notFoundMessage = By.xpath(".//img[@alt='Not found']");

    public NotFound(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public boolean checkMessageExist() {
        return !webDriver.findElements(notFoundMessage).isEmpty();
    }
}

