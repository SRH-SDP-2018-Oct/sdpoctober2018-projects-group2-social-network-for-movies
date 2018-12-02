package com.SNM.app.pojo;


import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.persistence.*;
@Entity
@Table(name = "userprofile")
public class UserProfile{
    @Id
    //@GeneratedValue
    @Column(name = "user_name")
    private String user_name;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "age")
    private int age;

    @Column(name = "email_ID")
    private String email_ID;

    @Column(name = "pasword")
    private String password;




    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name)
    {
        this.user_name = user_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail_ID() {
        return email_ID;
    }

    public void setEmail_ID(String email_ID) {
        this.email_ID = email_ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLast_name(MysqlxDatatypes.Scalar.String lastname) {
    }


    public void setEmail_ID(MysqlxDatatypes.Scalar.String emailID) {
    }
}
