package org.academiadecodigo.secondrow.killbox.maps;

import org.academiadecodigo.secondrow.killbox.objects.Door;
import org.academiadecodigo.secondrow.killbox.objects.Key;
import org.academiadecodigo.secondrow.killbox.objects.Position;
import org.academiadecodigo.secondrow.killbox.objects.platform.Platform;

public class Level1 extends Maps {


    // 2 plats, 1 jump, 1 door, 1 enemy, 1 key
    public Level1() {
        setPlatforms(new Platform[2]);
        setKeys(new Key[1]);
        Key key = new Key(new Position(640, 350));
        getKeys()[0] = key;
        setDoor(new Door(new Position (1200,20), getKeys()));

        Platform doorPlatform = new Platform(new Position(1085, 60), 205, 40);
        Platform middlePlatform = new Platform(new Position(500, 260), 350, 90);

        getPlatforms()[0] = doorPlatform;
        getPlatforms()[1] = middlePlatform;



    }

}
