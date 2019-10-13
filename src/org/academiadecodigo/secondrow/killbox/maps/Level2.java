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

public class Level2 extends Map{

    public Level2() {

        setPlatforms(new Platform[5]);
        setKeys(new Key[2]);
        setEnemy(new Enemy[15]);
        setJumpBoxes(new JumpBox[14]);

    }

    @Override
    public void draw(){


        setPlayer(new Player(true, 100, 100));

        //////////////////////////////////////////////////////////////////////////////////////////
        //top platform
        getPlatforms()[0] = new Platform(new Position(100, 130), 1080, 50);
        //left platform
        getPlatforms()[1] = new Platform(new Position(35,300),560, 100);
        //right platform
        getPlatforms()[2] = new Platform(new Position(695, 300), 560, 100);
        //platform standing up for L
        getPlatforms()[3] = new Platform(new Position(670, 500), 50, 120);
        //platform laying down for L
        getPlatforms()[4] = new Platform(new Position(720, 570), 150, 50);
        /////////////////////////////////////////////////////////////////////////////////////////
        //platform L jumpbox
        getJumpBoxes()[0] = new JumpBox(new Position(680, 495), 20, 5);
        //door jumpbox
        getJumpBoxes()[1] = new JumpBox(new Position(220, 695), 20, 5);
        //top platform jumpboxes
        getJumpBoxes()[2] = new JumpBox(new Position(150, 125), 20, 5);
        getJumpBoxes()[3] = new JumpBox(new Position(250, 125), 20, 5);
        getJumpBoxes()[4] = new JumpBox(new Position(350, 125), 20, 5);
        getJumpBoxes()[5] = new JumpBox(new Position(450, 125), 20, 5);
        getJumpBoxes()[6] = new JumpBox(new Position(550, 125), 20, 5);
        getJumpBoxes()[7] = new JumpBox(new Position(650, 125), 20, 5);
        getJumpBoxes()[8] = new JumpBox(new Position(750, 125), 20, 5);
        getJumpBoxes()[9] = new JumpBox(new Position(850, 125), 20, 5);
        getJumpBoxes()[10] = new JumpBox(new Position(950, 125), 20, 5);
        getJumpBoxes()[11] = new JumpBox(new Position(1050, 125), 20, 5);
        getJumpBoxes()[12] = new JumpBox(new Position(1150, 125), 20, 5);
        //key jumpbox
        getJumpBoxes()[13] = new JumpBox(new Position(60, 295), 20, 5);
        /////////////////////////////////////////////////////////////////////////////////////////
        getEnemies()[0] = new FixedPathEnemy(getPlatforms()[0].getX(),getPlatforms()[0].getY(),
                getPlatforms()[0].getWidth(),getPlatforms()[0].getHeight(),
                true, false);

        getEnemies()[1] = new RunningEnemy(30, 660, 1200, true, false, getPlayer());
        //////////////////////////////////////////////////////////////////////////////////////////
        getEnemies()[2] = new Bomb(115, 630);
        getEnemies()[3] = new Bomb(130, 620);
        getEnemies()[4] = new Bomb(140, 630);
        getEnemies()[5] = new Bomb(145, 645);
        getEnemies()[6] = new Bomb(155, 630);
        getEnemies()[7] = new Bomb(165, 665);
        getEnemies()[8] = new Bomb(170, 640);
        getEnemies()[9] = new Bomb(180, 680);
        getEnemies()[10] = new Bomb(185, 665);
        getEnemies()[11] = new Bomb(200, 680);
        //platform L bombs
        getEnemies()[12] = new Bomb(590, 440);
        getEnemies()[13] = new Bomb(620, 470);
        getEnemies()[14] = new Bomb(650, 500);
        //getEnemies()[15] = new Bomb(675, 500);
        //////////////////////////////////////////////////////////////////////////////////////////
        setDoor(new Door(new Position(100, 640), getKeys().length));
        //////////////////////////////////////////////////////////////////////////////////////////
        getKeys()[0] = new Key(new Position(1155, 100), getDoor());
        getKeys()[1] = new Key(new Position(900, 280), getDoor());
        /////////////////////////////////////////////////////////////////////////////////////////
        getPlayer().init();


    }

}

