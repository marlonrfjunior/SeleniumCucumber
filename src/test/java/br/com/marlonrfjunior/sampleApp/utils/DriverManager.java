package br.com.marlonrfjunior.sampleApp.utils;

import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static br.com.marlonrfjunior.sampleApp.utils.Utils.getProperty;
import static br.com.marlonrfjunior.sampleApp.utils.Utils.loadProperties;

public class DriverManager {
    public static WebDriver driver;
    public static String activeAutomation;


    /**
     * Seleciona o tipo de browser que será inicializado para o teste de acordo com o parâmetro.
     *
     * @param browser Tipo do browser
     */
    public static void openBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                openApplicationChrome();
                break;
            case "ie":
                openApplicationIE();
                break;
            case "firefox":
                openApplicationFirefox();
                break;
            case "edge":
                openApplicationEdge();
                break;
            default:
                System.err.print("Browser não mapeado, ecolha outro browser");
                break;
        }
        System.out.println("\nStatus: Em execucão no browser " + browser + "...\n");

    }


    /**
     * Inicialização do browser Firefox com auxilio da libary webdrivermanager
     */
    private static void openApplicationFirefox() {
        activeAutomation = "firefox";
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    /**
     * Inicialização do browser Chrome com auxilio da libary webdrivermanager
     */
    private static void openApplicationChrome() {
        activeAutomation = "chrome";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Inicialização do browser Edge com auxilio da libary webdrivermanager
     */
    private static void openApplicationEdge() {
        activeAutomation = "edge";
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Inicialização do browser Internet Explorer com auxilio da libary webdrivermanager
     */
    private static void openApplicationIE() {
        activeAutomation = "ie";
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
    }

    /**
     * Retorna o browser inicialzado
     *
     * @return
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Navegar de acordo com o sistema mapeado pelo propreties
     *
     * @param sistemEveriment
     */
    public static void navigateSystem1(String sistemEveriment) {
        driver.navigate().to(getProperty(loadProperties(System.getProperty("user.dir") + "\\src\\test\\resources\\testsettings.properties") , sistemEveriment));
    }

    /**
     * Navegar direto pela URL parametrizada
     *
     * @param url
     */
    public static void navigateTo(String url) {
        driver.navigate().to(url);
    }

}
