import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class TestEnterprise {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "FireFox";
    }
    @Test
    public void successfulListEnterprise(){
        // Открыть главную страницу github.com
        open("https://github.com/");
        // Выбрать меню Solutions с помощью команды hover
        $("div.header-menu-wrapper").$(byText("Solutions")).hover();
        // Выбрать Enterprise и кликнуть
        $(withTagAndText("a", "Enterprise")).click();
        // Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best"
        $("div.application-main").shouldHave(Condition.text("Build like the best"));
    }
}