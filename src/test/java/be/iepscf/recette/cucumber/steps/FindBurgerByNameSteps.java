package be.iepscf.recette.cucumber.steps;

import be.iepscf.recette.Data;
import be.iepscf.recette.dto.burger.BurgerPostDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FindBurgerByNameSteps {
    Response response = null;

    @Given("the burger called {string} exists")
    public void theBurgerCalledExist(String nom){
        BurgerPostDTO burgerPostDTO = new BurgerPostDTO();
        burgerPostDTO.setNom(nom);
        burgerPostDTO.setPrix(2.5);

        given()
                .contentType(ContentType.JSON)
                .body(burgerPostDTO)
                .when()
                .post(Data.URL + "/burger")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @When("I search it with {string}")
    public void iSearchItWith(String search){
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(Data.URL + "/burger/findByName/"+search);
    }

    @Then("I get the burger called {string}")
    public void iGetTheBurger(String name){
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("nom", equalTo(name));
    }

    @Then("I don't get the burger")
    public void iDontGetTheBurger(){
        String body = response
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .asString();
        Assert.assertEquals("", body);
    }

}
