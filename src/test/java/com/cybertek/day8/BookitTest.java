package com.cybertek.day8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class BookitTest {

    @BeforeAll
    public static void init() {
        //save baseurl inside this variable so that we don't need to type each http method.
        baseURI = "https://cybertek-reservation-api-qa.herokuapp.com";
    }

    @DisplayName("GET all campuses")
    @Test
    public void testAuth1(){






    }

}
