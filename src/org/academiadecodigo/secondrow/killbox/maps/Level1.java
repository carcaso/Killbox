package org.academiadecodigo.secondrow.killbox.maps;

import org.academiadecodigo.secondrow.killbox.Var;
import org.academiadecodigo.secondrow.killbox.objects.Door;
import org.academiadecodigo.secondrow.killbox.objects.Key;
import org.academiadecodigo.secondrow.killbox.objects.Position;
import org.academiadecodigo.secondrow.killbox.objects.enemy.Enemy;
import org.academiadecodigo.secondrow.killbox.objects.enemy.FixedPathEnemy;
import org.academiadecodigo.secondrow.killbox.objects.platform.Platform;

public class Level1 extends Map {

    // TODO: 06/10/2019 Add walls to level.
    // 2 plats, 1 jump, 1 door, 1 enemy, 1 key
    public Level1() {
        setPlatforms(new Platform[2]);
        setKeys(new Key[1]);
        setEnemy(new Enemy[1]);

        // Door platform
        getPlatforms()[0] = new Platform(new Position(1085, 260), 205, 25);
        setDoor(new Door(new Position(Var.WIDTH - Var.DOOR_WIDTH - 30,
                getPlatforms()[0].getY() - Var.DOOR_HEIGHT)));

        // middle platform
        // getPlatforms()[1] = new Platform(350, 90);
        // int x = Var.PADDING + Var.WIDTH  / 2 - width  / 2 = 10 + 640 - 175 = 475
        // int y = Var.PADDING + Var.HEIGHT / 2 - height / 2; 360  = 325
        getPlatforms()[1] = new Platform(new Position(475, 325), 350, 90);

        // w: 350, h: 90

        // Create a key 5 pixels above platform and in the center of the screen
        getKeys()[0] = new Key(new Position(Var.WIDTH / 2 - Key.SIZE / 2 + Var.PADDING,
                Var.HEIGHT / 2 - getPlatforms()[1].getHeight() / 2 - Key.SIZE), getDoor());


        getEnemy()[0] = new FixedPathEnemy(getPlatforms()[1].getX(), getPlatforms()[1].getY(),
                                            getPlatforms()[1].getWidth(), getPlatforms()[1].getHeight());

    }

}
