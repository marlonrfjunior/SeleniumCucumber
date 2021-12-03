package br.com.marlonrfjunior.page;

import br.com.marlonrfjunior.attributes.ResumeAttributesLinkedin;
import br.com.marlonrfjunior.attributes.SearchAttributesLinkedin;
import br.com.marlonrfjunior.utils.DSL;
import org.openqa.selenium.support.PageFactory;

public class ResumePageLinkedin extends ResumeAttributesLinkedin {
    public ResumePageLinkedin() {
        PageFactory.initElements(DSL.getDriver() , this);
    }

    public void verification(){
        fixedWait(3);
        checkElement(labelAbout);
        checkElement(labelExperience);
        checkElement(labelAcademicEducation);
        checkElement(labelLanguages);
        checkElement(labelRecomendation);
    }


}
