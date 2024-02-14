import java.util.ArrayList;
import java.util.List;

abstract class Component {
    protected String name;
    protected int price;

    public Component(String n, int p) {
        name = n;
        price = p;
    }

    public abstract void describeComponent();

    public abstract void price();
}

class Leaf extends Component {
    public Leaf(String n, int p) {
        super(n, p);
    }

    public void describeComponent() {
        System.out.println(name);
    }

    public void price() {
        System.out.println(price);
    }

}

class Composite extends Component {
    List<Component> ls = new ArrayList<Component>();

    public Composite(String n, int p) {
        super(n, p);
    }

    public void addComponent(Component c) {
        ls.add(c);
    }

    public void removeComponent(Component c) {
        ls.remove(c);
    }

    public List componentList() {
        return ls;
    }

    public void describeComponent() {
        System.out.println(name);

        for (Component c : ls) {
            c.describeComponent();
        }
    }

    public void price() {
        System.out.println(price);

        for (Component c1 : ls) {
            c1.price();
        }
    }
}

public class comp {
    public static void main(String[] args) {
        Component l1 = new Leaf("HDD", 2000);
        Component l2 = new Leaf("RAM", 3000);
        Component l3 = new Leaf("CPU", 4000);
        Component l4 = new Leaf("Mouse", 2000);
        Component l5 = new Leaf("Keyboard", 3500);

        Composite c1 = new Composite("Computer", 50000);
        Composite c2 = new Composite("Cabinet", 15000);
        Composite c3 = new Composite("Peripheral", 25000);
        Composite c4 = new Composite("MotherBoard", 20000);

        c1.addComponent(c2);
        c1.addComponent(c3);

        c2.addComponent(l1);
        c2.addComponent(c4);

        c3.addComponent(l4);
        c3.addComponent(l5);

        c4.addComponent(l3);
        c4.addComponent(l2);

        l2.describeComponent();
        l2.price();
        c3.describeComponent();
        c3.price();
    }
}