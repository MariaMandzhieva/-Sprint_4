package ru.qa.scooter.praktikum.services;

import org.openqa.selenium.*;
import ru.qa.scooter.praktikum.services.pom.*;
import ru.qa.scooter.praktikum.services.rules.BrowserRule;
import ru.qa.scooter.praktikum.services.steps.Steps;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderSamokat {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    private final String orderButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String tel;
    private final String rentalPeriod;
    private final String colour;
    private final String textComment;
    private final int plusDaysToDate;
    private final boolean isSuccessOrderMessageDisplayed;

    public OrderSamokat(String orderButton, String name, String surname, String address, String metroStation, String tel, String rentalPeriod, String colour, String textComment, int plusDaysToDate, boolean isSuccessOrderMessageDisplayed) {
        this.orderButton = orderButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.tel = tel;
        this.rentalPeriod = rentalPeriod;
        this.colour = colour;
        this.textComment = textComment;
        this.plusDaysToDate = plusDaysToDate;
        this.isSuccessOrderMessageDisplayed = isSuccessOrderMessageDisplayed;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderSamokat() {
        return new Object[][]{
                {MainPage.getTopOrderButton(), "Иван", "Иванов", "Лесная,5", ForWhomSamokat.getBabushkinskayaMetroStation(), "89999999999", AboutRent.getTwoDays(), AboutRent.getBlackColour(), "Спасибо!", 1, true},
                {MainPage.getBottomOrderButton(), "Александра", "Александрова", "Парковая,12", ForWhomSamokat.getMolodezhnayaMetroStation(), "89876543210", AboutRent.getThreeDays(), AboutRent.getGreyColour(), "Привет!", 2, true},
        };
    }

    @Test
    public void checkOrderSamokat() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        Steps steps = new Steps(browserRule.getWebDriver());

        steps.open(MainPage.URL);

        // вырезка элемента Сookies, который перекрывает кнопку Далее
        WebElement elementCookie = browserRule.getWebDriver().findElement(mainPage.getCookies());
        JavascriptExecutor js = (JavascriptExecutor) browserRule.getWebDriver();
        js.executeScript("arguments[0].remove();", elementCookie);

        steps.click(By.xpath(orderButton));

        ForWhomSamokat forWhomSamokat = new ForWhomSamokat(browserRule.getWebDriver());

        steps.input(forWhomSamokat.getName(), name)
                .input(forWhomSamokat.getSurname(), surname)
                .input(forWhomSamokat.getAddress(), address)
                .click(forWhomSamokat.getMetro());

        // прокрутка страницы до необходимой станции метро
        WebElement station = browserRule.getWebDriver().findElement(By.xpath(metroStation));
        ((JavascriptExecutor) browserRule.getWebDriver()).executeScript("arguments[0].scrollIntoView();", station);
        new WebDriverWait(browserRule.getWebDriver(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(metroStation)));

        steps.click(By.xpath(metroStation))
                .input(forWhomSamokat.getTel(), tel)
                .click(forWhomSamokat.getButtonFurther());

        AboutRent aboutRent = new AboutRent(browserRule.getWebDriver());

        steps.click(aboutRent.deliveryDateField);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().plusDays(plusDaysToDate).format(formatter);
        browserRule.getWebDriver().findElement(aboutRent.deliveryDateInput).sendKeys(date);
        browserRule.getWebDriver().findElement(aboutRent.deliveryDateInput).sendKeys(Keys.RETURN);

        steps.click(aboutRent.getRentalPeriodField())
                .click(By.xpath(rentalPeriod))
                .click(By.xpath(colour))
                .input(aboutRent.getComment(), textComment)
                .click(aboutRent.getButtonOrder());

        ConfirmOrder confirmOrder = new ConfirmOrder(browserRule.getWebDriver());

        steps.click(confirmOrder.getButtonYes());

        SuccessOrder successOrder = new SuccessOrder(browserRule.getWebDriver());

        assertEquals("Всплывающее окно с сообщением об успешном создании заказа не появилось", isSuccessOrderMessageDisplayed, browserRule.getWebDriver().findElement(successOrder.getSuccessOrderMessage()).isDisplayed());
    }
}

