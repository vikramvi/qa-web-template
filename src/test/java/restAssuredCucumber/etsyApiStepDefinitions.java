package restAssuredCucumber;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class etsyApiStepDefinitions {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    @Given("^User visits etsy$")
    public void callEtsy(){
            request = given().contentType("application/json");

            response = request.when().get("https://www.etsy.com/");
    }

    @When("^User clicks on \"([^\"]*)\" icon$")
    public void callSearchByIcon(String iconLink){
        request = given().contentType("application/json");

        response = request.when().get(iconLink);
    }

    @When("^User searches by \"([^\"]*)\"$")
    public void callSearchByItemName(String itemName) {
        request = given().contentType("application/json");

        response = request.when().get(itemName);
    }

    @Then("^Response should be (\\d+)$")
    public void checkResponse(int responseCode){
        json = response.then().statusCode(responseCode);
    }

    @Then("Response time should be less than (\\d+) sec")
    public void checkResponseTime(long maxTime){
        json = response.then().time(lessThan(maxTime), TimeUnit.SECONDS);
    }
}

