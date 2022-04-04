package co.com.client.webproject.test.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features/contactanos.feature",
        glue = "co.com.client.webproject.test.stepdefinition.contactanos",
        tags = "",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class ContactanosRunner {
}
