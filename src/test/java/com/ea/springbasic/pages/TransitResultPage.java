package com.ea.springbasic.pages;

import com.ea.springbasic.pages.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

import static com.ea.springbasic.common.Constants.CLIMATE_NEUTRAL;
import static com.ea.springbasic.common.Constants.DHL_FREIGHT_EURAPID;
import static com.ea.springbasic.common.Constants.DHL_FREIGHT_EUROCONNECT;
import static com.ea.springbasic.common.Constants.EPROOF_DELIVERY;
import static com.ea.springbasic.common.Constants.ONLINE_TRACKING;
import static com.ea.springbasic.common.Constants.PRE_10;
import static com.ea.springbasic.common.Constants.PRE_12;
import static com.ea.springbasic.common.Constants.SAME_DAY_PICKUP;

@Page
public class TransitResultPage extends BasePage {

    @FindBy(className = "c-calculator--ruler")
    private WebElement calculatorResultWindow;

    @FindBy(className = "h4")
    private WebElement pageTitle;

    @FindBy(className = "js--goto-previous-countryselector")
    private WebElement editPreviousWindow;

    @FindBy(linkText = "Customer Service")
    private WebElement customerServiceFirstLink;

    @FindBy(linkText = "customer Service")
    private WebElement customerServiceSecondLink;

    @FindBy(xpath = "//div[contains(@class, 'c-leadtime--product-box-top') and contains(.//span, '"+ DHL_FREIGHT_EURAPID +"')]/following-sibling::div[contains(.//p, '"+ ONLINE_TRACKING +"')]/descendant::p[2]")
    private WebElement dhlEurapidOnlineTracking;

    @FindBy(xpath = "//div[contains(@class, 'c-leadtime--product-box-top') and contains(.//span, '"+ DHL_FREIGHT_EURAPID +"')]/following-sibling::div[contains(.//p, '"+ EPROOF_DELIVERY +"')]/descendant::p[2]")
    private WebElement dhlEurapidProof;

    @FindBy(xpath = "//div[contains(@class, 'c-leadtime--product-box-top') and contains(.//span, '"+ DHL_FREIGHT_EURAPID +"')]/following-sibling::div[contains(.//p, '"+ CLIMATE_NEUTRAL +"')]/descendant::p[2]")
    private WebElement dhlEurapidClimate;

    @FindBy(xpath = "//div[contains(@class, 'c-leadtime--product-box-top') and contains(.//span, '"+ DHL_FREIGHT_EURAPID +"')]/following-sibling::div[contains(.//p, '"+ PRE_10 +"')]/descendant::p[2]")
    private WebElement dhlEurapidPre10;

    @FindBy(xpath = "//div[contains(@class, 'c-leadtime--product-box-top') and contains(.//span, '"+ DHL_FREIGHT_EURAPID +"')]/following-sibling::div[contains(.//p, '"+ PRE_12 +"')]/descendant::p[2]")
    private WebElement dhlEurapidPre12;

    @FindBy(xpath = "//div[contains(@class, 'c-leadtime--product-box-top') and contains(.//span, '"+ DHL_FREIGHT_EURAPID +"')]/following-sibling::div[contains(.//p, '"+ SAME_DAY_PICKUP +"')]/descendant::p[2]")
    private WebElement dhlEurapidSameDay;

    @FindBy(xpath = "//div[contains(@class, 'c-leadtime--product-box-top') and contains(.//span, '"+ DHL_FREIGHT_EUROCONNECT +"')]/following-sibling::div[contains(.//p, '"+ ONLINE_TRACKING +"')]/descendant::p[2]")
    private WebElement dhlEuroConnectOnlineTracking;

    @FindBy(xpath = "//div[contains(@class, 'c-leadtime--product-box-top') and contains(.//span, '"+ DHL_FREIGHT_EUROCONNECT +"')]/following-sibling::div[contains(.//p, '"+ EPROOF_DELIVERY +"')]/descendant::p[2]")
    private WebElement dhlEuroConnectProof;

    @FindBy(xpath = "//div[contains(@class, 'c-leadtime--product-box-top') and contains(.//span, '"+ DHL_FREIGHT_EUROCONNECT +"')]/following-sibling::div[contains(.//p, '"+ CLIMATE_NEUTRAL +"')]/descendant::p[2]")
    private WebElement dhlEuroConnectClimate;

