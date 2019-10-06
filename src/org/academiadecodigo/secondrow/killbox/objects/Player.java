package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.keyboard.Keyboard;
import org.academiadecodigo.secondrow.keyboard.KeyboardEvent;
import org.academiadecodigo.secondrow.keyboard.KeyboardEventType;
import org.academiadecodigo.secondrow.keyboard.KeyboardHandler;
import org.academiadecodigo.secondrow.killbox.Var;


public class Player implements Movable, Collidable, KeyboardHandler {

    private Rectangle player;
    private Keyboard kbd;


    // Keybinds for playing movement
    private boolean keySpace, keyD, keyA;


    private int dx = 0;
    private int dy = 0;

    // Max Y that the player can move
    private int maxY = Var.HEIGHT - Var.PLAYER_HEIGHT - Var.WALL_PADDING + Var.PADDING;
    private int minX = Var.PADDING + Var.WALL_PADDING;

    // TODO: 2019-10-06 Change from maximum Y value to incremental value
    private int maxJump;
    private int jumpInterval = -5;


    public Player() {
        this.kbd = new Keyboard(this);
        player = new Rectangle(Var.PADDING + Var.WALL_PADDING + 1100, 500, Var.PLAYER_WIDTH, Var.PLAYER_HEIGHT);
    }

    public void init() {
        player.fill();

        addKeybind(KeyboardEvent.KEY_A, KeyboardEventType.KEY_PRESSED);
        addKeybind(KeyboardEvent.KEY_A, KeyboardEventType.KEY_RELEASED);

        addKeybind(KeyboardEvent.KEY_D, KeyboardEventType.KEY_PRESSED);
        addKeybind(KeyboardEvent.KEY_D, KeyboardEventType.KEY_RELEASED);

        addKeybind(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);
    }

    public void checkUpdate() {
        dx = 0;
        dy = -jumpInterval;

        dx = (keyD && player.getX() < Var.PADDING - Var.WALL_PADDING + Var.WIDTH - Var.PLAYER_WIDTH) ? dx + 3 : dx;
        dx = (keyA && player.getX() > Var.PADDING + Var.WALL_PADDING) ? dx - 3 : dx;

        /*
        if (keySpace) {
            if (player.getY() <= maxJump) {
                keySpace = false;
                dy = 0;
                return;
            }
            dy = jumpInterval;
        }
        */

        if (keySpace) {
            if (maxJump <= 0) {
                keySpace = false;
                dy = 0;
                return;
            }

            dy = jumpInterval;
            maxJump -= Math.abs(jumpInterval);
        }

        if (!keySpace && player.getY() >= maxY) {
            dy = 0;
        }
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_A:
                keyA = true;
                break;
            case KeyboardEvent.KEY_D:
                keyD = true;
                break;
            case KeyboardEvent.KEY_SPACE:

                // FIXME: 2019-10-06 implement with collision
                if (player.getY() != maxY) {
                    maxJump = 0;
                    break;
                }

                // TODO: 2019-10-06 Find out if value resets in jumping outside the ground
                maxJump = Var.PLAYER_HEIGHT * 3;
                keySpace = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_A:
                keyA = false;
                break;
            case KeyboardEvent.KEY_D:
                keyD = false;
                break;
        }
    }

    @Override
    public void collide() {

    }

    // TODO: 2019-10-06 Move this to draw or something else
    @Override
    public void move() {
        player.translate(dx, dy);
    }

    /**
     * Adds keybinds for the player
     *
     * @param key
     * @param type
     */
    private void addKeybind(int key, KeyboardEventType type) {
        KeyboardEvent keybind = new KeyboardEvent();
        keybind.setKey(key);
        keybind.setKeyboardEventType(type);
        kbd.addEventListener(keybind);
    }

    public boolean isDead() {
        return false;
    }
}
