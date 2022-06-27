package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.CarvanaCalculatorPage;
import pages.CarvanaHelpMeSearchPage;
import pages.CarvanaHomePage;
import pages.CarvanaSellMyCar;
import utils.ActionsUtil;
import utils.Driver;
import utils.DropdownHandler;
import utils.Waiter;

public class CarvanaSteps {

    WebDriver driver;
    CarvanaHomePage carvanaHomePage;
    CarvanaHelpMeSearchPage carvanaHelpMeSearchPage;
    CarvanaSellMyCar carvanaSellMyCar;
    CarvanaCalculatorPage carvanaCalculatorPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        carvanaHomePage = new CarvanaHomePage();
        carvanaHelpMeSearchPage = new CarvanaHelpMeSearchPage();
        carvanaSellMyCar = new CarvanaSellMyCar();
        carvanaCalculatorPage = new CarvanaCalculatorPage();
    }


    @When("user clicks on {string} menu item")
    public void user_clicks_on_menu_item(String menuItem) {
        switch(menuItem){
            case "CAR FINDER":
                Waiter.waitForVisiabilityWebElement(driver, carvanaHomePage.carFinderMenuItem, 6);
                Assert.assertTrue(carvanaHomePage.carFinderMenuItem.isDisplayed());
                carvanaHomePage.carFinderMenuItem.click();
                break;
            case "SELL/TRADE":
                Waiter.pause(3);
                Assert.assertTrue(carvanaHomePage.sellTradeMenuItem.isDisplayed());
                carvanaHomePage.sellTradeMenuItem.click();
                break;
            case "AUTO LOAN CALCULATOR":
                carvanaHomePage.autoLoanCalculatorOption.get(2).click();
                break;
            default:
                throw new NotFoundException("The text is not defined properly in the feature file!!!");
        }

    }


    @Then("user should see {string} text")
    public void user_should_see_text(String text) {
        Waiter.pause(6);
        switch(text){
            case "WHAT CAR SHOULD I GET?":
                Assert.assertTrue(carvanaHelpMeSearchPage.whatCarShouldIGetText.isDisplayed());
                Assert.assertEquals(text, carvanaHelpMeSearchPage.whatCarShouldIGetText.getText());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertTrue(carvanaHelpMeSearchPage.answerAQuickQuestionText.isDisplayed());
                Assert.assertEquals(text, carvanaHelpMeSearchPage.answerAQuickQuestionText.getText());
                    break;
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertTrue(carvanaHelpMeSearchPage.mostImportantInNextCarText.isDisplayed());
                Assert.assertEquals(text, carvanaHelpMeSearchPage.mostImportantInNextCarText.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertTrue(carvanaHelpMeSearchPage.selectUpTo4Text.isDisplayed());
                Assert.assertEquals(text, carvanaHelpMeSearchPage.selectUpTo4Text.getText());
                break;
            case "GET A REAL OFFER IN 2 MINUTES":
                Assert.assertTrue(carvanaSellMyCar.headers.get(1).isDisplayed());
                Assert.assertEquals(text, carvanaSellMyCar.headers.get(1).getText());
                break;
            case "We pick up your car. You get paid on the spot.":
                Assert.assertTrue(carvanaSellMyCar.headers.get(2).isDisplayed());
                Assert.assertEquals(text, carvanaSellMyCar.headers.get(2).getText());
                break;
            case "We couldn’t find that VIN. Please check your entry and try again.":
                Assert.assertTrue(carvanaSellMyCar.weCouldNotFindItText.isDisplayed());
                Assert.assertEquals(text, carvanaSellMyCar.weCouldNotFindItText.getText());
                break;
            default:
                throw new NotFoundException("The text is not defined properly in the feature file!!!");
        }
    }

    @Then("user should see {string} link")
    public void user_should_see_link(String linkText) {
        Assert.assertTrue(carvanaHelpMeSearchPage.tryCarFinderLink.isDisplayed());
        Assert.assertEquals(linkText, carvanaHelpMeSearchPage.tryCarFinderLink.getText());
    }

    @When("user clicks on {string} link")
    public void user_clicks_on_link(String link) {
        carvanaHelpMeSearchPage.tryCarFinderLink.click();
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String buttonText) {
        switch(buttonText){
            case "VIN":
                carvanaSellMyCar.vinButton.click();
                break;
            case "GET MY OFFER":
                carvanaSellMyCar.getMyOfferButton.click();
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file!!!");
        }
    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String key) {
        carvanaSellMyCar.vinNumInput.sendKeys(key);
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String itemText) {
        Waiter.pause(5);
        switch(itemText){
            case "FINANCING":
                ActionsUtil.moveToElement(carvanaHomePage.financingMenuItem);
               // carvanaHomePage.financingDropDown.get(2).click();
                break;
            default:
                throw new NotFoundException("The item text is not defined properly in the feature file!!!");
        }
    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String inputBoxText, String key) {
        Waiter.pause(3);
        switch(inputBoxText){
            case "Cost of Car I want":
                carvanaCalculatorPage.vehiclePriceInput.click();
                carvanaCalculatorPage.vehiclePriceInput.sendKeys(key);
                break;
            case "What is Your Down Payment?":
                carvanaCalculatorPage.downPaymentInput.click();
                carvanaCalculatorPage.downPaymentInput.sendKeys(key);
                break;
            default:
                throw new NotFoundException("The required input text is not defined properly in the feature file!!!");


        }
    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String inputBoxText, String visibleText) {
        switch(inputBoxText){
            case "What’s Your credit Score?":
                carvanaCalculatorPage.scoreIndexDropDown.click();
                DropdownHandler.selectOptionByVisibleText(carvanaCalculatorPage.scoreIndexDropDown, visibleText);
                break;
            case "Choose Your Loan Terms":
                carvanaCalculatorPage.loanTermDropDown.click();
                DropdownHandler.selectOptionByVisibleText(carvanaCalculatorPage.loanTermDropDown, visibleText);
                break;
            default:
                throw new NotFoundException("The visible text is not defined properly in the feature file!!!");



        }
    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String text) {
        carvanaCalculatorPage.monthlyPayment.isDisplayed();
        Assert.assertEquals(text, carvanaCalculatorPage.monthlyPayment.getText());

    }

}
