package designPatterns;

import designPatterns.adapterPattern.RoundHole;
import designPatterns.adapterPattern.RoundPeg;
import designPatterns.adapterPattern.SquarePeg;
import designPatterns.adapterPattern.SquarePegAdapter;
import designPatterns.observerPattern.CurrentConditionsDisplay;
import designPatterns.observerPattern.SomeRandomDisplay;
import designPatterns.observerPattern.WeatherData;

public class Application {
    public static void main(String[] args) {
        // Testing adapter pattern
//        RoundHole roundHole = new RoundHole(2);
//        System.out.println(roundHole.fits(new RoundPeg(3)));
//        System.out.println(roundHole.fits(new SquarePegAdapter(new SquarePeg(3))));

        // Testing obsever pattern
        WeatherData weatherData = new WeatherData(1,2,3);
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        SomeRandomDisplay someRandomDisplay = new SomeRandomDisplay(weatherData);
        
        currentConditionsDisplay.display();
        someRandomDisplay.display();
        weatherData.allMeasurementsChanged(5,6,7);
        currentConditionsDisplay.display();
        someRandomDisplay.display();
    }
}
