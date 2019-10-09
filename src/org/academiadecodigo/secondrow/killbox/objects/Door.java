package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.killbox.Var;

public class Door {
    private Rectangle door;
    private Position pos;
    private Key[] keys;
    private boolean open;

    public Door(Position position) {
        open = false;
        pos = position;
        this.keys = keys;
        door = new Rectangle(pos.getX(), pos.getY(), Var.DOOR_WIDTH, Var.DOOR_HEIGHT);
        door.fill();
    }

    public boolean isOpen() {
        return open;
    }

    public void openDoor(){
        if(!open) {
            door.setColor(Color.ORANGE);
            open = true;
        }

    }



}
