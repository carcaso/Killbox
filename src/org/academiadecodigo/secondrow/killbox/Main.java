package org.academiadecodigo.secondrow.killbox;

import org.academiadecodigo.secondrow.killbox.maps.Level1;
import org.academiadecodigo.secondrow.killbox.objects.Menu;
import org.academiadecodigo.secondrow.killbox.maps.Level2;

public class Main {

    public static void main(String[] args) {
        Game g = new Game();
        Menu menu = new Menu();


        synchronized (g) {
            try {

                menu.drawMenu();

                while (!menu.getStart())   {
                    Thread.sleep(10);
                }
                for(int i=0; i<g.getMaps().length; i++){
                    if(g.getPlayerWon()){
                        while (!menu.getStart())   {
                            Thread.sleep(10);
                        }
                    }
                    if(g.getPlayerDead()){
                        //Desenhar as teclas
                        while (!menu.getStart())   {
                            Thread.sleep(10);
                        }
                        g.setPlayerDead(false);
                        --i;
                    }
                    g.setPlayerWon(false);
                    menu.setStart(false);
                    g.init();
                    g.getMaps()[i].draw();
                    g.start(g.getMaps()[i]);

                }

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}