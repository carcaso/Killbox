package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.killbox.CollisionDetector;

public class Key {

    private Rectangle key;
    private Position pos;
    private boolean collide = false;
    public static final int SIZE = 15;


    public Key(Position position, Color color) {
        pos = position;
        key = new Rectangle(pos.getX(), pos.getY(), SIZE, SIZE);
        key.setColor(color);
        key.fill();
    }

    /**
     * Default constructor
     * */
    public Key(Position position) {
        pos = position;
        key = new Rectangle(pos.getX(), pos.getY(), SIZE, SIZE);
        key.setColor(Color.YELLOW);
        key.fill();
    }

    // Getters
    public int getX(){
        return key.getX();
    }

    public int getY(){
        return key.getY();
    }

    public int getWidth(){
        return key.getWidth();
    }

    public int getHeigth(){
        return key.getHeight();
    }

    /**
     * None used methods
     * */


    public void setCollide(){
        key.delete();
    }
}
