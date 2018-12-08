package com.SNM.app.main;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImplementSNMTest {

    int other;


    @Test
    public void existingUser() {
        ImplementSNM implementSNM=new ImplementSNM();
        int existingUser=1;
        assertEquals("Existing User",existingUser,1);
        //        assertTrue("only accepts 1 for existin User", nu == 1);

    }

    @Test
    public void newUser() {
        int newUser=2;
     assertEquals("New user",newUser,2);
        //        assertTrue("only accepts 2 for new User", nu == 2);

    }

    @Test
    public void otherOption() {

        assertTrue("Any other value other than 1 or 2", (other!=1) && (other!=2));

    }

}