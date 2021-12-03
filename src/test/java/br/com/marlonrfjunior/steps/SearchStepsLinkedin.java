package br.com.marlonrfjunior.steps;

import br.com.marlonrfjunior.page.SearchPageLinkedin;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;

public class SearchStepsLinkedin {

    @Quando("pesquiso o perfil da pessoa com nome {string} e sobrenome {string}")
    public void searchPerfil(String name, String lastName) {
        new SearchPageLinkedin().searchPerfil(name, lastName);
    }

    @E("seleciono o com o titulo {string} e nome {string}")
    public void selectPerfil(String title, String name) {
        new SearchPageLinkedin().selectPerfil(title, name);
    }
}
