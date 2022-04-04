package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.CheckOutPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.helpers.enums.TimesWaits.*;

public class CheckOutController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void goToProccedCheckOutSummary() {
        try {
            CheckOutPage checkOutPage = new CheckOutPage(webAction.getDriver());
            webAction.click(checkOutPage.getProceedCheckOut(), FIVE_SECONDS.getValue(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error en el proceso de compra", e);
        }
    }

    ;

    public void completarProcesoDeCompra() {
        try {
            CheckOutPage checkOutPage = new CheckOutPage(webAction.getDriver());
            webAction.click(checkOutPage.getProccedAddress(), TWO_SECONDS.getValue(), true);
            webAction.click(checkOutPage.getAcceptTermns(), THREE_SECONDS.getValue(), true);
            webAction.click(checkOutPage.getProcessCarrier(), TWO_SECONDS.getValue(), true);
            webAction.click(checkOutPage.getPayBankWire(), THREE_SECONDS.getValue(), true);
            webAction.click(checkOutPage.getConfirmMyOrder(), TWO_SECONDS.getValue(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error en el proceso de compra", e);
        }
    }
}
