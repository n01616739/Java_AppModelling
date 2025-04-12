package com.sn.spring.finalex.model;

public class FormDTO {
    private String firstName;
    private String lastName;
    private int numberOfPassengers;
    private String travelClass;
    private String phoneNumber;
    private String time;
    private String dateOfDeparture;

    // Getters & Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getNumberOfPassengers() { return numberOfPassengers; }
    public void setNumberOfPassengers(int numberOfPassengers) { this.numberOfPassengers = numberOfPassengers; }

    public String getTravelClass() { return travelClass; }
    public void setTravelClass(String travelClass) { this.travelClass = travelClass; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getDateOfDeparture() { return dateOfDeparture; }
    public void setDateOfDeparture(String dateOfDeparture) { this.dateOfDeparture = dateOfDeparture; }
}
