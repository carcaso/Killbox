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
import org.academiadecodigo.secondrow.pictures.Picture;

public class Enemy implements Movable, Collidable {

    private Player player;


    public void Enemy(Player player) {
        this.player = player;
    }


    @Override
    public void performCollision() {
        Picture youDiedScreen = new Picture(400, 125, "resources/pictures/playerDead.png");
        //Rectangle youDiedScreen = new Rectangle(427,240, 426,240);
        //youDiedScreen.setColor(Color.WHITE);
        youDiedScreen.draw();

        //Text text = new Text(615, 350, "YOU DEAD!");
        //text.setColor(Color.RED);
        //text.draw();
        //text.grow(150, 50);

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
