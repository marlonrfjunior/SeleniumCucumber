package br.com.marlonrfjunior.sampleApp.page;

import br.com.marlonrfjunior.sampleApp.attributes.PriceOptionAttributesSampleapp;
import br.com.marlonrfjunior.sampleApp.attributes.SendQuoteAttributesSampleapp;
import org.openqa.selenium.support.PageFactory;

import static br.com.marlonrfjunior.sampleApp.utils.Utils.getPropertyRestsettings;

public class SendQuotePageSampleapp extends SendQuoteAttributesSampleapp {

    public SendQuotePageSampleapp() {
        PageFactory.initElements(getDriver() , this);
    }

    /**
     *  Preenche o formulario de dados para envio da cotacao
     */
    public void fillFormQuote() {
        setText(fieldEmail,getPropertyRestsettings("sampleapp.dataform.email"));
        setText(fieldPhone,getPropertyRestsettings("sampleapp.dataform.phone"));
        setText(fieldUsername,getPropertyRestsettings("sampleapp.dataform.username"));
        setText(fieldPassword,getPropertyRestsettings("sampleapp.dataform.password"));
        setText(fieldConfirmPassword,getPropertyRestsettings("sampleapp.dataform.confirmPassword"));
        setText(textAreaComments,getPropertyRestsettings("sampleapp.dataform.comments"));
    }

    /**
     * Enviar email
     */
    public void seendingEmail(){
        click(btnSend);
    }

}
