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

    //Keyboard property
    private Keyboard keyboard = new Keyboard(this);

    //Draw Menu and Start property
    private boolean isStart = false;
    private boolean isAlright = false;
    private boolean isBack = false;
    private boolean isPaused = false;

    //Menu properties
    private Rectangle background = new Rectangle(10, 10, Var.WIDTH, Var.HEIGHT);
    private Text titleText = new Text(630, 100, "<KillBox>");
    private Text startText = new Text(610, 280, "START (Press S)");
    private Rectangle startButton = new Rectangle(545, 250, 200, 70);
    private Text helpText = new Text(610, 380, "HELP (Press H)");
    private Rectangle helpButton = new Rectangle(545, 350, 200, 70);
    private Text quitText = new Text(610, 480, "QUIT (Press Q)");
    private Rectangle quitButton = new Rectangle(545, 450, 200, 70);

    //Help Properties
    private boolean isHelp = false;
    private Text left = new Text(590, 250, "Left -> Press A");
    private Text right = new Text(590, 300, "Right -> Press D");
    private Text jump = new Text(590, 350, "Jump -> Press SPACE");
    private Text boost = new Text(590, 400, "Boost -> Press W");
    private Text quit = new Text(590, 450, "Quit -> Press Q (Anytime)");
    private Text back = new Text(70, 700, "[B] Back");
    private Text start = new Text(1200, 700, "[S] Start");
    private Text message = new Text(70, 45, "Alright ;D");

    public boolean getStart() {
        return isStart;
    }

    public void drawMenu() {

        keyboard();

        //Background
        background.setColor(Color.LIGHT_GRAY);
        background.fill();

        //Title
        titleText.grow(150, 50);
        titleText.draw();

        //Start
        startButton.draw();
        startText.grow(10, 10);
        startText.draw();

        //Help
        helpButton.draw();
        helpText.grow(10, 10);
        helpText.draw();

        //Quit
        quitButton.draw();
        quitText.grow(10, 10);
        quitText.draw();

        //Drawing the helpText grow
        left.grow(30, 10);
        right.grow(30, 10);
        jump.grow(30, 10);
        quit.grow(30, 10);
        boost.grow(30, 10);
        back.grow(30, 20);
        start.grow(30, 20);

    }

    public void drawHelpMenu() {

        //Delete pieces of menu
        startText.delete();
        startButton.delete();
        helpText.delete();
        helpButton.delete();
        quitText.delete();
        quitButton.delete();

        //Title
        titleText.setText("Menu Help");
        titleText.draw();

        //Information
        left.draw();
        right.draw();
        jump.draw();
        boost.draw();
        quit.draw();
        back.draw();
        start.draw();

    }

    public void reDrawMenu() {
        left.delete();
        right.delete();
        jump.delete();
        boost.delete();
        quit.delete();
        titleText.setText("<KillBox>");

        //Start
        startButton.draw();
        startText.draw();

        //Help
        helpButton.draw();
        helpText.draw();

        //Quit
        quitButton.draw();
        quitText.draw();

        //Down Options
        back.delete();
        start.delete();
    }

    public void keyboard() {

        //Start
        KeyboardEvent start = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_S);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(start);

        //Help
        KeyboardEvent help = new KeyboardEvent();
        help.setKey(KeyboardEvent.KEY_H);
        help.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(help);

        //Quit
        KeyboardEvent quit = new KeyboardEvent();
        quit.setKey(KeyboardEvent.KEY_Q);
        quit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(quit);

        //Back
        KeyboardEvent back = new KeyboardEvent();
        back.setKey(KeyboardEvent.KEY_B);
        back.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(back);

        //Pause
        KeyboardEvent pause = new KeyboardEvent();
        pause.setKey(KeyboardEvent.KEY_P);
        pause.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pause);

        //Alright
        KeyboardEvent alright = new KeyboardEvent();
        alright.setKey(KeyboardEvent.KEY_F);
        alright.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(alright);

    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_S:
                System.out.println("Pressed Key S");
                isStart = true;
                break;
            case KeyboardEvent.KEY_H:
                System.out.println("Pressed Key H");
                if (!isHelp) {
                    drawHelpMenu();
                    isHelp = true;
                    isBack = false;
                }
                break;
            case KeyboardEvent.KEY_Q:
                System.out.println("Pressed Key Q");
                System.exit(1);
                break;
            case KeyboardEvent.KEY_F:
                if (!isAlright) {
                    message.grow(30, 20);
                    message.draw();
                    isAlright = true;
                }
                break;
            case KeyboardEvent.KEY_B:
                if (!isBack) {
                    reDrawMenu();
                    isBack = true;
                    isHelp = false;
                }
                break;
            case KeyboardEvent.KEY_P:
                if (!isPaused) {
                    isPaused = true;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }
}
