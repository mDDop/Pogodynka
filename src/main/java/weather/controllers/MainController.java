package weather.controllers;

import org.json.JSONException;
import weather.models.WeatherModel;
import weather.models.services.WeatherService;
import weather.views.MainMenu;

public class MainController{
    private WeatherService weatherService = WeatherService.getInstance();
    private MainMenu mainMenu;

    public MainController(){
        mainMenu = new MainMenu();
    }

    public void run() throws JSONException {

        String response;
        do{
            response = mainMenu.getCityFromUser();
            weatherService.getWeather(response);
        }while (!response.equals("exit"));

    }

    public void onWeatherComing(WeatherModel weatherModel) {
        mainMenu.sendMessageToConsole(weatherModel.toString());
        mainMenu.cleanConsole(1);
    }
}
