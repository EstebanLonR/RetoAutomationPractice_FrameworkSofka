package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.helpers.Helper;
import co.com.client.webproject.test.model.Customer;
import co.com.client.webproject.test.page.CheckOutPage;
import co.com.client.webproject.test.page.CreateAnAccountPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.helpers.Dictionary.*;
import static co.com.client.webproject.test.helpers.enums.TimesWaits.*;

public class CreateAnAccountWebController {
    private WebAction webAction;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void crearUnaCuenta() {
        try {
            customer = Helper.generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
            CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(webAction.getDriver());
            webAction.sendText(createAnAccountPage.getEmailAddress(), customer.getEmail(), TWO_SECONDS.getValue(), true);
            webAction.click(createAnAccountPage.getCreateAnAccount(), THREE_SECONDS.getValue(), true);
            webAction.sendText(createAnAccountPage.getFirstName(), customer.getFirstName(), TWO_SECONDS.getValue(), true);
            webAction.sendText(createAnAccountPage.getLastName(), customer.getLastName(), ONE_SECONDS.getValue(), true);
            webAction.sendText(createAnAccountPage.getPassword(), customer.getPassword(), TWO_SECONDS.getValue(), true);
            webAction.sendText(createAnAccountPage.getAddress1(), customer.getAddress(), FOUR_SECONDS.getValue(), true);
            webAction.sendText(createAnAccountPage.getCity(), customer.getCity(), TWO_SECONDS.getValue(), true);
            webAction.selectByText(createAnAccountPage.getState(), customer.getState(), true);
            webAction.sendText(createAnAccountPage.getPostCode(), customer.getPostalCode(), TWO_SECONDS.getValue(), true);
            webAction.sendText(createAnAccountPage.getPhoneMobile(), customer.getMobilePhone(), true);
            webAction.click(createAnAccountPage.getRegister(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar crear una cuenta.", e);
        }
    }
}
