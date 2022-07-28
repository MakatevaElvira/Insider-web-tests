package com.useinsider.web.view.blocks.careerPage;

import com.useinsider.web.view.blocks.openPositionPage.LocationLink;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Filter by Location block")
@FindBy(xpath = "//label[contains(text(),'Filter by Location')]/..")
public class FilterByLocation extends HtmlElement {
    public LocationLink locationLink;

    @Name("Location filter")
    @FindBy(xpath = ".//span[@class='selection']")
    public WebElement filter;


    @Step("Open Location filter")
    public void openFilter() {
        filter.isDisplayed();
        filter.click();
    }

    @Step("Select Location By Name")
    public void selectLocationByName(String location) {
        locationLink.chooseLocationByName(location).click();
    }

    @Step("Set Location filter")
    public void setLocation(String location) {
        openFilter();
        selectLocationByName(location);
    }
}
