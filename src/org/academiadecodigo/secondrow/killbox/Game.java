package org.academiadecodigo.secondrow.killbox;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.killbox.maps.*;
import org.academiadecodigo.secondrow.killbox.objects.Player;

public class Game {

    private Rectangle background;
    private Rectangle walls;
    private Player p1;
    private CollisionDetector collisionDetector;
    //must exist
    private Map[] maps = { /*new Level1(), new Level2(), */new Level3(), new Level4(), new FinalLevel()};

    private boolean playerDead = false;
    private boolean playerWon = false;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Map[] getMaps(){

        return maps;
    }

    public boolean getPlayerWon(){
        return playerWon;
    }

    public void setPlayerWon(boolean value){
        playerWon = value;
    }

    public boolean getPlayerDead (){
        return playerDead;
    }

    public void setPlayerDead(boolean value){
        playerDead = value;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    public void init() {

        // Create walls (If later they change by level, move this code).
        walls = new Rectangle(Var.PADDING, Var.PADDING, Var.WIDTH, Var.HEIGHT);
        walls.setColor(Color.DARK_GRAY);
        walls.fill();

        background = new Rectangle(Var.PADDING + Var.CELL_SIZE, Var.PADDING + Var.CELL_SIZE,
                Var.WIDTH - 2 * Var.CELL_SIZE, Var.HEIGHT - 2 * Var.CELL_SIZE);
        background.setColor(Color.LIGHT_GRAY);
        background.fill();
    }


    public void start(Map map) {

        p1 = map.getPlayer();

        collisionDetector = new CollisionDetector(map, p1);

        while (!playerDead && !playerWon) {
            p1.update(collisionDetector.checkCollision(map.getPlatforms()));
            p1.move(map.getPlatforms());

            for (int i = 0; i < map.getKeys().length; i++) {
                collisionDetector.checkCollision(map.getKeys()[i]);
            }
            /*
            for (int i = 0; i < map.getEnemies().length; i++) {
                collisionDetector.checkCollision(map.getEnemies()[i]);

            }
            */
            if (map.getDoor().isOpen()) {
                if (collisionDetector.checkCollision(map.getDoor())) {
                    playerWon = true;
                }
            }

            for (int i = 0; i < map.getJumpBoxes().length; i++) {
                collisionDetector.checkCollision(map.getJumpBoxes()[i]);
            }

            for (int i = 0; i < map.getEnemies().length; i++) {
                if(collisionDetector.checkCollision(map.getEnemies()[i])){
                 playerDead = true;
                }
                map.getEnemies()[i].update();
                map.getEnemies()[i].move();
                map.getEnemies()[i].shot(p1.getX(), p1.getY());
            }

            try {
                Thread.sleep(Var.DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
