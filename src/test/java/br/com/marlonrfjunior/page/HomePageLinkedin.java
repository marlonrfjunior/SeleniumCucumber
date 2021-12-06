package br.com.marlonrfjunior.page;

import br.com.marlonrfjunior.attributes.HomeAttributesLinkedin;
import br.com.marlonrfjunior.utils.DSL;
import br.com.marlonrfjunior.utils.Utils;
import org.openqa.selenium.support.PageFactory;

public class HomePageLinkedin extends HomeAttributesLinkedin {
    public HomePageLinkedin() {
        PageFactory.initElements(DSL.getDriver(), this);
    }

    public void searchPeople() {
        click(btnSearchPeople);
    }

}
