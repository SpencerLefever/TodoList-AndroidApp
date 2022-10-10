/**
 * Spencer Lefever
 * COSC330 Lab4
 * 
 * Testing class for observer
 * pattern implementation
 */

 import java.lang.Math;

 public class ObserverTest {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        weatherData.setMeasurements(50, 50, 50);

        WeatherDataDisplay weatherDataDisplay = new WeatherDataDisplay(weatherData);

        //For loop to simulate changes to data
        for(int i=0; i<3; i++){
            float newTemp = weatherData.getTemperature() + (float)((-5) + Math.random()*(10));
            float newHumidity = weatherData.getHumidity() + (float)((-5) + Math.random()*(10));
            float newPressure = weatherData.getPressure() + (float)((-5) + Math.random()*(10));

            weatherData.measurmentsChanged(newTemp, newHumidity, newPressure);
        }
        
    }
 }