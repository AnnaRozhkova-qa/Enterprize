import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest1 {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dragAndDrop() {
        Configuration.fastSetValue = true;
        open("/drag_and_drop");
        $("#column-a").shouldHave(exactText("A"));
        $("#column-b").dragAndDrop(to("#column-a"));

        //$("#column-b").hover();
        //actions().clickAndHold().moveByOffset(-200, 0).release().perform();
        $("#column-a").shouldHave(exactText("B"));
    }
}
