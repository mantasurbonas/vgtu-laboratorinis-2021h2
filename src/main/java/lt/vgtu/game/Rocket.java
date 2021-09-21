package lt.vgtu.game;

public class Rocket {
    private final char up;
    private final char down;
    private final char left;
    private final char right;
    int x;
    int y;

    public Rocket(int sx, int sy, String controls) {
        this.x = sx;
        this.y = sy;

        this.up = controls.charAt(0);
        this.down = controls.charAt(1);
        this.left = controls.charAt(2);
        this.right = controls.charAt(3);
    }

    public char getUp() {
        return up;
    }

    public char getDown() {
        return down;
    }

    public char getLeft() {
        return left;
    }

    public char getRight() {
        return right;
    }

    public void processUserCommand(int n) {
        if (n == left)
            this.x -= 1;
        else if (n == right)
            this.x += 1;
        else if (n == up)
            this.y -= 1;
        else if (n == down)
            this.y += 1;
    }
}
