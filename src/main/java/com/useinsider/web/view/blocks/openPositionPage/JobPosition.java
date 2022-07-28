package com.useinsider.web.view.blocks.openPositionPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Name("Jobs result position")
@FindBy(xpath = ".//div[@class='position-list-item-wrapper bg-light']")
public class JobPosition extends HtmlElement {
    @Name("List of positions")
    public List<JobPosition> jobPositionList;

    @Name("location of positions")
    @FindBy(xpath = ".//p")
    public WebElement location;

    @Name("department of positions")
    @FindBy(xpath = ".//span")
    public WebElement department;

    @Name("Apply Now button")
    @FindBy(xpath = ".//a")
    public WebElement applyNowButton;

    @Step("Apply now")
    public void applyNow() {
        applyNowButton.isDisplayed();
        applyNowButton.click();
    }


    @Step("Find Location By Name")
    public JobPosition findPositionByLocation(String location) {
        return jobPositionList.stream().filter(param -> param.getAttribute("data-location")
                .contains(location))
                .findAny().orElseThrow(() ->
                        new RuntimeException(String
                                .format("Parametr with %s not found", location)));
    }

    @Step("check Found Positions By : Location")
    public void checkFoundPositionsByLocation(String location) {
        List<JobPosition> elements = jobPositionList;
        int numberListElements = elements.size();
        for (int i = 0; i < numberListElements; i++) {
            List<JobPosition> positionElements = jobPositionList;
            String positionLocation = positionElements.get(i).location.getText();
            assertThat(positionLocation, equalTo(location));
        }
    }

    @Step("check Found Positions By : Location")
    public void checkFoundPositionsByDepartment(String department) {
        List<JobPosition> elements = jobPositionList;
        int numberListElements = elements.size();
        for (int i = 0; i < numberListElements; i++) {
            List<JobPosition> positionElements = jobPositionList;
            String positionDepartment = positionElements.get(i).department.getText();
            assertThat(positionDepartment, equalTo(department));
        }
    }

    @Step("check Apply Now button in Positions")
    public void checkApplyNowButtonInPositions(String applyNowButtonName) {
        List<JobPosition> elements = jobPositionList;
        int numberListElements = elements.size();
        for (int i = 0; i < numberListElements; i++) {
            List<JobPosition> positionElements = jobPositionList;
            String applyNowButton = positionElements.get(i).applyNowButton.getText();
            assertThat(applyNowButton, equalTo(applyNowButtonName));
        }
    }

}
