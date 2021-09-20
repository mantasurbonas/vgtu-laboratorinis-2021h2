package lt.vgtu.game;

import java.util.List;

public class GameRules {

	private List<Rocket> rockets;
	private Map map;
	private boolean userPressedQuit = false;

	public GameRules(Map map, List<Rocket> rockets) {
		this.map = map;
		this.rockets = rockets;
	}
	
	public boolean hasHitAsteroid() {
		for (Rocket rocket: rockets)
			if (map.getElement(rocket.getXCoordinates(), rocket.getYCoordinates()) != 0 || map.getElement(rocket.getXCoordinates()+1, rocket.getYCoordinates())  != 0)
				return true;
				
		return false;
	}

	public boolean isGameOver() {
		return hasHitAsteroid() || userPressedQuit;
	}

	public void processUserCommand(int userCommand) {
		if (userCommand == 'q')
			this.userPressedQuit  = true;
	}
}
