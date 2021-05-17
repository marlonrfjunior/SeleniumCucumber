package br.com.marlonrfjunior.sampleApp.steps;

import io.cucumber.java.pt.Dado;

import static br.com.marlonrfjunior.sampleApp.utils.Hooks.*;

public class loadStepsSampleApp {

    @Dado("que acessei o Sample App no browser {string}")
    public void loadAplication(String browser) {
        openBrowser(browser);
        navigateSystem("sampleapp");
    }
}
