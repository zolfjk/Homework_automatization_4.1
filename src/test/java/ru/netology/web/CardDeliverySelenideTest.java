package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliverySelenideTest {
    @Test
    void selenideTest() {

        Configuration.holdBrowserOpen = true;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        Date myNewDate = DateUtils.addDays(date, 3);


        open("http://localhost:9999");
        $("[data-test-id='city'] input").val("Нижний Новгород");
        $("[data-test-id='date'] input").doubleClick();
        $("[data-test-id='date'] input").sendKeys(Keys.DELETE);
        $("[data-test-id='date'] input").setValue(sdf.format(myNewDate));
        $("[data-test-id='name'] input").val("Михаил Римский-Корсаков");
        $("[data-test-id='phone'] input").val("+79999999999");
        $("[data-test-id='agreement'] span[role]").click();
        $("[class='button button_view_extra button_size_m button_theme_alfa-on-white']").click();
        $(" [data-test-id='notification']").should(Condition.visible, Duration.ofSeconds(15));


    }
}
