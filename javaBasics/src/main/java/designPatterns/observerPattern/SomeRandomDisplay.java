package designPatterns.observerPattern;

public class SomeRandomDisplay implements Observer{
    private int pressure;
    private final Subject weatherData;

    public SomeRandomDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
        update();
    }

    @Override
    public void update() {
        if(weatherData instanceof WeatherData){
            pressure = ((WeatherData) weatherData).getPressure();
        }
    }

    public void display() {
        System.out.println("Pressure Here is:"  + pressure);
    }
}
