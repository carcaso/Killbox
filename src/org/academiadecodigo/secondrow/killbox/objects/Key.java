package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.graphics.Text;
import org.academiadecodigo.secondrow.pictures.Picture;

public class Key implements Collidable {

    private Rectangle key;
    private Position pos;
    public static final int SIZE = 15;
    private Door door;
    private Text winMessage;



    public Key(Position position, Color color, Door door) {
        pos = position;
        key = new Rectangle(pos.getX(), pos.getY(), SIZE, SIZE);
        key.setColor(color);
        key.fill();
        this.door = door;
    }

    /**
     * Default constructor
     * */
    public Key(Position position, Door door ) {
        pos = position;
        key = new Rectangle(pos.getX(), pos.getY(), SIZE, SIZE);
        key.setColor(Color.YELLOW);
        key.fill();
        this.door = door;
    }

    // Getters
    public int getX(){
        return pos.getX();
    }

    public int getY(){
        return pos.getY();
    }

    public int getWidth(){
        return SIZE;
    }

    public int getHeight(){
        return SIZE;
    }


    @Override
    public void performCollision(){
        key.delete();
        door.openDoor();
    }


}
