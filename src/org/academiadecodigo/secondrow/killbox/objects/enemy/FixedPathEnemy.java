package org.academiadecodigo.secondrow.killbox.objects.enemy;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Ellipse;
import org.academiadecodigo.secondrow.killbox.objects.Collidable;
import org.academiadecodigo.secondrow.killbox.objects.Movable;
import org.academiadecodigo.secondrow.killbox.objects.Position;

public class FixedPathEnemy extends Enemy implements Movable, Collidable {


    private int width = 40;
    private int height = 40;
    private int distanceFromPlataform = 15 + 40;

    private Position pos;
    private Ellipse enemy;

    private int plataformX;
    private int plataformY;
    private int plataformWidth;
    private int plataformHeight;

    private boolean block1 = false;
    private boolean block2 = false;
    private boolean block3 = false;
    private boolean block4 = false;

    private int dx = 0;
    private int dy = 0;


    public FixedPathEnemy(int plataformX, int plataformY, int plataformWidth, int plataformHeight) {

        this.plataformX = plataformX;
        this.plataformY = plataformY;
        this.plataformWidth = plataformWidth;
        this.plataformHeight = plataformHeight;

        pos = new Position(plataformX - distanceFromPlataform, plataformY - distanceFromPlataform);
        enemy = new Ellipse(pos.getX(), pos.getY(), width, height);
        enemy.setColor(Color.ORANGE);
        enemy.fill();
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

        int minX = pos.getX();
        int minY = pos.getY();
        int maxX = pos.getX() + 2 * (distanceFromPlataform) + plataformWidth - 40;
        int maxY = pos.getY() + 2 * (distanceFromPlataform) + plataformHeight - 40;

        //to introduce as a parameter in fixed-path-enemy constructor
        directionRight = true;


        //move to right
        if (directionRight) {

            if(enemy.getX() == maxX && !block1) {block1=true;}
            if (enemy.getX() < maxX && !block1) {
                dx = 1;
                dy = 0;
                return;

            }

            if (enemy.getY() == maxY && !block2 ) {block2=true;}
            if (enemy.getY() < maxY && !block2 ) {
                dx = 0;
                dy = 1;
                return;

            }

            if (enemy.getX() == minX && !block3) {block3=true;}
            if (enemy.getX() > minX && !block3) {
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

            if (enemy.getY() > minY && !block4) {
                dx = 0;
                dy = -1;
                return;
            }



        }

    }


}




