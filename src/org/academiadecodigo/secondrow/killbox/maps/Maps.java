package org.academiadecodigo.secondrow.killbox.maps;

import org.academiadecodigo.secondrow.killbox.objects.Door;
import org.academiadecodigo.secondrow.killbox.objects.Key;
import org.academiadecodigo.secondrow.killbox.objects.enemy.Enemy;
import org.academiadecodigo.secondrow.killbox.objects.platform.JumpBox;
import org.academiadecodigo.secondrow.killbox.objects.platform.Platform;

public abstract class Maps {

    Enemy[] enemy;
    Platform[] platforms;
    JumpBox[] jumpBoxes;
    Door door;
    Key[] key;

    public Enemy[] getEnemy() {
        return enemy;
    }

    public Platform[] getPlatforms() {
        return platforms;
    }

    public JumpBox[] getJumpBoxes() {
        return jumpBoxes;
    }

    public Platform getPlatform(int index) {
        return platforms[index];
    }

    public Door getDoor() {
        return door;
    }

    public Key[] getKeys() {
        return key;
    }

    public void setEnemy(Enemy[] enemy) {
        this.enemy = enemy;
    }

    public void setPlatforms(Platform[] platforms) {
        this.platforms = platforms;
    }

    public void setJumpBoxes(JumpBox[] jumpBoxes) {
        this.jumpBoxes = jumpBoxes;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public void setKeys(Key[] key) {
        this.key = key;
    }
}
