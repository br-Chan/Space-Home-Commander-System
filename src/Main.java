import exceptions.EmptyNameException;
import commands.TurnOffCommand;
import commands.TurnOnCommand;
import exceptions.DeviceNotFoundException;

public class Main {
    public static void main(String[] args) {
        SpaceHomeCommanderSystem system = new SpaceHomeCommanderSystem();

        System.out.println("===ADDING_DEVICES===");
        system.addDevice("Lamp");
        system.addDevice("MeteorShield");
        system.addDevice("NanoCoolant");
        system.addDevice("AC");

        System.out.println("===CONNECTING_DEVICES===");
        system.connectDevices("Lamp", "MeteorShield");
        system.connectDevices("MeteorShield", "NanoCoolant");
        system.connectDevices("NanoCoolant", "PeanutBar");

        System.out.println("===ADDING_EXECUTING_COMMANDS===");
        try {
            system.addCommand(new TurnOnCommand(system.getDeviceByName("Lamp")));
        } catch (DeviceNotFoundException e) {
            System.out.println(e.getMessage() + ", command not executed.");
        }

        try {
            system.executeCommand(new TurnOnCommand(system.getDeviceByName("MeteorShield")));
        } catch (DeviceNotFoundException e) {
            System.out.println(e.getMessage() + ", command not executed.");
        }

        system.undoLast();

        try {
            system.addCommand(new TurnOffCommand(system.getDeviceByName("Lampe")));
        } catch (DeviceNotFoundException e) {
            System.out.println(e.getMessage() + ", command not executed.");
        }

        system.executeAll();

            // System.out.println("BFS traversal from Light:");
            // system.showBFS("Light");

            // System.out.println("DFS traversal from Light:");
            // system.showDFS("Light");

        // } catch (EmptyNameException e) {
        //     System.out.println(e.getMessage());
        // }
    }
}