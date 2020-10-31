package Pieces;

import Pieces.GamePiece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Controller;

import java.util.ArrayList;
import java.util.Set;


public class MyPiece extends GamePiece {
    public MyPiece(Controller c){
        super(200, 350,100, 100, c);
        this.damage = 100;
        this.hp = 100;
        this.fitHeight = 100;
        this.fitWidth = 100;
        Image image = new Image("file:///C:/Users/19548/Downloads/mypiece.png");
        this.imageview.setImage(image);

    }

    private void goLeft(){
        if (!(this.getX() < 0))
        this.updatePosition(this.getX() - 10, this.getY());
    }
    private void goRight(){
        if (!(this.getX() > Controller.X_SIZE))
            this.updatePosition(this.getX() + 10, this.getY());
    }
    private void goDown(){
        if (!(this.getY() > Controller.Y_SIZE))
            this.updatePosition(this.getX(), this.getY() + 10);
    }
    private void goUp(){
        if (!(this.getY() < 0))
            this.updatePosition(this.getX(), this.getY() - 10);
    }


    public void go(Set<String> directions){
        if (directions.contains("LEFT"))
            this.goLeft();
        if (directions.contains("UP"))
            this.goUp();
        if (directions.contains("RIGHT"))
            this.goRight();
        if (directions.contains("DOWN"))
            this.goDown();
        if (c.getKeys().contains("SPACE")){
            this.shootBullets(true);
            c.getKeys().remove("SPACE");
        }
    }


    @Override
    public void defaultMove() {
        return;
    }
}
