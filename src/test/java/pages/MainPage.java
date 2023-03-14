package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private Alert currentAlert;

    public MainPage(String url) {
        Selenide.open(url);
    }

    public void triggerAlert() {
        $$(".code-example .toolbar__button_run").get(0).click();
        switchToPopUp();
    }

    public void triggerConfirm() {
        $$(".code-example .toolbar__button_run").get(4).click();
        switchToPopUp();
    }

    public void triggerPrompt() {
        $$(".code-example .toolbar__button_run").get(1).click();
        switchToPopUp();
    }

    public void switchToPopUp() {
        currentAlert = switchTo().alert();
    }

    public String getPopUpText() {
        return currentAlert == null ? "" : currentAlert.getText();
    }

    public void acceptPopUp() {
        if (currentAlert != null)
            currentAlert.accept();
    }

    public void sendTextToPrompt(String text) {
        if (currentAlert != null)
            currentAlert.sendKeys(text);
    }

    public void cancelPopUp() {
        if (currentAlert != null)
            currentAlert.dismiss();
    }
}
