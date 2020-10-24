package Pieces;

import Pieces.GamePiece;

public class BulletPiece extends GamePiece {
    public BulletPiece(double x, double y){
        super(x,y, 20, 20);
        this.damage = 10;
        this.hp = 1;
        this.imageLink = "file:///C:/Users/19548/Downloads/ball.png";
    }
}
