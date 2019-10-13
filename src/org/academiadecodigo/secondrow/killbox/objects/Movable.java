package org.academiadecodigo.secondrow.killbox.objects;

import org.academiadecodigo.secondrow.killbox.objects.platform.Platform;

public interface Movable {

    void move();

    void move(Platform[] platforms);
}
