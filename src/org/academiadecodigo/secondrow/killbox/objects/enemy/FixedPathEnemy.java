package org.academiadecodigo.secondrow.killbox.objects.enemy;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Ellipse;
import org.academiadecodigo.secondrow.killbox.Var;
import org.academiadecodigo.secondrow.killbox.objects.Collidable;
import org.academiadecodigo.secondrow.killbox.objects.Movable;
import org.academiadecodigo.secondrow.killbox.objects.Position;

public class FixedPathEnemy extends Enemy implements Movable, Collidable {

    private int SIZE = 40;

    private int distanceFromPlatform = 15 + SIZE;

    private Position pos;
    private Ellipse enemy;

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

    private boolean directionRight = false;
    private boolean directionLeft = false;
    private boolean horizontal = false;
    private boolean vertical = false;

    private int end;
    int start;

    public FixedPathEnemy(int platformX, int platformY, int platformWidth, int platformHeight, boolean directionLeft, boolean directionRight) {
        this.platformX = platformX;
        this.platformY = platformY;
        this.platformWidth = platformWidth;
        this.platformHeight = platformHeight;
        this.directionLeft = directionLeft;
        this.directionRight = directionRight;

        pos = new Position(platformX - distanceFromPlatform, platformY - distanceFromPlatform);
        enemy = new Ellipse(pos.getX(), pos.getY(), SIZE, SIZE);
        enemy.setColor(Color.ORANGE);
        enemy.fill();
    }

    public FixedPathEnemy(int x, int y, int endOfPath, boolean horizontal, boolean vertical){

        this.end = endOfPath;
        this.horizontal = horizontal;
        this.vertical = vertical;

        pos = new Position(x, y);
        enemy = new Ellipse(x, y, SIZE, SIZE);
        enemy.setColor(Color.ORANGE);
        enemy.fill();
        start = pos.getX();
    }


    @Override
    public void move() {
        enemy.translate(dx, dy);
    }

    @Override
    public void update(){

        if (directionRight) {moveRight();}

        if (directionLeft) {moveLeft();}

        if(horizontal) { moveHorizontal();}

        if (vertical) { moveVertical();}

    }

    public void moveRight(){

        int minX = platformX - distanceFromPlatform;

        //int minY = pos.getY();
        int minY = platformY - distanceFromPlatform;

        int maxX = minX + 2 * (distanceFromPlatform) + platformWidth - 40;
        int maxY = minY + 2 * (distanceFromPlatform) + platformHeight - 40;


        if(enemy.getX() == maxX && !block1) {block1=true;}
        if (minX < maxX && !block1) {

            pos.setX(getX() + Var.ENEMY_SPEED);
            dx = Var.ENEMY_SPEED;
            dy = 0;
            return;

        }

        if (enemy.getY() == maxY && !block2 ) {block2=true;}
        if (minY < maxY && !block2 ) {

            pos.setY(getY() + Var.ENEMY_SPEED);
            dx = 0;
            dy = Var.ENEMY_SPEED;
            return;

        }

        if (enemy.getX() == minX && !block3) {block3=true;}
        if (maxX > minX && !block3) {

            pos.setX(getX() - Var.ENEMY_SPEED);
            dx = -Var.ENEMY_SPEED;
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

            pos.setY(getY() - Var.ENEMY_SPEED);
            dx = 0;
            dy = -Var.ENEMY_SPEED;
        }

    }

    public void moveLeft(){

        int minX = platformX - distanceFromPlatform;

        //int minY = pos.getY();
        int minY = platformY - distanceFromPlatform;

        int maxX = minX + 2 * (distanceFromPlatform) + platformWidth - 40;
        int maxY = minY + 2 * (distanceFromPlatform) + platformHeight - 40;

        if(enemy.getY() == maxY){block1 = true;}
        if(minY < maxY && !block1){
            pos.setY(getY() + Var.ENEMY_SPEED);
            dx = 0;
            dy = Var.ENEMY_SPEED;
            return;
        }

        if(enemy.getX() == maxX){block2 = true;}
        if(minX < maxX && !block2){
            pos.setX(getX() + Var.ENEMY_SPEED);
            dx = Var.ENEMY_SPEED;
            dy = 0;
            return;
        }

        if(enemy.getY() == minY) {block3 = true;}
        if(maxY > minY && !block3){
            pos.setY(getY() - Var.ENEMY_SPEED);
            dx = 0;
            dy = -Var.ENEMY_SPEED;
            return;
        }

        if(enemy.getX() == minX){
            block1 = false;
            block2 = false;
            block3 = false;
            block4 = false;
        }

        if(maxX > minX && !block4) {
            pos.setX(getX() - Var.ENEMY_SPEED);
            dx = -Var.ENEMY_SPEED;
            dy = 0;
            return;
        }

    }

    public void moveVertical(){

        int start = pos.getY();

        if(enemy.getY() == end) {block1 = true;}
        if(start < end) {
            pos.setY(getY() + Var.ENEMY_SPEED);
            dy = Var.ENEMY_SPEED;
            return;
        }


        if (enemy.getY() == start) {block1 = false;}
        if(end > start) {
            pos.setY(getY() - Var.ENEMY_SPEED);
            dy = - Var.ENEMY_SPEED;
            return;
        }


    }

    public void moveHorizontal(){




        if(enemy.getX() == end) {block1 = true;}
        if(start < end && !block1) {
            pos.setX(getX() + Var.ENEMY_SPEED);
            dx = Var.ENEMY_SPEED;
            return;
        }

        if(enemy.getX() == start){block1 = false;}
        if(end > start && !block2) {
            pos.setX(getX() - Var.ENEMY_SPEED);
            dx = -Var.ENEMY_SPEED;
            return;
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

    @Override
    public void delete(){

        enemy.delete();

    }

}




