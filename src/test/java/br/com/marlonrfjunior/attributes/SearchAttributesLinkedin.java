package br.com.marlonrfjunior.attributes;

import br.com.marlonrfjunior.utils.DSL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchAttributesLinkedin extends DSL {

    @FindBy(xpath = "//input[@aria-label=\"Nome\"]")
    protected WebElement  labelName;

    @FindBy(xpath = "//input[@aria-label=\"Sobrenome\"]")
    protected WebElement  labelLastName;

    @FindBy(xpath = "//section[@data-searchbar-type=\"PEOPLE\"]//button[@aria-label='Pesquisar']")
    protected WebElement  btnSearchPerfil;

//    @FindBy(xpath = )
    protected WebElement  cardPefil( String title, String name){
        return findElementByXpath("//h4[contains(text(),\""+title+"\")]/../h3[contains(text(),\""+ name +"\")]/../../../a");
    }




}
