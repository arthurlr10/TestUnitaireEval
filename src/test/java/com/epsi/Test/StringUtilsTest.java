package com.epsi.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    public void testReverse() {
        
        String result = new StringBuilder("Hello World").reverse().toString();
        assertEquals("dlroW olleH", result);
    }
}