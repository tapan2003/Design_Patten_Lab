import java.util.ArrayList;
import java.util.List;

class ContactDetails {
    private long number;
    private String email;

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
        return "Number: " + number + "Email Id: " + email;
    }
}

class Account {
    private String account_Holder;
    private int account_No;
    private ContactDetails contact;

    Account(String account_Holder, int account_No, ContactDetails contact) {
        this.account_Holder = account_Holder;
        this.account_No = account_No;
        this.contact = contact;
    }

    public void setaccount_Holder(String account_Holder) {
        this.account_Holder = account_Holder;
    }

    public String getaccount_Holder() {
        return account_Holder;
    }

    public void setaccount_No(int account_No) {
        this.account_No = account_No;
    }

    public int getaccount_No() {
        return account_No;
    }

    public void setContact(ContactDetails contact) {
        this.contact = contact;
    }

    public ContactDetails getContact() {
        return contact;
    }

    public String toString() {
        return "\nAccount Holder: " + account_Holder + " Account No.: " + account_No + " Contact Details-> " + contact;
    }
}

class Banker {
    // private final static SingletonInstace st = new SingletonInstance(); //eager
    // initialisation

    private static Banker b = null;
    private static List<Account> accounts = new ArrayList<Account>();
    static {
        b = new Banker();
    }

    private Banker() {
        System.out.println("Creating singleton instance of banker..");
    }

    public static Banker getInstance() {
        if (b == null)
            b = new Banker();

        return b;
    }

    public static void addAccounts(Account... accs) {
        for (Account i : accs) {
            accounts.add(i);
        }
    }

    public static List<Account> getAccounts() {
        return accounts;
    }
}

public class single2 {
    public static void main(String[] args) {
        Banker b1 = Banker.getInstance();
        Banker b2 = Banker.getInstance();

        // Same one object is assigned to both variables so both s1 and s2 must have the
        // same hashcode
        System.out.println("Instances : " + b1 + "\t" + b2);

    }
}