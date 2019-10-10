package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;

public class Key implements Collidable {

    private Rectangle key;
    private Position pos;
    private boolean collide = false;
    public static final int SIZE = 15;


    // TODO: 09/10/2019 tem de receber porta ( porta pára de receber keys ) 
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

    public void delete(){key.delete();}

    @Override
    public void performCollision(){
        // TODO: 09/10/2019 must open door
        delete();
    }
}
