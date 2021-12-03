package br.com.marlonrfjunior.page;

import br.com.marlonrfjunior.attributes.SearchAttributesLinkedin;
import br.com.marlonrfjunior.utils.DSL;
import br.com.marlonrfjunior.utils.Utils;
import org.openqa.selenium.support.PageFactory;

public class SearchPageLinkedin extends SearchAttributesLinkedin {
    public SearchPageLinkedin() {
        PageFactory.initElements(DSL.getDriver() , this);
    }


    public void searchPerfil(String name, String lastName) {
        fixedWait(3);
        setText(labelName, name);
        setText(labelLastName, lastName);
        click(btnSearchPerfil);
    }

    public  void selectPerfil(String title, String name){
        fixedWait(3);
        click(cardPefil(title,name));
    }
}
