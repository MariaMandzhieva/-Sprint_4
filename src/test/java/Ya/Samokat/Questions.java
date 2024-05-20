package Ya.Samokat;

import POM.MainPage;
import Rules.BrowserRule;
import Steps.Steps;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Questions {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    private final String arrow; // поле вопроса со стрелкой
    private final String actualAnswer; // поле раскрывщегося ответа
    private final String expectedAnswer; // текст ожидаемого ответа

    public Questions(String arrow, String actualAnswer, String expectedAnswer){
        this.arrow=arrow;
        this.actualAnswer=actualAnswer;
        this.expectedAnswer=expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object [] [] getRelevantText(){
        return new Object[][] {
                { ".//div[@id='accordion__heading-0']", ".//div[@aria-labelledby='accordion__heading-0']", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                { ".//div[@id='accordion__heading-1']", ".//div[@aria-labelledby='accordion__heading-1']", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                { ".//div[@id='accordion__heading-2']", ".//div[@aria-labelledby='accordion__heading-2']", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30." },
                { ".//div[@id='accordion__heading-3']", ".//div[@aria-labelledby='accordion__heading-3']", "Только начиная с завтрашнего дня. Но скоро станем расторопнее." },
                { ".//div[@id='accordion__heading-4']", ".//div[@aria-labelledby='accordion__heading-4']", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010." },
                { ".//div[@id='accordion__heading-5']", ".//div[@aria-labelledby='accordion__heading-5']", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится." },
                { ".//div[@id='accordion__heading-6']", ".//div[@aria-labelledby='accordion__heading-6']", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои." },
                { ".//div[@id='accordion__heading-7']", ".//div[@aria-labelledby='accordion__heading-7']", "Да, обязательно. Всем самокатов! И Москве, и Московской области." }
        };
    }

    @Test
    public void RelevantAnswerIfClickQuestion(){
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        Steps steps = new Steps(browserRule.getWebDriver());

        steps.open(MainPage.URL);

        // прокрутка страницы до заголовка раздела "Вопросы о важном"
        WebElement element = browserRule.getWebDriver().findElement(mainPage.getHeaderQuestions());
        ((JavascriptExecutor) browserRule.getWebDriver()).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(browserRule.getWebDriver(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(mainPage.getHeaderQuestions()));

        steps.click(By.xpath(arrow));

        // проверка, что при нажатии на стрелочку, полученный текст ответа соответствует ожидаемому
        String textActualAnswer = browserRule.getWebDriver().findElement(By.xpath(actualAnswer)).getText();
        assertEquals("Когда нажимаешь на стрелочку, не открывается соответствующий текст", expectedAnswer, textActualAnswer);
    }
}

