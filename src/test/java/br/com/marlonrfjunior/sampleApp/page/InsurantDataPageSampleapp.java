package br.com.marlonrfjunior.sampleApp.page;

import br.com.marlonrfjunior.sampleApp.attributes.InsurantDataAttributesSampleapp;
import org.openqa.selenium.support.PageFactory;

import static br.com.marlonrfjunior.sampleApp.utils.Utils.getPropertyRestsettings;

public class InsurantDataPageSampleapp extends InsurantDataAttributesSampleapp {
    public InsurantDataPageSampleapp() {
        PageFactory.initElements(getDriver() , this);
    }

    /**
     * Preenchendo dados do formuçário de dados do seguro
     */
    public void fillFormInsuratData() {
        setText(fieldFirstName , getPropertyRestsettings("sampleapp.dataform.fristName"));
        setText(fieldLastName , getPropertyRestsettings("sampleapp.dataform.lastName"));
        setText(fieldBirthday,getPropertyRestsettings("sampleapp.dataform.birthDay"));
        click(selectGender(getPropertyRestsettings("sampleapp.dataform.gender")));
        setText(fieldStreetAddress , getPropertyRestsettings("sampleapp.dataform.streetAddress"));
        select(comboCountry , getPropertyRestsettings("sampleapp.dataform.country"));
        setText(fieldZipCode , getPropertyRestsettings("sampleapp.dataform.zipCode"));
        setText(fieldCity , getPropertyRestsettings("sampleapp.dataform.city"));
        select(comboOccupation , getPropertyRestsettings("sampleapp.dataform.occupation"));
        click(selectHoobies(getPropertyRestsettings("sampleapp.dataform.hobbies")));
        setText(fieldWebsite , getPropertyRestsettings("sampleapp.dataform.website"));
        uploadArchive();
    }

    /**
     * Upload de arquivo
     */
    public void uploadArchive(){
//        click(btnOpenFile);
//        btnOpenFile.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\file.png");

    }


}
