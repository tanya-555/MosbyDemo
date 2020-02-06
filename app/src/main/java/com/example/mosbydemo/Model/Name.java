package com.example.mosbydemo.Model;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public class Name implements MvpView {

    String firstname;
    String lastname;

    public Name(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {

        return this.firstname;
    }

    public String getLastname() {

        return this.lastname;
    }
}
