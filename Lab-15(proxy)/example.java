interface EmployeeDao {
    public void create(String client, EmployeeDao obj) throws Exception;

    public void delete(String client, int employeeID) throws Exception;

    public EmployeeDo get(String client, int employeeID) throws Exception;
}

class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void create(String client, EmployeeDo obj) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("New row created");

    }

    @Override
    public void delete(String client, int employeeID) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("deleted row with employeeid: " + employeeID);
    }

    @Override
    public EmployeeDo get(String client, int employeeID) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("Fetching data from DB");
        return new EmployeeDo();
    }

}

class EmployeeDaoProxy implements EmployeeDao {
    EmployeeDao employeeDaoObj;

    EmployeeDaoProxy() {
        employeeDaoObj = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, EmployeeDo obj) throws Exception {
        // TODO Auto-generated method stub
        if (client.equals("Admin")) {
            employeeDaoObj.create(client, obj);
            return;
        }
        throw new Exception("Access denied");
    }

    @Override
    public void delete(String client, int employeeID) throws Exception {
        // TODO Auto-generated method stub
        if (client.equals("Admin")) {
            employeeDaoObj.delete(client, employeeID);
            return;
        }
        throw new Exception("Access denied");
    }

    @Override
    public EmployeeDo get(String client, int employeeID) throws Exception {
        // TODO Auto-generated method stub
        if (client.equals("Admin") || client.equals("User")) {
            return employeeDaoObj.get(client, employeeID);
        }
        throw new Exception("Access denied");
    }
}

public class example {
    public static void main(String[] args) {
        try {
            EmployeeDao emp = new EmployeeDaoProxy();
            emp.create("User", new EmployeeDo());
            System.out.println("successfull");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}