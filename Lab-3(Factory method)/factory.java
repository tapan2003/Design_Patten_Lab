import java.util.Scanner;

interface Vehicle {

    float getFixedCharge();

    float getPerKmCharge();

    float getFare(float km);
}

class Auto implements Vehicle {
    @Override
    public float getFixedCharge() {
        return 50;
    }

    @Override

    public float getPerKmCharge() {
        return 10;
    }

    @Override

    public float getFare(float km) {

        return this.getFixedCharge() + (km * this.getPerKmCharge());

    }

}

class Car implements Vehicle {

    @Override

    public float getFixedCharge() {
        return 100;
    }

    @Override

    public float getPerKmCharge() {
        return 15;
    }

    @Override

    public float getFare(float km) {

        return this.getFixedCharge() + (km * this.getPerKmCharge());

    }

}

class VehicleFactory {

    public Vehicle creatVehicle(String v) {
        switch (v) {
            case ("car"):

                return new Car();
            case ("auto"):
                return new Auto();
            default:
                return null;

        }

        // return null;

    }

}

public class factory {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VehicleFactory vf = new VehicleFactory();
        System.out.println("Which vehicle you would prefer [car,auto]");
        String s = sc.next();
        Vehicle v1 = vf.creatVehicle(s);
        System.out.println("Fixed charge: " + v1.getFixedCharge());
        System.out.println("Per km charge: " + v1.getPerKmCharge());
        System.out.print("\nTotal meter reading(kms travelled): ");
        float km = sc.nextFloat();
        System.out.println("Total Fare: " + v1.getFare(km));

    }

}
