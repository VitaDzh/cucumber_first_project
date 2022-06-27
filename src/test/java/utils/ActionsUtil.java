package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtil {

    private static Actions actions; // more safe

    static{
        actions = new Actions(Driver.getDriver()); // this save our time, we do not need to call driver in each method anymore
    }


    public static void rightClick(WebElement element){
        actions.contextClick(element).perform();
    }

    public static void moveToElement(WebElement element){
        actions.moveToElement(element).perform();
    }
}