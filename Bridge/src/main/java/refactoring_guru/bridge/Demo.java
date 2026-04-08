package refactoring_guru.bridge;

import refactoring_guru.bridge.devices.Device;
import refactoring_guru.bridge.devices.Radio;
import refactoring_guru.bridge.devices.SmartTv;
import refactoring_guru.bridge.devices.Tv;
import refactoring_guru.bridge.remotes.AdvancedRemote;
import refactoring_guru.bridge.remotes.BasicRemote;
import refactoring_guru.bridge.remotes.SmartRemote;

public class Demo {

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }

    public static void main(String[] args) {
        System.out.println("Testing TV with existing remotes");
        testDevice(new Tv());

        System.out.println("Testing Radio with existing remotes");
        testDevice(new Radio());

        System.out.println("Testing SmartTV with SmartRemote");
        SmartTv smartTv = new SmartTv();
        SmartRemote smartRemote = new SmartRemote(smartTv);

        smartRemote.power();
        smartRemote.volumeUp();
        smartRemote.channelUp();
        smartRemote.openStreamingApp("YouTube");
        smartRemote.browseWeb("https://refactoring.guru");
        smartRemote.voiceControl("Play music");
        smartTv.printStatus();
    }
}