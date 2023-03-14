package tests;

import pages.MainPage;
import org.junit.Assert;
import org.junit.Test;

public class PromptTest extends BaseTest{
    String URL = "https://javascript.info/alert-prompt-confirm";
    String INPUT_TEXT = "18";
    String EXPECTED_TEXT = "How old are you?";

    @Test
    public void sendTextTest() throws InterruptedException {
        MainPage mainPage = new MainPage(URL);
        mainPage.triggerPrompt();
        Assert.assertEquals("Сообщения не сходятся", EXPECTED_TEXT, mainPage.getPopUpText());
        mainPage.sendTextToPrompt(INPUT_TEXT);
//        Thread.sleep(500L);
        mainPage.acceptPopUp();
        mainPage.switchToPopUp();
        final String expectedAnswer = String.format("You are %s years old!", INPUT_TEXT);
        Assert.assertEquals("Сообщения не сходятся", expectedAnswer, mainPage.getPopUpText());
//        Thread.sleep(500L);
        mainPage.acceptPopUp();
    }

    @Test
    public void canselTest() throws InterruptedException {
        MainPage mainPage = new MainPage(URL);
        mainPage.triggerPrompt();
        Assert.assertEquals("Сообщения не сходятся", EXPECTED_TEXT, mainPage.getPopUpText());
//        Thread.sleep(500L);
        mainPage.cancelPopUp();
        mainPage.switchToPopUp();
        final String expectedAnswer = "You are null years old!";
        Assert.assertEquals("Сообщения не сходятся", expectedAnswer, mainPage.getPopUpText());
//        Thread.sleep(500L);
        mainPage.acceptPopUp();
    }
}
