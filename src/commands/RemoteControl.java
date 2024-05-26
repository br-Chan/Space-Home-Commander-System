package commands;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RemoteControl {
    private Stack<Command> commandHistory;
    private Queue<Command> commandQueue;

    public RemoteControl() {
        commandHistory = new Stack<>();
        commandQueue = new LinkedList<>();
    }

    public Stack<Command> getCommandHistory() {
        return commandHistory;
    }

    public Queue<Command> getCommandQueue() {
        return commandQueue;
    }

    public void addCommand(Command command) {
        commandQueue.add(command);
    }

    public void executeAll() {
        while(!commandQueue.isEmpty()) {
            Command command = commandQueue.poll();
            command.execute();
            commandHistory.add(command);
        }
    }

    



}
