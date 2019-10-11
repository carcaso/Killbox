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


    public Key(Position position, Color color, Door door) {
        pos = position;
        this.door = door;
        keyPicture = new Picture(pos.getX(), pos.getY(), "/Users/codecadet/Desktop/2D-Platform/key2.png");
        key.draw();

    }

    /**
     * Default constructor
     */
    public Key(Position position, Door door) {
        pos = position;
        this.door = door;
        keyPicture = new Picture(pos.getX(), pos.getY(), "/Users/codecadet/Desktop/2D-Platform/key2.png");
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


    @Override
    public void performCollision() {
        keyPicture.delete();
        door.openDoor();
    }


}
