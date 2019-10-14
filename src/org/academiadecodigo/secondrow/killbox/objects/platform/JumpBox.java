package org.academiadecodigo.secondrow.killbox.objects.platform;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.killbox.objects.Collidable;
import org.academiadecodigo.secondrow.killbox.objects.Position;
import org.academiadecodigo.secondrow.killbox.objects.Sound;
import org.academiadecodigo.secondrow.pictures.Picture;

public class JumpBox implements Collidable {

    private Position pos;
    private int width;
    private int height;
    private Picture platform;

    public JumpBox(Position pos, int width, int height) {

        this.pos = pos;
        this.width = width;
        this.height = height;

        platform = new Picture(pos.getX(), pos.getY(), "resources/pictures/jumpBox.png");
        platform.draw();
    }

    @Override
    public void performCollision() {
        // This method is not used.

    }

    public void delete(){
        platform.delete();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return platform.getX();
    }

    public int getY() {
        return platform.getY();
    }

}

