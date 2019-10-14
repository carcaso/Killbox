package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.pictures.Picture;

public class Door implements Collidable {
    private Picture doorClose;
    private Picture doorOpen;
    private Position pos;
    private boolean open;
    private int totalButton;
    private int howManyToOpen = 1;

    public Door(Position position, int totalButton) {
        open = false;
        pos = position;
        doorClose = new Picture(pos.getX(), pos.getY(), "resources/pictures/doorClose.png");
        this.totalButton = totalButton;
        doorClose.draw();
    }

    public boolean isOpen() {
        return open;
    }

    public void openDoor() {

        if(howManyToOpen != totalButton){
            howManyToOpen++;
            return;
        }
        doorOpen = new Picture(pos.getX(), pos.getY(), "resources/pictures/doorOpen.png");
        doorOpen.draw();
        open = true;
    }



    @Override
    public void performCollision() {
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
