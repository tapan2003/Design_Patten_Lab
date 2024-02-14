import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ContactDetails {
    protected long number;
    protected String email;

    ContactDetails(long number, String email) {
        this.number = number;
        this.email = email;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public String toString() {

        return "\nNumber: " + number + "\tEmail Id: " + email;

    }

}

class Owner {

    protected String Name;

    private ContactDetails Contact;

    Owner(String name, ContactDetails contact) {
        Name = name;
        Contact = contact;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ContactDetails getContact() {
        return Contact;
    }

    public void setContact(ContactDetails contact) {
        Contact = contact;

    }

    @Override

    public String toString() {

        return "\nName: " + Name + "\nContact Details: " + Contact;

    }

}

class House implements Cloneable {
    protected int house_id;
    protected double house_area;
    protected double price;
    static int count = 1;
    protected int house_No;
    protected Owner owner;

    public House clone() {
        House clone = null;
        try {
            clone = (House) super.clone();

            Owner o = new Owner(owner.getName(), owner.getContact());
            clone.setHouse_No(count++);
            clone.owner = o;

        }

        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;

    }

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public double getHouse_area() {
        return house_area;
    }

    public void setHouse_area(double house_area) {
        this.house_area = house_area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setHouse_No(int house_No) {
        this.house_No = house_No;
    }

    public int getHouse_No() {
        return house_No;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override

    public String toString() {

        return "\nHouse Details: " + "\nHouse ID: " + house_id + "\nHouse No.: " + house_No + "\nHouse Area: "
                + house_area + "\nHouse Price: " + price + owner;
    }

}

class TwoBHK extends House {
    int parkingCharges;

    TwoBHK() {
        house_id = 2;

        house_area = 700;
        house_No = count;
        price = 7000000;
        parkingCharges = 1500;

        owner = new Owner("Ram", new ContactDetails(909, "ram@gmail.com"));

    }

}

class ThreeBHK extends House {
    int furnitureCharges;

    ThreeBHK() {
        house_id = 3;

        house_area = 1100;
        house_No = count;
        price = 12000000;
        furnitureCharges = 20000;

        owner = new Owner("Ram", new ContactDetails(909, "ram@gmail.com"));

    }

}

class SampleHouse {

    private static Map<Integer, House> houseDictionary = new HashMap<Integer, House>();

    static {

        houseDictionary.put(2, new TwoBHK());
        houseDictionary.put(3, new ThreeBHK());
    }

    public static House getHouse(int id) {
        return houseDictionary.get(id).clone();

    }

}

public class housiedeep {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SampleHouse sh = new SampleHouse();
        House twoBHK1 = sh.getHouse(2);
        House twoBHK2 = sh.getHouse(2);
        House threeBHK1 = sh.getHouse(3);
        System.out.println(twoBHK1);
        System.out.println(twoBHK2);
        System.out.println(threeBHK1);

        twoBHK2.getOwner().setName("Nisarg");
        System.out.println(twoBHK1);
        System.out.println(twoBHK2);
        System.out.println(threeBHK1);

    }

}
