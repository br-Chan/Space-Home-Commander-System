import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import commands.Command;
import devices.Device;
import exceptions.DeviceNotFoundException;

/**
 * Main system that houses the network (graph of devices) and acts as the
 * invoker of device Commands with a queue and history.
 */
public class SpaceHomeCommanderSystem {
    private Graph<Device> network;
    private Stack<Command> commandHistory;
    private Queue<Command> commandQueue;

    public SpaceHomeCommanderSystem() {
        network = new Graph<>();
        commandHistory = new Stack<>();
        commandQueue = new LinkedList<>();
    }

    public Stack<Command> getCommandHistory() {
        return commandHistory;
    }

    public Queue<Command> getCommandQueue() {
        return commandQueue;
    }

    /**
     * Finds the device with matching name in the graph.
     *
     * @param name name of the device to search for.
     * @return device with matching name.
     * @throws DeviceNotFoundException if the device with that name couldn't be found.
     */
    public Device getDeviceByName(String name) throws DeviceNotFoundException {
        for (Device key : network.adjacencyMap.keySet()) {
            if (key.getName().equals(name)) return key;
        }

        throw new DeviceNotFoundException(name);
    }

    public void addDevice(String name) {
        network.addNode(new Device(name));
        System.out.println(name + " added!");
    }

    public void connectDevices(String name1, String name2) {
        Device device1 = null;
        Device device2 = null;
        try {
            device1 = getDeviceByName(name1);
            device2 = getDeviceByName(name2);
        } catch (DeviceNotFoundException e) {
            System.out.println("Error: " + e.getMessage() + ", cancelling connect request.");
            return;
        }
    
        network.addEdge(device1, device2);
        System.out.println(device1.getName() + " and " + device2.getName() + " connected!");

    }

    public void addCommand(Command command) {
        commandQueue.add(command);
        System.out.println("Command added!");
    }

    // TODO: could make addCommand(String deviceName String commandName)
    // then can remove try-catch in Main class because they're here instead

    // TODO: could add functionality where all connected devices turn on

    public void executeCommand(Command command) {
        System.out.print("Exec: ");
        command.execute();
        commandHistory.push(command);
    }

    public void executeFirst() {
        executeCommand(commandQueue.poll());
    }

    public void executeAll() {
        System.out.println("EXEC: entire queue...");

        while(!commandQueue.isEmpty()) {
            executeFirst();
        }
    }

    public void undoLast() {
        System.out.print("Undo: ");
        Command command = commandHistory.pop();
        command.undo();
    }

}
