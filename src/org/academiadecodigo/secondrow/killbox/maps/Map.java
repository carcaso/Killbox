package org.academiadecodigo.secondrow.killbox.maps;

import org.academiadecodigo.secondrow.killbox.objects.Door;
import org.academiadecodigo.secondrow.killbox.objects.Key;
import org.academiadecodigo.secondrow.killbox.objects.Player;
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
    Player player; // TODO: 10/10/2019 estamos a tentar dar acesso ao player a toda a gente.
    // TODO: 10/10/2019 criar uma classe para mensagens (init, press play) (end) (died)
    // TODO: 10/10/2019 add cell to map. Only platforms need to be inside these cells (touching)
    // TODO: 10/10/2019 player jump reset validar o landing (em vez da collision geral)


    public Enemy[] getEnemy() {
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

    public Door getdoor(){
        return door;
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
    public int numberOfKeys(){
        return key.length;
    }
}
