package edu.uco.dware6.p4danielwa;


public class Department {

    private String mName;
    private String mPhoneNumber;
    private String mHomePage;

    public Department(String mName, String mPhoneNumber, String mHomePage) {
        this.mName = mName;
        this.mPhoneNumber = mPhoneNumber;
        this.mHomePage = mHomePage;
    }

    public String getmName() {
        return mName;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public String getmHomePage() {
        return mHomePage;
    }
}
