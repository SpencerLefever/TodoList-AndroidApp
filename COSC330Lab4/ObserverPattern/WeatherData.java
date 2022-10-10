/**
 * Spencer Lefever
 * COSC330 Lab4 Observer Pattern
 * 
 * WeatherData class implementation
 * using the observer pattern
 */

 import java.util.ArrayList;

 public class WeatherData implements Observable {

    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    public void measurmentsChanged(float t, float h, float p) {
        
        this.temperature = t;
        this.humidity = h; 
        this.pressure = p;
        notfifyObserver();
    }


    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void deleteObserver(Observer o) {
        int i = observers.indexOf(o);
        if( i >= 0) {
            observers.remove(i);
        }
    }

    public void notfifyObserver() {
        for(Observer o : observers) {
            o.update(this.getTemperature(), this.getHumidity(), this.getPressure());
        }
    }



    //Setters and Getters
    public void setMeasurements(float t, float h, float p) {
        this.temperature = t;
        this.humidity = h;
        this.pressure = p;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }


 }
