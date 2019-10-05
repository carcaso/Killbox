package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Rectangle;

public class Door implements Collidable {

    Rectangle door;
    Position pos;
    Key[] keys;
    boolean open;
    private int width = 25;
    private int height = 40;

    public Door(Position position, Key[] keys) {
        open = false;
        pos = position;
        this.keys = keys;
        door = new Rectangle(pos.getX(), pos.getY(), width, height);
        door.fill();
    }

    @Override
    public void collide() {

    }

    public boolean isOpen() {
        return open;
    }
}
