package org.academiadecodigo.secondrow.killbox.objects.enemy;

import org.academiadecodigo.secondrow.graphics.*;
import org.academiadecodigo.secondrow.killbox.Var;
import org.academiadecodigo.secondrow.killbox.maps.Map;
import org.academiadecodigo.secondrow.killbox.objects.Collidable;
import org.academiadecodigo.secondrow.killbox.objects.Position;

public class LaserEnemy extends Enemy implements Collidable {

    private int width = 20;
    private int height = 20;
    private int distanceFromPlataform = 15 + 40;

    private Position pos;
    private Ellipse enemy;
    private Line shot;

    private int dx = 0;
    private int dy = 0;

    private boolean shotTaken;
    private int counter = 0;

    public LaserEnemy(int creationX, int creationY ) {

        pos = new Position(creationX, creationY);
        enemy = new Ellipse(creationX, creationY, width,height);
        enemy.setColor(Color.ORANGE);
        enemy.fill();



    }

    @Override
    public void performCollision() {
      super.performCollision();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
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
    public void move() {

    }

    @Override               ///////////don't think it's needed
    public void update(){

    }

    @Override
    public void delete(){

        enemy.delete();
        shot.delete();

    }



    public void shot(int playerX, int playerY){



        if(shotTaken && counter < 900) {
            counter++;
            return;
        }

        if(counter == 900){shot.delete();}

        int inicialX = pos.getX() + (width/2);
        int inicialY = pos.getY() + (height/2);

        int finalY = Var.HEIGHT - Var.WALL_PADDING + 10;

        int finalX = playerX + Var.PLAYER_WIDTH;


        //ADD line-platform collision and ADD player-line collision and ADD don't shot when below platform

        shot = new Line( inicialX, inicialY, finalX, finalY);
        shot.setColor(Color.GREEN);
        shot.draw();
        shotTaken = true;
        counter = 0;


    }

}
