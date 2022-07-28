package com.useinsider.web.matchers;

import org.hamcrest.Matcher;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.matchers.decorators.MatcherDecoratorsBuilder;

import java.io.IOException;

import static com.useinsider.web.utils.WebDriverManager.GetDriver.getDriver;
import static ru.yandex.qatools.htmlelements.matchers.MatcherDecorators.should;
import static ru.yandex.qatools.htmlelements.matchers.MatcherDecorators.timeoutHasExpired;

public class WaitingMatchers {

    public static <T> MatcherDecoratorsBuilder<? super T> waitFor(Matcher<T> matcher) {
        return should(matcher).whileWaitingUntil(timeoutHasExpired(5000));
    }

    public static <T> MatcherDecoratorsBuilder<Iterable<? super T>> waitCollectionFor(Matcher<Iterable<? super T>> matcher) {
        return should(matcher).whileWaitingUntil(timeoutHasExpired());
    }


    public static void waitClickable(WebElement element) throws IOException {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), 5, 1000)
                .withMessage("Element was not found").ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void waitNotClickable(WebElement element) throws IOException {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), 5, 1000)
                .withMessage("Element was not found").ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));
    }

    public static void waitInvisibility(WebElement element) throws IOException {
        new WebDriverWait(getDriver(), 5, 1000)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOf((element)));
    }

    public static void waitStalenessOf(WebElement element) throws IOException {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.stalenessOf(element));
    }

}
