import java.util.Scanner;

interface Chair {
    float chairPrice();

    String chairInfo();
}

interface Table {
    float tablePrice();

    String tableInfo();
}

interface Sofa {
    float sofaPrice();

    String sofaInfo();
}

class OfficeChair implements Chair {
    @Override
    public float chairPrice() {
        return 2000;
    }

    @Override
    public String chairInfo() {
        return "Office Rolling Chair";
    }
}

class homeChair implements Chair {
    @Override
    public float chairPrice() {
        return 2000;
    }

    @Override
    public String chairInfo() {
        return "Foldable Home Chair";
    }
}

class officeSofa implements Sofa {
    @Override
    public float sofaPrice() {
        return 10000;
    }

    @Override
    public String sofaInfo() {
        return "Office sofa";
    }
}

class homeSofa implements Sofa {
    @Override
    public float sofaPrice() {
        return 15000;
    }

    @Override
    public String sofaInfo() {
        return "Home sofa";
    }
}

class officeTable implements Table {
    @Override
    public float tablePrice() {
        return 5000;
    }

    @Override
    public String tableInfo() {
        return "Office Table";
    }
}

class homeTable implements Table {
    @Override
    public float tablePrice() {
        return 4000;
    }

    @Override
    public String tableInfo() {
        return "Dining Table";
    }
}

interface AbstractFurnitureFactory {
    Chair createChair();

    Sofa createSofa();

    Table createTable();
}

class OfficeFurniture implements AbstractFurnitureFactory {
    @Override
    public Chair createChair() {
        return new OfficeChair();
    }

    @Override
    public Sofa createSofa() {
        return new officeSofa();
    }

    @Override
    public Table createTable() {
        return new officeTable();
    }
}

class homeFurniture implements AbstractFurnitureFactory {
    @Override
    public Chair createChair() {
        return new homeChair();
    }

    @Override
    public Sofa createSofa() {
        return new homeSofa();
    }

    @Override
    public Table createTable() {
        return new homeTable();
    }

}

public class Lab4_FurnitureAbstractFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice for furnitures: [office,home]");
        String s = sc.next();
        AbstractFurnitureFactory aff;
        String f;
        switch (s.toLowerCase()) {
            case "office":
                aff = new OfficeFurniture();
                System.out.println("Enter your futniture to buy: [chair,sofa,table]");
                f = sc.next();
                switch (f.toLowerCase()) {
                    case "chair":
                        Chair ch = aff.createChair();
                        System.out.println("Price of chair: " + ch.chairPrice());
                        System.out.println(ch.chairInfo());
                        break;
                    case "sofa":
                        Sofa so = aff.createSofa();
                        System.out.println("Price of sofa: " + so.sofaPrice());
                        System.out.println(so.sofaInfo());
                        break;
                    case "table":
                        Table tb = aff.createTable();
                        System.out.println("Price of sofa: " + tb.tablePrice());
                        System.out.println(tb.tableInfo());
                        break;
                    default:
                        return;
                }
                break;

            case "home":
                aff = new homeFurniture();
                System.out.println("Enter your futniture to buy: [chair,sofa,table]");
                f = sc.next();
                switch (f.toLowerCase()) {
                    case "chair":
                        Chair ch = aff.createChair();
                        System.out.println("Price of chair: " + ch.chairPrice());
                        System.out.println(ch.chairInfo());
                        break;
                    case "sofa":
                        Sofa so = aff.createSofa();
                        System.out.println("Price of sofa: " + so.sofaPrice());
                        System.out.println(so.sofaInfo());
                        break;
                    case "table":
                        Table tb = aff.createTable();
                        System.out.println("Price of sofa: " + tb.tablePrice());
                        System.out.println(tb.tableInfo());
                        break;
                    default:
                        return;
                }
                break;

            default:
                return;
        }
    }
}
