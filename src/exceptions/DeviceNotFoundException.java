package exceptions;

public class DeviceNotFoundException extends Exception {

    public DeviceNotFoundException(String name) {
        super("Device Not Found with name: " + name);
    }

}
