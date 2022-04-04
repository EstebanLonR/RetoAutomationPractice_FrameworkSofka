package co.com.client.webproject.test.helpers;


import co.com.client.webproject.test.model.Customer;
import co.com.client.webproject.test.model.DressSpecification;
import co.com.client.webproject.test.model.Order;
import co.com.sofka.test.evidence.reports.Report;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static co.com.client.webproject.test.helpers.Dictionary.*;


public class Helper {

    private Helper() {
    }

    public static String getProperty(String property) {
        Properties properties = new Properties();

        try (FileReader fileReader = new FileReader(CONFIGURATION_PROPERTIES_FILE)) {
            properties.load(fileReader);
        } catch (IOException e) {
            Report.reportFailure("Fallo al consultar una propiedad del archivo "
                    + CONFIGURATION_PROPERTIES_FILE, e);
        }

        return properties.getProperty(property);
    }

    public static Customer generateCustomer(String language, String country, String emailDomain) {

        Faker faker = Faker.instance(
                new Locale(language, country),
                new Random()
        );

        Customer customer = new Customer();
        customer.setEmail(
                faker.name()
                        .username()
                        .concat(emailDomain)
                        .replace(SPACE_STRING, EMPTY_STRING)
        );

        customer.setFirstName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());
        customer.setPassword(faker.number().digits(8));
        customer.setDayBirth(String.valueOf(faker.number().numberBetween(1, 28)));
        customer.setMonthBirth(String.valueOf(faker.number().numberBetween(1, 12)));
        customer.setYearBirth(String.valueOf(faker.number().numberBetween(1980, 2003)));

        customer.setAddress(faker.address().fullAddress());
        customer.setCity(faker.address().city());
        customer.setPostalCode(faker.address().zipCode());
        customer.setMobilePhone(
                String.valueOf(
                                faker
                                        .number()
                                        .numberBetween(300000000, 399999999))
                        .concat(
                                String.valueOf(
                                        faker.number()
                                                .numberBetween(1, 9)
                                )
                        )
        );
        customer.setState(STATE_BY_DEFAULT_FLORIDA);

        return customer;
    }

    public static Order generateOrderContactUs(List<List<String>> rows) {
        List<List<String>> information;
        information = rows;
        Order order = new Order();
        order.setEmailAddress(information.get(1).get(0));
        order.setOrderReference(information.get(1).get(1));
        order.setMessage(information.get(1).get(2));

        return order;
    }

    public static Order generateTechnicalOrderWithoutMessage(List<List<String>> rows) {
        List<List<String>> information;
        information = rows;
        Order order = new Order();
        order.setEmailAddress(information.get(1).get(0));
        order.setOrderReference(information.get(1).get(1));

        return order;
    }

    public static DressSpecification generateSpecificationsOfDress(List<List<String>> rows) {
        List<List<String>> information;
        information = rows;
        DressSpecification dressSpecification = new DressSpecification();
        dressSpecification.setQuantity(information.get(1).get(0));
        dressSpecification.setSize(information.get(1).get(1));
        dressSpecification.setColor(information.get(1).get(2));

        return dressSpecification;
    }
}
