package org.academiadecodigo.secondrow.killbox.objects.enemy;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Ellipse;
import org.academiadecodigo.secondrow.killbox.objects.Collidable;
import org.academiadecodigo.secondrow.killbox.objects.Movable;
import org.academiadecodigo.secondrow.killbox.objects.Position;
import org.academiadecodigo.secondrow.pictures.Picture;

public class FixedPathEnemy extends Enemy implements Movable, Collidable {

    private int SIZE = 40;

    private int distanceFromPlataform = 15 + 40;

    private Position pos;
    private Picture enemy;

    private int platformX;
    private int platformY;
    private int platformWidth;
    private int platformHeight;

    private boolean block1 = false;
    private boolean block2 = false;
    private boolean block3 = false;
    private boolean block4 = false;

    private int dx = 0;
    private int dy = 0;

    public FixedPathEnemy(int platformX, int platformY, int platformWidth, int platformHeight) {
        this.platformX = platformX;
        this.platformY = platformY;
        this.platformWidth = platformWidth;
        this.platformHeight = platformHeight;

        pos = new Position(platformX - distanceFromPlataform, platformY - distanceFromPlataform);
        enemy = new Picture(pos.getX(), pos.getY(), "/Users/codecadet/Desktop/2D-Platform/resources/pictures/" +
                "enemy.png");
        enemy.draw();
    }


    @Override
    public void move() {
        enemy.translate(dx, dy);
    }

    @Override
    public void update(){

        //use position
        boolean directionRight;
        boolean directionLeft;

        //int minX = pos.getX();
        int minX = platformX - distanceFromPlataform;

        //int minY = pos.getY();
        int minY = platformY - distanceFromPlataform;

        int maxX = minX + 2 * (distanceFromPlataform) + platformWidth - 40;
        int maxY = minY + 2 * (distanceFromPlataform) + platformHeight - 40;

        //to introduce as a parameter in fixed-path-enemy constructor
        directionRight = true;

        //move to right
        if (directionRight) {


            //guardar pos
            if(enemy.getX() == maxX && !block1) {block1=true;}
            if (minX < maxX && !block1) {

                pos.setX(getX() + 1);
                dx = 1;
                dy = 0;
                return;

            }

            if (enemy.getY() == maxY && !block2 ) {block2=true;}
            if (minY < maxY && !block2 ) {

                pos.setY(getY() + 1);
                dx = 0;
                dy = 1;
                return;

            }

            if (enemy.getX() == minX && !block3) {block3=true;}
            if (maxX > minX && !block3) {

                pos.setX(getX() - 1);
                dx = -1;
                dy = 0;
                return;

            }

            if (enemy.getY() == minY && !block4) {

                block1 = false;
                block2 = false;
                block3 = false;
                block4 = false;
            }

            if ( maxY > minY && !block4) {

                pos.setY(getY() - 1);
                dx = 0;
                dy = -1;
            }



        }

    }



    @Override
    public void performCollision() {
    super.performCollision();
    }

    @Override
    public int getWidth() {
        return SIZE;
    }

    @Override
    public int getHeight() {
        return SIZE;
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




