package com.useinsider.web.view.pages;

import com.useinsider.web.view.blocks.homePage.MoreMenu;
import com.useinsider.web.view.blocks.homePage.NavigationBar;
import javafx.scene.control.Pagination;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.io.IOException;

import static com.useinsider.web.utils.WebDriverManager.GetDriver.getDriver;


@Name("Insider HomePage")
public class HomePage {
    public NavigationBar navigationBar;
    public Pagination pagination;
    public MoreMenu moreMenu;


    public HomePage() throws IOException {
        HtmlElementLoader.populate(this, getDriver());
    } //

    public static HomePage homePage() throws IOException {
        return new HomePage();
    }

}
