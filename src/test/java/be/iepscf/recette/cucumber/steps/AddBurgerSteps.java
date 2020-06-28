package be.iepscf.recette.cucumber.steps;

import be.iepscf.recette.Data;
import be.iepscf.recette.dto.burger.BurgerPostDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddBurgerSteps {
    private BurgerPostDTO burgerPostDTO = new BurgerPostDTO();
    Response response = null;
    @Given("a burger named {string}")
    public void aBurgerNamed(String name){
        burgerPostDTO.setNom(name);
    }
    @Given("that cost {float}")
    public void thatCost(double price){
        burgerPostDTO.setPrix(price);
    }
    @When("I post it")
    public void iPostIt(){
        response = given()
                .contentType(ContentType.JSON)
                .body(burgerPostDTO)
                .when()
                .post(Data.URL + "/burger");
    }

    @Then("the name is {string}")
    public void theNameIs(String name){
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("nom", equalTo(name));
    }

}
