package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.graphics.Text;
import org.academiadecodigo.secondrow.pictures.Picture;

public class Key implements Collidable {

    private Rectangle key;
    private Position pos;
    private Door door;
    public static final int SIZE = 15;
    private int totalKeys;
    private int keysLeft;


    public Key(Position position, Color color, Door door) {
        pos = position;
        key = new Rectangle(pos.getX(), pos.getY(), SIZE, SIZE);
        key.setColor(color);
        key.fill();
        this.door = door;
    }

    /**
     * Default constructor
     */
    public Key(Position position, Door door, int numberOfKeys) {
        pos = position;
        key = new Rectangle(pos.getX(), pos.getY(), SIZE, SIZE);
        key.setColor(Color.YELLOW);
        key.fill();
        this.door = door;
        totalKeys=numberOfKeys;
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

    public void delete(){key.delete();}

    @Override
    public void performCollision() {
        if (keysLeft == totalKeys) {
            key.delete();
            System.out.println(door);
            door.openDoor();
            return;
        }

        keysLeft++;
    }


}
