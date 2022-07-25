package com.cybertek.day5;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class HamcrestMatchersIntro {

    @Test
    public void simpleTest() {

        //actual 5+5
        assertThat(5 + 5, is(10));
        assertThat(5 + 5, equalTo(10));
        //Matchers has 2 overloaded version
        //first that accept actual value
        //second that accept another matchers
        //below examples is method is accepting another matchers equal to make it readable
        assertThat(5 + 5, is(equalTo(10)));
        assertThat(5+5,not(9));
        //or u can say
        assertThat(5+5,is(not(9)));
        //or
        assertThat(5+5,is(not(equalTo(9))));

        //number comparison
        //greaterThan()
        //greaterThanOrEqualTo()
        //lessThan()
        //lessThanOrEqualTo()
        assertThat(5+5,is(greaterThan(9)));
    }
}
