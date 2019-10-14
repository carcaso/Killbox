package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.pictures.Picture;

public class Key implements Collidable {

    private Rectangle key;
    private Position pos;
    public static final int SIZE = 15;
    private Door door;
    private Picture keyPicture;
    private boolean deleted;
    private Sound effects = new Sound();

    /**
     * Default constructor
     */
    public Key(Position position, Door door) {
        pos = position;
        this.door = door;
        keyPicture = new Picture(pos.getX(), pos.getY(), "resources/pictures/key2.png");
        keyPicture.draw();
    }

    // Getters
    public int getX() {
        return pos.getX();
    }

    public int getY() {
        return pos.getY();
    }

    public int getWidth() {
        return SIZE;
    }

    public int getHeight() {
        return SIZE;
    }

    public void delete() {
        key.delete();
    }

    @Override
    public void performCollision() {

        if (!deleted) {
            keyPicture.delete();
            effects.playSound(0, "resources/sounds/key.wav");
            door.openDoor();
            deleted = true;
        }
    }
}
