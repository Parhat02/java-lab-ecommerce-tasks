package com.cydeo;

import java.util.List;
import java.util.UUID;

public class Customer {

    private final UUID id;
    private final String userName;
    private final String email;
    private List<Address> addressList;

    public Customer(UUID id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public Customer(UUID id, String userName, String email, List<Address> addressList) {
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

    public List<Address> getAddressList() {
        return addressList;
    }

}
