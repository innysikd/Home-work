package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class CensorTest {

    @Test
    public void testIsLegal_nonEmptyString_containsBeginning() {

        String[] badWords = {"one", "two", "three"};
        Censor censor = new Censor(badWords);

        assertFalse(censor.isLegal("one four nine"));
    }

        @Test
    public void testIsLegal_nonEmptyString_containsMiddle() {

        String[] badWords = {"one", "two", "three"};
        Censor censor = new Censor(badWords);

        assertFalse(censor.isLegal("five Two four nine"));
    }


        @Test
    public void testIsLegal_nonEmptyString_notContains() {

        String[] badWords = {"one", "two", "three"};
        Censor censor = new Censor(badWords);

        assertTrue(censor.isLegal("five, four. nine"));
    }




}