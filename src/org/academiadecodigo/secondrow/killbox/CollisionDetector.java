package org.academiadecodigo.secondrow.killbox;

import org.academiadecodigo.secondrow.killbox.maps.Map;
import org.academiadecodigo.secondrow.killbox.objects.Collidable;
import org.academiadecodigo.secondrow.killbox.objects.Player;
import org.academiadecodigo.secondrow.killbox.objects.platform.JumpBox;
import org.academiadecodigo.secondrow.killbox.objects.platform.Platform;

public class CollisionDetector {

    Map map;
    Player player;

    // Player information
    private int playerStartX;
    private int playerStartY;
    private int playerEndX;
    private int playerEndY;

    //Object information
    private int objectStartX;
    private int objectStartY;
    private int objectEndX;
    private int objectEndY;

    public CollisionDetector(Map map, Player player) {
        this.player = player;
        this.map = map;
    }

    /**
     * Checks collision with Platforms
     *
     * @return array of "if side is touching platform" top, bottom, right, left.
     */
    public boolean[] checkCollision(Platform[] objects) {
        boolean isLanding = false;
        boolean isBumpingHead = false;
        boolean isBumpingRight = false;
        boolean isBumpingLeft = false;

        for (int i = 0; i < objects.length; i++) {

            getPositions(objects[i]);

            if ((playerEndX > objectStartX && playerStartX < objectEndX)) {

                // Colliding bottom
                if (playerEndY == objectStartY) {
                    isLanding = true;
                }

                // Colliding top
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

            if (isBumpingHead || isBumpingLeft || isBumpingRight || isLanding) {
                objects[i].performCollision();
            }

        }

        boolean[] ret = {isBumpingHead, isLanding, isBumpingRight, isBumpingLeft};
        return ret;
    }

    /**
     * to check collision with keys and enemies.
     *
     * @param object
     */
    public boolean checkCollision(Collidable object) {

        getPositions(object);

        // TODO: 2019-10-11 clean this mess
        if (
                ((playerStartX >= objectStartX && playerStartX <= objectEndX
                        && playerStartY >= objectStartY && playerStartY <= objectEndY)

                        || (playerEndX >= objectStartX && playerEndX <= objectEndX
                        && playerStartY >= objectStartY && playerStartY <= objectEndY)
                        || (playerStartX >= objectStartX && playerStartX <= objectEndX
                        && playerEndY >= objectStartY && playerEndY <= objectEndY)
                        || (playerEndX >= objectStartX && playerEndX <= objectEndX
                        && playerEndY >= objectStartY && playerEndY <= objectEndY))

                        || ((objectStartX >= playerStartX && objectStartX <= playerEndX
                        && objectStartY >= playerStartY && objectStartY <= playerEndY)

                        || (objectEndX >= playerStartX && objectEndX <= playerEndX
                        && objectStartY >= playerStartY && objectStartY <= playerEndY)
                        || (objectStartX >= playerStartX && objectStartX <= playerEndX
                        && objectEndY >= playerStartY && objectEndY <= playerEndY)
                        || (objectEndX >= playerStartX && objectEndX <= playerEndX
                        && objectEndY >= playerStartY && objectEndY <= playerEndY))

        ) {

            object.performCollision();

            if (object instanceof JumpBox) {
                JumpBox jumpBox = (JumpBox) object;
                player.boost(jumpBox);
            }
            return true;
        }
        return false;
    }


    public void getPositions(Collidable object) {
        playerStartX = player.getX();
        playerStartY = player.getY();
        playerEndX = player.getX() + Var.PLAYER_WIDTH;
        playerEndY = player.getY() + Var.PLAYER_HEIGHT;

        //Object information
        objectStartX = object.getX();
        objectStartY = object.getY();
        objectEndX = object.getX() + object.getWidth();
        objectEndY = object.getY() + object.getHeight();
    }
}
