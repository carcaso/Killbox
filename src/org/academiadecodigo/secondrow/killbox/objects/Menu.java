package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.graphics.Text;
import org.academiadecodigo.secondrow.keyboard.Keyboard;
import org.academiadecodigo.secondrow.keyboard.KeyboardEvent;
import org.academiadecodigo.secondrow.keyboard.KeyboardEventType;
import org.academiadecodigo.secondrow.keyboard.KeyboardHandler;
import org.academiadecodigo.secondrow.killbox.Var;

public class Menu implements KeyboardHandler {

    private Keyboard keyboard = new Keyboard(this);
    private boolean start = false;
    private Rectangle background = new Rectangle(10, 10, Var.WIDTH, Var.HEIGHT);
    private Text titleText = new Text(630, 100, "<KillBox>");
    private Text alrightText = new Text(605, 180, "Alright ;D");
    private Text startText = new Text(610, 280, "START (Press S)");
    private Rectangle startButton = new Rectangle(545, 250, 200, 70);
    private Text helpText = new Text(610, 380, "HELP (Press H)");
    private Rectangle helpButton = new Rectangle(545, 350, 200, 70);
    private Text quitText = new Text(610, 480, "QUIT (Press Q)");
    private Rectangle quitButton = new Rectangle(545, 450, 200, 70);

    public boolean getStart() {
        return start;
    }

    public void drawMenu() {

        KeyboardEvent start = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_S);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(start);

        //Background
        background.setColor(Color.LIGHT_GRAY);
        background.fill();

        //TITLE
        titleText.setColor(Color.BLACK);
        titleText.grow(100, 50);
        titleText.draw();
        alrightText.setColor(Color.WHITE);
        titleText.grow(50, 50);
        alrightText.draw();

        //Start
        startButton.setColor(Color.BLACK);
        startButton.draw();
        startText.setColor(Color.BLACK);
        startText.grow(10, 10);
        startText.draw();

        //Help
        helpButton.setColor(Color.BLACK);
        helpButton.draw();
        helpText.setColor(Color.BLACK);
        helpText.grow(10, 10);
        helpText.draw();

        //Quit
        quitButton.setColor(Color.BLACK);
        quitButton.draw();
        quitText.setColor(Color.BLACK);
        quitText.grow(10, 10);
        quitText.draw();

    }

    public void delete() {
        background.delete();
        titleText.delete();
        alrightText.delete();
        startText.delete();
        startButton.delete();
        helpText.delete();
        helpButton.delete();
        quitText.delete();
        quitButton.delete();
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_S:
                System.out.println("Pressed Key S");
                start = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }
}
