package tests;

import pages.MainPage;
import org.junit.Assert;
import org.junit.Test;

public class ConfirmTest extends BaseTest{
    String URL = "https://javascript.info/alert-prompt-confirm";
    String EXPECTED_TEXT = "Are you the boss?";

    @Test
    public void acceptTest() throws InterruptedException {
        MainPage mainPage = new MainPage(URL);
        mainPage.triggerConfirm();
        Assert.assertEquals("Сообщения не сходятся", EXPECTED_TEXT, mainPage.getPopUpText());
//        Thread.sleep(300L);
        mainPage.acceptPopUp();
        mainPage.switchToPopUp();
        final String expectedAnswer = "true";
        Assert.assertEquals("Сообщения не сходятся", expectedAnswer, mainPage.getPopUpText());
//        Thread.sleep(300L);
        mainPage.acceptPopUp();
    }

    @Test
    public void canselTest() throws InterruptedException {
        MainPage mainPage = new MainPage(URL);
        mainPage.triggerConfirm();
        Assert.assertEquals("Сообщения не сходятся", EXPECTED_TEXT, mainPage.getPopUpText());
//        Thread.sleep(300L);
        mainPage.cancelPopUp();
        mainPage.switchToPopUp();
        final String expectedAnswer = "false";
        Assert.assertEquals("Сообщения не сходятся", expectedAnswer, mainPage.getPopUpText());
//        Thread.sleep(300L);
        mainPage.acceptPopUp();
    }
}
