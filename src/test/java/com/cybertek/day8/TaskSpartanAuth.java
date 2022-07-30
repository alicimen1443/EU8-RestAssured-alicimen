package com.cybertek.day8;

import com.cybertek.pojo.Spartan;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;

public class TaskSpartanAuth extends SpartanWithAuthTests{

    @Test
    public void adminCreateSpartanTest(){

        Spartan spartan = new Spartan();
        spartan.setName("Ali Cimen");
        spartan.setGender("Male");
        spartan.setPhone(985654132114l);

        Response response = given().contentType(ContentType.JSON)
                .auth().basic("admin", "admin")
                .body(spartan)
                .when().post("/api/spartans")
                .then().statusCode(201).extract().response();

        response.prettyPrint();
    }

    @Test
    public void adminGetSpartanTest() {

        Response response = given()
                .auth().basic("admin", "admin")
                .pathParam("id", 10)
                .when().get("api/spartans/{id}")
                .then().statusCode(200).extract().response();

        response.prettyPrint();
    }

    @Test
    public void adminPutSpartanTest(){

        Spartan spartan = new Spartan();
        spartan.setName("Zeynep Cimen");
        spartan.setGender("Female");
        spartan.setPhone(985654132176l);

        Response response = given().contentType(ContentType.JSON)
                .auth().basic("admin", "admin")
                .body(spartan).pathParam("id",103)
                .when().put("/api/spartans/{id}")
                .then().statusCode(204).log().all().extract().response();


    }
    @Test
    public void adminPatchSpartanTest(){

        String request = "{\n" +
                "  \"name\": \"Monte Kristo\"\n" +
                "}";

        Response response = given().header("Content-Type", "application/json")
                .auth().basic("admin", "admin")
                .body(request).pathParam("id", "70")
                .patch("/api/spartans/{id}")
                .then().statusCode(204)
                .extract().response();

        response.prettyPrint();
    }

    @Test
    public void adminDeleteSpartanWithIdTest(){

        Response response = given().auth().basic("admin", "admin")
                .pathParam("id", "3")
                .delete("/api/spartans/{id}")
                .then().statusCode(204)
                .extract().response();

        response.prettyPrint();
    }
    @Test
    public void userDeleteSpartanWithIdTest() {

        Response response = given().auth().basic("user", "user")
                .pathParam("id", "4")
                .delete("/api/spartans/{id}")
                .then().statusCode(403)
                .extract().response();

        response.prettyPrint();
    }

    @Test
    public void userPutSpartanTest() {

        String request = "{\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"Monte Kristo\",\n" +
                "  \"phone\": 4569871236\n" +
                "}";

        Response response = given().header("Content-Type", "application/json")
                .auth().basic("user", "user")
                .body(request).pathParam("id", "48")
                .put("/api/spartans/{id}")
                .then().statusCode(403)
                .extract().response();

        response.prettyPrint();
    }

    @Test
    public void editorPatchSpartanTest(){

        String request = "{\n" +
                "  \"name\": \"Monte Kristo\"\n" +
                "}";

        Response response = given().header("Content-Type", "application/json")
                .auth().basic("editor", "editor")
                .body(request).pathParam("id", "70")
                .patch("/api/spartans/{id}")
                .then().statusCode(204)
                .extract().response();

        response.prettyPrint();
    }

    @Test
    public void editorDeleteSpartanWithIdTest(){

        Response response = given().auth().basic("editor", "editor")
                .pathParam("id", "4")
                .delete("/api/spartans/{id}")
                .then().statusCode(403)
                .extract().response();

        response.prettyPrint();
    }




}
