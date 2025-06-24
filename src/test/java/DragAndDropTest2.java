import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest2 {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dragAndDropTest() {
        Configuration.fastSetValue = true;
        open("/drag_and_drop");


        SelenideElement first = $("#column-a");
        SelenideElement second = $("#column-b");
        $(first).shouldHave(text("A"));
        $(second).shouldHave(text("B"));
        actions().clickAndHold(first).moveToElement(second).release().perform();
        $(first).shouldHave(exactText("B"));
        $(second).shouldHave(text("A"));
    }
}


