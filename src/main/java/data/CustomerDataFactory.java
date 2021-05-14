package data;

import com.github.javafaker.Faker;
import java.util.Locale;
import model.Customer;
import model.CustomerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static config.ConfigurationManager.configuration;

public class CustomerDataFactory {

    private final Faker faker;
    private static final Logger logger = LogManager.getLogger(CustomerDataFactory.class);

    public CustomerDataFactory() {
        faker = new Faker(new Locale(configuration().faker()));
    }

    public Customer createCustomerData(String ddEmail, String ddPassword) {
        Customer customer = new CustomerBuilder().
            //email(faker.internet().emailAddress()).
            //password(faker.internet().password()).
        	email(ddEmail).
        	password(ddPassword).
            build();

        logger.info(customer);
        return customer;
    }


}
