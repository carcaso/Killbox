package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.graphics.Text;
import org.academiadecodigo.secondrow.keyboard.Keyboard;
import org.academiadecodigo.secondrow.keyboard.KeyboardEvent;
import org.academiadecodigo.secondrow.keyboard.KeyboardEventType;
import org.academiadecodigo.secondrow.keyboard.KeyboardHandler;
import org.academiadecodigo.secondrow.killbox.CollisionDetector;
import org.academiadecodigo.secondrow.killbox.Var;
import org.academiadecodigo.secondrow.pictures.Picture;

import javax.print.DocFlavor;


public class Player implements Movable, KeyboardHandler {

    private Picture playerAvatar;
    private Picture PlayerAvatarDead;
    private Keyboard keyboard;
    private boolean dead;
    private Sound effects = new Sound();

    // Keybinds for playing movement
    private boolean keyD, keyA, keySpace;
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
        this.keyboard = new Keyboard(this);
        playerAvatar = new Picture (Var.PADDING + Var.WALL_PADDING + 700, 200, "/Users/codecadet/Desktop/" +
                "2D-Platform/resources/pictures/playerRight.png");
    }

    public void init() {
        playerAvatar.draw();

        addKeybind(KeyboardEvent.KEY_A, KeyboardEventType.KEY_PRESSED);
        addKeybind(KeyboardEvent.KEY_A, KeyboardEventType.KEY_RELEASED);

        addKeybind(KeyboardEvent.KEY_D, KeyboardEventType.KEY_PRESSED);
        addKeybind(KeyboardEvent.KEY_D, KeyboardEventType.KEY_RELEASED);

        addKeybind(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);
        addKeybind(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_RELEASED);

        addKeybind(KeyboardEvent.KEY_W, KeyboardEventType.KEY_PRESSED);
        addKeybind(KeyboardEvent.KEY_W, KeyboardEventType.KEY_RELEASED);



    }

    public void update(boolean[] bumps) {
        dx = 0;
        dy = -jumpInterval;

        dx = (keyD && playerAvatar.getX() < Var.PADDING - Var.WALL_PADDING + Var.WIDTH - Var.PLAYER_WIDTH) ?
                dx + Var.PLAYER_VELOCITY : dx;
        dx = (keyA && playerAvatar.getX() > Var.PADDING + Var.WALL_PADDING) ? dx - Var.PLAYER_VELOCITY : dx;

        boolean isBumpingTop = bumps[0];
        boolean isBumpingBottom = bumps[1];
        boolean isBumpingRight = bumps[2];
        boolean isBumpingLeft = bumps[3];

        if (playerAvatar.getY() >= maxY || isBumpingBottom) {
            dy = 0;
        }

        if (isBumpingLeft || isBumpingRight) {
            dx = 0;
        }

        if (keySpace || boosted) {
            if ((playerAvatar.getY() == maxY || isBumpingBottom) && !boosted) {
                maxJump = Var.PLAYER_JUMP_HEIGHT;
                isJumping = true;
            }

            if ((playerAvatar.getY() == maxY || isBumpingBottom) && boosted) {
                maxJump = Var.PLAYER_JUMP_HEIGHT * 4;
                isJumping = true;
            }

            if (isJumping || boosted) {
                if (maxJump <= 0 || isBumpingTop || playerAvatar.getY() == minY) {
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

    public int getY() {
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
                effects.playSound(0,"jump.wav");
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
        keyboard.addEventListener(keybind);
    }

    public boolean isDead() {

        PlayerAvatarDead = new Picture(getX(), getY(), "/Users/codecadet/Desktop/2D-Platform/resources/" +
                "pictures/PlayerDead.png");
        return dead;
    }

    public void setDead(boolean x) {

        this.dead = x;
    }

    public void setBoosted(boolean boost) {
        this.boosted = boost;
    }

}
