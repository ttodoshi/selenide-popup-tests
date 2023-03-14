package tests;

import pages.MainPage;
import org.junit.Assert;
import org.junit.Test;

public class AlertTest extends BaseTest {
    String URL = "https://javascript.info/alert-prompt-confirm";
    String EXPECTED_TEXT = "Hello";

    @Test
    public void textEqualsTest() throws InterruptedException {
        MainPage mainPage = new MainPage(URL);
        mainPage.triggerAlert();
        String alertText = mainPage.getPopUpText();
        Assert.assertEquals("Сообщения не сходятся", EXPECTED_TEXT, alertText);
//        Thread.sleep(300L);
        mainPage.acceptPopUp();
    }
}
