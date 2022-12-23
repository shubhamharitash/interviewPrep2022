package designPatterns.observerPattern;

public class CurrentConditionsDisplay implements Observer {
    private int temperature;
    private int humidity;
    private final Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
        update();
    }

    @Override
    public void update() {
        if(weatherData instanceof WeatherData){
            temperature = ((WeatherData) weatherData).getTemperature();
            humidity = ((WeatherData) weatherData).getHumidity();
        }
    }

    public void display() {
        System.out.printf("Current temperature is %d and humidity is %d", temperature, humidity);
    }
}
