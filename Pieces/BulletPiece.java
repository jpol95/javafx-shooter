package Pieces;

import Pieces.GamePiece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Controller;

public class BulletPiece extends GamePiece {
    boolean up;
    public BulletPiece(double x, double y, boolean up) {
        super(x, y,20, 20, null);
        this.damage = 10;
        this.hp = 1;
        this.imageview.setImage(new Image("file:///C:/Users/19548/Downloads/ball.png"));
        this.up = up;
    }


    public void defaultMove() {
        if (up)
        this.updatePosition(this.getX(), this.getY() - 5);
        else this.updatePosition(this.getX(), this.getY() + 5);
    }


}