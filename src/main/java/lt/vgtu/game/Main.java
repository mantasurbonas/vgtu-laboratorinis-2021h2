package lt.vgtu.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        final List<Rocket> rockets = new ArrayList<>();
        rockets.add(new Rocket(3, 10, "wsad"));
        rockets.add(new Rocket(5, 12, "ikjl"));

        final Map map = new Map();

        final ConsoleRenderer renderer = new ConsoleRenderer(map, rockets);

        final GameRules gameRules = new GameRules(map, rockets);

        while (gameRules.isGameOver() == false) {
            renderer.render();

            int userCommand = System.in.read();

            gameRules.processUserCommand(userCommand);

            for (Rocket rocket : rockets)
                if (!gameRules.isOutofBounds(rocket, userCommand)) {
                    rocket.processUserCommand(userCommand);
                }
        }
    }

}
