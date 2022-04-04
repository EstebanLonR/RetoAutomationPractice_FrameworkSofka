package co.com.client.webproject.test.stepdefinition.contactanos;

import co.com.client.webproject.test.controllers.ContactUsController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.page.ContactUsPage;
import co.com.client.webproject.test.stepdefinition.Setup;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static co.com.client.webproject.test.helpers.Dictionary.SPACE_STRING;

public class ContactanosStepDefinition extends Setup {
    private WebAction webAction;
    private List<List<String>> information;

    @Before
    public void setup(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el usuario se encuentra en la pagina de incio del aplicativo")
    public void queElUsuarioSeEncuentraEnLaPaginaDeIncioDelAplicativo() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }

    @Cuando("este se dirige al apartado de contac us y diligencia el formulario de customer service")
    public void esteSeDirigeAlApartadoDeContacUsYDiligenciaElFormularioDeCustomerService(DataTable dataTable) {
        ContactUsController contactUsController = new ContactUsController();
        contactUsController.setWebAction(webAction);
        contactUsController.dirigirseHaciaContactUs();
        information = dataTable.asLists(String.class);
        contactUsController.realizarUnaConsultaCon(information);
    }

    @Entonces("el sistema debera mostrarle el mensaje {string}")
    public void elSistemaDeberaMostrarleElMensaje(String messageExpected) {
        ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
        String messageObtained = contactUsPage.getMessageSuccesfullySent().getText();
        Assert.Hard.thatString(messageObtained).contains(messageExpected);
        Report.reportInfo("El mensaje esperado es " + messageExpected + SPACE_STRING +
                "El mensaje Obtenido fue " + messageObtained);
    }

    //@Scenario:InformarFalloTecnico
    @Cuando("se dirige al apartado de contact us y diligencia el formulario de customer service sin mensaje")
    public void seDirigeAlApartadoDeContactUsYDiligenciaElFormularioDeCustomerServiceSinMensaje(DataTable dataTable) {
        ContactUsController contactUsController = new ContactUsController();
        contactUsController.setWebAction(webAction);
        contactUsController.dirigirseHaciaContactUs();
        information = dataTable.asLists(String.class);
        contactUsController.informarDeUnFalloSinMensajeConLa(information);
    }

    @Entonces("el sistema debera mostrarle un mensaje {string}")
    public void elSistemaDeberaMostrarleUnMensaje(String messageExpected) {
        ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
        String messageObtained = contactUsPage.getMessageCannotBlank().getText();
        Assert.Hard.thatString(messageObtained).isEqualTo(messageExpected);
        Report.reportInfo("El mensaje esperado es " + messageExpected + SPACE_STRING +
                "El mensaje Obtenido fue " + messageObtained);
    }

    @After
    public void cerrarDriver() throws InterruptedException {
        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
