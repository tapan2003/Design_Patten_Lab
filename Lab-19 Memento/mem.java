import java.util.*;

class OriginatorObject {
    private int temperature;
    private int volume;

    public OriginatorObject(int t, int v) {
        temperature = t;
        volume = v;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temparature) {
        this.temperature = temparature;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public MementoObject saveObjectState() {
        return new MementoObject(temperature, volume);
    }

    public void restoreObjectState(MementoObject m) {
        temperature = m.getTemperature();
        volume = m.getVolume();
    }

    public void operateMachine() {
        System.out.println("Machine operating with temperature: " + temperature + " and volume: " + volume);
    }

}

class MementoObject {
    private int temperature;
    private int volume;

    public MementoObject(int t, int v) {
        temperature = t;
        volume = v;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getVolume() {
        return volume;
    }
    // only getter method and no setter as now we cannot edit
}

class CaretakerObject {
    List<MementoObject> lm = new ArrayList<MementoObject>();

    public void addMementoObject(MementoObject m) {
        lm.add(m);
    }

    public MementoObject getMementoObject(int i) {
        return lm.get(i);
    }
}

public class mem {
    public static void main(String[] args) {
        OriginatorObject o1 = new OriginatorObject(20, 10);

        // save the state of the originator object
        MementoObject m1 = o1.saveObjectState();

        // add the memento objects to the caretaker
        CaretakerObject caretaker = new CaretakerObject();
        caretaker.addMementoObject(m1);

        // change the state of the originator object
        o1.setTemperature(30);
        o1.setVolume(20);
        o1.operateMachine();

        // restore the state of the originator object to the first saved state
        o1.restoreObjectState(caretaker.getMementoObject(0));
        o1.operateMachine();

        o1.setTemperature(50);
        o1.setVolume(80);
        o1.operateMachine();

        o1.restoreObjectState(caretaker.getMementoObject(0));
        o1.operateMachine();

        o1.setTemperature(90);
        o1.setVolume(60);
        o1.operateMachine();

        o1.restoreObjectState(caretaker.getMementoObject(0));
        o1.operateMachine();
    }
}

// generally after this we call business methods of the class
// called operateMachine
// store the required state using saveObjectState() which gives a memento
// store the memento in caretaker
// change the state of machine using getter and setter methods like 3 times
// then try to restore the memento initial state using getMementoObject of
// caretaker and then send it to restoreObjectState of Originator