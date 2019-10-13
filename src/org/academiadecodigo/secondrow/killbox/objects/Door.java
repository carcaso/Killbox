package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.graphics.Text;
import org.academiadecodigo.secondrow.killbox.Var;

public class Door implements Collidable {
    private Rectangle door;
    private Position pos;
    private boolean open;
    private Rectangle winRectangle = new Rectangle(Var.PADDING + Var.CELL_SIZE, Var.PADDING + Var.CELL_SIZE,
            Var.WIDTH - 2 * Var.CELL_SIZE, Var.HEIGHT - 2 * Var.CELL_SIZE);
    private Text winMessage = new Text(625, 350, "YOU WON!");
    private int totalButton;
    private int howManyToOpen = 1;

    public Door(Position position, int totalButton) {
        open = false;
        pos = position;
        door = new Rectangle(pos.getX(), pos.getY(), Var.DOOR_WIDTH, Var.DOOR_HEIGHT);
        this.totalButton = totalButton;
        door.fill();
    }



    public void delete(){door.delete();}


    public void openDoor() {

        if(howManyToOpen != totalButton){
            howManyToOpen++;
            return;
        }
            door.setColor(Color.ORANGE);
            open = true;
    }

    public boolean isOpen() {
        return open;
    }

    @Override
    public void performCollision() {


        winRectangle.setColor(Color.LIGHT_GRAY);
        winRectangle.fill();
        winMessage.grow(150, 50);
        winMessage.draw();

        Rectangle nextLevel = new Rectangle(400, 500, 200, 70);
        nextLevel.setColor(Color.BLACK);
        nextLevel.draw();

        Text repeatLevelText = new Text(440, 530, "NEXT LEVEL (Press S)");
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
    public int getWidth() {
        return 40;
    }

    @Override
    public int getHeight() {
        return 40;
    }

    @Override
    public int getX() {
        return pos.getX();
    }

    @Override
    public int getY() {
        return pos.getY();
    }
}
