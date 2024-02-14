import java.util.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class Customer {
    String custID, custName, custEmail, custCity;

    Customer(String custID, String custName, String custEmail, String custCity) {
        this.custID = custID;
        this.custName = custName;
        this.custEmail = custEmail;
        this.custCity = custCity;
    }

    @Override
    public String toString() {
        return "CustID: " + custID + "\tCustomerName: " + custName + "\tCustomerEmail: " + custEmail
                + "\tCustomerCity: " + custCity;
    }
}

interface CustormerServiceDatabase {
    public Customer getCustoemerDetails(String custID) throws Exception;
}

class CustomerService implements CustormerServiceDatabase { // client wants to access this
    @Override
    public Customer getCustoemerDetails(String custID) throws Exception {
        // Read the file customerinfo.txt
        // Search for thr custID if exist return Customer Details.
        // Else record not found
        // File file = new File("C:/Users/Nisarg/Nisarg/Nisarg1/Design Pattern
        // Lab/customerinfo.txt");
        FileReader fr = new FileReader("customerinfo.csv");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        int counter = 0;
        Customer c = null;
        while ((line = reader.readLine()) != null) {
            String words[] = line.strip().split(",");
            // System.out.println(Arrays.toString(words));
            if (custID.equals(words[0])) {
                // System.out.println(line);
                c = new Customer(words[0], words[1], words[2], words[3]);
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("CustID of customer not found.\n");
        }
        reader.close();
        return c;
    }
}

class CustomerServiceProxy implements CustormerServiceDatabase { // we give this to clients
    CustomerService cs = new CustomerService();

    @Override
    public Customer getCustoemerDetails(String custID) throws Exception {
        // Write activity or log
        // i.e. write user info to the logCustomerDatabase.txt->custID, Time, role
        // This is known as Logging Proxy
        // if user role is "Admin" then forward the request
        // else message "ACCESS IS DENIED"
        // This is known as Protection Proxy
        FileOutputStream write = new FileOutputStream("userlog.csv", true);
        OutputStreamWriter output = new OutputStreamWriter(write);
        BufferedWriter writer = new BufferedWriter(output);

        FileReader fr = new FileReader("userinfo.csv");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();

        Scanner sc = new Scanner(System.in);
        // String arr[] = new String[4];
        Customer c = null;
        System.out.print("UserId: ");
        String uid = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        String logentry[] = new String[3];
        logentry[0] = uid;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        logentry[1] = dtf.format(now);
        int counter = 0;
        while ((line = reader.readLine()) != null) {
            String words[] = line.strip().split(",");
            // System.out.println(Arrays.toString(words));
            if (uid.equals(words[0]) && pass.equals(words[2])) {
                logentry[2] = words[3];
                writer.newLine();
                writer.write(logentry[0] + "," + logentry[1] + "," + logentry[2]);
                writer.close();
                if (words[3].equalsIgnoreCase("Admin")) {
                    c = cs.getCustoemerDetails(custID);
                    return c;
                }
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("INVALID UserID and Password");
            return c;
        }
        System.out.println("ACCESS IS DENIED");
        return c;
    }

}
// class ClientProxyPattern{

// }
public class prox {
    public static void main(String[] args) throws Exception {
        CustomerServiceProxy cs = new CustomerServiceProxy();
        Customer c1 = cs.getCustoemerDetails("CUS101");
        System.out.println(c1);
    }
}
