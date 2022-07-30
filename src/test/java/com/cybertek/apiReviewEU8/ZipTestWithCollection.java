package com.cybertek.apiReviewEU8;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;
import static io.restassured.RestAssured.given;

public class ZipTestWithCollection extends ZipBase {

    @Test
    public void CollectionTest(){
        Response response = given().accept(ContentType.JSON)
                .pathParam("zip",22031)
                .when()
                .get("/{zip}");
        response.prettyPrint();
        //we can get the response as a String but we don't have much choise with this body actually
     //   System.out.println("response.toString() = " + response.asString());

        //De-serializiation
        java.util.Map<String,Object> postCode = response.body().as(Map.class);
        System.out.println("postCode.get(\"post code\") = " + postCode.get("post code"));

        Assertions.assertEquals("United States",postCode.get("country"));

        //"state" : "Virginia" verify : this information is inside the "places"key
        //we need to cast it to List of map because it was an object initially
        List<Map<String,Object>> places = (List<java.util.Map<String, Object>>) postCode.get("places");

        assertEquals("Virginia",places.get(0).get("state"));
        assertEquals("Fairfax",places.get(0).get("place name"));






    }

}
