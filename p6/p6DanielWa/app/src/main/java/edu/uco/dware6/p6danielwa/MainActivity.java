package edu.uco.dware6.p6danielwa;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends Activity {

    final String FORECAST_BASE_URL =
            "http://api.openweathermap.org/data/2.5/forecast/daily?";

    Button mapButton;

    TextView weatherDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.submit_button).setOnClickListener(v->{
            new WeatherRequest(((EditText)findViewById(R.id.city_name)).getText().toString());
        });

        mapButton = (Button)findViewById(R.id.map_button);
        weatherDisplay = (TextView)findViewById(R.id.weather_display);
    }

    private class WeatherRequest extends AsyncTask<City, Void, City> {

        private String baseUrl = null;
        public WeatherRequest(String url){
            baseUrl = url;
        }

        @Override
        protected City doInBackground(City... cities) {
            City c = cities[0];

            InputStream in = null;
            HttpURLConnection httpURLConnection = null;

            try{
                Uri builtUri = Uri.parse(baseUrl).buildUpon()
                        .appendQueryParameter("q", c.getName()+",us")
                        .appendQueryParameter("mode", "json")
                        .appendQueryParameter("units", "metric")
                        .appendQueryParameter("cnt", "1")
                        .appendQueryParameter("APPID", "d7512169aa5c42bba4c45bbb49be4a00")
                        .build();

                URL url = new URL(builtUri.toString());
                httpURLConnection = (HttpURLConnection) url.openConnection();
                in = new BufferedInputStream(httpURLConnection.getInputStream());
                String data = readStream(in);
                c.parseJSONData(data);

            }catch (MalformedURLException m){
                System.out.println("MalformedURLException: " + m.getMessage());
            }catch (IOException i){
                System.out.println("IOException: " + i.getMessage());
            }

            return c;
        }

        @Override
        protected void onPostExecute(City result) {
            if (!result.getJSONSuccess()) {
                Toast.makeText(MainActivity.this,
                        result.getErrorText(),
                        Toast.LENGTH_SHORT).show();
                return;
            }

            mapButton.setText(result.getName());
            mapButton.setClickable(true);

            weatherDisplay.setText(result.getWeatherInfo());


        }
    }

    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer data = new StringBuffer("");
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                data.append(line);
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data.toString();
    }

}
