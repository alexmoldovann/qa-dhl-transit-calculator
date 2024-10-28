package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class TransitCalculatorPage extends BasePage {

    @FindBy(className = "c-calculator--tabcontent")
    private WebElement calculatorWindow;
    // this element has overlay with display none or block, needs test
    // opacity 1 or 0.3
    @FindBy(id = "title-e44d356bbf")
    private WebElement pageTitle;
    @FindBy(id = "text-e431ec040c")
    private WebElement firstText;
    @FindBy(id = "origin-country")
    private WebElement originCountry;
    @FindBy(id = "origin-postcode")
    private WebElement originCode;
    @FindBy(id = "destination-country")
    private WebElement destinationCountry;
    @FindBy(id = "destination-postcode")
    private WebElement destinationCode;
    @FindBy(className = "js--freightcalc--input-submit")
    private WebElement calculateButton;

    @FindBy(className = "is-loading")
    private WebElement calculateButtonLoading;
    @FindBy(className = "js--origin-zip-error")
    private WebElement originError;
    @FindBy(className = "js--destination-zip-error")
    private WebElement destinationError;

    public boolean isTitleDisplayed() {
        return pageTitle.isDisplayed();
    }

    public String getTitleDisplayed() {
        return pageTitle.getText();
    }

    public void calculateTransitTime(String source, String sourcePostcode, String destination, String destinationPostcode) throws InterruptedException {
        originCountry.sendKeys(source);
        originCode.sendKeys(sourcePostcode);
        destinationCountry.sendKeys(destination);
        destinationCode.sendKeys(destinationPostcode);
        scrollToElementCenter(calculateButton);
        calculateButton.click();
        Thread.sleep(5000);
    }

    public String getOriginError() {
        return originError.getText();
    }

    public String getDestinationError() {
        return destinationError.getText();
    }

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> calculatorWindow.isDisplayed());
    }
}
