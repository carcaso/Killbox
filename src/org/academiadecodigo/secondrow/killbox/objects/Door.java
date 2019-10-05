package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Rectangle;

public class Door implements Collidable {

    Rectangle door;
    Position pos;
    Key[] keys;
    boolean open;

    public Door(Position position, Key[] keys) {
        open = false;
    }

    @Override
    public void collide() {

    }

    public boolean isOpen(){
        return false;
    }
}
