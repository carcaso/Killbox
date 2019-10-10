package org.academiadecodigo.secondrow.killbox.objects.platform;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.killbox.objects.Collidable;
import org.academiadecodigo.secondrow.killbox.objects.Position;

public class JumpBox implements Collidable {

    private Position pos;
    private int width;
    private int height;
    private Rectangle platform;

    public JumpBox(Position pos, int width, int height) {

        this.pos = pos;
        this.width = width;
        this.height = height;

        platform = new Rectangle(pos.getX(), pos.getY(), width, height);

        platform.setColor(Color.RED);
        platform.fill();
    }

    @Override
    public void performCollision() {
        // This method is not used.
    }

    public void delete(){
        super.delete();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return platform.getX();
    }

    public int getY() {
        return platform.getY();
    }

}

