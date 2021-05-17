package br.com.marlonrfjunior.sampleApp.page;

import br.com.marlonrfjunior.sampleApp.attributes.ProductDataAttributesSampleapp;
import br.com.marlonrfjunior.sampleApp.attributes.VehicleDataAttributesSampleapp;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static br.com.marlonrfjunior.sampleApp.utils.Utils.getPropertyRestsettings;

public class ProductDataPageSampleapp extends ProductDataAttributesSampleapp {

    public ProductDataPageSampleapp() {
        PageFactory.initElements(getDriver() , this);
    }

    /**
     * Preenchendo dados do formulário de dados de produtos
     */
    public void fillFormProductData() {
        startDate(getPropertyRestsettings("sampleapp.dataform.startDate"));
        select(comboInsuranceSum , getPropertyRestsettings("sampleapp.dataform.insuranceSum"));
        select(comboMeritRating , getPropertyRestsettings("sampleapp.dataform.meritRating"));
        select(comboDamageInsurance , getPropertyRestsettings("sampleapp.dataform.damageInsurance"));
        click(selectProducts(getPropertyRestsettings("sampleapp.dataform.products")));
        select(comboCourtesyCar, getPropertyRestsettings("sampleapp.dataform.courtesyCar"));
    }

    /**
     * Seleciona a data de fabricação através do calendario de acordo com a data especificada
     *
     * @param date
     */
    private void startDate(String date) {
        moveToElement(btncalendar);
        click(btncalendar);
        String[] Date = date.split("/");
        verifyDate(Integer.valueOf(Date[1]) , Integer.valueOf(Date[2]));
        click(selectDay(Date[0]));

    }

    /**
     * Verifica a data e caso sja necessario irá alterar
     *
     * @param expectedyear
     * @param expectedmonth
     */
    private void verifyDate(int expectedmonth , int expectedyear) {
        int actualyear = Integer.valueOf(getText(actualYear));

        while (actualyear != expectedyear) {
            if (actualyear > expectedyear) {
                click(btnPreviousMonth);
            } else {
                click(btnNextMonth);
            }
            actualyear = Integer.valueOf(getText(actualYear));
        }

        int actualmonth = intMonth(getText(actualMonth));
        while (actualmonth != expectedmonth) {
            if (actualmonth > expectedmonth) {
                click(btnPreviousMonth);
            } else {
                click(btnNextMonth);
            }
            actualmonth = intMonth(getText(actualMonth));
        }
    }

    /** Convert o mes escrito para int
     * @param monthName
     * @return
     */
    private int intMonth(String monthName) {
        Date date = null;
        try {
            date = new SimpleDateFormat("MMMM" , Locale.US).parse(monthName);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.get(Calendar.MONTH);
        return cal.get(Calendar.MONTH) + 1;
    }


}
