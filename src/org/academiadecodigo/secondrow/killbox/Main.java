package org.academiadecodigo.secondrow.killbox;

import org.academiadecodigo.secondrow.killbox.maps.Level1;
import org.academiadecodigo.secondrow.killbox.objects.Menu;
import org.academiadecodigo.secondrow.killbox.maps.Level2;

public class Main {

    public static void main(String[] args) {
        Game g = new Game();

        synchronized (g) {
            try {
                Menu menu = new Menu();
                menu.drawMenu();

                while (!menu.getStart())   {
                    Thread.sleep(10);
                }

                while (!menu.getPaused()) {
                    if(menu.getPaused()){
                        Thread.sleep(10);
                    }
                    g.init();
                    Level1 level1 = new Level1();
                    g.start(level1);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}