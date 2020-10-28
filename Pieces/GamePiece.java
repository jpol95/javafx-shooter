package Pieces;

import com.sun.javafx.geom.Shape;
import javafx.scene.image.ImageView;
import sample.Controller;
import sample.Model;


public abstract class GamePiece {
    private double xPosition;
    private double yPosition;
    protected int hp;
    protected int damage;
    protected ImageView imageview;
    private int fitHeight;
    private int fitWidth;
    public GamePiece(){}

    public boolean isOnScreen() {
        return onScreen;
    }

    private boolean onScreen;
    public GamePiece(double xPosition, double yPosition, int fitWidth, int fitHeight){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.fitWidth = fitWidth;
        this.fitHeight = fitHeight;
        this.onScreen = true;
        configImage();

    }
    public void updatePosition(double x, double y) {
        if (!this.outOfBounds()) {
            xPosition = x;
            yPosition = y;
            this.imageview.setX(xPosition);
            this.imageview.setY(yPosition);
        }
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


    public boolean collisionDetection(GamePiece g1){
        boolean xCollision = false;
        if (g1.getX() > this.getX()) xCollision = g1.getX() - this.getX() > this.getFitWidth();
        else xCollision = this.getX() - g1.getX() > g1.getFitWidth();
        boolean yCollision = false;
        if (g1.getY() > this.getY()) yCollision = g1.getY() - this.getY() > this.getFitWidth();
        else xCollision = this.getY() - g1.getY() > g1.getFitWidth();
        return (xCollision && yCollision);

    }

    public boolean outOfBounds(){
        return (this.getX() > Controller.X_SIZE || this.getX() < -10 || this.getY() > Controller.Y_SIZE || this.getY() < -10);
    }

    public void decreaseHP(GamePiece g){
        this.hp -= g.getDamage();
        if (this.hp <= 0) onScreen = false;
    }

    public abstract void defaultMove();
}
