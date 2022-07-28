package com.cybertek.utilities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class BookitUtil extends BookitTestBase {

    //create BookItUtil then create a method, that accepts email and password return token Bearer +yourToken as a String

    public static String getToken(String email,String password){

                return "Bearer "+ given().queryParam("email", email)
                .queryParam("password", password)
                .get("/sign").then().extract()
                .jsonPath().getString("accessToken");

    }


}
