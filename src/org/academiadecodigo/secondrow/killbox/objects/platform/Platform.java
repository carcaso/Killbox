package org.academiadecodigo.secondrow.killbox.objects.platform;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.killbox.Var;
import org.academiadecodigo.secondrow.killbox.objects.Collidable;
import org.academiadecodigo.secondrow.killbox.objects.Position;

public class Platform{

    private Position pos;
    private int width;
    private int height;
    private Rectangle platform;

    /**
     *
     * @param pos Position of the platform (top left corner)
     * @param width
     * @param height
     */
    public Platform(Position pos, int width, int height) {

        this.pos = pos;
        this.width = width;
        this.height = height;

        platform = new Rectangle(pos.getX(), pos.getY(), width, height);

        platform.setColor(Color.DARK_GRAY);
        platform.fill();

    }

    /**
     * Creates a platform in the middle of the screen
     * @param width of the desired platform
     * @param height of the desired platform
     */
    public Platform(int width, int height) {
        this.width = width;
        this.height = height;
        platform = createPlatformInCenter(width, height);
        platform.setColor(Color.DARK_GRAY);
        platform.fill();
    }

    private Rectangle createPlatformInCenter(int width, int height) {
        int x = Var.PADDING + Var.WIDTH  / 2 - width  / 2;
        int y = Var.PADDING + Var.HEIGHT / 2 - height / 2;
        pos = new Position(x, y);

        return new Rectangle(x, y, width, height);

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
