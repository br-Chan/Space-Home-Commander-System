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
        system.addDevice("BlastDoors");
        system.addDevice("AlienTranslator");
        system.addDevice("SmartWatch");

        System.out.println("===CONNECTING_DEVICES===");
        system.connectDevices("Lamp", "MeteorShield");
        system.connectDevices("Lamp", "BlastDoors");
        system.connectDevices("MeteorShield", "NanoCoolant");
        system.connectDevices("MeteorShield", "BlastDoors");
        system.connectDevices("NanoCoolant", "AC");
        system.connectDevices("SmartWatch", "AlienTranslator");
        system.connectDevices("SmartWatch", "BlastDoors");
        system.connectDevices("SmartWatch", "AC");
        system.connectDevices("SmartWatch", "MeteorShield");

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
            system.addCommand(new TurnOffCommand(system.getDeviceByName("Lamp")));
        } catch (DeviceNotFoundException e) {
            System.out.println(e.getMessage() + ", command not executed.");
        }

        system.executeAll();

        system.showBFS("Lamp");
        system.showDFS("Lamp");

        system.showBFS("SmartWatch");

        // } catch (EmptyNameException e) {
        //     System.out.println(e.getMessage());
        // }
    }
}