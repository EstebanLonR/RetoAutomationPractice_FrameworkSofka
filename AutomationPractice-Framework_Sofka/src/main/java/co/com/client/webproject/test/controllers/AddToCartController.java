package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.helpers.Helper;
import co.com.client.webproject.test.model.DressSpecification;
import co.com.client.webproject.test.page.DressesPage;
import co.com.client.webproject.test.page.MainPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;

import java.util.List;

import static co.com.client.webproject.test.helpers.enums.TimesWaits.*;

public class AddToCartController {
    private WebAction webAction;
    private DressSpecification dressSpecification;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void dirigirseAlApartadoVestidos() {
        try {
            MainPage mainPage = new MainPage(webAction.getDriver());
            webAction.click(mainPage.getDresses(), true);
        } catch (Exception e) {
            Report.reportFailure("Fallo", e);
        }

    }

    public void añadirVestidoAlCarrito(List<List<String>> specifications) {
        try {
            dressSpecification = Helper.generateSpecificationsOfDress(specifications);

            DressesPage dressesPage = new DressesPage(webAction.getDriver());
            webAction.click(dressesPage.getEveningDresses(), true);
            webAction.click(dressesPage.getPrintedDress(), THREE_SECONDS.getValue(), true);
            webAction.clearText(dressesPage.getQuantityWanted(), true);
            webAction.sendText(dressesPage.getQuantityWanted(), dressSpecification.getQuantity(), ONE_SECONDS.getValue(), true);
            switch (dressSpecification.getSize().toUpperCase().trim()) {
                case "S":
                    webAction.click(dressesPage.getSmallSize(), TWO_SECONDS.getValue(), true);
                    break;
                case "M":
                    webAction.click(dressesPage.getMediumSize(), TWO_SECONDS.getValue(), true);
                    break;
                case "L":
                    webAction.click(dressesPage.getLargeSize(), TWO_SECONDS.getValue(), true);
                    break;
                default:
            }
            switch (dressSpecification.getColor().trim()) {
                case "Pink":
                    webAction.click(dressesPage.getPinkColor(), ONE_SECONDS.getValue(), true);
                    break;
                case "Beige":
                    webAction.click(dressesPage.getBeigeColor(), ONE_SECONDS.getValue(), true);
                    break;
                default:
            }
            webAction.click(dressesPage.getAddToCartButton(), TWO_SECONDS.getValue(), true);
            webAction.click(dressesPage.getContinueShopping(), FOUR_SECONDS.getValue(), true);
        } catch (Exception e) {

        }
    }

    public void agregarVestidoAlCarritoParaComprar(List<List<String>> specifications) {
        try {
            dressSpecification = Helper.generateSpecificationsOfDress(specifications);

            DressesPage dressesPage = new DressesPage(webAction.getDriver());
            webAction.click(dressesPage.getEveningDresses(), true);
            webAction.click(dressesPage.getPrintedDress(), THREE_SECONDS.getValue(), true);
            webAction.clearText(dressesPage.getQuantityWanted(), true);
            webAction.sendText(dressesPage.getQuantityWanted(), dressSpecification.getQuantity(), ONE_SECONDS.getValue(), true);
            switch (dressSpecification.getSize().toUpperCase().trim()) {
                case "S":
                    webAction.click(dressesPage.getSmallSize(), TWO_SECONDS.getValue(), true);
                    break;
                case "M":
                    webAction.click(dressesPage.getMediumSize(), TWO_SECONDS.getValue(), true);
                    break;
                case "L":
                    webAction.click(dressesPage.getLargeSize(), TWO_SECONDS.getValue(), true);
                    break;
                default:
            }
            switch (dressSpecification.getColor().trim()) {
                case "Pink":
                    webAction.click(dressesPage.getPinkColor(), ONE_SECONDS.getValue(), true);
                    break;
                case "Beige":
                    webAction.click(dressesPage.getBeigeColor(), ONE_SECONDS.getValue(), true);
                    break;
                default:
            }
            webAction.click(dressesPage.getAddToCartButton(), TWO_SECONDS.getValue(), true);
            webAction.click(dressesPage.getProceedToCheckOut(), FIVE_SECONDS.getValue(), true);
        } catch (Exception e) {

        }
    }

}
