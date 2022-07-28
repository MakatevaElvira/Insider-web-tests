package com.useinsider.web.view.blocks.careerPage;


import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Career  page - Life Block")
@FindBy(xpath = "//h2[contains(text(),'Life at Insider')]/../../..")
public class LifeBlock extends HtmlElement {
}
