package org.academiadecodigo.secondrow.killbox.objects.enemy;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Text;
import org.academiadecodigo.secondrow.killbox.objects.Collidable;
import org.academiadecodigo.secondrow.killbox.objects.Movable;
import org.academiadecodigo.secondrow.killbox.objects.Sound;

public class Enemy implements Movable, Collidable {

    public Sound effect = new Sound();

    @Override
    public void performCollision() {

        Text text = new Text(640, 360, "K.O");
        text.setColor(Color.RED);
        text.grow(150, 50);
        text.draw();
        //effect.playSound(0,"punch.wav");
        effect.playSound(0,"KO.wav");

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void move() {

    }

    public void update() {
    }


    //added
    public void shot(int playerX, int playerY) {
    }
}
