package com.cybertek.day5;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class HamcrestMatchersApiTest {

    @DisplayName("OneSpartan with Hamcrest and chaining")
    @Test
    public void test1(){

        given().accept(ContentType.JSON)
                .and().pathParam("id",15)
                .when().get("\n" +
                        "http://54.144.126.242:8000/api/spartans/{id}")
                .then().statusCode(200)
                .and()
                .contentType("application/json")
                .and()
                .body("id",equalTo(15),"name",is("Meta")
                ,"gender",is("Female"),"phone",is(1938695106));



    }


}
