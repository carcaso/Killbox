package org.academiadecodigo.secondrow.killbox.objects.enemy;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Ellipse;
import org.academiadecodigo.secondrow.killbox.Var;
import org.academiadecodigo.secondrow.killbox.objects.Collidable;
import org.academiadecodigo.secondrow.killbox.objects.Movable;
import org.academiadecodigo.secondrow.killbox.objects.Player;
import org.academiadecodigo.secondrow.killbox.objects.Position;


public class RunningEnemy extends Enemy implements Movable ,Collidable {

    private boolean horizontal;
    private boolean vertical;
    private int SIZE = 35;
    private int start;
    private int end;
    private int dx;
    private int dy;
    private boolean block1 = false;
    private boolean block2 = false;

    private Player player;
    private Position pos;
    private Ellipse enemy;


    public RunningEnemy(int x, int y, int endOfPath, boolean horizontal, boolean vertical, Player player) {

        end = endOfPath;
        this.horizontal = horizontal;
        this.vertical = vertical;

        this.player = player;
        pos = new Position(x, y);
        enemy = new Ellipse(x, y, SIZE, SIZE);
        enemy.setColor(Color.ORANGE);
        enemy.fill();
        if(horizontal) {start = pos.getX();}
        if(vertical) {start = pos.getY();}
}







    @Override
    public void move() {
        enemy.translate(dx, dy);
    }

    @Override
    public void update(){

        if(horizontal) { moveHorizontal();}

        if (vertical) { moveVertical();}

    }

    public void moveVertical(){

        dy = 0;

        if(enemy.getY() == end) {block1 = true;}
        if(start < end && !block1) {
            if(enemy.getX() == player.getX() && player.getY() > enemy.getY()){
                pos.setY(getY() + Var.ENEMY_SPEED * 2);
                dy = Var.ENEMY_SPEED * 2;
                return;
            }
            pos.setY(getY() + Var.ENEMY_SPEED);
            dy = Var.ENEMY_SPEED;
            return;
        }


        if (enemy.getY() == start) {block1 = false;}
        if(end > start) {
            if(enemy.getX() == player.getX() && player.getY() < enemy.getY()){
                pos.setY(getY() - Var.ENEMY_SPEED * 2);
                dy = - Var.ENEMY_SPEED;
                return;
            }
            pos.setY(getY() - Var.ENEMY_SPEED);
            dy = -Var.ENEMY_SPEED;
            return;
        }


    }

    public void moveHorizontal(){




        if(enemy.getX() == end) {block1 = true;}
        if(start < end && !block1) {
            if(enemy.getY() == player.getY() && player.getX() > enemy.getX()){
                pos.setX(getX() + Var.ENEMY_SPEED * 2);
                dx = Var.ENEMY_SPEED * 2;
                return;
            }
            pos.setX(getX() + Var.ENEMY_SPEED);
            dx = Var.ENEMY_SPEED;
            return;
        }

        if(enemy.getX() == start ){block1 = false;}
        if(end > start && !block2) {
            if(enemy.getY() == player.getY() && player.getX() < enemy.getX()){
                pos.setX(getX() - Var.ENEMY_SPEED * 2);
                dx = - Var.ENEMY_SPEED * 2;
                return;
            }
            pos.setX(getX() - Var.ENEMY_SPEED);
            dx = -Var.ENEMY_SPEED;
            return;
        }

    }




    @Override
    public void performCollision() {
        super.performCollision();
    }

    @Override
    public int getWidth() {
        return SIZE;
    }

    @Override
    public int getHeight() {
        return SIZE;
    }

    @Override
    public int getX() {
        return pos.getX();
    }

    @Override
    public int getY() {
        return pos.getY();
    }

    @Override
    public void delete(){

        enemy.delete();

    }

}

