package ua.com.hav.battleship;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<AbstractShip> ships;

    public Fleet() {
//        System.out.println("new Fleet");
        ships = new ArrayList<AbstractShip>();
        int[][] config = GameConfig.getFleetConfig();
//        System.out.println("config=" + Arrays.deepToString(config));
        for (int i = 0; i < config.length; i++) {
            for (int j = 0; j < config[i][1]; j++) {
//                System.out.println(i + " " + j + " " + config[i][0]);
                ships.add(new Ship(config[i][0]));
            }

        }
//        System.out.println("new Fleet created");
    }

    public int getFleetSize() {
        return ships.size();
    }

    public AbstractShip getShip(int n) {
        return ships.get(n);
    }


    public int getAliveDecks() {
        int cnt = 0;
        for (AbstractShip ship : ships) {
            cnt += ship.getAliveDecks();
        }
        return cnt;
    }
}
