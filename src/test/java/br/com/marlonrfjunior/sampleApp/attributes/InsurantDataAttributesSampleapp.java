package br.com.marlonrfjunior.sampleApp.attributes;

import br.com.marlonrfjunior.sampleApp.utils.DSL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class InsurantDataAttributesSampleapp extends DSL {

    @FindBy(id = "country")
    protected WebElement comboCountry;

    @FindBy(id = "occupation")
    protected WebElement comboOccupation;

    @FindBy(id = "firstname")
    protected WebElement fieldFirstName;

    @FindBy(id = "lastname")
    protected WebElement fieldLastName;

    @FindBy(id = "streetaddress")
    protected WebElement fieldStreetAddress;

    @FindBy(id = "zipcode")
    protected WebElement fieldZipCode;

    @FindBy(id = "city")
    protected WebElement fieldCity;

    @FindBy(id = "website")
    protected WebElement fieldWebsite;

    @FindBy(id = "birthdate")
    protected WebElement fieldBirthday;

    @FindBy(xpath = "//a[contains(@class,'prev')]")
    protected WebElement btnPreviousMonth;

    @FindBy(xpath = "//a[contains(@class,'-next')]")
    protected WebElement btnNextMonth;

    @FindBy(id = "opendateofbirthcalender")
    protected WebElement btncalendar;

    @FindBy(xpath = "//span[contains(@class,'month')]")
    protected WebElement actualMonth;

    @FindBy(xpath = "//span[contains(@class,'year')]")
    protected WebElement actualYear;

    @FindBy(xpath = "//button[contains(@class,'ideal-file-upload')]")
    protected WebElement btnOpenFile;

    @FindBy(id = "fileInput")
    protected WebElement uploadElement;

    protected WebElement selectDay(String dia){
        return findElementByXpath("//a[contains(text(),'"+dia+"')]");
    }

    protected WebElement selectGender(String gender){
        return findElementByXpath("//input[contains(@id,'gender"+gender+"')]/..//span[@class='ideal-radio']");
    }

    protected WebElement selectHoobies(String hobbies){
        return findElementByXpath("//input[@name = 'Hobbies' and contains(@id,'"+hobbies+"')]/..//span[@class='ideal-check']");
    }


}
