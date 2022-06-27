package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.Waiter;

import java.util.List;

public class CarvanaHomePage {
    public CarvanaHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

   // @FindBy(css = "div[data-qa='header-items']>a")   - shows size of array 2, but locating 3 webEl
   // public List<WebElement> menuItems;

    @FindBy(css = "a[data-cv-test='headerCarFinderLink']")
    public WebElement carFinderMenuItem;

    @FindBy(css = "a[data-cv-test='headerTradesLink']")
    public WebElement sellTradeMenuItem;

    @FindBy(css = "div[data-qa='styled-dropdown']")
    public List<WebElement> dropdownMenuItems;

    @FindBy(css = "div[data-cv-test='headerFinanceDropdown']>a")
    public WebElement financingMenuItem;

    @FindBy(css = ".ewpFSy>a")
    public List<WebElement> autoLoanCalculatorOption;


/*
    public void clickOnMenuItems(String linkText) {
        for (WebElement link : menuItems) {
            if (link.getText().equals(linkText)) {
                link.click();
                break;
            }
        }
    }

 */




}
