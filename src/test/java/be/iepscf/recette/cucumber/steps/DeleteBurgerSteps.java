package be.iepscf.recette.cucumber.steps;

import be.iepscf.recette.Data;
import io.cucumber.java.en.Given;

import static io.restassured.RestAssured.given;

public class DeleteBurgerSteps {
    @Given("the burger called {string} doesn't exist")
    public void deleteBurger(String name){
        given()
                .get(Data.URL + "/burger/deleteByName/"+name)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
