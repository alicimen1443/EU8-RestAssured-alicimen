package com.cybertek.day5;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class HamcrestMatchersIntro {

    @Test
    public void simpleTest(){

       assertThat(5+5,is(10));

    }
}
