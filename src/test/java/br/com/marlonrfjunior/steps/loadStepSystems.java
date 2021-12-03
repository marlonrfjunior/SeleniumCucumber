package br.com.marlonrfjunior.steps;

import io.cucumber.java.pt.Dado;

import static br.com.marlonrfjunior.utils.DriverManager.*;

public class loadStepSystems {

    @Dado("que acessei o linkedin no browser {string}")
    public void loadAplication(String browser) {
        openBrowser(browser);
        navigateSystem("linkedin");
    }
}
