package Pieces;

import Pieces.GamePiece;
import javafx.scene.image.Image;

public class MyPiece extends GamePiece {
    public MyPiece(){
        super(200, 350, 100, 100);
        this.damage = 100;
        this.hp = 100;
        this.image = new Image("file:///C:/Users/19548/Downloads/ball.png");
    }

    @Override
    public void defaultMove() {
        return;
    }

}
