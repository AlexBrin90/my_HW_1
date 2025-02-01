import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    @Test
    void succesfullLoginTest() {
        Configuration.holdBrowserOpen = true; // Браузер не закрывается после прохождения теста
        Configuration.browser = "edge"; // Выбор браузера, который будет открываться
        Configuration.browserSize = "1920x1080"; // Размер окна браузера

        open("https://school.qa.guru/cms/system/login"); // Открыть страницу авторизации
        $("[name=email]").setValue("hasala90@yandex.ru"); // Ввод в поле емейл
        $("[name=password]").setValue("18111990"); // Ввод в поле пароль
        $(".btn-success").click(); // Кликаем по кнопке Вход
        $(".logined-form").shouldHave(text("Алексеев"));
    }
}