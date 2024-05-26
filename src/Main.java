import exceptions.DeviceAlreadyOnException;
import exceptions.DeviceNotFoundException;

public class Main {
    public static void main(String[] args) {
        SmartHomeAutomationSystem system = new SmartHomeAutomationSystem();

        system.addDevice("Light");
        system.addDevice("Fan");
        system.addDevice("Heater");
        system.addDevice("AC");

        try {
            system.connectDevices("Light", "Fan");
            system.connectDevices("Fan", "Heater");
            system.connectDevices("Heater", "AC");

            system.turnOnDevice("Light");
            system.turnOnDevice("Fan");
            system.undoLastCommand();
            system.turnOffDevice("Light");

            System.out.println("BFS traversal from Light:");
            system.showBFS("Light");

            System.out.println("DFS traversal from Light:");
            system.showDFS("Light");

        } catch (DeviceNotFoundException | DeviceAlreadyOnException e) {
            System.out.println(e.getMessage());
        }
    }
}