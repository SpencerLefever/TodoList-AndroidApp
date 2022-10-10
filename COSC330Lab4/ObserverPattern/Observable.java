/**
 * Spencer Lefever
 * COSC330 Lab4 Observer Pattern
 * 
 * Observable class implementation
 * using the observer pattern
 */

interface Observable {

    public void addObserver(Observer o);

    public void deleteObserver(Observer o); 

    public void notfifyObserver();
}