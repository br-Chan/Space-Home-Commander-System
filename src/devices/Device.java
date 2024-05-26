package devices;

public class Device {
    private final String name;
    private boolean isOn;

    public Device(String name) {
        this.name = name;
        isOn = false;
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(name + " is on");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " is off");
    }

}
