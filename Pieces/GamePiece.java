package Pieces;

import com.sun.javafx.geom.Shape;
import javafx.scene.image.ImageView;


public abstract class GamePiece {
    private double xPosition;
    private double yPosition;
    protected int hp;
    protected int damage;
    protected ImageView imageview;
    private int fitHeight;
    private int fitWidth;
    public GamePiece(){}
    public GamePiece(double xPosition, double yPosition, int fitWidth, int fitHeight){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.fitWidth = fitWidth;
        this.fitHeight = fitHeight;
        configImage();

    }
    public void updatePosition(double x, double y){
        xPosition = x;
        yPosition = y;
        this.imageview.setX(xPosition);
        this.imageview.setY(yPosition);
    }
    public double getX(){
        return this.xPosition;
    }

    public double getY(){
        return this.yPosition;
    }

    public int getDamage() {
        return damage;
    }

    public int getHp() {
        return hp;
    }

    public int getFitHeight() {
        return fitHeight;
    }

    public int getFitWidth() {
        return fitWidth;
    }
    public ImageView getImageview() {
        return this.imageview;
    }
    private void configImage(){
        this.imageview = new ImageView();
        this.imageview.setX(this.getX());
        this.imageview.setY(this.getY());
        this.imageview.setFitHeight(this.getFitHeight());
        this.imageview.setFitWidth(this.getFitWidth());
    }

    public abstract void defaultMove();
}
