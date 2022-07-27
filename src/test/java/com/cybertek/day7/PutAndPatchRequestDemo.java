package com.cybertek.day7;

import com.cybertek.pojo.Spartan;
import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class PutAndPatchRequestDemo extends SpartanTestBase {

    @DisplayName("PUT request to one spartan for update with map")
    @Test
    public void PUTRequest() {

        //just like post request we have different options to send body, we will go with map

        Map<String, Object> putRequestMap = new LinkedHashMap<>();
        putRequestMap.put("name", "SeverusSpartan");
        putRequestMap.put("gender", "Male");
        putRequestMap.put("phone", 88774451111l);

        given().contentType(ContentType.JSON)
                .body(putRequestMap).log().body()
                .and().pathParam("id", 126)
                .when().put("/api/spartans/{id}")
                .then()
                .statusCode(204);


        //send a GET request after update, make sure updated field changed, or the new info matching
        //with requestBody that we send

        Spartan spartan = given().accept(ContentType.JSON)
                .and().pathParam("id", 126)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .extract().response().as(Spartan.class);

        assertThat(spartan.getName(), is(putRequestMap.get("name")));
        assertThat(spartan.getGender(), is(putRequestMap.get("gender")));
        assertThat(spartan.getPhone(), is(putRequestMap.get("phone")));

    }

    @DisplayName("PATCH request to one spartan for update with map")
    @Test
    public void PATCHRequest() {

        //%100 interview question what is the difference between put and patch
        //patch is partial update you can give only the value that you need to update it
        //put is you can still update one line but you need to provide the full body

        //just like post request we have different options to send body, we will go with map

        Map<String, Object> patchRequestMap = new LinkedHashMap<>();
        patchRequestMap.put("phone", 88774451111l);

        given().contentType(ContentType.JSON)
                .body(patchRequestMap).log().body()
                .and().pathParam("id", 127)
                .when().patch("/api/spartans/{id}")
                .then()
                .statusCode(204);
        //send a get request after update, make sure updated field changed, or the new info matching
        //with requestBody that we send

        Spartan spartan2 = given().accept(ContentType.JSON)
                .and().pathParam("id",127)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200).extract().response().as(Spartan.class);

        assertThat(spartan2.getPhone(),is(patchRequestMap.get("phone")));
    }

    @DisplayName("DELETE one spartan")
    @Test
    public void deleteSpartan(){

        int idToDelete=36;

        given().pathParam("id",idToDelete)
                .when().delete("/api/spartans/{id}")
                .then().statusCode(204);

                //send a get request after you delete make sure you are getting 404

        given().accept(ContentType.JSON)
                .and().pathParam("id",36)
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(404);

    }







}
