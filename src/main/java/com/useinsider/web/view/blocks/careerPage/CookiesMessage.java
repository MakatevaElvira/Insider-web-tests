package com.useinsider.web.view.blocks.careerPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Cookies Message")
@FindBy(xpath = "//div[@class='cli-wrapper']")
public class CookiesMessage extends HtmlElement {

    @Name("Accept all button")
    @FindBy(xpath = ".//a[contains(text(),'Accept All')]")
    public WebElement acceptAllButton;


    @Step("Accept cookies")
    public void acceptAll() {
        if (acceptAllButton.isDisplayed()) {
            acceptAllButton.click();
        }
    }
}
