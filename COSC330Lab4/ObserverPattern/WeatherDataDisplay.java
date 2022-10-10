/**
 * Spencer Lefever
 * COSC330 Lab4 
 * 
 * Weather data display
 * implementing Observer interface
 */

 public class WeatherDataDisplay implements Observer {

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDataDisplay(WeatherData weatherData) {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        this.pressure = weatherData.getPressure();
        weatherData.addObserver(this);
    }

    
    public void update(float t, float h, float p) {
        this.temperature = t;
        this.humidity = h;
        this.pressure = p;
        display();
    }
    
    public void display() {
        System.out.println("\nTemperature: " + temperature + "\nHumidity: " + humidity + "\nPressure: \n" + pressure);
    }
 }