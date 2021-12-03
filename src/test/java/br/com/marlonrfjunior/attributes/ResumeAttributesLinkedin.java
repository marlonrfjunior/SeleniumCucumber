package br.com.marlonrfjunior.attributes;

import br.com.marlonrfjunior.utils.DSL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ResumeAttributesLinkedin extends DSL {

    @FindBy(xpath = "//h2[contains(text(),\"Sobre\")]")
    protected WebElement  labelAbout;

    @FindBy(xpath = "//h2[contains(text(),\"Experiência\")]")
    protected WebElement  labelExperience;

    @FindBy(xpath = "//h2[contains(text(),\"Formação acadêmica\")]")
    protected WebElement  labelAcademicEducation;

    @FindBy(xpath = "//h2[contains(text(),\"Idiomas\")]")
    protected WebElement  labelLanguages;

    @FindBy(xpath = "//h2[contains(text(),\"Recomendações recebidas\")]")
    protected WebElement  labelRecomendation;


}
