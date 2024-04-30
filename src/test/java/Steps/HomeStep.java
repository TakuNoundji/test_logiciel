package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Test.HomePage;

public class HomeStep{

    private HomePage  homepage = new HomePage();


    @Given("user in the home page")
    public void UserInTheHomePage(){
        this.homepage.navigateToHomePage();
    }

    @When("user is begin to sign up")
    public void UserReadyToCreateAccount(){
        this.homepage.inscription();
    }

    @When("user is begin to log out")
    public void UserReadyToLogout(){
        this.homepage.deconnexion();
    }

    @Then("login after sign up")
    public void UserReadyToLoginAccount(){
        this.homepage.connexion();
    }

}
