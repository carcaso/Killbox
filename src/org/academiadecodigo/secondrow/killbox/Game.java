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

        background = new Rectangle(Var.PADDING + Var.CELL_SIZE, Var.PADDING + Var.CELL_SIZE,
                Var.WIDTH - 2 * Var.CELL_SIZE, Var.HEIGHT - 2 * Var.CELL_SIZE);
        background.setColor(Color.LIGHT_GRAY);
        background.fill();

        p1 = new Player(false);
        p1.init();
    }

    public void start(Map map) {
        collisionDetector = new CollisionDetector(map, p1);

        while (true) {
            p1.update(collisionDetector.checkCollision(map.getPlatforms()));
            p1.move(map.getPlatforms());

            for (int i = 0; i < map.getKeys().length; i++) {
                collisionDetector.checkCollision(map.getKeys()[i]);
            }
            for (int i = 0; i < map.getEnemy().length; i++) {
                collisionDetector.checkCollision(map.getEnemy()[i]);
            }

            if (map.getDoor().isOpen()) {
                if (collisionDetector.checkCollision(map.getDoor())) {
                    break;
                }
            }

            for (int i = 0; i < map.getJumpBoxes().length; i++) {
                collisionDetector.checkCollision(map.getJumpBoxes()[i]);
            }

            for (int i = 0; i < map.getEnemy().length; i++) {
                map.getEnemy()[i].update();
                map.getEnemy()[i].move();
                map.getEnemy()[i].shot(p1.getX(), p1.getY());
            }

            try {
                Thread.sleep(Var.DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
