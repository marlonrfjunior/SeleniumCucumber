package br.com.marlonrfjunior.sampleApp.page;

import br.com.marlonrfjunior.sampleApp.attributes.*;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static br.com.marlonrfjunior.sampleApp.utils.Utils.getPropertyRestsettings;
import static jdk.nashorn.internal.objects.Global.println;

public class VehicleDataPageSampleapp extends VehicleDataAttributesSampleapp {

    public VehicleDataPageSampleapp() {
        PageFactory.initElements(getDriver() , this);
    }

    /**
     * Preenchendo dados do formuçário de dados veicular
     */
    public void fillFormVehicleData() {
        select(comboMake , getPropertyRestsettings("sampleapp.dataform.make"));
        select(comboModel , getPropertyRestsettings("sampleapp.dataform.model"));
        setText(fieldCylinderCapacity , getPropertyRestsettings("sampleapp.dataform.cylinderCapacity"));
        setText(fieldEnginePerformance , getPropertyRestsettings("sampleapp.dataform.engine"));
        selectManufactureDate(getPropertyRestsettings("sampleapp.dataform.date"));
        select(comboNumberOfSeats , getPropertyRestsettings("sampleapp.dataform.seats"));
        click(selectRightHandDriven(getPropertyRestsettings("sampleapp.dataform.rightHandDriven")));
        select(comboNumberofSeatsMotorcycle , getPropertyRestsettings("sampleapp.dataform.numberofSeatsMotorcycle"));
        select(comboFuel , getPropertyRestsettings("sampleapp.dataform.fuelType"));
        setText(fielPayLoad , getPropertyRestsettings("sampleapp.dataform.payLoad"));
        setText(fieldTotalWeight , getPropertyRestsettings("sampleapp.dataform.totalWeight"));
        setText(fieldListprice , getPropertyRestsettings("sampleapp.dataform.price"));
        setText(fieldLicensePlateNumber , getPropertyRestsettings("sampleapp.dataform.plate"));
        setText(fieldAnnualMileage , getPropertyRestsettings("sampleapp.dataform.annualMileage"));
    }

    /**
     * Seleciona a data de fabricação através do calendariode acordo com a data especificada
     *
     * @param date
     */
    private void selectManufactureDate(String date) {
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
