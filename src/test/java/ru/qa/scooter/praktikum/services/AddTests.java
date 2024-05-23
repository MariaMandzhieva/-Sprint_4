package ru.qa.scooter.praktikum.services;

import ru.qa.scooter.praktikum.services.pom.MainPage;
import ru.qa.scooter.praktikum.services.rules.BrowserRule;
import ru.qa.scooter.praktikum.services.steps.Steps;
import org.junit.Rule;
import org.junit.Test;

import static ru.qa.scooter.praktikum.services.utils.Utils.randomString;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class AddTests {
    private static final String NOT_EXISTING_ORDER_NUMBER = randomString();

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void MainPageIfClickLogoSamokat() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        Steps steps = new Steps(browserRule.getWebDriver());

        steps.open(MainPage.URL)
                .click(mainPage.getTopOrderButton())
                .click(mainPage.getLogoSamokat());

        String url = browserRule.getWebDriver().getCurrentUrl();

        assertEquals("https://qa-scooter.praktikum-services.ru/", url);
    }

    @Test
    public void notFoundIfOrderNotExists() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        Steps steps = new Steps(browserRule.getWebDriver());

        steps.open(MainPage.URL)
                .click(mainPage.getCheckOrderButton())
                .input(mainPage.getOrderNumberInput(), NOT_EXISTING_ORDER_NUMBER)
                .click(mainPage.getGoButton());

        assertTrue("Сообщение об ошибке не показывается",
                mainPage.getNotFound().checkMessageExist());
    }
}

