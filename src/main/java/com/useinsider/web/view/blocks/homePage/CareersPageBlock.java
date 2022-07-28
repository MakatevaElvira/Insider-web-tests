package com.useinsider.web.view.blocks.homePage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Careers page block")
@FindBy(xpath = ".//a[@href='https://useinsider.com/careers/']")
public class CareersPageBlock extends HtmlElement {

    @Name("Careers page block title")
    @FindBy(xpath = ".//h5[.='Careers']")
    public WebElement title;

    @Name("Careers page block body")
    @FindBy(xpath = ".//p")
    public WebElement text;

    @Step("Open Careers Page")
    public void openCareersPage() {
        title.isDisplayed();
        title.click();
    }
}
