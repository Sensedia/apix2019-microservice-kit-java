package com.sensedia.apix2019.kit.request;

public class NotificationRequest {

    private String phone;
    private Integer numberOfCombinationsFound;

    public NotificationRequest() {
    }

    public NotificationRequest(String phone, Integer numberOfCombinationsFound) {
        this.phone = phone;
        this.numberOfCombinationsFound = numberOfCombinationsFound;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getNumberOfCombinationsFound() {
        return numberOfCombinationsFound;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNumberOfCombinationsFound(Integer numberOfCombinationsFound) {
        this.numberOfCombinationsFound = numberOfCombinationsFound;
    }
}
