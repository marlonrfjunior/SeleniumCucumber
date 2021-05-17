package br.com.marlonrfjunior.sampleApp.attributes;

import br.com.marlonrfjunior.sampleApp.utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PriceOptionAttributesSampleapp extends BasePage {


    protected WebElement planChoice(String plan){
        return findElementByXpath("//input[contains(@id,'select"+plan+"')]/..//span");
    }


}
