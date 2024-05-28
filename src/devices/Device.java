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

    @Override
    public String toString() {
        String onOrOff = isOn ? "on" : "off";
        return name + " (" + onOrOff + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Device other = (Device) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    

}
