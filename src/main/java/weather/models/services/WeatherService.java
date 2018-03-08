package weather.models.services;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import weather.models.Utils;
import weather.models.WeatherModel;



public class WeatherService {
    private static WeatherService ourInstance = new WeatherService();

    public static WeatherService getInstance() {
        return ourInstance;
    }

     private WeatherService() {
     }

     public void getWeather(final String city) throws JSONException {
            String websiteResponse = Utils.readWebsiteContent("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=b874d92729c25067bab28bf23ee81698");
            String description = null;
            int temperature;
            int pressure;
            int humidity;
            int clouds;

            JSONObject root = null;
                root = new JSONObject(websiteResponse);
            JSONArray weatherObject = null;
                weatherObject = root.getJSONArray("weather");
            for (int i = 0; i < weatherObject.length(); i++) {
                JSONObject elementInArray = null;
                    elementInArray = weatherObject.getJSONObject(i);
                    description = elementInArray.getString("main");
            }

            JSONObject mainObject = null;
                mainObject = root.getJSONObject("main");
                temperature = (int) mainObject.getInt("temp");
                pressure = mainObject.getInt("pressure");
                humidity = mainObject.getInt("humidity");

            JSONObject cloudsObject = null;

            cloudsObject = root.getJSONObject("clouds");


            clouds = cloudsObject.getInt("all");

            WeatherModel weatherModel = new WeatherModel.Builder(city)
                    .setWeatherComment(description)
                    .setClouds(clouds)
                    .setPressure(pressure)
                    .setTemperature(temperature)
                    .setHumidity(humidity)
                    .build();
         System.out.println(weatherModel);

        }
    }