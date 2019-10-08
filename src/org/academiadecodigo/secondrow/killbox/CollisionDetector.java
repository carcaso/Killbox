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


    public boolean[] check() {
        boolean isLanding = false;
        boolean isBumpingHead = false;
        boolean isBumpingRight = false;
        // TODO: 08/10/2019 do isBumpingLeft
        for (int i = 0; i < map.getPlatforms().length; i++) {

            int playerStartX = player.getX();
            int playerStartY = player.getY();

            int playerEndX = player.getX() + Var.PLAYER_WIDTH;
            int playerEndY = player.getY() + Var.PLAYER_HEIGHT;

            int objectStartX = map.getPlatform(i).getX();
            int objectStartY = map.getPlatform(i).getY();

            int objectEndX = map.getPlatform(i).getX() + map.getPlatform(i).getWidth();
            int objectEndY = map.getPlatform(i).getY() + map.getPlatform(i).getHeight();

            if ((playerStartX >= objectStartX && playerEndX <= objectEndX)) {

                if (playerEndY == objectStartY) {
                    //System.out.println("LANDING AT X: " + player.getX() + " AND Y: " + player.getY());
                    isLanding = true;
                }

                if (playerStartY == objectEndY) {
                    //System.out.println("BUMPED HEAD AT X: " + player.getX() + " AND Y: " + player.getY());
                    isBumpingHead = true;
                }
            }
            if (playerStartY >= objectStartY && playerEndY <= objectEndY) {
                if (playerEndX == objectStartY) {
                    //System.out.println("BUMPED RIGHT AT X: " + player.getX() + " AND Y: " + player.getY());
                    isBumpingRight = true;
                }
            }
        }

        boolean[] ret = {isBumpingHead, isLanding, isBumpingRight};
        return ret;
    }
}
