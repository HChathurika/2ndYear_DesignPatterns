package refactoring_guru.bridge.devices;

public class SmartTv implements Device {
    private boolean on = false;
    private int volume = 40;
    private int channel = 1;
    private String currentApp = "Home";

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        if (percent > 100) {
            volume = 100;
        } else if (percent < 0) {
            volume = 0;
        } else {
            volume = percent;
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void browseInternet(String website) {
        if (on) {
            System.out.println("SmartTV is browsing: " + website);
        } else {
            System.out.println("SmartTV is off. Turn it on first.");
        }
    }

    public void openApp(String appName) {
        if (on) {
            currentApp = appName;
            System.out.println("SmartTV opened app: " + appName);
        } else {
            System.out.println("SmartTV is off. Turn it on first.");
        }
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm Smart TV.");
        System.out.println("| I'm " + (on ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("| Current app is " + currentApp);
        System.out.println("------------------------------------\n");
    }
}