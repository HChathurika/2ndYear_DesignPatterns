package weatherstation;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class WeatherStation implements Runnable {

    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private final Random random = new Random();

    private int temperature;
    private final int minTemp = -10;
    private final int maxTemp = 35;

    public WeatherStation() {
        temperature = minTemp + random.nextInt(maxTemp - minTemp + 1);
        System.out.println("Initial temperature: " + temperature + "°C");
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    private void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }

    private void changeTemperature() {
        int change = random.nextBoolean() ? 1 : -1;
        temperature += change;

        if (temperature < minTemp) temperature = minTemp;
        if (temperature > maxTemp) temperature = maxTemp;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((1 + random.nextInt(5)) * 1000);
            } catch (InterruptedException e) {
                return;
            }

            changeTemperature();
            System.out.println("\nWeatherStation changed temperature to " + temperature + "°C");
            notifyObservers();
        }
    }
}
