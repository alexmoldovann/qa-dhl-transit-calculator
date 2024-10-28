package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class FooterPage extends BasePage {
    @FindBy(className = "c-voc-footer--branding")
    private WebElement footer;
   //TODO map all elements, not in scope now

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> footer.isDisplayed());
    }
}
