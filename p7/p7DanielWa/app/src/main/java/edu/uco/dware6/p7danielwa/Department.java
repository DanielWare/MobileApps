package edu.uco.dware6.p7danielwa;


import java.io.Serializable;

public class Department implements Serializable{

    private String mName;
    private String mPhoneNumber;
    private String mHomePage;
    private LatitudeLng latLng;

    public Department(String name, String phoneNumber, String homePage, LatitudeLng latLng) {
        this.mName = name;
        this.mPhoneNumber = phoneNumber;
        this.mHomePage = homePage;
        this.latLng = latLng;
    }

    public String getName() { return mName; }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public String getHomePage() {
        return mHomePage;
    }

    public LatitudeLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatitudeLng latLng) {
        this.latLng = latLng;
    }
}
