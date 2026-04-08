package refactoring_guru.bridge.remotes;

import refactoring_guru.bridge.devices.Device;
import refactoring_guru.bridge.devices.SmartTv;

public class SmartRemote extends AdvancedRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl(String command) {
        System.out.println("SmartRemote voice command: " + command);
    }

    public void browseWeb(String website) {
        if (device instanceof SmartTv) {
            ((SmartTv) device).browseInternet(website);
        } else {
            System.out.println("Connected device does not support web browsing.");
        }
    }

    public void openStreamingApp(String appName) {
        if (device instanceof SmartTv) {
            ((SmartTv) device).openApp(appName);
        } else {
            System.out.println("Connected device does not support apps.");
        }
    }
}