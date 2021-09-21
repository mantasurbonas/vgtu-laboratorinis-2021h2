package lt.vgtu.game;

import java.util.List;

public class GameRules {

    private final List<Rocket> rockets;
    private final Map map;
    private boolean userPressedQuit = false;

    public GameRules(Map map, List<Rocket> rockets) {
        this.map = map;
        this.rockets = rockets;
    }

    public boolean hasHitAsteroid() {
        for (Rocket rocket : rockets)
            if (map.getElement(rocket.x, rocket.y) != 0 || map.getElement(rocket.x + 1, rocket.y) != 0)
                return true;

        return false;
    }

    public boolean isOutofBounds(Rocket rocket, int userCommand) {
        if (userCommand == rocket.getLeft() && rocket.x == 0)
            return true;
        else if (userCommand == rocket.getRight() && rocket.x == map.getWidth() - 2)
            return true;
        else if (userCommand == rocket.getUp() && rocket.y == 0)
            return true;
        else return userCommand == rocket.getDown() && rocket.y == map.getHeight() - 1;
    }

    public boolean isGameOver() {
        return hasHitAsteroid() || userPressedQuit;
    }

    public void processUserCommand(int userCommand) {
        if (userCommand == 'q')
            this.userPressedQuit = true;
    }
}
