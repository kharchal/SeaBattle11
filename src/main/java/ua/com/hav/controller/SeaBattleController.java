package ua.com.hav.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.hav.seabattle.Computer;
import ua.com.hav.seabattle.Game;
import ua.com.hav.seabattle.Player;

@Controller
@RequestMapping("/seabattle")
public class SeaBattleController {

    private Game game;
    private Player playerA;
    private Player playerB;
    private int shotAtX;
    private int shotAtY;
    private Player current;

    @RequestMapping(method = RequestMethod.GET)
    public String init() {
        System.out.println("init");
        playerA = new Computer("A player");
        playerB = new Computer("B player");
        game = new Game(playerA, playerB);
        current = playerB;
        return "menu";
    }

    @RequestMapping("/fields")
    public String field(Model model) {
//        System.out.println("playerA = " + playerA.getField().toString());
        model.addAttribute("playerA", playerA);
        model.addAttribute("playerB", playerB);
        model.addAttribute("x", shotAtX);
        model.addAttribute("y", shotAtY);

        return "fields";
    }

    @RequestMapping("/shot/{x}-{y}")
    public String shot(@PathVariable int x, @PathVariable int y, Model model) {
        System.out.println("shot is being done at: " + x + ", " + y);
        shotAtX = x;
        shotAtY = y;
        boolean b = current.move(x, y);
        System.out.println(current.getField());

        return "redirect:/seabattle/fields";
    }
}
