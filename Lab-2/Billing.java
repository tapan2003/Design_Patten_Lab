import java.util.Iterator;
import java.util.TreeSet;

class Shop {
    private String sName;
    private TreeSet<Product> product;

    public Shop(String sName) {
        this.sName = sName;
    }

    public void addProduct(Product p) {
        product.add(p);
    }

    public double generateBill(int n, Product[] product) {
        int total = 0;
        for (int i = 0; i < product.length; i++) {
            total += product[i].getPrice(n);
        }
        return total;
    }

    public void listOfProduct() {
        // Iterator<E> i = product.iterator();
        // while (i.hasNext()) {
        // Product p = (Product) i.next();
        // System.out.println(p);
        // }
    }

    // public TreeSet<Product> getProduct() {
    // return product;
    // }

    // public void setProduct(TreeSet<Product> product) {
    // this.product = product;
    // }

    // public String getsName() {
    // return sName;
    // }

    // public void setsName(String sName) {
    // this.sName = sName;
    // }
}

class Product implements Comparable {
    private String product_name;
    private int price;

    public Product(String product_name, int price) {
        this.product_name = product_name;
        this.price = price;
    }

    public String toString() {
        return "Name is: " + product_name + " and price is: " + price;
    }

    public int getPrice(int n) {
        return n * price;
    }

    public int compareTo(Object other) {
        Product p = (Product) other;
        return this.price = p.price;
    }

    // public String getName() {
    // return product_name;
    // }

    // public void setName(String product_name) {
    // this.product_name = product_name;
    // }

    // public int getPrice() {
    // return price;
    // }

    // public void setPrice(int price) {
    // this.price = price;
    // }
}

class oldProduct extends Product {
    oldProduct(String product_name, int price) {
        super(product_name, price);
    }

    // public void setPrice(int price) {
    // super.setPrice(price - price / 10);
    // }
}

class newProduct extends Product {
    newProduct(String product_name, int price) {
        super(product_name, price);
    }

    @Override
    public String toString() {
        return "No discount on new product";
    }
}

public class Billing {
    public static void main(String[] args) {
    }
}

// class -- Shop - name , product

// tree set --> comparator required (comparable interface)

// product -- old and new

// shop --
// sname -- string private
// product -- treeset private
// #

// generate Bill() -- double public
// listProducts -- void public

// product
// name -- string
// price int