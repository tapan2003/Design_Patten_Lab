import java.util.ResourceBundle.Control;

class ProductModelEntity {
    int id;
    int price;
    String name;

    public ProductModelEntity(int id, int p, String n) {
        this.id = id;
        price = p;
        name = n;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price - 10;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class ViewEntity {
    public void printProductDetails(int id, String n, int price) {
        System.out.println("Product Details: id: " + id + ", Name: " + n + " and Price: " + price);
    }
}

class ControllerEntity {
    ProductModelEntity pe;
    ViewEntity ve;

    public ControllerEntity(ProductModelEntity pe, ViewEntity ve) {
        this.pe = pe;
        this.ve = ve;
    }

    public void setName(String name) {
        pe.setName(name);
    }

    public void setPrice(int price) {
        pe.setPrice(price);
    }

    public void updateProductView() {
        ve.printProductDetails(pe.getId(), pe.getName(), pe.getPrice());
    }
}

public class mvc {
    public static void main(String[] args) {
        ProductModelEntity p1 = new ProductModelEntity(101, 300, "PR1");
        ViewEntity ve = new ViewEntity();

        ve.printProductDetails(p1.getId(), p1.getName(), p1.getPrice());

        ControllerEntity ce = new ControllerEntity(p1, ve);

        ce.setName("PR-New");
        ce.setPrice(400);

        ce.updateProductView();
    }
}