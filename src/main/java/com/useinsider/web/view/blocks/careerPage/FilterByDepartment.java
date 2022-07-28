package com.useinsider.web.view.blocks.careerPage;


import com.useinsider.web.view.blocks.openPositionPage.DepartmentLink;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Filter by Department block")
@FindBy(xpath = "//label[contains(text(),'Filter by Department')]/..")
public class FilterByDepartment extends HtmlElement {
    public DepartmentLink departmentLink;

    @Name("Location filter")
    @FindBy(xpath = ".//span[@class='selection']")
    public WebElement filter;


    @Step("Open Location filter")
    public void openFilter() {
        filter.isDisplayed();
        filter.click();
    }

    @Step("Select Location By Name")
    public void selectDepartmentByName(String department) {
        departmentLink.chooseDepartmentByName(department).click();
    }

    @Step("Set department filter")
    public void setDepartment(String location) {
        openFilter();
        selectDepartmentByName(location);
    }
}
