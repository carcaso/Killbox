package org.academiadecodigo.secondrow.killbox.objects.enemy;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.killbox.objects.Collidable;
import org.academiadecodigo.secondrow.killbox.objects.Position;

public class Bomb extends Enemy implements Collidable {


    private int SIZE = 5;
    private Rectangle bomb;
    private Position pos;

    public Bomb(int x, int y) {

        pos = new Position(x, y);
        bomb = new Rectangle(x, y, SIZE, SIZE);
        bomb.setColor(Color.RED);
        bomb.fill();
    }


    public Bomb(int x, int y, int width, int height) {

        pos = new Position(x, y);
        bomb = new Rectangle(x, y, width, height);
        bomb.setColor(Color.RED);
        bomb.fill();
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




