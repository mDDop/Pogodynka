package weather;

import org.json.JSONException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import weather.controllers.MainController;
import weather.models.WeatherModel;

@SpringBootApplication
public class Starter {
    public static void main(String[] args) throws JSONException {
        new MainController().run();
    }
}
