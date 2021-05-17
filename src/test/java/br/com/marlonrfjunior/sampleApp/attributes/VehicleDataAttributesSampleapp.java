package br.com.marlonrfjunior.sampleApp.attributes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.marlonrfjunior.sampleApp.utils.BasePage;
import org.openqa.selenium.support.ui.Select;


public class VehicleDataAttributesSampleapp extends BasePage {

    @FindBy(id = "make")
    protected WebElement comboMake;

    @FindBy(id = "model")
    protected WebElement comboModel;

    @FindBy(id = "numberofseats")
    protected WebElement comboNumberOfSeats;

    @FindBy(id = "fuel")
    protected WebElement comboFuel;

    @FindBy(id = "numberofseatsmotorcycle")
    protected WebElement comboNumberofSeatsMotorcycle;

    @FindBy(id = "engineperformance")
    protected WebElement fieldEnginePerformance;

    @FindBy(id = "cylindercapacity")
    protected WebElement fieldCylinderCapacity;

    @FindBy(id = "listprice")
    protected WebElement fieldListprice;

    @FindBy(id = "licenseplatenumber")
    protected WebElement fieldLicensePlateNumber;

    @FindBy(id = "annualmileage")
    protected WebElement fieldAnnualMileage;

    @FindBy(id = "payload")
    protected WebElement fielPayLoad;

    @FindBy(id = "totalweight")
    protected WebElement fieldTotalWeight;

    @FindBy(xpath = "//a[contains(@class,'prev')]")
    protected WebElement btnPreviousMonth;

    @FindBy(xpath = "//a[contains(@class,'-next')]")
    protected WebElement btnNextMonth;

    @FindBy(id = "opendateofmanufacturecalender")
    protected WebElement btncalendar;

    @FindBy(xpath = "//span[contains(@class,'month')]")
    protected WebElement actualMonth;

    @FindBy(xpath = "//span[contains(@class,'year')]")
    protected WebElement actualYear;

    protected WebElement selectDay(String dia){
        return findElementByXpath("//a[contains(text(),'"+dia+"')]");
    }

    protected WebElement selectRightHandDriven(String option){
        return findElementByXpath("//input[contains(@id,'righthanddrive"+option+"')]/..//span[@class='ideal-radio']");
    }

}
