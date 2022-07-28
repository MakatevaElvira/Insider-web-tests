package com.useinsider.web.view.blocks.careerPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.io.IOException;

import static com.useinsider.web.helpers.HelperBase.scrollFor;
import static com.useinsider.web.matchers.WaitingMatchers.waitClickable;


@Name("Career  page - Teams Block")
@FindBy(xpath = "//h3[contains(text(),'Find your calling')]/../..")
public class TeamsBlock extends HtmlElement {
    public QualityAssurancePageBlock qualityAssurancePageBlock;

    @Name("seeAllTeams Button")
    @FindBy(xpath = ".//a[contains(text(),'See all teams')]")
    public WebElement seeAllTeamsButton;

    @Step("Open seeAllTeams Page")
    public void openSeeAllTeams() throws IOException {
        scrollFor(seeAllTeamsButton);
        seeAllTeamsButton.isDisplayed();
        waitClickable(seeAllTeamsButton);
        seeAllTeamsButton.click();
    }


}
