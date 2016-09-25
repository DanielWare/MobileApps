package edu.uco.dware6.p5danielwa;

public class Department {

    private String name;
    private String homePage;

    public Department(String name, String homePage) {
        this.name = name;
        this.homePage = homePage;
    }

    public String getName() {
        return name;
    }

    public String getHomePage() {
        return homePage;
    }
}
