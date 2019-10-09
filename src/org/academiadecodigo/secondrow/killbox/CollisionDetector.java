package org.academiadecodigo.secondrow.killbox;

import org.academiadecodigo.secondrow.killbox.maps.Map;
import org.academiadecodigo.secondrow.killbox.objects.Collidable;
import org.academiadecodigo.secondrow.killbox.objects.Key;
import org.academiadecodigo.secondrow.killbox.objects.Player;
import org.academiadecodigo.secondrow.killbox.objects.platform.Platform;

public class CollisionDetector {

    Map map;
    Player player;

    public CollisionDetector(Map map, Player player) {
        this.player = player;
        this.map = map;
    }

    /**
     * Checks collision with Platforms
     * @return array of "if side is touching platform" top, bottom, right, left.
     */
    public boolean[] checkCollision(Platform[] objects) {
        boolean isLanding = false;
        boolean isBumpingHead = false;
        boolean isBumpingRight = false;
        boolean isBumpingLeft = false;

        for (int i = 0; i < objects.length; i++) {
            //PLayerInformation
            int playerStartX = player.getX();
            int playerStartY = player.getY();
            int playerEndX = player.getX() + Var.PLAYER_WIDTH;
            int playerEndY = player.getY() + Var.PLAYER_HEIGHT;

            //Object information
            int objectStartX = objects[i].getX();
            int objectStartY = objects[i].getY();
            int objectEndX = objects[i].getX() + objects[i].getWidth();
            int objectEndY = objects[i].getY() + objects[i].getHeight();

            if ((playerEndX > objectStartX && playerStartX < objectEndX)) {

                if (playerEndY == objectStartY) {
                    isLanding = true;
                }

                if (playerStartY == objectEndY) {
                    isBumpingHead = true;
                }
            }

            // Checks if player is in between a platform and sees if height is the same.
            if ((playerStartY >= objectStartY && playerStartY <= objectEndY)
                    || (playerEndY >= objectStartY && playerEndY <= objectEndY)) {
                if (playerEndX == objectStartX) {
                    System.out.println("right");
                    isBumpingRight = true;
                }

                if (playerStartX == objectEndX) {
                    System.out.println("left");
                    isBumpingLeft = true;
                }
            }

            /* **************** Unecessary if **************** */
            if(isBumpingHead || isBumpingLeft || isBumpingRight || isLanding) {
                objects[i].performCollision();
            }

        }

        boolean[] ret = {isBumpingHead, isLanding, isBumpingRight, isBumpingLeft};
        return ret;
    }

    /**
     * to check collision with keys and enemies.
     * @param objects
     */
    public void checkCollision(Collidable[] objects) {
        int playerStartX = player.getX();
        int playerStartY = player.getY();
        int playerEndX = player.getX() + Var.PLAYER_WIDTH;
        int playerEndY = player.getY() + Var.PLAYER_HEIGHT;

        for (int i = 0; i < objects.length; i++) {

            //Object information
            int objectStartX = objects[i].getX();
            int objectStartY = objects[i].getY();
            int objectEndX = objects[i].getX() + objects[i].getWidth();
            int objectEndY = objects[i].getY() + objects[i].getHeight();

            if (
                    ( objectStartX >= playerStartX && objectStartX <= playerEndX
                            && objectStartY >= playerStartY && objectStartY <= playerEndY )
                    || ( objectEndX >= playerStartX && objectEndX <= playerEndX
                            && objectStartY >= playerStartY && objectStartY <= playerEndY )
                    || ( objectEndY >= playerStartX && objectEndY <= playerStartX
                            && objectStartX >= playerStartX && objectStartX <= playerEndX)
            ) {

                objects[i].performCollision();
            }

        }
    }


    // TODO: 08/10/2019 collision with door
}
