package weatherstation;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WeatherStation station = new WeatherStation();

        Observer phone = new PhoneDisplay("Bao");
        Observer window = new WindowDisplay("Kitchen");
        Observer logger = new LoggerDisplay();

        station.registerObserver(phone);
        station.registerObserver(window);
        station.registerObserver(logger);

        Thread t = new Thread(station);
        t.start();

        Thread.sleep(12000);

        System.out.println("\n=== Removing WindowDisplay ===");
        station.removeObserver(window);

        Thread.sleep(12000);
    }
}
