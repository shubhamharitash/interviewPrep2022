package designPatterns.observerPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private int temperature;
    private int humidity;
    private int pressure;
    private boolean isStateChanged;
    private final List<Observer> observerList;

    public WeatherData(){
        observerList = new ArrayList<>();
        isStateChanged = false;
    }

    public WeatherData(int temperature, int humidity, int pressure) {
        this();
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        setStateChanged();
        notifyObserver();
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
        setStateChanged();
        notifyObserver();
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
        setStateChanged();
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        if(isStateChanged) {
            for (Observer observer : observerList) {
                observer.update();
            }
        }
        isStateChanged = false;
    }

    public void setStateChanged(){
        isStateChanged = true;
    }

    public void allMeasurementsChanged(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        setStateChanged();
        notifyObserver();
    }
}
