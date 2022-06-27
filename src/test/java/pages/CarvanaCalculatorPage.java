package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class CarvanaCalculatorPage {

    public CarvanaCalculatorPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "vehiclePrice")
    public WebElement vehiclePriceInput;

    @FindBy(name = "downPayment")
    public WebElement downPaymentInput;

    @FindBy(name = "creditScoreIndex")
    public WebElement scoreIndexDropDown;

    @FindBy(name = "loanTerm")
    public WebElement loanTermDropDown;

    @FindBy(css = ".loan-calculator-display-value")
    public WebElement monthlyPayment;


}
