package br.com.marlonrfjunior.sampleApp.steps;

import io.cucumber.java.pt.E;

import br.com.marlonrfjunior.sampleApp.page.*;

public class HomeStepsSampleApp {
    @E("estou na aba {string}")
    public void estouAqua(String bar) {
        new HomePageSampleapp().navigateBar(bar);
    }
}
