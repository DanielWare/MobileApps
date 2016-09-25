package edu.uco.dware6.p5danielwa;



public class Contact {

    private String lastName;
    private String firstName;
    private String phoneNum;
    private String email;


    public Contact(String firstName, String lastName, String phoneNum, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public String getLastNameFirstName(){
        return getLastName() + ", " + getFirstName();
    }
}
