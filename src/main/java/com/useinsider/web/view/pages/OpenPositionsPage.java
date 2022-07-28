package com.useinsider.web.view.pages;

import com.useinsider.web.view.blocks.careerPage.FilterByDepartment;
import com.useinsider.web.view.blocks.careerPage.FilterByLocation;
import com.useinsider.web.view.blocks.openPositionPage.JobPosition;
import com.useinsider.web.view.blocks.openPositionPage.JobsList;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.io.IOException;

import static com.useinsider.web.utils.WebDriverManager.GetDriver.getDriver;

@Name("Careers/OpenPositions Page")
public class OpenPositionsPage {
    public FilterByLocation filterByLocation;
    public FilterByDepartment filterByDepartment;
    public JobsList jobsList;
    public JobPosition jobPosition;


    public OpenPositionsPage() throws IOException {
        HtmlElementLoader.populate(this, getDriver());
    } //

    public static OpenPositionsPage openPositionsPage() throws IOException {
        return new OpenPositionsPage();


    }
}
