package org.academiadecodigo.secondrow.killbox.objects.platform;

import org.academiadecodigo.secondrow.killbox.objects.Position;

public class JumpBox extends Platform {

    public JumpBox(Position pos) {
        super(pos, 10, 10);
        // FIXME: 05/10/2019 
    }

    public void boost() {
    }

    public void delete(){
        super.delete();
    }
}

