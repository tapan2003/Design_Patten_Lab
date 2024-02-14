import java.util.Scanner;

interface Mobile {
    String getUI();

    String unlockMobile();

    String charging();
}

class Samsung implements Mobile {
    @Override
    public String getUI() {
        return "One UI";
    }

    @Override

    public String unlockMobile() {

        return "Welcome to Samsung Galaxy";

    }

    @Override

    public String charging() {

        return "Samsung is fast charing";

    }

}

class Iphone implements Mobile {
    @Override
    public String getUI() {
        return "IOS";
    }

    @Override

    public String unlockMobile() {

        return "Namaste welcome to Apple";

    }

    @Override

    public String charging() {
        return "Iphone is charging";
    }

}

class MobileFactory {

    public Mobile creatMobile(String m) {
        switch (m.toLowerCase()) {
            case ("samsung"):

                return new Samsung();
            case ("iphone"):
                return new Iphone();
            default:
                return null;

        }

        // return null;

    }

}

public class factorym {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MobileFactory mf = new MobileFactory();
        System.out.println("Which mobile you'd like to buy: ");
        String s = sc.next();
        Mobile m1 = mf.creatMobile(s);
        System.out.println(m1.getUI());
        System.out.println(m1.unlockMobile());
        System.out.println(m1.charging());
    }

}
