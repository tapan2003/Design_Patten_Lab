class HardwareEngineer {

    private ComputerBuilder compBuilder;

    public void setCompBuilder(ComputerBuilder compBuilder) {
        this.compBuilder = compBuilder;
    }

    public ComputerBuilder getCompBuilder() {
        return compBuilder;
    }

    public void constructComputer() {
        compBuilder.createNewComputer();
        compBuilder.configureHDD();
        compBuilder.configureRAM_Size();
        compBuilder.configureProcessor();
        compBuilder.configureMoitor();
        compBuilder.configureOs();
        compBuilder.configureDeviceDriver();
    }

}

class Computer {
    private int HDD;
    private int RAM_Size;

    private String processor_make;
    private String processor_type;
    private float monitorSize;
    private String monitorType;
    private String OsConfig;

    private String deviceDriver;

    public int getHDD() {
        return HDD;
    }

    public void setHDD(int hDD) {
        HDD = hDD;
    }

    public int getRAM_Size() {
        return RAM_Size;
    }

    public void setRAM_Size(int rAM_Size) {
        RAM_Size = rAM_Size;
    }

    public String getProcessor_make() {
        return processor_make;
    }

    public void setProcessor_make(String processor_make) {
        this.processor_make = processor_make;
    }

    public String getProcessor_type() {
        return processor_type;
    }

    public void setProcessor_type(String processor_type) {
        this.processor_type = processor_type;
    }

    public float getMonitorSize() {
        return monitorSize;
    }

    public void setMonitorSize(float monitorSize) {
        this.monitorSize = monitorSize;
    }

    public String getMonitorType() {

        return monitorType;

    }

    public void setMonitorType(String monitorType) {
        this.monitorType = monitorType;
    }

    public String getOsConfig() {
        return OsConfig;
    }

    public void setOsConfig(String osConfig) {
        OsConfig = osConfig;
    }

    public String getDeviceDriver() {
        return deviceDriver;
    }

    public void setDeviceDriver(String deviceDriver) {
        this.deviceDriver = deviceDriver;
    }

    @Override

    public String toString() {

        return "Computer Details:\nHDD: " + HDD + "\nRAM Size: " + RAM_Size + "\nProcessor: " + processor_make + " "
                + processor_type + "\nMonitor: " + monitorSize + " " + monitorType + "\nOS Config: " + OsConfig
                + "\nDevice Drivers: " + deviceDriver;
    }

}

abstract class ComputerBuilder {
    protected Computer comp;

    public Computer getComp() {
        return comp;

    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    public void createNewComputer() {
        comp = new Computer();

    }

    public void configureHDD() {
    };

    public void configureRAM_Size() {
    };

    public void configureProcessor() {
    };

    public void configureMoitor() {
    };

    public void configureOs() {
    };

    public void configureDeviceDriver() {
    };

}

class PersonalComputerBuilder extends ComputerBuilder {
    PersonalComputerBuilder() {
        super.setComp(new Computer());

    }

    @Override

    public void configureHDD() {
        comp.setHDD(500);
    }

    @Override

    public void configureRAM_Size() {
        comp.setRAM_Size(16);
    }

    @Override

    public void configureProcessor() {
        comp.setProcessor_make("AMD");
        comp.setProcessor_type("QuadCore");
    }

    @Override

    public void configureMoitor() {
        comp.setMonitorSize(14);
        comp.setMonitorType("LCD");
    }

    @Override

    public void configureOs() {

        comp.setOsConfig("Windows");

    }

    @Override

    public void configureDeviceDriver() {
        comp.setDeviceDriver("All drivers up-to-date");
    }

}

class ServerComputerBuilder extends ComputerBuilder {
    ServerComputerBuilder() {
        // this.setComp(new Computer()); createNewComputer();
    }

    @Override

    public void configureHDD() {
        comp.setHDD(1000);
    }

    @Override

    public void configureRAM_Size() {
        comp.setRAM_Size(64);
    }

    @Override

    public void configureProcessor() {
        comp.setProcessor_make("Intel");
        comp.setProcessor_type("OctaCore");
    }

    @Override

    public void configureMoitor() {
        comp.setMonitorSize(32);
        comp.setMonitorType("LED");
    }

    @Override

    public void configureOs() {
        comp.setOsConfig("UNIX");
    }

    @Override

    public void configureDeviceDriver() {
        comp.setDeviceDriver("All drivers up-to-date");
    }

}

public class comp {

    public static void main(String[] args) {

        HardwareEngineer hardwareEngineer = new HardwareEngineer();

        // instantiate each concrete builder (take orders)
        ComputerBuilder pcBuilder = new PersonalComputerBuilder();
        ComputerBuilder serverBuilder = new ServerComputerBuilder();

        // build a PC
        hardwareEngineer.setCompBuilder(pcBuilder);
        hardwareEngineer.constructComputer();
        Computer pc = pcBuilder.getComp();
        System.out.println(pc);
    }

}
