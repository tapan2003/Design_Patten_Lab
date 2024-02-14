import java.util.*;

//find popular weapon among players
//right play area has which type of players
//approx memeory consumpution

class PlayerFlyWeight {
    String type;
    String colorCode;
    String task;

    public PlayerFlyWeight(String t, String c, String task) {
        System.out.println("PlayerFlyWeight created!!!");
        type = t;
        colorCode = c;
        this.task = task;
    }
}

class Player {

    PlayerFlyWeight pfw;
    String weapon;
    int x;
    int y;

    public Player(PlayerFlyWeight pf) {
        pfw = pf;
    }

    public Player(PlayerFlyWeight p, String weapon, int x, int y) {
        System.out.println("Player created with weapon: " + weapon);
        pfw = p;
        this.weapon = weapon;
        this.x = x;
        this.y = y;
    }

    public void spawnPlayer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class PlayerFactory {
    Map<String, PlayerFlyWeight> mp = new HashMap<String, PlayerFlyWeight>();
    PlayerFlyWeight pfw = null;

    public PlayerFlyWeight createPlayer(String type) {
        if (mp.containsKey(type))
            pfw = mp.get(type);
        else {
            if (type.equalsIgnoreCase("Counter Terrorist")) {
                pfw = new PlayerFlyWeight("Counter Terrorist", "Blue", "Defuse bomb!!!");
            } else if (type.equalsIgnoreCase("Terrorist")) {
                pfw = new PlayerFlyWeight("Terrorist", "Red", "Plant bomb!!!");
            } else {
                System.out.println("Player type not available!!!");
            }
            mp.put(type, pfw);
        }
        return pfw;
    }
}

public class csgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int n = sc.nextInt();
        PlayerFactory playerFactory = new PlayerFactory();

        Random random = new Random();
        // For loop for N times
        String[] types = { "Counter Terrorist", "Terrorist" };
        String[] weapons = { "Desert Eagle", "AK-47", "FAMAS", "M249", "M4A1-S" };
        int[] count = new int[weapons.length];
        String type, weapon;
        // TreeFlyWeight tfw;
        Player[] community = new Player[n];
        for (int i = 0; i < n; i++) {
            type = types[random.nextInt(types.length)];
            int ind = random.nextInt(weapons.length);
            weapon = weapons[ind];
            count[ind]++;
            community[i] = new Player(playerFactory.createPlayer(type), weapon, random.nextInt(-100, 100),
                    random.nextInt(-100, 100));
        }
        int max = count[0];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
                index = i;
            }
        }
        System.out.println();
        System.out.println("Most popular weapon: " + weapons[index]);
    }
}