package co.com.client.webproject.test.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features/agregarAlCarroDeCompras.feature",
        glue = "co.com.client.webproject.test.stepdefinition.agregaralcarro",
        tags = "",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class AgregarAlCarroDeComprasRunner {
}
