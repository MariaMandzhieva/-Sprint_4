package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmOrder {
    private final By buttonYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    private final WebDriver webDriver;
    public ConfirmOrder(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public By getButtonYes(){
        return buttonYes;
    }

}

