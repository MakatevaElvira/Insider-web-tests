package com.useinsider.web.view.blocks.careerPage;


import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static com.useinsider.web.helpers.HelperBase.scrollFor;

@Name("Career  page - QualityAssurance page Block")
@FindBy(xpath = ".//a[@href='https://useinsider.com/careers/quality-assurance/']/../..")
public class QualityAssurancePageBlock extends HtmlElement {

    @Name("Open QualityAssurance Page block title")
    @FindBy(xpath = ".//h3[contains(text(),'Quality Assurance')]")
    public WebElement title;

    @Name("Careers page block body")
    @FindBy(xpath = ".//p")
    public WebElement text;

    @Step("Open QualityAssurance Page")
    public void openQualityAssurancePage() {
        scrollFor(title);
        title.isDisplayed();
        title.click();
    }
}
