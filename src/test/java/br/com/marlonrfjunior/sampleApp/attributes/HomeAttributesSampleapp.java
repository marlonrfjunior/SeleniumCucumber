package br.com.marlonrfjunior.sampleApp.attributes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.marlonrfjunior.sampleApp.utils.BasePage;

public class HomeAttributesSampleapp extends BasePage {

    protected WebElement menuBar(String bar) {
        return findElementByXpath("//a[contains(text(),'" + bar + "')]");
    }

    protected WebElement correctForms(String bar) {
        return findElementByXpath("//a[contains(text(),'" + bar + "')]/..//span");
    }

}
