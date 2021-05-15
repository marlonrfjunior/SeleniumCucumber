package br.com.marlonrfjunior.sampleApp.attributes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.marlonrfjunior.sampleApp.utils.BasePage;


public class VehicleDataAttributesSampleapp extends BasePage {

    @FindBy(id = "make")
    protected WebElement comboMake;

    @FindBy(id = "numberofseats")
    protected WebElement comboNumberOfSeats;

    @FindBy(id = "fuel")
    protected WebElement comboFuel;

    @FindBy(id = "engineperformance")
    protected WebElement fieldEnginePerformance;

    @FindBy(id = "listprice")
    protected WebElement fieldListprice;

    @FindBy(id = "licenseplatenumber")
    protected WebElement fieldLicensePlateNumber;

    @FindBy(id = "annualmileage")
    protected WebElement fieldannualmileage;

    @FindBy(id = "nextenterinsurantdata")
    protected WebElement btnNext;

}
