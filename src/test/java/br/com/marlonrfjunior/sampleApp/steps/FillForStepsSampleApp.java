package br.com.marlonrfjunior.sampleApp.steps;

import io.cucumber.java.es.E;
import io.cucumber.java.pt.Quando;

import br.com.marlonrfjunior.sampleApp.page.*;
import org.junit.Assert;

public class FillForStepsSampleApp {

    @E("preencho o formulario {string} com os dados do propreties e avanco para a proxima etapa")
    public void fillForm(String form) {
        switch (form.toLowerCase()) {
            case "vehicle data":
                new VehicleDataPageSampleapp().fillFormVehicleData();
                new HomePageSampleapp().avancedForNextForm("enterinsurantdata");
                break;
            case "insurant data":
                new InsurantDataPageSampleapp().fillFormInsuratData();
                new HomePageSampleapp().avancedForNextForm("enterproductdata");
                break;
            case "product data":
                new ProductDataPageSampleapp().fillFormProductData();
                new HomePageSampleapp().avancedForNextForm("selectpriceoption");
                break;
            case "price option":
                new PriceOptionPageSampleapp().selectPlan();
                new HomePageSampleapp().avancedForNextForm("sendquote");
                break;
            default:
                Assert.fail("Formulario invalido.");
                break;
        }

    }


    @Quando("preencho o fomrulario Send Quote e envio a cotacao")
    public void fillFormSendQuote() {
        new SendQuotePageSampleapp().fillFormQuote();
        new SendQuotePageSampleapp().seendingEmail();
    }
}
