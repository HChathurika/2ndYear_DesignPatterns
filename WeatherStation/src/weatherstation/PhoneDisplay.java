package weatherstation;

public class PhoneDisplay implements Observer {

    private final String owner;

    public PhoneDisplay(String owner) {
        this.owner = owner;
    }

    @Override
    public void update(int temperature) {
        System.out.println("📱 Phone (" + owner + "): " + temperature + "°C");
    }
}
