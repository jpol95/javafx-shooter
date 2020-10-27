package Pieces;

import Pieces.GamePiece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MyPiece extends GamePiece {
    public MyPiece(){
        super(200, 350, 100, 100);
        this.damage = 100;
        this.hp = 100;
        Image image = new Image("file:///C:/Users/19548/Downloads/mypiece.png");
        this.imageview.setImage(image);

    }

    @Override
    public void defaultMove() {
        return;
    }

}
