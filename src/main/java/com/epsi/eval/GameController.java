package com.epsi.eval;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/game")
public class GameController {

    private int gagné;
    private int perdu;
    private int égalité;

    private Random rand = new Random();

    @GetMapping("/play/{action}")
    public String playGame(@PathVariable String action) {
        String[] actions = { "pierre", "feuille", "ciseaux" };
        int computerActionIndex = rand.nextInt(3);
        String computerAction = actions[computerActionIndex];

        String result;
        if (action.equals(computerAction)) {
            result = "Égalité";
            égalité++;
        } else if ((action.equals("pierre") && computerAction.equals("ciseaux"))
                || (action.equals("feuille") && computerAction.equals("pierre"))
                || (action.equals("ciseaux") && computerAction.equals("feuille"))) {
            result = "Gagné";
            gagné++;
        } else {
            result = "Perdu";
            perdu++;
        }

        return "Vous avez joué " + action + ". L'ordinateur a joué " + computerAction + ". Vous avez " + result + ".";
    }

}
