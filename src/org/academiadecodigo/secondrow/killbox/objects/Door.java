package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.graphics.Text;
import org.academiadecodigo.secondrow.killbox.Var;
import org.academiadecodigo.secondrow.pictures.Picture;

public class Door implements Collidable {
    private Rectangle door;
    private Position pos;
    private boolean open;
    private Picture winPicture = new Picture(400, 125,"/Users/codecadet/Desktop/2D-Platform/youwin.png" +
            "");
    //private Rectangle winRectangle = new Rectangle(427, 240, 426, 240);
    //private Text winMessage = new Text(625, 350, "You won!");

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
        //winRectangle.setColor(Color.GREEN);
        //winRectangle.fill();
        //winMessage.grow(150, 50);
        //winMessage.draw();

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
