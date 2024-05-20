package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    // ссылка на главкую страницу сервиса
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    // кнопка Статус заказа
    private final By checkOrderButton = By.xpath(".//button[@class='Header_Link__1TAG7']");
    // поле Введите номер заказа
    private final By orderNumberInput = By.xpath(".//input[contains(@class, 'Input_Input__1iN_Z')]");
    // кнопка Go!
    private final By goButton = By.xpath(".//button[text()='Go!']");
    // Верхняя кнопка заказа
    private final By topOrderButton = By.xpath(".//button[@class='Button_Button__ra12g' and text()='Заказать']");
    // Нижняя кнопка заказа
    private final By bottomOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // лого Самокат
    private final By logoSamokat = By.xpath((".//a[@class='Header_LogoScooter__3lsAR']"));
    // лого Яндекс
    private final By logoYandex = By.xpath((".//a[@class='Header_LogoYandex__3TSOI']"));
    private final By headerQuestions = By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']");
    private final By cookies = By.xpath(".//div[@class='App_CookieConsent__1yUIN']");

    private NotFound notFound;

    private final WebDriver webDriver;
    public MainPage(WebDriver webDriver) {
        this.webDriver=webDriver;
        notFound = new NotFound(webDriver);
    }

    public By getCheckOrderButton() {
        return checkOrderButton;
    }

    public By getOrderNumberInput() {
        return orderNumberInput;
    }

    public By getGoButton() {
        return goButton;
    }

    public By getTopOrderButton(){
        return topOrderButton;
    }

    public By getBottomOrderButton(){
        return bottomOrderButton;
    }
    public By getLogoSamokat(){
        return logoSamokat;
    }
    public By getLogoYandex(){
        return logoYandex;
    }
    public By getHeaderQuestions(){
        return headerQuestions;
    }
    public By getCookies(){
        return cookies;
    }

    public NotFound getNotFound() {
        return notFound;
    }

}

