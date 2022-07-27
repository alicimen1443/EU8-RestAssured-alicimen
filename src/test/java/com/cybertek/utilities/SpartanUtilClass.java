package com.cybertek.utilities;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class SpartanUtilClass extends SpartanTestBase {
    //Create one SpartanUtil class
    //create a static method that returns Map<String,Object>
    //use faker library(add as a depedency) to assign each time different information
    //for name,gender,phone number
    //then use your method for creating spartan as a map,dynamically.

    public static Map<String,Object> createNewSpartan(){

        Faker faker = new Faker();
        int number = faker.number().randomDigit();

        Map<String,Object> newSpartan = new HashMap<>();

        newSpartan.put("name",faker.name().firstName());
        newSpartan.put("gender",number%2==0? "Male":"Female");
        newSpartan.put("phone",faker.numerify("############"));

        return newSpartan;
    }

    public static void postSpartan(){
        String expectedResponseMessage = "A Spartan is Born!";

        Response response = given().contentType(ContentType.JSON)
                .and().body(createNewSpartan())
                .when().post("/api/spartans")
                .then().statusCode(201).contentType("application/json")
                .body("success", is(expectedResponseMessage)).extract().response();

       // response.prettyPrint();


    }




}
