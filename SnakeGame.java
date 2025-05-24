
package JAVAPROJECT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SnakeGame extends JPanel implements KeyListener {

    private int[] x = new int[100];
    private int[] y = new int[100];
    private int fruitX, fruitY;
    private int length = 3;
    private char direction = 'R';
    private int score = 0;
    private boolean gameOver = false;
    private Timer timer;
    private Random random = new Random();

    public SnakeGame() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.BLACK);
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
        startGame();
    }

    private void startGame() {
        for (int i = 0; i < length; i++) {
            x[i] = 50 - i * 10;
            y[i] = 50;
        }
        newFruit();
        timer = new Timer(100, e -> update());
        timer.start();
    }

    private void update() {
        if (!gameOver) {
            move();
            checkFruit();
            checkCollisions();
            repaint();
        }
    }

    private void move() {
        for (int i = length - 1; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case 'U' -> y[0] -= 10;
            case 'D' -> y[0] += 10;
            case 'L' -> x[0] -= 10;
            case 'R' -> x[0] += 10;
        }
    }

    private void newFruit() {
        fruitX = random.nextInt(39) * 10;
        fruitY = random.nextInt(39) * 10;
    }

    private void checkFruit() {
        if (x[0] == fruitX && y[0] == fruitY) {
            length++;
            score++;
            newFruit();
        }
    }

    private void checkCollisions() {
        // Border collision
        if (x[0] < 0 || x[0] >= 400 || y[0] < 0 || y[0] >= 400) {
            gameOver = true;
        }
        // Body collision
        for (int i = 1; i < length; i++) {
            if (x[0] == x[i] && y[0] == y[i]) {
                gameOver = true;
            }
        }
        if (gameOver) {
            timer.stop();
            JOptionPane.showMessageDialog(null, "Game Over! Your score is " + score);
            System.exit(0);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!gameOver) {
            g.setColor(Color.RED);
            g.fillOval(fruitX, fruitY, 10, 10);
            g.setColor(Color.GREEN);
            for (int i = 0; i < length; i++) {
                g.fillRect(x[i], y[i], 10, 10);
            }
            g.setColor(Color.WHITE);
            g.drawString("Score: " + score, 10, 20);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> {
                if (direction != 'D') {
                    direction = 'U';
                }
            }
            case KeyEvent.VK_DOWN -> {
                if (direction != 'U') {
                    direction = 'D';
                }
            }
            case KeyEvent.VK_LEFT -> {
                if (direction != 'R') {
                    direction = 'L';
                }
            }
            case KeyEvent.VK_RIGHT -> {
                if (direction != 'L') {
                    direction = 'R';
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SnakeGame());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}