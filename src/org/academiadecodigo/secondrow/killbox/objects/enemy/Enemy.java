package org.academiadecodigo.secondrow.killbox.objects.enemy;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.graphics.Text;
import org.academiadecodigo.secondrow.killbox.CollisionDetector;
import org.academiadecodigo.secondrow.killbox.Var;
import org.academiadecodigo.secondrow.killbox.maps.Map;
import org.academiadecodigo.secondrow.killbox.objects.Collidable;
import org.academiadecodigo.secondrow.killbox.objects.Movable;
import org.academiadecodigo.secondrow.killbox.objects.Player;
import org.academiadecodigo.secondrow.killbox.objects.Position;

public class Enemy implements Movable, Collidable {

    private Player player;


    public void Enemy(Player player) {
        this.player = player;
    }


    @Override
    public void performCollision() {
        Rectangle youDiedScreen =new Rectangle(Var.PADDING + Var.CELL_SIZE, Var.PADDING + Var.CELL_SIZE,
                Var.WIDTH - 2 * Var.CELL_SIZE, Var.HEIGHT - 2 * Var.CELL_SIZE);
        youDiedScreen.setColor(Color.LIGHT_GRAY);
        youDiedScreen.fill();

        Text text = new Text(615, 350, "YOU DEAD!");
        text.setColor(Color.RED);
        text.draw();
        text.grow(150, 50);
        //player.setDead(true);

        Rectangle repeatLevel = new Rectangle(400, 500, 200, 70);
        repeatLevel.setColor(Color.BLACK);
        repeatLevel.draw();

        Text repeatLevelText = new Text(440, 530, "REPEAT LEVEL (Press S)");
        repeatLevelText.grow(10, 10);
        repeatLevelText.draw();


        Rectangle quit = new Rectangle(700, 500, 200, 70);
        quit.setColor(Color.BLACK);
        quit.draw();

        Text quitText = new Text(765, 530, "QUIT (Press Q)");
        quitText.grow(10, 10);
        quitText.draw();

    }

    @Override
    public int getWidth() { return 0; }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void move() {

    }

    ///////////////////////////////////////////////////////////////////

    public void update(){}

    public void delete(){}

    public void shot(int playerX, int playerY){}
}
