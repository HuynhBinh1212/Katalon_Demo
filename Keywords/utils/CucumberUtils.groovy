package utils

import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.GherkinKeyword
import io.cucumber.plugin.ConcurrentEventListener
import io.cucumber.plugin.event.EventHandler
import io.cucumber.plugin.event.EventPublisher
import io.cucumber.plugin.event.PickleStepTestStep
import io.cucumber.plugin.event.TestCaseStarted
import io.cucumber.plugin.event.TestSourceRead
import io.cucumber.plugin.event.TestStepStarted
import io.cucumber.plugin.event.HookTestStep
import com.aventstack.extentreports.gherkin.model.Scenario
import com.aventstack.extentreports.gherkin.model.Feature
import extentReport.ExtentReportManager as ExtentLog

public class CucumberUtils implements ConcurrentEventListener {
	
    public static String currentStepKeyword = ""
    public static String currentStepName = ""
	
	public static ExtentReports extent
	

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepStarted.class, stepStartedHandler)
		
    }
	
    private EventHandler<TestStepStarted> stepStartedHandler = new EventHandler<TestStepStarted>() {
        @Override
        public void receive(TestStepStarted event) {
            if (event.getTestStep() instanceof PickleStepTestStep) {
                PickleStepTestStep testStep = (PickleStepTestStep) event.getTestStep()
                currentStepKeyword = testStep.getStep().getKeyword() // Lấy 'Given', 'When', 'Then'
                currentStepName = testStep.getStep().getText()      // Lấy tên Step
				
        }          
			  
        }
		
    }

}