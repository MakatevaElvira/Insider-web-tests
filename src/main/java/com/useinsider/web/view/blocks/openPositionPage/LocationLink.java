package com.useinsider.web.view.blocks.openPositionPage;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@Name("Location link")
@FindBy(xpath = "//span[@class='select2-results']//li")
public class LocationLink extends HtmlElement {
    @Name("List of location link")
    public List<LocationLink> locationLinkList;

    @Step("Find Location By Name")
    public LocationLink chooseLocationByName(String location) {
        return locationLinkList.stream().filter(param -> param.getText()
                .contains(location))
                .findAny().orElseThrow(() ->
                        new RuntimeException(String
                                .format("Parametr with %s not found", location)));
    }
}
