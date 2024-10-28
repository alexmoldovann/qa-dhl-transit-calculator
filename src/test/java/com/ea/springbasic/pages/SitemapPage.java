package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class SitemapPage extends BasePage {

    @FindBy(className = "c-voc-footer--sitemap l-grid component-wide")
    private WebElement siteMap;
   //TODO map all elements, not in scope now

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> siteMap.isDisplayed());
    }

}
