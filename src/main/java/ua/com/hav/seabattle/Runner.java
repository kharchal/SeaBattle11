package ua.com.hav.seabattle;

public class Runner {
    public static void main(String[] args) {
        Field field = new Field();
        field.init();
        Fleet fleet = new Fleet();
        field.plantFleet(fleet);
        System.out.println(field);

//        Game game = new Game(new Computer("Alex"), new Computer("Comp"));
//        game.play();
//        System.out.println("The winner is: " + game.getWinner());
    }
}
