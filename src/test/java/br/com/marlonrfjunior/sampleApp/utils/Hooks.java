package br.com.marlonrfjunior.sampleApp.utils;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.rules.TestWatcher;
import java.io.File;
import java.io.IOException;


import static br.com.marlonrfjunior.sampleApp.utils.DriverManager.driver;

public class Hooks extends TestWatcher {

    private static Scenario scenario;

    public Hooks() {
        super();
    }

    @Before
    public void beforeCenario(Scenario scenario) {
        Hooks.scenario = scenario;

        Utils.setEnvironment();
        new File("target/report").mkdir();
        new File("target/report/Screenshoots").mkdir();
        Utils.deleteAllFilesInFolder("target/report/Screenshoots");

    }

    @After
    public void afterCenario() throws IOException {
        if (scenario.isFailed()) {
            if (driver != null) {
                DSL basePage = new DSL();
                System.out.println("The test is failed");
                Throwable throwable = Utils.logError(scenario);
                String errorMessage = throwable.getMessage();
            }
        }
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }


}
