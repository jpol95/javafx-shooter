package Pieces;

import Pieces.GamePiece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BulletPiece extends GamePiece {
    public BulletPiece(double x, double y){
        super(x,y, 20, 20);
        this.damage = 10;
        this.hp = 1;
        Image image = new Image("file:///C:/Users/19548/Downloads/ball.png");
        this.imageview.setImage(image);
    }



    public void defaultMove(){
        this.updatePosition(this.getX(), this.getY() - 5);
    }
}
