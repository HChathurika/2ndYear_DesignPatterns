package weatherstation;

public class LoggerDisplay implements Observer {

    @Override
    public void update(int temperature) {
        System.out.println("📝 Logger recorded: " + temperature + "°C");
    }
}
