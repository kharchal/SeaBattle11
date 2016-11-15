package ua.com.hav.seabattle;

import org.apache.log4j.Logger;

public class Game {
    private final static Logger logger = Logger.getLogger(Game.class);
    private Player player1;
    private Player player2;
    private Player winner;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        player1.setOpponent(player2);
        player2.setOpponent(player1);
    }

    public void play() {

        System.out.println("player1 = " + player1.field);
        System.out.println("player2 = " + player2.field);
        System.exit(7);

        logger.info("The game begins...");
        Player currentPlayer = ((Math.random() > 0.5) ? player1 : player2);
        while (!currentPlayer.isWinner()) {
            if (!currentPlayer.move()) {
                currentPlayer = currentPlayer.getOpponent();
            }
        }
        winner = currentPlayer;

    }

    public Player getWinner() {
        return winner;
    }
}
