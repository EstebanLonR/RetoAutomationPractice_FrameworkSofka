package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.helpers.Helper;
import co.com.client.webproject.test.model.Order;
import co.com.client.webproject.test.page.ContactUsPage;
import co.com.client.webproject.test.page.MainPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import java.util.List;

import static co.com.client.webproject.test.helpers.enums.TimesWaits.*;

public class ContactUsController {
    private WebAction webAction;
    private Order order;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }


    public void dirigirseHaciaContactUs() {
        try {
            MainPage mainPage = new MainPage(webAction.getDriver());
            webAction.click(mainPage.getContactUs(), FOUR_SECONDS.getValue(), true);
        } catch (Exception e) {
            Report.reportFailure("Ocurrio un error al intentar abrir la tienda online", e);
        }
    }

    public void realizarUnaConsultaCon(List<List<String>> information) {
        try {
            order = Helper.generateOrderContactUs(information);
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.click(contactUsPage.getSubjectCustomerService(), ONE_SECONDS.getValue(), true);
            webAction.sendText(contactUsPage.getEmailAddress(), order.getEmailAddress(), true);
            webAction.sendText(contactUsPage.getOrderReference(), order.getOrderReference(), ONE_SECONDS.getValue(), true);
            webAction.sendText(contactUsPage.getMessage(), order.getMessage(), TWO_SECONDS.getValue(), true);
            webAction.click(contactUsPage.getSubmitMessage(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error durante el proceso", e);
        }

    }

    public void informarDeUnFalloSinMensajeConLa(List<List<String>> information) {
        try {
            order = Helper.generateTechnicalOrderWithoutMessage(information);
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.click(contactUsPage.getSubjectWebMaster(), ONE_SECONDS.getValue(), true);
            webAction.sendText(contactUsPage.getEmailAddress(), order.getEmailAddress(), ONE_SECONDS.getValue(), true);
            webAction.sendText(contactUsPage.getOrderReference(), order.getOrderReference(), true);
            webAction.click(contactUsPage.getSubmitMessage(), TWO_SECONDS.getValue(), true);
        } catch (Exception e) {
            Report.reportFailure("Algo fallo", e);
        }
    }
}
