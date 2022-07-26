package com.cybertek.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class SpartanTestBase {

    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we don't need to type each http method.
        baseURI="http://54.144.126.242:8000";

        String dbUrl = "jdbc:oracle:thin:@54.144.126.242:1521:xe";
        String dbUsername = "SP";
        String dbPassword = "SP";
//we commnet it out cos we don't want to connect to database all the time.Whenever we need we can connect it
        //DBUtils.createConnection(dbUrl,dbUsername,dbPassword);
    }

    @AfterAll
    public static void teardown(){

        //DBUtils.destroy();
    }

}
