package org.academiadecodigo.secondrow.killbox.maps;

import org.academiadecodigo.secondrow.killbox.Game;
import org.academiadecodigo.secondrow.killbox.Var;
import org.academiadecodigo.secondrow.killbox.objects.Key;
import org.academiadecodigo.secondrow.killbox.objects.Player;
import org.academiadecodigo.secondrow.killbox.objects.Position;
import org.academiadecodigo.secondrow.killbox.objects.enemy.Enemy;
import org.academiadecodigo.secondrow.killbox.objects.platform.JumpBox;
import org.academiadecodigo.secondrow.killbox.objects.platform.Platform;

public class Level3 extends Map{

    public static void main(String[] args) {
        Game game = new Game();
        Level3 level3 = new Level3();
        game.init();
        game.start(level3);
    }

    public Level3(){
        setPlatforms(new Platform[2]);
        setKeys(new Key[1]);
        setEnemy(new Enemy[1]); //changed
        setJumpBoxes(new JumpBox[2]);
    }

    @Override
    public void draw(){

        setPlayer(new Player(true, Var.PADDING + Var.WALL_PADDING + 700, 200));

        getPlatforms()[0] = new Platform(new Position(50, 50), 100, 100);
    }
}
