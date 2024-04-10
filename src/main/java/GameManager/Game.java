package GameManager;

import Domain.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> names = new ArrayList<>();

    public List<Player> register(Player player) {
        names.add(player);
        return names;
    }

    public List<Player> findAll() {
        return names;
    }

    public Player findByName(String name) {
        for (Player player : names) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(
                    playerName1 + " You need to register first, dear!"
            );
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    playerName2 + " You need to register fist, dear!"
            );
        }

        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        }
        if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            return 2;
        }
        return 0;
    }
}
