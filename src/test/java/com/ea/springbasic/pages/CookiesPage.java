package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class CookiesPage extends BasePage {
    @FindBy(id = "onetrust-banner-sdk")
    private WebElement cookiesBar;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookiesAcceptButton;
   //TODO map all elements, not in scope now

    public void clickAcceptButton() throws InterruptedException {
        isDisplayed();
        Thread.sleep(2000);
        cookiesAcceptButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> cookiesBar.isDisplayed());
    }
}
