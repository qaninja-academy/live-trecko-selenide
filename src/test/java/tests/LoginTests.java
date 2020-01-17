package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TasksPage;

import static com.codeborne.selenide.Condition.text;

public class LoginTests {

    private LoginPage login;
    private TasksPage tasks;

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://treckoapp.herokuapp.com";
        Configuration.timeout = 10000;

        login = new LoginPage();
        tasks = new TasksPage();
    }

    @AfterMethod
    public void cleanup() {
        login.clearSession();
    }

    @Test
    public void deveAutenticarOUsurario() {
        login.open().with("eu@papito.io", "pwd123");

        tasks.welcome().shouldHave(text("Hello, Papito"));
    }

    @Test
    public void deveExibirSenhaIncorreta() {
        login.open().with("eu@papito.io", "abc123");

        login.alert().shouldHave(text("Incorrect password"));
    }

    @Test
    public void deveExibirEmailIncorreto() {
        login.open().with("eu&papito.io", "abc123");

        login.alert().shouldHave(text("Email is required"));
    }

    @Test
    public void deveExibirEmailRequerido() {
        login.open().with("", "abc123");

        login.alert().shouldHave(text("Email is required"));
    }

    @Test
    public void deveExibirSenhaRequerida() {
        login.open().with("eu@papito.io", "");

        login.alert().shouldHave(text("Password is required"));
    }
}
