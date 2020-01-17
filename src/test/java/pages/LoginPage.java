package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class LoginPage {

    public LoginPage open() {
        Selenide.open("/login");
        return this;
    }

    public LoginPage with(String email, String senha) {
        $("#login_email").setValue(email);
        $("#login_password").setValue(senha);
        $("button[id*=btnLogin]").click();
        return this;
    }

    public SelenideElement alert() {
        return $(".alert-login");
    }

    public LoginPage clearSession() {
        executeJavaScript("localStorage.clear();");
        Selenide.open("/login");
        return this;
    }

}
