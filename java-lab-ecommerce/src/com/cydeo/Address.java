package com.cydeo;

public class Address {

    private String streetNumber;
    private String streetName;
    private String additionalAddressLine;
    private String zipCode;
    private String state;

    public Address(String streetNumber, String streetName, String additionalAddressLine, String zipCode) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.additionalAddressLine = additionalAddressLine;
        this.zipCode = zipCode;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getAdditionalAddressLine() {
        return additionalAddressLine;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }

}
