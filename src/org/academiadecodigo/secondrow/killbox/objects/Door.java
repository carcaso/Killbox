package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.graphics.Text;
import org.academiadecodigo.secondrow.killbox.Var;
import org.academiadecodigo.secondrow.pictures.Picture;

public class Door implements Collidable {
    private Picture doorClose;
    private Picture doorOpen;
    private Position pos;
    private boolean open;
    private Rectangle winRectangle = new Rectangle(427, 240, 426, 240);
    private Text winMessage = new Text(625, 350, "You won!");
    private int totalButton;
    private int howManyToOpen = 1;

    public Door(Position position, int totalButton) {
        open = false;
        pos = position;
        doorClose = new Picture(pos.getX(), pos.getY(), "/Users/codecadet/Desktop/2D-Platform/resources/pictures" +
                "/doorClose.png");
        this.totalButton = totalButton;
        doorClose.draw();
    }

    public boolean isOpen() {
        return open;
    }

    public void openDoor() {

        if (howManyToOpen != totalButton) {
            howManyToOpen++;
            return;
        }
        doorOpen = new Picture(pos.getX(), pos.getY(), "/Users/codecadet/Desktop/2D-Platform/resources/pictures" +
                "/doorOpen.png");
        doorOpen.draw();
        open = true;
    }


    @Override
    public void performCollision() {
        winRectangle.setColor(Color.GREEN);
        winRectangle.fill();
        winMessage.grow(150, 50);
        winMessage.draw();
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
