package org.academiadecodigo.secondrow.killbox.objects.enemy;

import org.academiadecodigo.secondrow.killbox.maps.Map;
import org.academiadecodigo.secondrow.killbox.objects.Collidable;
import org.academiadecodigo.secondrow.killbox.objects.Movable;
import org.academiadecodigo.secondrow.killbox.objects.Position;

public class Enemy implements Movable, Collidable {


    @Override
    public void collide(Map map) {
    }

    @Override
    public void move() {

    }

    public void update(){}


    //added
    public void shot(int playerX, int playerY){}
}
