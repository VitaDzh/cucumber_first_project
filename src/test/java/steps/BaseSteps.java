package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.Driver;

public class BaseSteps {

    WebDriver driver;

    @Before
    public void setup(){
        driver = Driver.getDriver();
    }

    @Given("user is on {string}")
    public void userNavigatesTo(String url) {
        driver.get(url);
    }

    @Then("user should be navigated to {string}")
    public void user_should_be_navigated_to(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }



}



