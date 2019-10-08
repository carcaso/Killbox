package org.academiadecodigo.secondrow.killbox;

import org.academiadecodigo.secondrow.killbox.maps.Map;
import org.academiadecodigo.secondrow.killbox.objects.Player;

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
    public boolean[] checkCollisionWithPlatforms() {
        boolean isLanding = false;
        boolean isBumpingHead = false;
        boolean isBumpingRight = false;
        boolean isBumpingLeft = false;

        for (int i = 0; i < map.getPlatforms().length; i++) {

            // Auxiliary variables to checkCollisionWithPlatforms collision
            int playerStartX = player.getX();
            int playerStartY = player.getY();
            int playerEndX = player.getX() + Var.PLAYER_WIDTH;
            int playerEndY = player.getY() + Var.PLAYER_HEIGHT;

            int objectStartX = map.getPlatform(i).getX();
            int objectStartY = map.getPlatform(i).getY();
            int objectEndX = map.getPlatform(i).getX() + map.getPlatform(i).getWidth();
            int objectEndY = map.getPlatform(i).getY() + map.getPlatform(i).getHeight();


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
                    isBumpingRight = true;
                }

                if (playerStartX == objectEndX) {
                    isBumpingLeft = true;
                }
            }
        }

        boolean[] ret = {isBumpingHead, isLanding, isBumpingRight, isBumpingLeft};
        return ret;
    }

    // TODO: 08/10/2019 collision with key

    // TODO: 08/10/2019 collision with door
}
