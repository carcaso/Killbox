package org.academiadecodigo.secondrow.killbox.maps;

import org.academiadecodigo.secondrow.killbox.objects.Door;
import org.academiadecodigo.secondrow.killbox.objects.Key;
import org.academiadecodigo.secondrow.killbox.objects.enemy.Enemy;
import org.academiadecodigo.secondrow.killbox.objects.platform.JumpBox;
import org.academiadecodigo.secondrow.killbox.objects.platform.Platform;

public abstract class Map {

    ////////////////////change enemy to enemies
    Enemy[] enemy;
    Platform[] platforms;
    JumpBox[] jumpBoxes;
    Door door;
    Key[] key;

    public Enemy[] getEnemies() {
        return enemy;
    }

    public JumpBox[] getJumpBoxes() {
        return jumpBoxes;
    }

    public Door getDoor() {
        return door;
    }

    public void setEnemy(Enemy[] enemy) {
        this.enemy = enemy;
    }

    public void setJumpBoxes(JumpBox[] jumpBoxes) {
        this.jumpBoxes = jumpBoxes;
    }


    //Return the Array Platfrom
    public Platform[] getPlatforms() {
        return platforms;
    }

    //Return a platfrom by the index
    public Platform getPlatform(int index) {
        return platforms[index];
    }

    //Retrun the Array Keys
    public Key[] getKeys() {
        return key;
    }

    //Added method for get key in index
    public Key getKey(int index){
        return key[index];
    }


    // Setteres
    public void setPlatforms(Platform[] platforms) {
        this.platforms = platforms;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public void setKeys(Key[] key) {
        this.key = key;
    }

    public void delete(Enemy[] enemies, Platform[] platforms, JumpBox[] jumpBoxes, Door[] doors, Key[] keys){

        for (int i = 0; i < enemies.length; i++) {
            enemies[i].delete();
        }

        for (int i = 0; i < platforms.length; i++) {
            platforms[i].delete();
        }

        for (int i = 0; i < jumpBoxes.length; i++) {
            jumpBoxes[i].delete();
        }

        for (int i = 0; i < doors.length; i++) {
            doors[i].delete();
        }

        for (int i = 0; i < keys.length; i++) {
            keys[i].delete();
        }
    }
}
