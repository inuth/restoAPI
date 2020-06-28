package be.iepscf.recette;

import be.iepscf.recette.dto.burger.BurgerPostDTO;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BurgerControllerTest {

    // IL FAUT LANCER L'APPLICATION POUR RUN CES TEST

    @BeforeEach
    public void deleteBurger(){
        System.out.println("before called");
        given()
                .get("http://localhost:8085/api/burger/deleteByName/gigaburger")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void burgerControllerAddBurger_nameInMajSend_nameInMinRetrieved(){
        System.out.println("TEST 1");
        BurgerPostDTO burgerPostDTO = new BurgerPostDTO();
        burgerPostDTO.setNom("GIGABURGER");
        burgerPostDTO.setPrix(2.5);
        burgerPostDTO.setDescription("burger gigantesque");
        burgerPostDTO.setRecette("");
        burgerPostDTO.setImage("");

        Integer id =
            given()
                    .contentType(ContentType.JSON)
                    .body(burgerPostDTO)
                    .when()
                    .post("http://localhost:8085/api/burger")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("nom", equalTo("gigaburger"))
                    .and()
                    .extract()
                    .path("id");
        System.out.println("ID : " + id);
        given()
                .get("http://localhost:8085/api/burger/delete/"+id)
                .then()
                .assertThat()
                .statusCode(200);

    }
    @Test
    public void burgerControllerFindByName_correctName_dataFound(){
        System.out.println("TEST 2");
        BurgerPostDTO burgerPostDTO = new BurgerPostDTO();
        burgerPostDTO.setNom("GIGABURGER");
        burgerPostDTO.setPrix(2.5);
        burgerPostDTO.setDescription("burger gigantesque");
        burgerPostDTO.setRecette("");
        burgerPostDTO.setImage("");

        Integer id =
                given()
                        .contentType(ContentType.JSON)
                        .body(burgerPostDTO)
                        .when()
                        .post("http://localhost:8085/api/burger")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .and()
                        .extract()
                        .path("id");
        System.out.println("ID : " + id);

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:8085/api/burger/findByName/gigaburger")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(id));
    }
    @Test
    public void burgerControllerFindByName_beginningOfName_empty(){
        System.out.println("TEST 3");
        BurgerPostDTO burgerPostDTO = new BurgerPostDTO();
        burgerPostDTO.setNom("GIGABURGER");
        burgerPostDTO.setPrix(2.5);
        burgerPostDTO.setDescription("burger gigantesque");
        burgerPostDTO.setRecette("");
        burgerPostDTO.setImage("");

        Integer id =
                given()
                        .contentType(ContentType.JSON)
                        .body(burgerPostDTO)
                        .when()
                        .post("http://localhost:8085/api/burger")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .and()
                        .extract()
                        .path("id");

        System.out.println("ID : " + id);

        String body = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:8085/api/burger/findByName/giga")
                .then()
                .assertThat()
                .statusCode(200)
        .extract()
        .asString();
        Assert.assertEquals("", body);
    }
}
