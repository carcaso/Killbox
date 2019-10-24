package org.academiadecodigo.secondrow.killbox.maps;

import org.academiadecodigo.secondrow.killbox.Var;
import org.academiadecodigo.secondrow.killbox.objects.Door;
import org.academiadecodigo.secondrow.killbox.objects.Key;
import org.academiadecodigo.secondrow.killbox.objects.Player;
import org.academiadecodigo.secondrow.killbox.objects.Position;
import org.academiadecodigo.secondrow.killbox.objects.enemy.Enemy;
import org.academiadecodigo.secondrow.killbox.objects.enemy.FixedPathEnemy;
import org.academiadecodigo.secondrow.killbox.objects.enemy.RunningEnemy;
import org.academiadecodigo.secondrow.killbox.objects.platform.JumpBox;
import org.academiadecodigo.secondrow.killbox.objects.platform.Platform;

public class Level3 extends Map {

    public Level3() {
        setPlatforms(new Platform[6]);
        setKeys(new Key[1]);
        setEnemy(new Enemy[3]); //changed
        setJumpBoxes(new JumpBox[2]);
        setDoor(new Door(new Position(615, 180), getKeys().length));
    }

    @Override
    public void draw() {

        setPlayer(new Player(false, 150, 100));

        // Up platforms
        //Bigger
        getPlatforms()[0] = new Platform(new Position(90, 100), 1100, 50);

        //left
        getPlatforms()[1] = new Platform(new Position(90, 150), 50, 400);
        //right
        getPlatforms()[2] = new Platform(new Position(1140, 150), 50, 400);

        //Down platforms
        //left
        getPlatforms()[3] = new Platform(new Position(90, 550), 450, 50);
        //right
        getPlatforms()[4] = new Platform(new Position(740, 550), 450, 50);

        //Mid platform
        getPlatforms()[5] = new Platform(new Position(540,230),190,50);

        getKeys()[0] = new Key(new Position(100, 85), getDoor());

        getEnemies()[0] = new RunningEnemy(900, getPlatforms()[0].getY() - 40,
                getPlatforms()[0].getWidth() + getPlatforms()[0].getX() - 20, true, false, getPlayer());

        getEnemies()[1] = new RunningEnemy(getPlatforms()[3].getX(), getPlatforms()[3].getY() - 40,
                getPlatforms()[0].getWidth() + getPlatforms()[3].getX() - 20, true, false, getPlayer());

        getEnemies()[2] = new RunningEnemy(getPlatforms()[4].getX(), getPlatforms()[4].getY() - 40,
                getPlatforms()[0].getHeight() + getPlatforms()[4].getX() - 20, true, false, getPlayer());

        getJumpBoxes()[0] = new JumpBox(new Position(400,540), 20,10,3);

        getJumpBoxes()[1] = new JumpBox(new Position(580, 690),20,10,3);

        getPlayer().init();

    }
}
