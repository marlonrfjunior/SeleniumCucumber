package br.com.marlonrfjunior.sampleApp.page;

import br.com.marlonrfjunior.sampleApp.attributes.*;


public class HomePageSampleapp extends HomeAttributesSampleapp {


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
    public void checkNecessaryData(String bar) {
        System.out.println(getText(correctForms(bar)) + "Dados necessários a ser preenchidos");
    }
}
