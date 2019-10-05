package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;

public class Key implements Collidable {

    private Rectangle key;
    private Position pos;
    private int size = 5;

    /*public Key(Position position, Color color) {
        pos = position;
        key = new Rectangle(pos.getX(), pos.getY(), size, size);

    }*/

    public Key(Position position) {
        pos = position;
        key = new Rectangle(pos.getX(), pos.getY(), size, size);
        key.setColor(Color.YELLOW);
        key.fill();
    }

    @Override
    public void collide() {
        // disappear when collided
    }
}