    @FindBy(xpath = "//div[contains(@class, 'c-leadtime--product-box-top') and contains(.//span, '"+ DHL_FREIGHT_EUROCONNECT +"')]/following-sibling::div[contains(.//p, '"+ PRE_10 +"')]/descendant::p[2]")
    private WebElement dhlEuroConnectPre10;

    @FindBy(xpath = "//div[contains(@class, 'c-leadtime--product-box-top') and contains(.//span, '"+ DHL_FREIGHT_EUROCONNECT +"')]/following-sibling::div[contains(.//p, '"+ PRE_12 +"')]/descendant::p[2]")
    private WebElement dhlEuroConnectPre12;

    @FindBy(xpath = "//div[contains(@class, 'c-leadtime--product-box-top') and contains(.//span, '"+ DHL_FREIGHT_EUROCONNECT +"')]/following-sibling::div[contains(.//p, '"+ SAME_DAY_PICKUP +"')]/descendant::p[2]")
    private WebElement dhlEuroConnectSameDay;

    @FindBy(id = "leadtime-datepicker")
    private WebElement pickupDateInput;

    @FindBy(className = "js--leadtime-product-box-deliverydate")
    private List<WebElement> deliveryDate;

    public boolean isTitleDisplayed() {
        return pageTitle.isDisplayed();
    }

    public void clickEditPreviousWindow() {
        editPreviousWindow.click();
    }

    public HashMap<String, String> getEurapidAvailability() {
        HashMap<String, String> tableResults = new HashMap<>();
        tableResults.put(ONLINE_TRACKING, dhlEurapidOnlineTracking.getAttribute("title"));
        tableResults.put(EPROOF_DELIVERY, dhlEurapidProof.getAttribute("title"));
        tableResults.put(CLIMATE_NEUTRAL, dhlEurapidClimate.getAttribute("title"));
        tableResults.put(PRE_10, dhlEurapidPre10.getAttribute("title"));
        tableResults.put(PRE_12, dhlEurapidPre12.getAttribute("title"));
        tableResults.put(SAME_DAY_PICKUP, dhlEurapidSameDay.getAttribute("title"));
        return tableResults;
    }

    public HashMap<String, String> getEuroConnectAvailability() {
        HashMap<String, String> tableResults = new HashMap<>();
        tableResults.put(ONLINE_TRACKING, dhlEuroConnectOnlineTracking.getAttribute("title"));
        tableResults.put(EPROOF_DELIVERY, dhlEuroConnectProof.getText());
        tableResults.put(CLIMATE_NEUTRAL, dhlEuroConnectClimate.getAttribute("title"));
        tableResults.put(PRE_10, dhlEuroConnectPre10.getAttribute("title"));
        tableResults.put(PRE_12, dhlEuroConnectPre12.getAttribute("title"));
        tableResults.put(SAME_DAY_PICKUP, dhlEuroConnectSameDay.getAttribute("title"));
        return tableResults;
    }

    public String getEurapidValues(String key) {
        HashMap<String, String> tableResults = getEurapidAvailability();
        return tableResults.get(key);
    }

    public String getEuroConnectValues(String key) {
        HashMap<String, String> tableResults = getEuroConnectAvailability();
        return tableResults.get(key);
    }

    public boolean isCustomerServiceFirstLinkDisplayed() {
        return customerServiceFirstLink.isDisplayed();
    }

    public boolean isCustomerServiceSecondLinkDisplayed() {
        return customerServiceSecondLink.isDisplayed();
    }

    public void clickCustomerServiceFirstLink() {
        customerServiceFirstLink.click();
    }

    public void clickCustomerServiceSecondLink() {
        customerServiceSecondLink.click();
    }

    public void setPickupDate(String date) throws InterruptedException {
        scrollToElementCenter(pickupDateInput);
        pickupDateInput.clear();
        pickupDateInput.sendKeys(date);
        deliveryDate.get(0).click();
        Thread.sleep(10000);
    }

    public String getEurapidDeliveryDateText() {
        return deliveryDate.get(0).getText();
    }

    public String getEuroConnectDeliveryDateText() {
        return deliveryDate.get(1).getText();
    }

    @Override
    public boolean isDisplayed() {
        return fluentWait.until((d) -> calculatorResultWindow.isDisplayed());
    }
}
