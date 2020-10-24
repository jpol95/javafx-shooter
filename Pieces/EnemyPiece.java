package Pieces;

public class EnemyPiece extends GamePiece{
    public EnemyPiece(double x, double y){
        super(x,y, 100, 100);
        this.damage = 10;
        this.hp = 1;
        this.imageLink = "file:///C:/Users/19548/Downloads/ball.png";
    }
}
