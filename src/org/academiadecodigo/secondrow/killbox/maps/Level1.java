package org.academiadecodigo.secondrow.killbox.maps;

import org.academiadecodigo.secondrow.killbox.Var;
import org.academiadecodigo.secondrow.killbox.objects.Door;
import org.academiadecodigo.secondrow.killbox.objects.Key;
import org.academiadecodigo.secondrow.killbox.objects.Position;
import org.academiadecodigo.secondrow.killbox.objects.enemy.Bomb;
import org.academiadecodigo.secondrow.killbox.objects.enemy.Enemy;
import org.academiadecodigo.secondrow.killbox.objects.enemy.FixedPathEnemy;
import org.academiadecodigo.secondrow.killbox.objects.enemy.LaserEnemy;
import org.academiadecodigo.secondrow.killbox.objects.platform.JumpBox;
import org.academiadecodigo.secondrow.killbox.objects.platform.Platform;

public class Level1 extends Map {

    // TODO: 06/10/2019 Add walls to level.
    // 2 plats, 1 jump, 1 door, 1 enemy, 1 key
    public Level1() {
        setPlatforms(new Platform[2]);
        setKeys(new Key[1]);
        setEnemy(new Enemy[2]); //changed
        setJumpBoxes(new JumpBox[2]);

        // Door platform
        /*getPlatforms()[0] = new Platform(
                new Position(Var.PADDING + Var.WIDTH - Var.WALL_PADDING - 6 * Var.CELL_SIZE,
                        7 * Var.CELL_SIZE),
                6 * Var.CELL_SIZE, Var.CELL_SIZE);*/

        //Original x of platform 85
        getPlatforms()[0] = new Platform(new Position(1065, 260), 205, 25);
        setDoor(new Door(new Position(Var.WIDTH - Var.DOOR_WIDTH - 30,
                getPlatforms()[0].getY() - Var.DOOR_HEIGHT),getKeys().length));

        // middle platform
        getPlatforms()[1] = new Platform(new Position(475, 325), 350, 90);

        getJumpBoxes()[0] = new JumpBox(new Position(425, Var.HEIGHT - Var.WALL_PADDING), 20, 10);
        getJumpBoxes()[1] = new JumpBox(new Position(1025, Var.HEIGHT - Var.WALL_PADDING), 20, 10);

        // Create a keys 5 pixels above platform and in the center of the screen
        getKeys()[0] = new Key(new Position(Var.WIDTH / 2 - Key.SIZE / 2 + Var.PADDING,
                Var.HEIGHT / 2 - getPlatforms()[1].getHeight() / 2 - Key.SIZE), getDoor());
        /*getKeys()[1] = new Key(new Position((Var.WIDTH / 2 - Key.SIZE / 2 + Var.PADDING)+20,
                Var.HEIGHT / 2 - getPlatforms()[1].getHeight() / 2 - Key.SIZE), getDoor());*/


        getEnemy()[0] = new FixedPathEnemy(getPlatforms()[1].getX(), getPlatforms()[1].getY(),
                getPlatforms()[1].getWidth(), getPlatforms()[1].getHeight());

        getEnemy()[1] = new Bomb(700, 200);


    }

}
