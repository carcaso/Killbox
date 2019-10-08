package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.keyboard.Keyboard;
import org.academiadecodigo.secondrow.keyboard.KeyboardEvent;
import org.academiadecodigo.secondrow.keyboard.KeyboardEventType;
import org.academiadecodigo.secondrow.keyboard.KeyboardHandler;
import org.academiadecodigo.secondrow.killbox.CollisionDetector;
import org.academiadecodigo.secondrow.killbox.Var;


public class Player implements Movable, KeyboardHandler {

    private Rectangle playerAvatar;
    private Keyboard kbd;


    // Keybinds for playing movement
    private boolean keyD, keyA, keyW, keySpace;
    private boolean isJumping;
    private boolean boosted;

    private int dx = 0;
    private int dy = 0;

    // Max Y that the playerAvatar can move
    private int maxY = Var.HEIGHT - Var.PLAYER_HEIGHT - Var.WALL_PADDING + Var.PADDING;
    private int minY = Var.PADDING + Var.WALL_PADDING;

    // TODO: 2019-10-06 Change from maximum Y value to incremental value
    private int maxJump;
    private int jumpInterval = -5;
    private boolean specialJump;

    public Player(boolean specialJump) {
        this.specialJump = specialJump;
        this.kbd = new Keyboard(this);
        playerAvatar = new Rectangle(Var.PADDING + Var.WALL_PADDING + 700, 200, Var.PLAYER_WIDTH, Var.PLAYER_HEIGHT);
    }

    public void init() {
        playerAvatar.fill();

        addKeybind(KeyboardEvent.KEY_A, KeyboardEventType.KEY_PRESSED);
        addKeybind(KeyboardEvent.KEY_A, KeyboardEventType.KEY_RELEASED);

        addKeybind(KeyboardEvent.KEY_D, KeyboardEventType.KEY_PRESSED);
        addKeybind(KeyboardEvent.KEY_D, KeyboardEventType.KEY_RELEASED);

        addKeybind(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);
        addKeybind(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_RELEASED);

        addKeybind(KeyboardEvent.KEY_W, KeyboardEventType.KEY_PRESSED);
        addKeybind(KeyboardEvent.KEY_W, KeyboardEventType.KEY_RELEASED);
    }

    public void update(CollisionDetector collisionDetector) {
        dx = 0;
        dy = -jumpInterval;

        dx = (keyD && playerAvatar.getX() < Var.PADDING - Var.WALL_PADDING + Var.WIDTH - Var.PLAYER_WIDTH) ?
                dx + Var.PLAYER_VELOCITY : dx;
        dx = (keyA && playerAvatar.getX() > Var.PADDING + Var.WALL_PADDING) ? dx - Var.PLAYER_VELOCITY : dx;

        boolean[] bumps = collisionDetector.check();
        boolean isBumpingHead = bumps[0];
        boolean isLanding = bumps[1];
        boolean isBumpingRight = bumps[2];

        if (playerAvatar.getY() >= maxY || isLanding) {
            dy = 0;
        }

        if (keySpace || boosted) {
            if ((playerAvatar.getY() == maxY || isLanding) && !boosted) {
                maxJump = Var.PLAYER_JUMP_HEIGHT;
                isJumping = true;
            }

            if ((playerAvatar.getY() == maxY  || isLanding) && boosted) {
                maxJump = Var.PLAYER_JUMP_HEIGHT * 4;
                isJumping = true;
            }

            if (isJumping || boosted) {
                if (maxJump <= 0 || isBumpingHead || playerAvatar.getY() == minY) {
                    isJumping = false;
                    boosted = false;
                    maxJump = 0;
                    dy = 0;
                    return;
                }

                dy = jumpInterval;
                maxJump -= Math.abs(jumpInterval);
            }
        }
    }

    public int getX() {
        return playerAvatar.getX();
    }

    public int getY(){
        return playerAvatar.getY();
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
                keySpace = true;
                break;
            case KeyboardEvent.KEY_W:
                boosted = true;
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
            case KeyboardEvent.KEY_SPACE:
                keySpace = false;
                if (specialJump) {
                    isJumping = false;
                }
                break;
            case KeyboardEvent.KEY_W:
                break;
        }
    }

    // TODO: 2019-10-06 Move this to draw or something else
    @Override
    public void move() {
        playerAvatar.translate(dx, dy);
    }

    /**
     * Adds keybinds for the playerAvatar
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
