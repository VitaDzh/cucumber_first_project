package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class CarvanaSellMyCar {

    public CarvanaSellMyCar(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".jwFVns>div") // loop starts from 1
    public List<WebElement> headers;

    @FindBy(css = "button[data-cv-test='VINToggle']")
    public WebElement vinButton;

    @FindBy(css = ".FormInput-oo6j68-5")
    public WebElement vinNumInput;

    @FindBy(css = "button[data-cv-test='heroGetMyOfferButton']") //heroGetMyOfferButton
    public WebElement getMyOfferButton;

    @FindBy(css = ".sc-fTFLOO")
    public WebElement weCouldNotFindItText;


}
