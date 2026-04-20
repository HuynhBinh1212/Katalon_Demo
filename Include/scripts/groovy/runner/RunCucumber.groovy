package runner

import org.junit.runner.RunWith
import io.cucumber.junit.*

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Include/features",
    glue = "", // Katalon automatically finds steps in Include/scripts/groovy
	plugin = ["pretty", 
	"html:Reports/cucumber-reports/html-report.html",
	"utils.CucumberUtils"]
)
public class RunCucumber {
	// This class remains empty
}