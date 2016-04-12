package com.verint;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", strict = true, snippets=SnippetType.CAMELCASE)
public class NoughtsAndCrossesCucumberTest {

}
