package br.com.marlonrfjunior.steps;

import br.com.marlonrfjunior.page.ResumePageLinkedin;
import br.com.marlonrfjunior.page.SearchPageLinkedin;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class ResumeStepsLinkedin {

    @Então("verifico o curriculo")
    public void resumeValidation() {
        new ResumePageLinkedin().verification();
    }
}
