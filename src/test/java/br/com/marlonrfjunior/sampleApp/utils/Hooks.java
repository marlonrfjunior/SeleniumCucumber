package br.com.marlonrfjunior.sampleApp.utils;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.apache.log4j.Logger;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;

import static br.com.marlonrfjunior.sampleApp.utils.Utils.*;

public class Hooks extends  TestWatcher {
    private static WebDriver driver;
//    private static ExtentReports extentReport;
    private static Scenario scenario;
//    private static ExtentTest extentTest;
    private static Logger logger = Logger.getLogger(Hooks.class);
    private static String activeAutomation;

    public Hooks() {
        super();
    }

    @Override
    protected void starting(Description description) {
        super.starting(description);

        Utils.setEnvironment();
        new File("target/report").mkdir();
        new File("target/report/pdf").mkdir();
        new File("target/temp").mkdir();
        Utils.deleteAllFilesInFolder("target/temp");

//        //EXTENTREPORT
//        new File("target/report/html").mkdir();
//        new File("target/report/html/img").mkdir();
//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("target/report/html/" + description.getDisplayName().replace("tests.", "") + ".html");
//        htmlReporter.config().setEncoding("ISO-8859-1");
//        extentReport = new ExtentReports();
//        extentReport.attachReporter(htmlReporter);
//        Utils.addAllTestPropertiesToExtentReport(extentReport);extentReport.setSystemInfo("os.name", System.getProperty("os.name"));
    }

    @Before
    public void beforeCenario(Scenario scenario) {
        Hooks.scenario = scenario;

        System.out.println("Thread ID - " + Thread.currentThread().getId());

        //START EXTENTTEST
//        extentTest = extentReport.createTest("Cenario: " + scenario.getName(), scenario.getName());
//        extentTest.assignCategory("feature:" + scenario.getId().replaceAll(";.*", ""));
        Collection<String> tags = scenario.getSourceTagNames();
        for (String tag : tags) {
            System.out.println(tag);
        }
//            extentTest.assignCategory(tag);
        }
    @After
    public void afterCenario() throws IOException {
        if (scenario.isFailed()) {
            if (driver != null ) {
                BasePage basePage = new BasePage();
//                basePage.logPrintFail("The test is failed");

                Throwable throwable = logError(scenario);
//                extentTest.fail(throwable);
                String errorMessage = throwable.getMessage();
                if (errorMessage != null) {
                    if (errorMessage.contains("FindFailed")) {
                        try {
                            String findFailedImage = Utils.substringRegexGroup1("FindFailed: (.*): ", errorMessage);
//                            FileUtils.copyFile(new File(ImagePath.find(findFailedImage).getPath()), new File("target/report/html/img/" + findFailedImage));
//                            extentTest.info("FindFailed: " + findFailedImage, MediaEntityBuilder.createScreenCaptureFromPath("img/" + findFailedImage).build());
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }

        //FINISH EXTENT REPORT
//        extentReport.flush();

        //FINISH DRIVER
        if (driver != null) {
            driver.quit();
            driver = null;
        }


    }

    private Throwable logError(Scenario scenario) {
//        Field field = FieldUtils.getField(Scenario.class, "delegate", true);
        Method getError = null;
        try {
//            final TestCaseState testCase = (TestCaseState) field.get(scenario);
            if (getError == null) {
//                getError = MethodUtils.getMatchingMethod(testCase.getClass(), "getError");
                getError.setAccessible(true);
            }
//            return (Throwable) getError.invoke(testCase);
        } catch (Exception e) {
            System.err.println("error receiving exception" + e);
        }
        return null;
    }

    @Override
    protected void finished(Description description) {
        super.finished(description);
    }

    /**
     * Seleciona o tipo de browser que será inicializado para o teste de acordo com o parâmetro.
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

    /**Retorna o browser inicialzado
     * @return
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Navegar de acordo com o sistema mapeado pelo propreties
     * @param sistemEveriment
     */
    public static void navigateSystem(String sistemEveriment) {
        driver.navigate().to(getProperty(loadProperties(System.getProperty("user.dir") + "\\src\\test\\resources\\testsettings.properties"), sistemEveriment));
    }

    /**
     * Navegar direto pela URL parametrizada
     * @param url
     */
    public static void navigateTo(String url) {
        driver.navigate().to(url);
    }

}
