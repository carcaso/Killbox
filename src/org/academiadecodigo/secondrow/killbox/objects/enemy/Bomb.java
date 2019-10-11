package org.academiadecodigo.secondrow.killbox.objects.enemy;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.killbox.objects.Collidable;
import org.academiadecodigo.secondrow.killbox.objects.Position;
import org.academiadecodigo.secondrow.pictures.Picture;

public class Bomb extends Enemy implements Collidable {


    private int SIZE = 5;
    private Picture bomb;
    //private Rectangle bomb;
    private Position pos;

    public Bomb(int x, int y) {

        pos = new Position(x, y);
        bomb = new Picture(x, y, "/Users/codecadet/Desktop/2D-Platform/sea mine2.png");
        //bomb = new Rectangle(x, y, SIZE, SIZE);
        //bomb.setColor(Color.RED);
        //bomb.fill();
        bomb.draw();
    }


    @Override
    public void performCollision() {
        super.performCollision();
    }

    @Override
    public int getWidth() {
        return bomb.getWidth();
    }

    @Override
    public int getHeight() {
        return bomb.getHeight();
    }

    @Override
    public int getX() {
        return bomb.getX();
    }

    @Override
    public int getY() {
        return bomb.getY();
    }

    ///////////////////////////////////////////////////////////////////

    public void delete() {
    }

}




