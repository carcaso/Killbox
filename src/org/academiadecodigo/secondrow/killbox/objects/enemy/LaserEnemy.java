package org.academiadecodigo.secondrow.killbox.objects.enemy;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Ellipse;
import org.academiadecodigo.secondrow.graphics.Line;
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
    public void collide(Map map) {
    }

    @Override
    public void move() {

    }

    @Override               ///////////don't think it's needed
    public void update(){

    }




    public void shot(int playerX, int playerY){



        if(shotTaken && counter < 900) {
            counter++;
            return;
        }
        if(counter == 900){shot.delete();}
        shot = new Line(pos.getX() + (width/2), pos.getY() + (height/2), playerX, playerY);
        shot.setColor(Color.GREEN);
        shot.draw();
        shotTaken = true;
        counter = 0;


    }

}
