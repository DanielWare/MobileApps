package edu.uco.dware6.p7danielwa;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class City implements Serializable {

    private String name;

    private LatitudeLng latitudeLng;

    private float temp;

    private String weatherDescription;

    private float windSpeed;

    private String errorText;

    private boolean JSONSuccess;

    public City(String name, LatitudeLng latitudeLng, float temp, String weatherDescription, float windSpeed) {
        this.name = name;
        this.latitudeLng = latitudeLng;
        this.temp = temp;
        this.weatherDescription = weatherDescription;
        this.windSpeed = windSpeed;
    }

    public City(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatitudeLng getLatitudeLng() {
        return latitudeLng;
    }

    public void setLatitudeLng(LatitudeLng latitudeLng) {
        this.latitudeLng = latitudeLng;
    }

    public void setLatLng(String lat, String lng){
        this.latitudeLng = new LatitudeLng(lat, lng);
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setWindSpeed(String speed){
        try{
            windSpeed = Float.parseFloat(speed);
        }catch(NumberFormatException ex){
            this.windSpeed = -999;
            System.out.println("failed to parse float: " + ex.getMessage());
        }
    }

    public boolean getJSONSuccess(){
        return JSONSuccess;
    }

    public void setTemp(String temp) {
        try{
            this.temp = Float.parseFloat(temp);
        }catch (NumberFormatException ex){
            this.temp = -999;
            System.out.println("failed to parse temp:  " + temp);
        }

    }

    public String getErrorText(){
        return this.errorText;
    }

    public void parseJSONData(String data){
        try{
            JSONObject o = new JSONObject(data);

            //check city name
            JSONObject cityObject = o.getJSONObject("city");
            if(!cityObject.getString("name").equalsIgnoreCase(getName())){
                errorText = "ERROR! " + getName() + " is not a valid city name. Try again!";
                JSONSuccess = false;
                return;
            }
            //set city coord
            JSONObject coord = cityObject.getJSONObject("coord");
            setLatitudeLng(new LatitudeLng(coord.getString("lat"), coord.getString("lon")));

            //set city temp
            JSONArray listObject = o.getJSONArray("list");
            JSONObject tempObject = listObject.getJSONObject(0).getJSONObject("temp");

            setTemp(tempObject.getString("day"));

            //set city weather desc
            JSONArray weatherArray = listObject.getJSONObject(0).getJSONArray("weather");
            setWeatherDescription(weatherArray.getJSONObject(0).getString("description"));

            //set wind speed
            setWindSpeed(listObject.getJSONObject(0).getString("speed"));

            JSONSuccess = true;
        }catch(JSONException j){
            errorText = "ERROR! JSONException: " + j.getMessage();
            JSONSuccess = false;
        }
    }

}
