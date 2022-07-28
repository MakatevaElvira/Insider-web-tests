package com.useinsider.web.tests;

import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.useinsider.web.config.UseinsiderFrontendUrlFactory.baseUrl;
import static com.useinsider.web.config.UseinsiderFrontendUrlFactory.careersUrl;
import static com.useinsider.web.config.UseinsiderFrontendUrlFactory.openQaPositionsUrl;
import static com.useinsider.web.helpers.HelperBase.getRedirectUrl;
import static com.useinsider.web.matchers.WaitingMatchers.waitFor;
import static com.useinsider.web.utils.WebDriverManager.openPage;
import static com.useinsider.web.view.pages.CareersPage.careersPage;
import static com.useinsider.web.view.pages.HomePage.homePage;
import static com.useinsider.web.view.pages.OpenPositionsPage.openPositionsPage;
import static com.useinsider.web.view.pages.QualityAssurancePage.qualityAssurancePage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class InsiderWebPagesTests extends TestBase {

    @Story("Home page checks")
    @Test(description = "check Insider home page is opened")
    @TmsLink("")
    public void testHomePageSuccessOpen() throws IOException {
        openPage(baseUrl());
        assertThat(homePage().navigationBar, waitFor(isDisplayed()));
    }

    @Story("Careers page checks")
    @Test(description = "check Careers page elements are displaying")
    @TmsLink("")
    public void testCareersPageElementsDisplaying() throws IOException {
        openPage(baseUrl());
        homePage().navigationBar.openMoreMenu();
        assertThat(homePage().navigationBar.careersBlock, waitFor(isDisplayed()));
        homePage().navigationBar.careersBlock.openCareersPage();
        assertThat(careersPage().teamsBlock, waitFor(isDisplayed()));
        assertThat(careersPage().locationsBlock, waitFor(isDisplayed()));
        assertThat(careersPage().lifeBlock, waitFor(isDisplayed()));
    }

    @Story("Careers page checks")
    @Test(description = "check Careers page QA jobs")
    @TmsLink("")
    public void testCareersPageQAJobsChecking() throws InterruptedException, IOException {
        openPage(careersUrl());
        careersPage().cookiesMessage.acceptAll();
        careersPage().teamsBlock.openSeeAllTeams();
        assertThat(careersPage().teamsBlock.qualityAssurancePageBlock, waitFor(isDisplayed()));
        careersPage().teamsBlock.qualityAssurancePageBlock.openQualityAssurancePage();
        assertThat(qualityAssurancePage().qualityAssuranceInfoBlock.title, waitFor(isDisplayed()));
        qualityAssurancePage().qualityAssuranceInfoBlock.openSeeAllQaJobs();
        assertThat(openPositionsPage().filterByLocation, waitFor(isDisplayed()));
        openPositionsPage().filterByLocation.setLocation("Istanbul, Turkey");
        openPositionsPage().filterByDepartment.setDepartment("Quality Assurance");
        assertThat(openPositionsPage().jobsList, waitFor(isDisplayed()));
    }

    @Story("Careers QA open positions")
    @Test(description = "check Careers page QA jobs")
    @TmsLink("")
    public void testCareersPageQAOpenPositionChecking() throws IOException {
        openPage(openQaPositionsUrl());
        careersPage().cookiesMessage.acceptAll();
        assertThat(openPositionsPage().filterByLocation, waitFor(isDisplayed()));
        openPositionsPage().filterByLocation.setLocation("Istanbul, Turkey");
        openPositionsPage().filterByDepartment.setDepartment("Quality Assurance");
        assertThat(openPositionsPage().jobsList, waitFor(isDisplayed()));
        openPositionsPage().jobsList.jobPosition.checkFoundPositionsByLocation("Istanbul, Turkey");
        openPositionsPage().jobsList.jobPosition.checkFoundPositionsByDepartment("Quality Assurance");
        openPositionsPage().jobsList.jobPosition.checkApplyNowButtonInPositions("Apply Now");

    }
    @Story("Careers QA open positions")
    @Test(description = "Apply Position QA")
    @TmsLink("")
    public void testApplyPositionChecking() throws IOException {
        openPage(openQaPositionsUrl());
        careersPage().cookiesMessage.acceptAll();
        assertThat(openPositionsPage().filterByLocation, waitFor(isDisplayed()));
        openPositionsPage().filterByLocation.setLocation("Istanbul, Turkey");
        assertThat(openPositionsPage().jobsList, waitFor(isDisplayed()));
        openPositionsPage().jobsList.jobPosition.applyNow();
        System.out.println("URL= "+ getRedirectUrl());
        assertThat(getRedirectUrl(),
                containsString("https://jobs.lever.co/useinsider/"));
    }
}