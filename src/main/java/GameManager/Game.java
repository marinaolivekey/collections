package GameManager;

import Domain.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Game {
    private final HashMap<String, Player> names = new HashMap<>();

    public Player register(Player player) {
        names.put(player.getName(), player);
        return player;
    }
    public boolean findByName(String name) {
        return names.containsKey(name);
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == false) {
            throw new NotRegisteredException(
                    playerName1 + " You need to register first, dear!"
            );
        }
        if (findByName(playerName2) == false) {
            throw new NotRegisteredException(
                    playerName2 + " You need to register fist, dear!"
            );
        }

        if (names.get(playerName1).getStrength() > names.get(playerName2).getStrength()) {
            return 1;
        }
        if (names.get(playerName1).getStrength() < names.get(playerName2).getStrength()) {
            return 2;
        }
        return 0;
    }
}
