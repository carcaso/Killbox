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

        //PLayerInformation
        int playerStartX = player.getX();
        int playerStartY = player.getY();
        int playerEndX = player.getX() + Var.PLAYER_WIDTH;
        int playerEndY = player.getY() + Var.PLAYER_HEIGHT;

        for (int i = 0; i < map.getPlatforms().length; i++) {

            //PLatform information
            int objectStartX = map.getPlatform(i).getX();
            int objectStartY = map.getPlatform(i).getY();
            int objectEndX = map.getPlatform(i).getX() + map.getPlatform(i).getWidth();
            int objectEndY = map.getPlatform(i).getY() + map.getPlatform(i).getHeight();

            //parentesis a mais removido
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

        /**
         * Added the new method checkColision with key
         * */
        for(int i=0; i< map.getKeys().length; i++){


            // Size of the key
            int keyStartX = map.getKey(i).getX();
            int keyStartY = map.getKey(i).getY();
            int keyEndX = map.getKey(i).getX()+ map.getKey(i).getWidth();
            int keyEndY = map.getKey(i).getY()+map.getKey(i).getHeigth();

            if (playerEndX > keyStartX && playerStartX < keyEndX){

                if(playerEndY == keyStartY){
                    map.getKey(i).setCollide();
                }

                if(playerStartY == keyEndY){
                    map.getKey(i).setCollide();
                }
            }

            // Checks if player is in between a platform and sees if height is the same.
            if ((playerStartY >= keyStartY && playerStartY <= keyEndY)
                    || (playerEndY >= keyStartY && playerEndY <= keyEndY)) {
                if (playerEndX == keyStartX) {
                    map.getKey(i).setCollide();
                }

                if (playerStartX == keyEndX) {
                    map.getKey(i).setCollide();
                }
            }

        }

        boolean[] ret = {isBumpingHead, isLanding, isBumpingRight, isBumpingLeft};
        return ret;
    }


    // TODO: 08/10/2019 collision with door
}
