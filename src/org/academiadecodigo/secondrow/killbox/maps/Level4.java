package org.academiadecodigo.secondrow.killbox.maps;

import org.academiadecodigo.secondrow.killbox.objects.Door;
import org.academiadecodigo.secondrow.killbox.objects.Key;
import org.academiadecodigo.secondrow.killbox.objects.Player;
import org.academiadecodigo.secondrow.killbox.objects.Position;
import org.academiadecodigo.secondrow.killbox.objects.enemy.Bomb;
import org.academiadecodigo.secondrow.killbox.objects.enemy.Enemy;
import org.academiadecodigo.secondrow.killbox.objects.enemy.FixedPathEnemy;
import org.academiadecodigo.secondrow.killbox.objects.enemy.RunningEnemy;
import org.academiadecodigo.secondrow.killbox.objects.platform.JumpBox;
import org.academiadecodigo.secondrow.killbox.objects.platform.Platform;

public class Level4 extends Map{

    public Level4() {

        setPlatforms(new Platform[12]);
        setKeys(new Key[2]);
        setEnemy(new Enemy[10]);
        setJumpBoxes(new JumpBox[0]);

    }

    @Override
    public void draw(){


        setPlayer(new Player(true, 50, 60));

        //////////////////////////////////////////////////////////////////////////////////////////
        //top platform
        getPlatforms()[0] = new Platform(new Position(40, 100), 100, 50);
        //door platform
        getPlatforms()[1] = new Platform(new Position(1150, 150), 100, 50);
        //middle platforms
        getPlatforms()[2] = new Platform(new Position(155, 400), 40, 40);
        getPlatforms()[3] = new Platform(new Position(350, 400), 40, 40);
        getPlatforms()[4] = new Platform(new Position(450, 300), 40, 40);
        getPlatforms()[5] = new Platform(new Position(550, 400), 40, 40);
        getPlatforms()[6] = new Platform(new Position(650, 510), 40, 40);
        getPlatforms()[7] = new Platform(new Position(750, 400), 40, 40);
        getPlatforms()[8] = new Platform(new Position(850, 290), 40, 40);
        getPlatforms()[9] = new Platform(new Position(850, 500), 40, 40);
        getPlatforms()[10] = new Platform(new Position(950, 200), 40, 40);
        getPlatforms()[11] = new Platform(new Position(1090, 200), 40, 40);
        /////////////////////////////////////////////////////////////////////////////////////////
        setDoor(new Door(new Position(1170, 90), getKeys().length));
        /////////////////////////////////////////////////////////////////////////////////////////
        getKeys()[0] = new Key(new Position(463, 270), getDoor());
        getKeys()[1] = new Key(new Position(863, 480), getDoor());
        ////////////////////////////////////////////////////////////////////////////////////////
        getEnemies()[0] = new RunningEnemy(250, 50, 650, false, true, getPlayer());
        getEnemies()[1] = new RunningEnemy(350, 50, 650, false, true, getPlayer());
        getEnemies()[2] = new RunningEnemy(450, 50, 650, false, true, getPlayer());
        getEnemies()[3] = new RunningEnemy(550, 50, 650, false, true, getPlayer());
        getEnemies()[4] = new RunningEnemy(650, 50, 650, false, true, getPlayer());
        getEnemies()[5] = new RunningEnemy(750, 50, 650, false, true, getPlayer());
        getEnemies()[6] = new RunningEnemy(850, 50, 650, false, true, getPlayer());
        getEnemies()[7] = new RunningEnemy(950, 50, 650, false, true, getPlayer());
        getEnemies()[8] = new RunningEnemy(1050, 50, 650, false, true, getPlayer());
        getEnemies()[9] = new Bomb(40, 690, 1200, 10);
        ////////////////////////////////////////////////////////////////////////////////////////
        getPlayer().init();


    }

}


