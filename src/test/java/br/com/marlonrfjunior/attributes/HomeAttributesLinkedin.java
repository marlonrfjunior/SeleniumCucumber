package br.com.marlonrfjunior.attributes;

import br.com.marlonrfjunior.utils.DSL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomeAttributesLinkedin extends DSL {

    @FindBy(xpath = "//a[contains(text(),'Encontre pessoas conhecidas')]")
    protected WebElement btnSearchPeople;


}
