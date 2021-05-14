package page.aos;

import io.qameta.allure.Step;
import page.AbstractPageObject;

import static config.ConfigurationManager.configuration;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverManager;



public class LoginPage extends AbstractPageObject {
	
	private static WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(configuration().timeout()));
	

    @FindBy(className = "loader")
    private WebElement loadPage;

    @FindBy(id = "hrefUserIcon")
    private WebElement userIcon;

    @FindBy(xpath = "//*[@id=\"menuUserLink\"]/span")
    private WebElement loggeduser;

    @FindBy(xpath = "//*[@id=\"loginMiniTitle\"]/label[3]")
    private WebElement signoutMenu;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "sign_in_btnundefined")
    private WebElement signin;

  
    @Step
    public void clickUserIcon() { 
    	wait.until(ExpectedConditions.attributeToBe(loadPage,"style", "display: none; opacity: 0;"));
    	this.userIcon.click(); 
    }

    @Step
    public String getLoggedUser() {
    	wait.until(ExpectedConditions.visibilityOf(loggeduser));
        return this.loggeduser.getText();
    }

    @Step
    public void clickSignout() { this.signoutMenu.click(); }

    @Step
    public void fillUsername(String email) { wait.until(ExpectedConditions.visibilityOf(this.username)).sendKeys(email); }

    @Step
    public void fillPassword(String password) { this.password.sendKeys(password);  }

    @Step
    public void clickSignin() { wait.until(ExpectedConditions.elementToBeClickable(this.signin)).click(); }
}
