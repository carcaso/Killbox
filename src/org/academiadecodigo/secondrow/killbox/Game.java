package org.academiadecodigo.secondrow.killbox;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.killbox.maps.Map;
import org.academiadecodigo.secondrow.killbox.objects.Player;

public class Game {

    private Rectangle background;
    private Rectangle walls;
    private Player p1;
    private CollisionDetector collisionDetector;

    public void init() {
        // Create walls (If later they change by level, move this code).
        walls = new Rectangle(Var.PADDING, Var.PADDING, Var.WIDTH, Var.HEIGHT);
        walls.setColor(Color.DARK_GRAY);
        walls.fill();

        background = new Rectangle(Var.PADDING + Var.WALL_PADDING, Var.PADDING + Var.WALL_PADDING,
                Var.WIDTH - 2 * Var.WALL_PADDING, Var.HEIGHT - 2 * Var.WALL_PADDING);
        background.setColor(Color.LIGHT_GRAY);
        background.fill();

        p1 = new Player(true);
        p1.init();
    }

    public void start(Map map) {
        collisionDetector = new CollisionDetector(map, p1);

        while (true) {
            p1.update(collisionDetector.checkCollision(map.getPlatforms()));
            p1.move();
            collisionDetector.checkCollision(map.getKeys());

            map.getEnemy()[0].update();
            map.getEnemy()[0].move();

            try {
                Thread.sleep(Var.DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
