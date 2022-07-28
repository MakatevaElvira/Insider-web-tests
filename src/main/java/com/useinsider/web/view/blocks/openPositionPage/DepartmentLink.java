package com.useinsider.web.view.blocks.openPositionPage;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@Name("Department Link")
@FindBy(xpath = "//ul[@class='select2-results__options']//li")
public class DepartmentLink extends HtmlElement {
    @Name("List of location link")
    public List<DepartmentLink> departmentLinkList;

    @Step("Найти должника по ФИО")
    public DepartmentLink chooseDepartmentByName(String department) {
        return departmentLinkList.stream().filter(param -> param.getText()
                .contains(department))
                .findAny().orElseThrow(() ->
                        new RuntimeException(String
                                .format("Parametr with %s not found", department)));
    }
}
