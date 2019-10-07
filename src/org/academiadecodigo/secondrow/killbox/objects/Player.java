package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.keyboard.Keyboard;
import org.academiadecodigo.secondrow.keyboard.KeyboardEvent;
import org.academiadecodigo.secondrow.keyboard.KeyboardEventType;
import org.academiadecodigo.secondrow.keyboard.KeyboardHandler;
import org.academiadecodigo.secondrow.killbox.Var;
import org.academiadecodigo.secondrow.killbox.maps.Maps;


public class Player implements Movable, Collidable, KeyboardHandler {

    private Rectangle player;
    private Keyboard kbd;


    // Keybinds for playing movement
    private boolean keyD, keyA;
    private boolean isJumping;
    private boolean isLanding;
    private boolean isBumpingHead;
    private boolean isBumpingRight;
    private boolean isBumpingLeft;

    private int dx = 0;
    private int dy = 0;

    // Max Y that the player can move
    private int maxY = Var.HEIGHT - Var.PLAYER_HEIGHT - Var.WALL_PADDING + Var.PADDING;
    private int minX = Var.PADDING + Var.WALL_PADDING;

    // TODO: 2019-10-06 Change from maximum Y value to incremental value
    private int maxJump;
    private int jumpInterval = -5;
    private boolean specialJump;

    public Player(boolean specialJump) {
        this.specialJump = specialJump;
        this.kbd = new Keyboard(this);
        player = new Rectangle(Var.PADDING + Var.WALL_PADDING + 700, 200, Var.PLAYER_WIDTH, Var.PLAYER_HEIGHT);
    }

    public void init() {
        player.fill();

        addKeybind(KeyboardEvent.KEY_A, KeyboardEventType.KEY_PRESSED);
        addKeybind(KeyboardEvent.KEY_A, KeyboardEventType.KEY_RELEASED);

        addKeybind(KeyboardEvent.KEY_D, KeyboardEventType.KEY_PRESSED);
        addKeybind(KeyboardEvent.KEY_D, KeyboardEventType.KEY_RELEASED);

        addKeybind(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);
        addKeybind(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_RELEASED);
    }

    public void checkUpdate(Maps map) {
        dx = 0;
        dy = -jumpInterval;

        dx = (keyD && player.getX() < Var.PADDING - Var.WALL_PADDING + Var.WIDTH - Var.PLAYER_WIDTH) ? dx + 3 : dx;
        dx = (keyA && player.getX() > Var.PADDING + Var.WALL_PADDING) ? dx - 3 : dx;

        collide(map);

        if (player.getY() >= maxY || isLanding) {
            dy = 0;
        }

        if (isJumping) {
            if (maxJump <= 0 || isBumpingHead) {
                isJumping = false;
                dy = 0;
                return;
            }

            dy = jumpInterval;
            maxJump -= Math.abs(jumpInterval);
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
                if (!isJumping) {
                    if (player.getY() == maxY) {
                        maxJump = Var.PLAYER_JUMP_HEIGHT;
                        isJumping = true;
                        break;
                    }
                    maxJump = 0;
                    isJumping = false;
                }
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
                if (specialJump) {
                    isJumping = false;
                }
                break;
        }
    }

    @Override
    public void collide(Maps map) {

        for (int i = 0; i <= 1; i++) {

            int playerStartX = player.getX();
            int playerStartY = player.getY();

            int playerEndX = player.getX() + Var.PLAYER_WIDTH;
            int playerEndY = player.getY() + Var.PLAYER_HEIGHT;

            int objectStartX = map.getPlatform(i).getX();
            int objectStartY = map.getPlatform(i).getY();

            int objectEndX = map.getPlatform(i).getX() + map.getPlatform(i).getWidth();
            int objectEndY = map.getPlatform(i).getY() + map.getPlatform(i).getHeight();

            if ((playerStartX >= objectStartX && playerEndX <= objectEndX)) {

                if (playerEndY == objectStartY) {
                    System.out.println("LANDING AT X: " + player.getX() + " AND Y: " + player.getY());
                    isLanding = true;
                    return;
                }

                if (playerStartY == objectEndY) {
                    System.out.println("BUMPED HEAD AT X: " + player.getX() + " AND Y: " + player.getY());
                    isBumpingHead = true;
                    return;
                }
            }
            if (playerStartY >= objectStartY && playerEndY <= objectEndY) {
                if (playerEndX == objectStartY) {
                    System.out.println("BUMPED RIGHT AT X: " + player.getX() + " AND Y: " + player.getY());
                    isBumpingRight = true;
                    return;
                }
            }
        }
        isBumpingHead = false;
        isLanding = false;
        isBumpingRight = false;
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
