package ru.qa.scooter.praktikum.services.pom;

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
    // лого Самокат
    private final By logoSamokat = By.xpath((".//a[@class='Header_LogoScooter__3lsAR']"));
    private final By headerQuestions = By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']");
    private final By cookies = By.xpath(".//div[@class='App_CookieConsent__1yUIN']");

    private NotFound notFound;

    private final WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
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

    public By getTopOrderButton() {
        return topOrderButton;
    }

    public By getLogoSamokat() {
        return logoSamokat;
    }

    public By getHeaderQuestions() {
        return headerQuestions;
    }

    public By getCookies() {
        return cookies;
    }

    public NotFound getNotFound() {
        return notFound;
    }

}

