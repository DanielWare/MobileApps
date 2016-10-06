package edu.uco.dware6.p6danielwa;


import java.io.Serializable;

public class LatitudeLng implements Serializable{

    private float lat;
    private float lng;

    public LatitudeLng(float lat, float lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public LatitudeLng(String lat, String lng){
        try{
            this.lat = Float.parseFloat(lat);
            this.lng = Float.parseFloat(lng);
        }catch(NumberFormatException ex){
            this.lat = 0;
            this.lng = 0;
            System.out.println("Failed to parse LatitudeLng: " + lat + " & " + lng);
        }

    }

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    public String getDescription(){
        return "Latitude: " + getLat() + "\nLongitude: " + getLng();
    }

}
