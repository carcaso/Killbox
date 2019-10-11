package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.killbox.Var;
import org.academiadecodigo.secondrow.pictures.Picture;

public class Door implements Collidable {
    private Rectangle door;
    private Position pos;
    private boolean open;
    private Picture winPicture = new Picture(400, 125,"/Users/codecadet/Desktop/2D-Platform/youwin.png" +
            "");
    public Door(Position position) {
        open = false;
        pos = position;
        door = new Rectangle(pos.getX(), pos.getY(), Var.DOOR_WIDTH, Var.DOOR_HEIGHT);
        door.fill();
    }

    public boolean isOpen() {
        return open;
    }

    public void openDoor() {
        if (!open) {
            door.setColor(Color.ORANGE);
            open = true;
        }
    }


    @Override
    public void performCollision() {
        winPicture.draw();

    }

    @Override
    public int getWidth() {
        return 40;
    }

    @Override
    public int getHeight() {
        return 40;
    }

    @Override
    public int getX() {
        return pos.getX();
    }

    @Override
    public int getY() {
        return pos.getY();
    }
}
