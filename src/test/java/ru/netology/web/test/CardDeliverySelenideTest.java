package ru.netology.web.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.web.data.LocalDateService;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class CardDeliverySelenideTest {
    @Test
    void selenideTest() {

        Configuration.holdBrowserOpen = true;

        LocalDateService localDate = new LocalDateService();
        String planningDate = localDate.generateDate(4);


        open("http://localhost:9999");
        $("[data-test-id='city'] input").val("Нижний Новгород");
        $("[data-test-id='date'] input").doubleClick();
        $("[data-test-id='date'] input").sendKeys(Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").val("Михаил Римский-Корсаков");
        $("[data-test-id='phone'] input").val("+79999999999");
        $("[data-test-id='agreement'] span[role]").click();
        $x(".//*[text()='Забронировать']/parent::span/parent::button").click();
        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);


    }
}
