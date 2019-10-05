package org.academiadecodigo.secondrow.killbox;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;

public class Game {

    Rectangle background;

    public void init() {
        background = new Rectangle(Var.PADDING, Var.PADDING, Var.WIDTH, Var.HEIGHT);
        background.setColor(Color.LIGHT_GRAY);
        background.fill();
    }

    public void start() {

    }
}
