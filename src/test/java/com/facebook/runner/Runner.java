package com.facebook.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "html:target/cucumber","json:target/report.json" }, 
				features = "src/test/resources/features", 
				glue = "com/facebook/stepdefs",
				tags = "@sup"
				// dryRun = true
					)
public class Runner {

}
