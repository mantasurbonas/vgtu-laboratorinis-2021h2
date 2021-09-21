package lt.vgtu.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class WindowsMain extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1L;

    private final List<Rocket> rockets = new ArrayList<>();
    private final Map map = new Map();
    private final WindowsRenderer renderer = new WindowsRenderer(map, rockets);
    private final GameRules gameRules = new GameRules(map, rockets);

    public WindowsMain() throws Exception {
        super.setPreferredSize(new Dimension(1200, 600));
        super.pack();
        super.setVisible(true);

        rockets.add(new Rocket(3, 10, "wsad"));
        rockets.add(new Rocket(5, 12, "ikjl"));

        super.addKeyListener(this);

        super.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                try {
                    new WindowsMain();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        renderer.paint(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int userCommand = e.getKeyChar();
        gameRules.processUserCommand(userCommand);

        for (Rocket rocket : rockets)
            if (!gameRules.isOutofBounds(rocket, map.getWidth(), map.getHeight(), userCommand)) {
                rocket.processUserCommand(userCommand);
            }

        if (gameRules.isGameOver())
            System.exit(1);

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
