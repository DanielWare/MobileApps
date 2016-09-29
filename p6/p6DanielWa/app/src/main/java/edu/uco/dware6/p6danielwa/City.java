package edu.uco.dware6.p6danielwa;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class City {

    private String name;

    private LatLng latLng;

    private float temp;

    private String errorText;

    private boolean JSONSuccess;

    public City(String name, LatLng latLng, float temp) {
        this.name = name;
        this.latLng = latLng;
        this.temp = temp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public void setLatLng(String lat, String lng){
        this.latLng = new LatLng(lat, lng);
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
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

    public String getWeatherInfo(){
        return getName() + " T: " + getTemp() + " LatLng: " + getLatLng().toString();
    }

    public String getErrorText(){
        return this.errorText;
    }

    public void parseJSONData(String data){
        try{
            JSONObject o = new JSONObject(data);

            JSONObject cityName = o.getJSONObject("city");
            if(!cityName.getString("name").equalsIgnoreCase(getName())){
                errorText = "ERROR! " + getName() + " does not equal " + cityName.getString("name");
                JSONSuccess = false;
                return;
            }
            JSONObject coord = o.getJSONObject("coord");
            setLatLng(new LatLng(coord.getString("lat"), coord.getString("lon")));

            JSONArray list = o.getJSONArray("list");
            JSONObject main = list.getJSONObject(0).getJSONObject("main");

            setTemp(main.getString("temp"));
            JSONSuccess = true;
        }catch(JSONException j){
            errorText = "ERROR! JSONException: " + j.getMessage();
            JSONSuccess = false;
        }
    }

}
