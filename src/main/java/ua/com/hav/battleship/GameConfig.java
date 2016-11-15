package ua.com.hav.battleship;

import java.util.Arrays;

public class GameConfig {
    public final static int DEFAULT_FIELD_SIZE = 10;
    public final static int[][] DEFAULT_FLEET_CONFIG = {{4, 1}, {3, 2}, {2, 3}, {1, 4}}; // {decks, qty}...
    private static int FIELD_SIZE;
    private static int[][] FLEET_CONFIG;

    public static int getFieldSize() {
        return FIELD_SIZE;
    }

    public static void setDefaultFieldSize() {
        if (FIELD_SIZE == 0) {
            FIELD_SIZE = DEFAULT_FIELD_SIZE;
        }
    }

    public static void setFieldSize(int size) {
        if (FIELD_SIZE == 0) {
            FIELD_SIZE = size;
        }
    }

    public static int[][] getFleetConfig() {
        return FLEET_CONFIG;
    }

    public static void setFleetConfig(int[][] fleetConfig) {
        if (FLEET_CONFIG == null) {
            FLEET_CONFIG = fleetConfig;
        }
    }

    public static void setDefaultFleetConfig() {
        if (FLEET_CONFIG == null) {
            FLEET_CONFIG = DEFAULT_FLEET_CONFIG;
        }
//        System.out.println("FLEET CONFIG=" + Arrays.deepToString(FLEET_CONFIG));
    }
    public static int getFleetSize() {
        int size = 0;
        for (int i = 0; i < FLEET_CONFIG.length; i++) {
            size += FLEET_CONFIG[i][1];
        }
        return size;
    }
}
