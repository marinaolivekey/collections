package GameManager;

import Domain.Player;
import GameManager.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

class GameTest {

    Player player1 = new Player(1, "kosta", 10);
    Player player2 = new Player(2, "petr", 20);
    Player player3 = new Player(3, "zhenya", 10);
    Player player4 = new Player(4, "mila", 30);
    Player player5 = new Player(5, "lena", 10);
    Player player6 = new Player(6, "olya", 45);

    @Test
    void register() {
        Game repo = new Game();

        Player expected = player1;
        Player actual = repo.register(player1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findByNameIfExist() {
        Game repo = new Game();
        repo.register(player1);
        repo.register(player2);

        boolean actual = repo.findByName("kosta");
        Assertions.assertEquals(true, actual);
    }

    @Test
    void findByNameIfNotExist() {
        Game repo = new Game();
        repo.register(player1);
        repo.register(player2);

        boolean actual = repo.findByName("kosta2");
        Assertions.assertEquals(false, actual);
    }

    @Test
    void roundIfPlayer1NotExist() {
        Game repo = new Game();

        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            repo.round("kosta2", "petr");
        });
    }

    @Test
    void roundIfPlayer2NotExist() {
        Game repo = new Game();

        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            repo.round("kosta", "petr2");
        });
    }

    @Test
    void roundIfPlayer1Wins() {
        Game repo = new Game();

        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);
        repo.register(player5);
        repo.register(player6);

        int expected = 1;
        int actual = repo.round("olya", "zhenya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundIfPlayer2Wins() {
        Game repo = new Game();

        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);
        repo.register(player5);
        repo.register(player6);

        int expected = 2;
        int actual = repo.round("lena", "petr");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundIfDraw() {
        Game repo = new Game();

        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);
        repo.register(player5);
        repo.register(player6);

        int expected = 0;
        int actual = repo.round("lena", "kosta");

        Assertions.assertEquals(expected, actual);
    }

}