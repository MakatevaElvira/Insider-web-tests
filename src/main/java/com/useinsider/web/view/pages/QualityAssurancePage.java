package com.useinsider.web.view.pages;

import com.useinsider.web.view.blocks.qualityAssurancePege.QualityAssuranceInfoBlock;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.io.IOException;

import static com.useinsider.web.utils.WebDriverManager.GetDriver.getDriver;

@Name("Insider QualityAssurance careers Page")
public class QualityAssurancePage {
    public QualityAssuranceInfoBlock qualityAssuranceInfoBlock;


    public QualityAssurancePage() throws IOException {
        HtmlElementLoader.populate(this, getDriver());
    } //

    public static QualityAssurancePage qualityAssurancePage() throws IOException {
        return new QualityAssurancePage();
    }
}
