package org.academiadecodigo.secondrow.killbox.objects.platform;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.killbox.objects.Collidable;
import org.academiadecodigo.secondrow.killbox.objects.Position;

public class Platform implements Collidable {

    private Position pos;
    private int width;
    private int height;
    private Rectangle platform;

    public Platform(Position pos, int width, int height) {

        this.pos = pos;
        this.width = width;
        this.height = height;

        platform = new Rectangle(pos.getX(), pos.getY(), width, height);

        platform.setColor(Color.DARK_GRAY);
        platform.fill();

    }

    @Override
    public void collide() {

    }
}
