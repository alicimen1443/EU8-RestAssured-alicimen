package com.cybertek.day2;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class HrGetRequests {

    //BeforeAll is a annotation equals to @BeforeClass in testNg, we use with static method name

    @BeforeAll
    public static void init(){
        RestAssured.baseURI="http://54.144.126.242:1000/ords/hr";
    }


}
