package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaHelpMeSearchPage {

    public CarvanaHelpMeSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(tagName = "h1")
    public WebElement whatCarShouldIGetText;

    @FindBy(tagName = "h3")
    public WebElement answerAQuickQuestionText;

    @FindBy(css = ".leftSide>a")
    public WebElement tryCarFinderLink;

    @FindBy(css = "div[data-qa='headline']")
    public WebElement mostImportantInNextCarText;

    @FindBy(css = "div[data-qa='sub-heading']")
    public WebElement selectUpTo4Text;
}
