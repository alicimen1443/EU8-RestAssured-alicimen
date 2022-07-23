package com.cybertek.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class SpartanTestBase {

    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we don't need to type each http method.
        baseURI="http://54.144.126.242:8000";

        //get IP adress from configurations
    }
}
