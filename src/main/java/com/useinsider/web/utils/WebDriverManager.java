package com.useinsider.web.utils;

import io.qameta.allure.Step;
import okhttp3.HttpUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.useinsider.web.utils.WebDriverManager.GetDriver.getDriver;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class WebDriverManager {
    public static class GetDriver {

        private static WebDriver wd;
        private static final String BROWSER = CHROME; //set here CHROME or FIREFOX

        public static WebDriver getDriver() throws IOException {
            if (wd == null) {
                if (BROWSER.equals(FIREFOX)) {
                    wd = new FirefoxDriver();
                } else if (BROWSER.equals(CHROME)) {
                    wd = new ChromeDriver();
                }
                wd.manage().window().maximize();
                wd.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);
            }
            return wd;
        }

    }

    @Step("Открыть {urlBuilder}")
    public static void openPage(HttpUrl.Builder urlBuilder) throws IOException {
        getDriver().get(urlBuilder.toString());
    }
}
