package tests;

import system.tests.BaseWeb;
import utils.ExcelDataUtils;
import data.CustomerDataFactory;
import model.Customer;
import page.aos.LoginPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class AosLoginWebTest extends BaseWeb {
	
    @DataProvider(name = "Users")
    public static Object[][] credentials() throws Exception {
        return ExcelDataUtils.getExcelData();

    }

    @Test(description = "Aos Login Web", dataProvider = "Users")
    public void loginTest(String ddEmail, String ddPassword) {
        Customer customerInformation = new CustomerDataFactory().createCustomerData(ddEmail, ddPassword);

        LoginPage loginPage = new LoginPage();
        
        loginPage.clickUserIcon();

        loginPage.fillUsername(customerInformation.getEmail());
        loginPage.fillPassword(customerInformation.getPassword());

        loginPage.clickSignin();

        assertThat(loginPage.getLoggedUser())
        .isEqualTo(customerInformation.getEmail());

        loginPage.clickUserIcon();
        loginPage.clickSignout();



    }
}
