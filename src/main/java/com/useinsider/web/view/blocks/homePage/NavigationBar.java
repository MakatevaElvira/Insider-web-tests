package com.useinsider.web.view.blocks.homePage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Navigation Bar")
@FindBy(xpath = "//div[@class='collapse navbar-collapse']")
public class NavigationBar extends HtmlElement {
    public MoreMenu moreMenu;
    public CareersPageBlock careersBlock;

    @Step("Open More menu")
    public void openMoreMenu() {
        moreMenu.isDisplayed();
        moreMenu.click();
    }
}
