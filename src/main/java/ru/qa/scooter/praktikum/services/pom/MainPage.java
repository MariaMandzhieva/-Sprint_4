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
    private static final String topOrderButton = ".//button[@class='Button_Button__ra12g' and text()='Заказать']";
    // Нижняя кнопка заказа
    private static final String bottomOrderButton = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']";
    // лого Самокат
    private final By logoSamokat = By.xpath((".//a[@class='Header_LogoScooter__3lsAR']"));
    private final By headerQuestions = By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']");
    private final By cookies = By.xpath(".//div[@class='App_CookieConsent__1yUIN']");
    // Вопросы
    private static final String firstQuestion = ".//div[@id='accordion__heading-0']";
    private static final String secondQuestion = ".//div[@id='accordion__heading-1']";
    private static final String thirdQuestion = ".//div[@id='accordion__heading-2']";
    private static final String forthQuestion = ".//div[@id='accordion__heading-3']";
    private static final String fifthQuestion = ".//div[@id='accordion__heading-4']";
    private static final String sixthQuestion = ".//div[@id='accordion__heading-5']";
    private static final String seventhQuestion = ".//div[@id='accordion__heading-6']";
    private static final String eighthQuestion = ".//div[@id='accordion__heading-7']";
    // Ответы
    private static final String firstAnswerField = ".//div[@aria-labelledby='accordion__heading-0']";
    private static final String secondAnswerField = ".//div[@aria-labelledby='accordion__heading-1']";
    private static final String thirdAnswerField = ".//div[@aria-labelledby='accordion__heading-2']";
    private static final String forthAnswerField = ".//div[@aria-labelledby='accordion__heading-3']";
    private static final String fifthAnswerField = ".//div[@aria-labelledby='accordion__heading-4']";
    private static final String sixthAnswerField = ".//div[@aria-labelledby='accordion__heading-5']";
    private static final String seventhAnswerField = ".//div[@aria-labelledby='accordion__heading-6']";
    private static final String eighthAnswerField = ".//div[@aria-labelledby='accordion__heading-7']";

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

    public static String getTopOrderButton() {
        return topOrderButton;
    }

    public static String getBottomOrderButton() {
        return bottomOrderButton;
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

    public static String getFirstQuestion() {
        return firstQuestion;
    }

    public static String getSecondQuestion() {
        return secondQuestion;
    }

    public static String getThirdQuestion() {
        return thirdQuestion;
    }

    public static String getForthQuestion() {
        return forthQuestion;
    }

    public static String getFifthQuestion() {
        return fifthQuestion;
    }

    public static String getSixthQuestion() {
        return sixthQuestion;
    }

    public static String getSeventhQuestion() {
        return seventhQuestion;
    }

    public static String getEighthQuestion() {
        return eighthQuestion;
    }

    public static String getFirstAnswerField() {
        return firstAnswerField;
    }

    public static String getSecondAnswerField() {
        return secondAnswerField;
    }

    public static String getThirdAnswerField() {
        return thirdAnswerField;
    }

    public static String getForthAnswerField() {
        return forthAnswerField;
    }

    public static String getFifthAnswerField() {
        return fifthAnswerField;
    }

    public static String getSixthAnswerField() {
        return sixthAnswerField;
    }

    public static String getSeventhAnswerField() {
        return seventhAnswerField;
    }

    public static String getEighthAnswerField() {
        return eighthAnswerField;
    }

    public NotFound getNotFound() {
        return notFound;
    }

}

