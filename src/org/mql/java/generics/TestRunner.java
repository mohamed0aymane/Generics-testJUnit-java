package org.mql.java.generics;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

public class TestRunner {

	public TestRunner() {
		Launcher launcher=LauncherFactory.create();//lance executer une requete du test
		SummaryGeneratingListener listener=new SummaryGeneratingListener();//pour recuperer le resultat
		launcher.registerTestExecutionListeners(listener);
		
		//creation et execution la requete
		LauncherDiscoveryRequest request =LauncherDiscoveryRequestBuilder
				.request()
				.selectors(DiscoverySelectors.selectClass(LinkedListTest.class))
				.build();
		launcher.execute(request);
		
		TestExecutionSummary summary= listener.getSummary();
		System.out.println("Test Found Count "+ summary.getTestsFoundCount());
		System.out.println("Test Succeded  Count "+ summary.getTestsSucceededCount());
		System.out.println("Test Faild  Count "+ summary.getTestsFailedCount());
		
	}
	
	
	

	public static void main(String[] args) {
		new TestRunner();

	}

}
