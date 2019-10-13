package org.academiadecodigo.secondrow.killbox.maps;

import org.academiadecodigo.secondrow.graphics.Color;
import org.academiadecodigo.secondrow.graphics.Rectangle;
import org.academiadecodigo.secondrow.graphics.Text;
import org.academiadecodigo.secondrow.killbox.Var;

public class FinalLevel extends Map {


    public FinalLevel() {

        Rectangle finalScreem = new Rectangle(10 + 30, 10 + 30,
                1260 - 2 * 30, 720 - 2 * 30);
        finalScreem.setColor(Color.LIGHT_GRAY);
        finalScreem.fill();


        Text text = new Text(600, 350, "YOU BEAT THE KILLBOX!");
        text.draw();
        text.grow(150, 50);


        Rectangle quit = new Rectangle(570, 500, 200, 70);
        quit.setColor(Color.BLACK);
        quit.draw();

        Text quitText = new Text(635, 530, "QUIT (Press Q)");
        quitText.grow(10, 10);
        quitText.draw();

    }




}
