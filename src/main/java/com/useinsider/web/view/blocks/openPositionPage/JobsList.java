package com.useinsider.web.view.blocks.openPositionPage;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Jobs result List")
@FindBy(xpath = "//div[@id='jobs-list']")
public class JobsList extends HtmlElement {
    public JobPosition jobPosition;
}
