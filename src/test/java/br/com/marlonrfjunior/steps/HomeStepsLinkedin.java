package br.com.marlonrfjunior.steps;

import br.com.marlonrfjunior.page.HomePageLinkedin;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;


public class HomeStepsLinkedin {

    @E("me direciono a página de procurar pessoas conhecidas")
    public void searchPeople() {
        new HomePageLinkedin().searchPeople();
    }


}


