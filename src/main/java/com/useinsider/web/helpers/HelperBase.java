package com.useinsider.web.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import static com.useinsider.web.utils.WebDriverManager.GetDriver.getDriver;


public class HelperBase {

    public static void scrollTo(WebElement element) throws InterruptedException, IOException {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
    }

    public static void scrollFor(WebElement element) {
        ((Locatable) element).getCoordinates().inViewPort();
    }

    public static void scrollBy(WebElement element) throws IOException {
        Actions action = new Actions(getDriver());
        action.moveToElement(element).build().perform();
    }
    public static String getRedirectUrl() throws IOException {
        ArrayList<String> winHandles = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(winHandles.get(1));
        return getDriver().getCurrentUrl().toString();
    }
}
