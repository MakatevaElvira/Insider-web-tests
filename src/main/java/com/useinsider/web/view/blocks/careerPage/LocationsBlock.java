package com.useinsider.web.view.blocks.careerPage;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Career  page - Locations Block")
@FindBy(xpath = "//h3[contains(text(),'Our Locations')]/../..")
public class LocationsBlock extends HtmlElement {
}
