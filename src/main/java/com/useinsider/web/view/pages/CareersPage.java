package com.useinsider.web.view.pages;


import com.useinsider.web.view.blocks.careerPage.CookiesMessage;
import com.useinsider.web.view.blocks.careerPage.LifeBlock;
import com.useinsider.web.view.blocks.careerPage.LocationsBlock;
import com.useinsider.web.view.blocks.careerPage.TeamsBlock;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.io.IOException;

import static com.useinsider.web.utils.WebDriverManager.GetDriver.getDriver;

@Name("Insider HomePage")
public class CareersPage {
    public TeamsBlock teamsBlock;
    public LocationsBlock locationsBlock;
    public LifeBlock lifeBlock;
    public CookiesMessage cookiesMessage;


    public CareersPage() throws IOException {
        HtmlElementLoader.populate(this, getDriver());
    }

    public static CareersPage careersPage() throws IOException {
        return new CareersPage();
    }
}
