package com.useinsider.web.view.blocks.qualityAssurancePege;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static com.useinsider.web.helpers.HelperBase.scrollFor;

@Name("QualityAssurance careers Page info block")
@FindBy(xpath = "//a[@href='https://useinsider.com/careers/open-positions/?department=qualityassurance']/../..")
public class QualityAssuranceInfoBlock extends HtmlElement {

    @Name("See all QA jobs button")
    @FindBy(xpath = ".//a[contains(text(),'See all QA jobs')]")
    public WebElement seeAllQaJobsButton;

    @Name("Quality Assurance title")
    @FindBy(xpath = ".//h1")
    public WebElement title;

    @Step("Open all QA jobs")
    public void openSeeAllQaJobs() {
        scrollFor(seeAllQaJobsButton);
        seeAllQaJobsButton.isDisplayed();
        seeAllQaJobsButton.click();
    }
}
