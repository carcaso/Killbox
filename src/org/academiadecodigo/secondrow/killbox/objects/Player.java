package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.keyboard.Keyboard;
import org.academiadecodigo.secondrow.keyboard.KeyboardEvent;
import org.academiadecodigo.secondrow.keyboard.KeyboardEventType;
import org.academiadecodigo.secondrow.keyboard.KeyboardHandler;
import org.academiadecodigo.secondrow.killbox.Var;
import org.academiadecodigo.secondrow.killbox.Vectors;
import org.academiadecodigo.secondrow.killbox.objects.platform.Platform;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class Player implements Movable, KeyboardHandler {

    private Rectangle playerAvatar;
    private Keyboard keyboard;
    private boolean dead;

    // FIXME: 2019-10-11 remove this
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH.mm.ss");
    private Sound effects = new Sound();

    // Keybinds for playing movement
    private boolean keyD, keyA, keySpace;
    private boolean jumpAvailable;
    //private boolean boosted;

    private int xMovement = 0;
    private int yMovement = 0;

    // Max Y that the playerAvatar can move
    private int maxY = Var.HEIGHT - Var.WALL_PADDING + Var.PADDING;
    private int minY = Var.PADDING + Var.WALL_PADDING;
    private int maxX = Var.PADDING - Var.WALL_PADDING + Var.WIDTH;
    private int minX = Var.PADDING + Var.WALL_PADDING;

    // TODO: 2019-10-06 Change from maximum Y value to incremental value
    private int gravity = 1;
    private boolean specialJump;

    public Player(boolean specialJump) {
        this.specialJump = specialJump;
        this.keyboard = new Keyboard(this);
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
    }

    public void update(boolean[] bumps) {

        boolean isBumpingTop = bumps[0];
        boolean isBumpingBottom = bumps[1];
        boolean isBumpingRight = bumps[2];
        boolean isBumpingLeft = bumps[3];

        // Inertia
        if (!keyD && !keyA) {
            if (xMovement < 0) {
                xMovement += Var.PLAYER_VELOCITY;
            }
            if (xMovement > 0) {
                xMovement -= Var.PLAYER_VELOCITY;
            }
        }

        // Left Movement
        if (keyA && xMovement >= -5) {
            xMovement -= Var.PLAYER_VELOCITY;
        }

        // Right movement
        if (keyD && xMovement <= 5) {
            xMovement += Var.PLAYER_VELOCITY;
        }

        // FIXME: 2019-10-12 set terminal velocity
        if (yMovement < 25) {
            yMovement += gravity;
        }

        if (isBumpingBottom) {
            yMovement = 0;
        }

        if (isBumpingTop) {
            yMovement = 1;
        }

        if (keySpace) {
            if (jumpAvailable) {
                // FIXME: 2019-10-12 set jump speed
                System.out.println("jumping!");
                yMovement = -30;
                jumpAvailable = false;
            }
        }

        if (isBumpingBottom && !jumpAvailable) {
            xMovement = 0;
            jumpAvailable = true;
        }

        checkWallBorders();

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
                    jumpAvailable = false;
                }
                break;
        }
    }

    @Override
    public void move() {

    }

    @Override
    public void move(Platform[] platforms) {

        // Timestamp for debugging
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        // Wanted position by update
        int playerStartX = this.getX() + xMovement;
        int playerEndX = this.getX() + Var.PLAYER_WIDTH + xMovement;
        int playerStartY = this.getY() + yMovement;
        int playerEndY = this.getY() + Var.PLAYER_HEIGHT + yMovement;

        // Original position
        int ogPlayerStartX = this.getX();
        int ogPlayerEndX = this.getX() + Var.PLAYER_WIDTH;
        int ogPlayerStartY = this.getY();
        int ogPlayerEndY = this.getY() + Var.PLAYER_HEIGHT;

        int objectStartX;
        int objectStartY;
        int objectEndX;
        int objectEndY;

        boolean yCeil = false;
        boolean yFloor = false;
        boolean xLeft = false;
        boolean xRight = false;


        for (Platform platform : platforms) {

            objectStartX = platform.getX();
            objectStartY = platform.getY();
            objectEndX = objectStartX + platform.getWidth();
            objectEndY = objectStartY + platform.getHeight();

            // Checks if player collides on Y axis
            if (playerEndY > objectStartY && playerStartY < objectEndY) {

                // Left to right
                if ((playerEndX > objectStartX)
                        && (playerEndX < objectEndX)
                        && (ogPlayerEndX < objectStartX)) {

                    xMovement = -10;
                    playerAvatar.translate(xMovement, 0);

                    System.out.println("SPAM LEFT TO RIGHT " + xMovement);

                    xMovement = 0;
                    yMovement = 0;
                    playerStartX = this.getX();
                    playerEndX = this.getX() + Var.PLAYER_HEIGHT;
                }

                // Right to left
                if (playerStartX <= objectEndX
                        && playerStartX > objectStartX
                        && ogPlayerStartX > objectEndX) {

                    xMovement += (objectEndX - playerStartX + 1);
                    playerAvatar.translate(xMovement, 0);
                    System.out.println("Translated: " + xMovement);
                    xMovement = 0;
                    playerStartX = this.getX();
                    playerEndX = this.getX() + Var.PLAYER_HEIGHT;
                }

                if (Math.abs(xMovement) > 50) {
                    System.out.println(timeFormat.format(timestamp) + ": X TRANSPORTING");
                    xMovement = 0;
                }
            }
        }

        if (yMovement != 0) {

            // Check movement on the Y axis

            for (Platform platform : platforms) {

                objectStartX = platform.getX();
                objectStartY = platform.getY();
                objectEndX = objectStartX + platform.getWidth();
                objectEndY = objectStartY + platform.getHeight();

                // Check if player collides on the X axis
                if (playerEndX > objectStartX && playerStartX < objectEndX) {

                    if (playerEndY > objectStartY && playerEndY < objectEndY) {

                        yMovement -= (playerEndY - objectStartY);
                        playerAvatar.translate(0, yMovement);
                        yMovement = 0;
                        playerStartY = this.getY();
                        playerEndY = this.getY() + Var.PLAYER_HEIGHT;
                    }

                    if (playerStartY < objectEndY && playerEndY > objectEndY) {

                        System.out.println("GOING DOWN");

                        yMovement += (objectEndY - playerStartY);
                        playerAvatar.translate(0, yMovement);
                        yMovement = 0;
                        playerStartY = this.getY();
                        playerEndY = this.getY() + Var.PLAYER_HEIGHT;
                    }

                    if (Math.abs(yMovement) > 35) {
                        System.out.println(timeFormat.format(timestamp) + ": Y Teletransport!");
                        yMovement = 0;
                    }
                }
            }
        }
        // Move our player
        playerAvatar.translate(xMovement, yMovement);

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

    public void checkWallBorders() {
        // Check if player is hitting floor
        if (getPlayerVectors(Vectors.Y_END) > maxY) {
            yMovement -= (getPlayerVectors(Vectors.Y_END) - maxY);

            // Reset jump
            jumpAvailable = true;
        }

        // Check if player is hitting ceil
        if (getPlayerVectors(Vectors.Y_START) < minY) {
            yMovement += (minY - getPlayerVectors(Vectors.Y_START));
        }

        if (getPlayerVectors(Vectors.X_END) > maxX) {
            xMovement -= (getPlayerVectors(Vectors.X_END) - maxX);
        }

        if (getPlayerVectors(Vectors.X_START) < minX) {
            xMovement += (minX - getPlayerVectors(Vectors.X_START));
        }

    }

    public int getPlayerVectors(Vectors vector) {
        switch (vector) {
            case X_START:
                return this.getX() + xMovement;
            case X_END:
                return this.getX() + Var.PLAYER_WIDTH + xMovement;
            case Y_START:
                return this.getY() + yMovement;
            case Y_END:
                return this.getY() + Var.PLAYER_HEIGHT + yMovement;
            default:
                return 0;
        }

    }

    public int getColisionVectors(Platform[] platforms, int index, Vectors vector) {

        switch (vector) {
            case X_START:
                return platforms[index].getX();
            case X_END:
                return platforms[index].getX() + platforms[index].getWidth();
            case Y_START:
                return platforms[index].getY();
            case Y_END:
                return platforms[index].getY() + platforms[index].getHeight();
            default:
                return 0;
        }
    }

    public boolean isDead() {

        return dead;
    }

    public void setDead(boolean x) {

    public void setDead(boolean x) {
        this.dead = x;
    }

    public void boost() {
        //System.out.println("boosting!");
        yMovement = -27;
        // playBoostSound
    }

}
