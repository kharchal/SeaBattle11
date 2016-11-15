package ua.com.hav.battleship;

public class Game {
    private Player currentPlayer;
    private Player opponentPlayer;

    public Game() {
        GameConfig.setDefaultFieldSize();
        GameConfig.setDefaultFleetConfig();
//        GameConfig.setFieldSize(5);
//        int[][] config = {{3, 1},{2, 1}};
//        GameConfig.setFleetConfig(config);
        currentPlayer = new Player();
        currentPlayer.setName("Human");
        currentPlayer.setHuman();
        opponentPlayer = new Player();
        opponentPlayer.setName("Comp");
    }

    public void play() {
        System.out.println("play");
        boolean gameOver = false;
        while (!(gameOver = gameOver())) {
//            System.out.println("game over = " + gameOver);
            System.out.println(currentPlayer);
            System.out.println(opponentPlayer);
            if (!currentPlayer.shut(opponentPlayer)) {
                rotatePlayers();
            }



        }
        System.out.println("The winner is: " + opponentPlayer);
    }

    private boolean gameOver() {
        return (currentPlayer.getAliveDecks() == 0) ? true : false;
    }

    private void rotatePlayers() {
        Player tmp = currentPlayer;
        currentPlayer = opponentPlayer;
        opponentPlayer = tmp;
    }

}
