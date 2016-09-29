package edu.uco.dware6.p6danielwa;


public class LatLng {

    private float lat;
    private float lng;

    public LatLng(float lat, float lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public LatLng(String lat, String lng){
        try{
            this.lat = Float.parseFloat(lat);
            this.lng = Float.parseFloat(lng);
        }catch(NumberFormatException ex){
            this.lat = 0;
            this.lng = 0;
            System.out.println("Failed to parse LatLng: " + lat + " & " + lng);
        }

    }

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

}
