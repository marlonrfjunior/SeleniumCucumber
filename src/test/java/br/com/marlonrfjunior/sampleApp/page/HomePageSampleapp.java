package br.com.marlonrfjunior.sampleApp.page;

import br.com.marlonrfjunior.sampleApp.attributes.*;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;


public class HomePageSampleapp extends HomeAttributesSampleapp {

    public HomePageSampleapp() {
        PageFactory.initElements(getDriver() , this);
    }

    /**
     * Navegando pelo Aba de acordo com o parâmetr0
     *
     * @param bar
     */
    public void navigateBar(String bar) {
        click(menuBar(bar));
        System.out.println("Aba " + bar + " selecionada.");
    }

    /**
     * Checar quantidade de DAdos necessários
     *
     * @param bar
     */
    public void checkNavigateBar(String bar) {
        System.out.println(getText(correctForms(bar)) + "Dados necessários a ser preenchidos");
    }

    /**
     * Avança para o próximo formulario
     */
    public void avancedForNextForm(String nextPage){
        click(btnNext(nextPage));
    }

    /**
     * Checando email enviado com sucesso
     */
    public void checkEmail() {
        implicitWait(resultSendingEmail,10);
        Assert.assertEquals("Sending e-mail success!",getText(resultSendingEmail));
    }
}
