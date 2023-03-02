import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DZ_3 {
    @Test
    void firstTest(){
        // Открыть сайт https://demoqa.com/automation-practice-form
        open("https://demoqa.com/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        //Найти поле ввода Имя и ввести Vladimir
        $("[id=firstName]").setValue("Vladimir");
        //Найти поле ввода Фамилия и ввести Testov
        $("[id=lastName]").setValue("Testov");
        //Найти поле ввода Почта и ввести test@test.ru
        $("[id=userEmail]").setValue("test@test.ru");
        //Найти поле ввода Гендер и выбрать Male и выбрать его клавишей пробел
        $("#gender-radio-1").sendKeys(" ");
        //Найти поле ввода Телефон и ввести 89998887766
        $("[id=userNumber]").setValue("8999888776");
        //Найти поле ввода Дата рождения и кликнуть на него
        $("[id=dateOfBirthInput]").click();
        //Найти поле ввода Месяц и выбрать Январь
        $(".react-datepicker__month-dropdown-container").$(byText("January")).click();
        //Найти поле ввода Год и выбрать 1987
        $(".react-datepicker__year-dropdown-container").$(byText("1987")).click();
        //Найти элемент День и выбрать 6
        $(".react-datepicker__month-container").$(byText("6")).click();
        //Найти поле ввода Субьект и ввести Commerce
        $("#subjectsInput").setValue("Commerce").pressEnter();
        //Найти чекбокс Хобби-1 и выбрать его клавишей пробел
        $("#hobbies-checkbox-1").sendKeys(" ");
        //Найти чекбокс Хобби-2 и выбрать его клавишей пробел
        $("#hobbies-checkbox-2").sendKeys(" ");
        //Найти чекбокс Хобби-3 и выбрать его клавишей пробел
        $("#hobbies-checkbox-3").sendKeys(" ");
        //Найти поле ввода Адрес и ввести Тестовый адрес
        $("[id=currentAddress]").setValue("Testing Address");
        //Найти выпадающее меню Штат и кликнуть по нему
        $("#state").click();
        //Найти штат Uttar Pradesh и крикнуть по нему
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        //Найти выпадающее меню Город и кликнуть по нему
        $("[id=city]").click();
        //Найти город Agra и крикнуть по нему
        $("#stateCity-wrapper").$(byText("Agra")).click();
        //Найти кнопку submit и кликнуть по ней
        $("#submit").click();

        //Проверки
        $(".modal-open").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Vladimir Testov"));
        $(".modal-body").shouldHave(text("test@test.ru"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("8999888776"));
        $(".modal-body").shouldHave(text("6 January,1987"));
        $(".modal-body").shouldHave(text("Commerce"));
        $(".modal-body").shouldHave(text("Sports, Reading, Music"));
        $(".modal-body").shouldHave(text("Testing Address"));
        $(".modal-body").shouldHave(text("Uttar Pradesh Agra"));
        $("#closeLargeModal").click();
    }
}
