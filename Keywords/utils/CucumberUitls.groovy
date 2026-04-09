package utils

import cucumber.api.event.EventListener // Đổi từ ConcurrentEventListener sang EventListener
import cucumber.api.event.EventHandler
import cucumber.api.event.EventPublisher
import cucumber.api.event.TestStepStarted
import cucumber.api.PickleStepTestStep

// SỬA LỖI: Dùng implements EventListener
class CucumberUtils implements EventListener {

	public static String currentStepKeyword = ""
	public static String currentStepName = ""

	@Override
	public void setEventPublisher(EventPublisher publisher) {
		publisher.registerHandlerFor(TestStepStarted.class, stepStartedHandler)
	}

	private EventHandler<TestStepStarted> stepStartedHandler = new EventHandler<TestStepStarted>() {
		@Override
		public void receive(TestStepStarted event) {
			if (event.testStep instanceof PickleStepTestStep) {
				PickleStepTestStep testStep = (PickleStepTestStep) event.testStep
				currentStepKeyword = testStep.getStep().getKeyword()
				currentStepName = testStep.getStep().getText()
				println ">>> STEP: " + currentStepKeyword + currentStepName
			}
		}
	}

}