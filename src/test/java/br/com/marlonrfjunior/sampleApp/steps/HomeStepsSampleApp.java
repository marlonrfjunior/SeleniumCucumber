package br.com.marlonrfjunior.sampleApp.steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;

import br.com.marlonrfjunior.sampleApp.page.*;

public class HomeStepsSampleApp  {

    @E("estou na aba {string}")
    public void checkBar(String bar) {
        new HomePageSampleapp().navigateBar(bar);
    }

    @Então("valido que o email foi enviado")
    public void checkEmail() {
       new HomePageSampleapp().checkEmail();
    }


}


