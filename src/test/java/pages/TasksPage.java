package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TasksPage {

    public SelenideElement welcome() {
        return $(".panel-body h3");
    }
}
