import java.util.ArrayList;
import java.util.List;

/*Implement File Management System as Composite Structure Patter.
  File -- FileComponent
  Composite(Container) -- Directory(Folder)
  Component -- describeComponenet()
               getsize()
 */
abstract class Component {
    protected String name;
    protected float size;

    public Component(String n) {
        name = n;
    }

    public abstract void describeComponent();

    public abstract float getSize();
}

class File extends Component {
    File(String name, float size) {
        super(name);
        this.size = size;
    }

    public File(String n) {
        super(n);
    }

    @Override
    public void describeComponent() {
        System.out.println(name);
    }

    @Override
    public float getSize() {
        return this.size;
    }

}

class Folder extends Component {
    List<Component> ls = new ArrayList<Component>();

    public Folder(String n) {
        super(n);
    }

    public void addComponent(Component c) {
        ls.add(c);
    }

    public void removeComponent(Component c) {
        ls.remove(c);
    }

    @Override
    public void describeComponent() {
        System.out.println(name);
        for (Component c : ls) {
            c.describeComponent();
        }
    }

    @Override
    public float getSize() {
        this.size = 0;
        for (Component c : ls) {
            this.size += c.getSize();
        }
        return size;
    }

}

public class filem {
    public static void main(String[] args) {
        Component f3 = new File("tapan1.txt", 30);
        Component f4 = new File("tapan2.txt", 30);
        Component f5 = new File("madhuram.txt", 30);
        Component f1 = new File("om1.txt", 30);
        Component f2 = new File("om2.txt", 30);
        Component f6 = new File("vandit.txt", 30);
        Folder folder2 = new Folder("Tapan");

        Folder folder0 = new Folder("B205");
        Folder folder3 = new Folder("Madhuram");
        Folder folder1 = new Folder("Om");
        Folder folder4 = new Folder("Vandit");

        folder0.addComponent(folder1);
        folder0.addComponent(folder2);
        folder0.addComponent(folder3);
        folder0.addComponent(folder4);

        folder1.addComponent(f1);
        folder1.addComponent(f2);
        folder2.addComponent(f3);
        folder2.addComponent(f4);
        folder3.addComponent(f5);
        folder4.addComponent(f6);

        f1.describeComponent();
        System.out.println(f1.getSize());
        System.out.println();
        folder0.describeComponent();
        System.out.println(folder0.getSize());
        System.out.println();
        folder1.describeComponent();
        System.out.println(folder1.getSize());

    }
}
