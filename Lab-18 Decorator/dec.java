interface Pizza {
    public String getDescription();

    public double getCost();
}

class MargheritaPizza implements Pizza {
    public String getDescription() {
        return "Margherita Pizza";
    }

    public double getCost() {
        return 300;
    }
}

class SevenCheese implements Pizza {
    public String getDescription() {
        return "SevenCheese Pizza";
    }

    public double getCost() {
        return 350;
    }
}

abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription();
    }

    public double getCost() {
        return pizza.getCost();
    }
}

class ExtraCheese extends PizzaDecorator {
    public ExtraCheese(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + " + Extra Cheese";
    }

    public double getCost() {
        return pizza.getCost() + 30;
    }
}

class CheeseBurst extends PizzaDecorator {
    public CheeseBurst(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + " + CheeseBurst";
    }

    public double getCost() {
        return pizza.getCost() + 50;
    }
}

public class dec {
    public static void main(String args[]) {
        Pizza margherita = new MargheritaPizza();
        System.out.println(margherita.getDescription());
        System.out.println(margherita.getCost());

        margherita = new ExtraCheese(margherita);
        margherita = new CheeseBurst(margherita);

        System.out.println(margherita.getDescription());
        System.out.println(margherita.getCost());

        Pizza SevenCheese = new SevenCheese();
        SevenCheese = new ExtraCheese(SevenCheese);
        SevenCheese = new CheeseBurst(SevenCheese);

        System.out.println(SevenCheese.getDescription());
        System.out.println(SevenCheese.getCost());
    }

}