package com.ea.springbasic.steps;

import com.ea.springbasic.pages.TransitCalculatorPage;
import com.ea.springbasic.pages.TransitResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.ea.springbasic.util.DateUtils.addWorkingDays;

public class CalculatorSteps {

    @Autowired
    private TransitCalculatorPage transitCalculatorPage;
    @Autowired
    private TransitResultPage transitResultPage;

    String datePlus7Days = LocalDate.now().with(addWorkingDays(7)).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    String datePlus12Days = LocalDate.now().with(addWorkingDays(12)).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    String datePlus11Days = LocalDate.now().with(addWorkingDays(11)).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    @Then("I check the if result page is displayed")
    public void iCheckTheResult() {
        Assert.assertTrue(transitResultPage.isDisplayed(), "Result page is not displayed");
    }

    @Then("^I check that Europid (.*) has value (.*)$")
    public void iCheckThatEuropidHasValue(String serviceName, String value) {
            Assert.assertEquals(transitResultPage.getEurapidValues(serviceName), value, "Service availability is not the same");
    }

    @Then("^I check that EuroConnect (.*) has value (.*)$")
    public void iCheckThatEuroConnectHasValue(String serviceName, String value) {
            Assert.assertEquals(transitResultPage.getEuroConnectValues(serviceName), value, "Service availability is not the same");

    }

    @When("^I fill the calculator info with (.*) and (.*) and (.*) and (.*)$")
    public void iFillTheCalculatorInfo(String source, String sourcePostcode, String destination, String destinationPostcode) throws InterruptedException {
        if (sourcePostcode.equals("whitespace") && destinationPostcode.equals("whitespace")) {
            transitCalculatorPage.calculateTransitTime(source, " ", destination, " ");
        }
        else {
            transitCalculatorPage.calculateTransitTime(source, sourcePostcode, destination, destinationPostcode);
        }
    }

    @When("I set delivery date to today plus 7 working days")
    public void iSetDeliveryDateTo() throws InterruptedException {
        transitResultPage.setPickupDate(datePlus7Days);
    }

    @When("^I check that (.*) delivery is over 12 working days$")
    public void iCheckDates(String deliveryType) {
        switch (deliveryType) {
            case "Eurapid":
                Assert.assertEquals(transitResultPage.getEurapidDeliveryDateText(), datePlus12Days, "Delivery date is not the same as expected date");
                break;
            case "EuroConnect":
                Assert.assertEquals(transitResultPage.getEuroConnectDeliveryDateText(), datePlus12Days + " (or next business day)", "Delivery date is not the same as expected date");
                break;
        }
    }

    @When("^I check that (.*) delivery is over 11 working days$")
    public void iCheckDates11Days(String deliveryType) {
        switch (deliveryType) {
            case "Eurapid":
                Assert.assertEquals(transitResultPage.getEurapidDeliveryDateText(), datePlus11Days, "Delivery date is not the same as expected date");
                break;
            case "EuroConnect":
                Assert.assertEquals(transitResultPage.getEuroConnectDeliveryDateText(), datePlus11Days + " (or next business day)", "Delivery date is not the same as expected date");
                break;
        }
    }

    @Then("Error message is displayed in both source and destination")
    public void errorMessageIsDisplayedInBothSourceAndDestination() {
        Assert.assertEquals(transitCalculatorPage.getOriginError(), "Correct postal code (e.g. no post box)*", "Source error message is not displayed");
        Assert.assertEquals(transitCalculatorPage.getDestinationError(), "Correct postal code (e.g. no post box)*", "Destination error message is not displayed");
    }

    @Given("page has loaded")
    public void pageHasLoaded() {
        //loaded in before
    }
}