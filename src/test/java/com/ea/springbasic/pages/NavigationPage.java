package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class NavigationPage extends BasePage {

    @FindBy(className = "c-navigation--bar c-navigation--bar--secondary")
    private WebElement navigationBar;
   //TODO map all elements, not in scope now

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> navigationBar.isDisplayed());
    }
}
