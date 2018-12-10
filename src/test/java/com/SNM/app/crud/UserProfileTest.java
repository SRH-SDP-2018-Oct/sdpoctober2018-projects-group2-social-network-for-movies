package com.SNM.app.crud;

import com.SNM.app.pojo.UserProfile;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserProfileTest {

    @Test
    public void fetchDetails() {
    }

    @Test
    public void setUserDetails() {
        String email="gauri@gmail.com",fname="gauri",lname="lahare",password="Xyzabc@123";
        int age=25;
        UserProfile instance = new UserProfile();
        instance.setEmail_ID(email);
        instance.setAge(age);
        instance.setFirst_name(fname);
        instance.setLast_name(lname);
        instance.setPassword(password);
        Assert.assertEquals("To set EmailId",instance.getEmail_ID(),email);
        Assert.assertEquals("To set Age",instance.getAge(),age);
        Assert.assertEquals("To set First name",instance.getFirst_name(),fname);
        Assert.assertEquals("To set Last name",instance.getLast_name(),lname);
        Assert.assertEquals("To set Password",instance.getPassword(),password);
    }
}