package lt.vgtu.game;

public class Rocket {
	private int x;
	private int y;
	
	private char up;
	private char down;
	private char left;
	private char right;
	
	public Rocket(int sx, int sy, String controls) {
		this.x = sx;
		this.y = sy;
		
		this.up = controls.charAt(0);
		this.down = controls.charAt(1);
		this.left = controls.charAt(2);
		this.right = controls.charAt(3);
	}

    public getXCoordinates() {
        return this.x;
    }

    public getYCoordinates() {
        return this.y;
    }
	
	public void processUserCommand(int n) {
		if (n == left)
			this.x -= 1;
		else
		if (n == right)
			this.x += 1;
		else
		if (n == up)
			this.y -= 1;
		else
		if (n == down)
			this.y += 1;
	}
}
