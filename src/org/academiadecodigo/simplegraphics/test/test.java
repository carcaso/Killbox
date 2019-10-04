package org.academiadecodigo.simplegraphics.test;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class test implements KeyboardHandler {

    private Rectangle gameBounds;
    //private Ellipse ball;
    private Picture spaceship;
    private Ellipse bullet;
    private Picture[] enemies;
    private Picture alien;

    Keyboard k = new Keyboard(this);

    public static void main(String[] args) throws InterruptedException {

        test egg = new test();
        egg.drawBald();

    }

    public void drawBald() throws InterruptedException {

        // Our physical keyboard
        KeyboardEvent KeySpace = new KeyboardEvent();
        KeyboardEvent keyA = new KeyboardEvent();
        KeyboardEvent keyD = new KeyboardEvent();
        KeyboardEvent keyS = new KeyboardEvent();

        // Listeners for our keys
        KeySpace.setKey(KeyboardEvent.KEY_SPACE);
        KeySpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(KeySpace);

        keyA.setKey(KeyboardEvent.KEY_A);
        keyA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyA);

        keyD.setKey(KeyboardEvent.KEY_D);
        keyD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyD);

        keyS.setKey(KeyboardEvent.KEY_S);
        keyS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyS);


        // Draw new rectangle

        gameBounds = new Rectangle(10, 10, 300, 200);
        gameBounds.setColor(Color.BLACK);
        gameBounds.draw();
        gameBounds.fill();

        spaceship = new Picture(gameBounds.getWidth() / 2, gameBounds.getHeight() - 10, "/Users/codecadet/Downloads/spaceship.png");
        spaceship.draw();

        alien = new Picture(gameBounds.getWidth() / 2, gameBounds.getHeight() / 3, "/Users/codecadet/Downloads/alien.png");
        alien.draw();

        enemies = new Picture[10];
        for (int i = 0; i < 10; i++) {
            enemies[i] = new Picture(gameBounds.getWidth() / 2, gameBounds.getHeight() / 3, "/Users/codecadet/Downloads/alien.png");
            alien.draw();
        }

        bullet = new Ellipse(0, 0, 5, 5);

        while (!(gameBounds.getY() <= 0)) {
            hitbox(bullet);
            if (gameBounds.getY() > 5 && gameBounds.getY() < 0) {
                bullet.delete();
            }
            bullet.translate(0, -1);
            Thread.sleep(5);
        }

    }

    public void hitbox(Picture[] enemies) {
        for (int i = 0; i < enemies.length; i++) {
            if (bullet.getY() == enemies[i].getY()) {
                enemies[i].delete();
                bullet.delete();
                System.out.println("TARGET HIT");
        }


    }

    public void spawnAlien(Picture alien) {
        int randX = (int) (Math.random() * gameBounds.getWidth());
        int randY = (int) (Math.random() * (gameBounds.getHeight() - (gameBounds.getHeight()/3)));
        alien = new Picture(randX, randY, "/Users/codecadet/Downloads/alien.png");
        alien.draw();
    }

    public void restartPos(Ellipse bullet) {
        int posX = bullet.getX() - spaceship.getX();
        int posY = bullet.getY() - spaceship.getY();

        bullet.translate(posX, posY);
    }

    public void shoot() {
        bullet = new Ellipse(spaceship.getX() + 10, spaceship.getY() - 5, 3, 3);
        bullet.setColor(Color.YELLOW);
        bullet.draw();
        bullet.fill();
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {

            // TODO: 2019-10-01 Get proper ranges
            case KeyboardEvent.KEY_SPACE:
                System.out.println("SPACE");
                if (bullet.getY() < 0) {
                    restartPos(bullet);
                    shoot();
                }
                break;
            case KeyboardEvent.KEY_A:
                System.out.println("KEY A");
                if (spaceship.getX() == 10) {
                    break;
                }
                spaceship.translate(-10, 0);
                break;
            case KeyboardEvent.KEY_D:
                System.out.println("KEY D");
                if (spaceship.getX() == gameBounds.getWidth() - 20) {
                    break;
                }
                spaceship.translate(10, 0);
                break;
            case KeyboardEvent.KEY_S:
                System.out.println("KEY S");
                spawnAlien(alien);
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }
}

/*


public class Tester implements KeyboardHandler, MouseHandler {

    public static void main(String[] args) throws InterruptedException {

        Tester t = new Tester();
        t.test();

    }

    public void test() throws InterruptedException {

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_SPACE);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

        Rectangle rect = new Rectangle(10, 10, 400, 400);
        rect.setColor(Color.BLACK);
        rect.draw();

        Rectangle smallRect = new Rectangle(50, 50, 100, 100);
        smallRect.setColor(Color.RED);
        smallRect.fill();

        Ellipse ellipse = new Ellipse(30, 30, 50, 60);
        ellipse.setColor(Color.YELLOW);
        ellipse.fill();

        Line line = new Line(200, 200, 300, 250);
        line.setColor(Color.BLUE);
        line.draw();

        Text text = new Text(20, 180, "Simple Graphics");
        text.setColor(Color.MAGENTA);
        text.draw();

        Picture pic = new Picture(20, 220, "http://static0.bigstockphoto.com/thumbs/3/5/2/small2/25346960.jpg");
        pic.draw();

        Thread.sleep(2000);

        smallRect.translate(100, 0);
        ellipse.translate(20, 20);
        line.translate(20, -10);
        text.translate(20, 20);
        pic.translate(40, 0);

        Thread.sleep(2000);

        smallRect.grow(10, 10);
        ellipse.grow(-20, -20);
        line.grow(10, 10);
        text.grow(5, 5);
        pic.grow(-50, -50);

        Thread.sleep(2000);

        text.setText("Academia de Codigo");
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        System.out.println("SPACE KEY PRESSED");

    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
       System.out.println(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        System.out.println(e);

    }
}

 */