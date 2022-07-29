package com.cydeo;

import java.util.UUID;

public class Customer {

    private UUID id;
    private String userName;
    private String email;
    private String addressList;

    public Customer(UUID id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public Customer(UUID id, String userName, String email, String addressList) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.addressList = addressList;
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddressList() {
        return addressList;
    }

}
