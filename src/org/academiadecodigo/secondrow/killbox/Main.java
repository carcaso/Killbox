package org.academiadecodigo.secondrow.killbox;

import org.academiadecodigo.secondrow.killbox.maps.Level1;
import org.academiadecodigo.secondrow.killbox.maps.Level2;

public class Main {
    public static void main(String[] args) {
        Game g = new Game();
        g.init();
        Level1 level2 = new Level1();
        g.start(level2);
    }
}