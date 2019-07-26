package com.zibby.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", glue = { "src/test/java/com/zibby/tests/" }, tags = {
		"@Demo" }, plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber.json",
				"junit:target/cucumber.xml " })

public class TestRunner {

}