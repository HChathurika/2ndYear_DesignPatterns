package weatherstation;

public class WindowDisplay implements Observer {

    private final String location;

    public WindowDisplay(String location) {
        this.location = location;
    }

    @Override
    public void update(int temperature) {
        System.out.println("🪟 Window (" + location + "): " + temperature + "°C");
    }
}
