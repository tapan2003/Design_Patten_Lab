import java.util.*;

class TreeFlyWeight {
    String type;
    String color;

    public TreeFlyWeight(String t, String c) {
        System.out.println("TreeFlyWeight Object created!!!");
        type = t;
        color = c;
    }
}

class Tree {

    TreeFlyWeight tf;
    int x;
    int y;

    public Tree(TreeFlyWeight t) {
        tf = t;
        // this.x = x;
        // this.y = y;
    }

    public Tree(TreeFlyWeight t, int x, int y) {
        tf = t;
        this.x = x;
        this.y = y;
        System.out.println("Tree Type - " + tf.type + " planted at X : " + x + " and Y : " + y);
    }

    public void plantTree(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Tree Type - " + tf.type + " planted at X : " + x + " and Y : " + y);
    }

}

class TreeFactory {

    Map<String, TreeFlyWeight> mp = new HashMap<String, TreeFlyWeight>();
    TreeFlyWeight tf = null;

    public TreeFlyWeight createTree(String type) {

        if (mp.containsKey(type))
            tf = mp.get(type);
        else {
            if (type.equalsIgnoreCase("Neem-Tree")) {
                tf = new TreeFlyWeight("Neem-Tree", "Green");
            } else if (type.equalsIgnoreCase("Oak-Tree"))
                tf = new TreeFlyWeight("Oak-Tree", "Orange");
            else
                System.out.println("Tree-Type not available!!");
            mp.put(type, tf);

        }
        return tf;
    }
}

class fly {
    public static void main(String[] args) {

        // for loop runs for n times in normal method
        // when n is less its ok but when n increases we may face issue
        // so we apply flyweight pattern
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of trees: ");
        int n = sc.nextInt();
        TreeFactory treeFactory = new TreeFactory();

        Random random = new Random();
        // For loop for N times
        String[] types = { "Oak-Tree", "Neem-Tree" };
        String type;
        // TreeFlyWeight tfw;
        Tree[] forest = new Tree[n];
        for (int i = 0; i < n; i++) {
            type = types[random.nextInt(types.length)];
            forest[i] = new Tree(treeFactory.createTree(type));
            forest[i].plantTree(random.nextInt(-100, 100), random.nextInt(-100, 100));
        }
    }
}
