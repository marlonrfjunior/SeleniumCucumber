package br.com.marlonrfjunior.sampleApp.page;

import br.com.marlonrfjunior.sampleApp.attributes.PriceOptionAttributesSampleapp;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static br.com.marlonrfjunior.sampleApp.utils.Utils.getPropertyRestsettings;

public class PriceOptionPageSampleapp extends PriceOptionAttributesSampleapp {

    public PriceOptionPageSampleapp() {
        PageFactory.initElements(getDriver() , this);
    }

    /**
     *  Selecionando o plano
     */
    public void selectPlan() {
        click(planChoice(getPropertyRestsettings("sampleapp.dataform.planType")));
    }



}
