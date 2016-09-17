package edu.uco.dware6.p4danielwa;


public class Department {

    private String mName;
    private String mPhoneNumber;
    private String mHomePage;

    public Department(String name, String phoneNumber, String homePage) {
        this.mName = name;
        this.mPhoneNumber = phoneNumber;
        this.mHomePage = homePage;
    }

    public String getName() { return mName; }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public String getHomePage() {
        return mHomePage;
    }
}
