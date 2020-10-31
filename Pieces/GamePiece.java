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
    protected int fitHeight;
    protected int fitWidth;
    Controller c;
    public GamePiece(){}

    public boolean isOnScreen() {
        return onScreen;
    }

    private boolean onScreen;
    public GamePiece(double xPosition, double yPosition, int fitWidth, int fitHeight, Controller c){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.fitWidth = fitWidth;
        this.fitHeight = fitHeight;
        this.onScreen = true;
        this.c = c;
        configImage();

    }
    public void updatePosition(double x, double y) {
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


    public boolean collisionDetection(GamePiece g1){
        boolean xCollision;
        if (g1.getX() > this.getX()) xCollision = Math.abs(g1.getX() - this.getX()) < this.getFitWidth();
        else xCollision = Math.abs(this.getX() - g1.getX()) < g1.getFitWidth();
        boolean yCollision;
        if (g1.getY() > this.getY()) yCollision = Math.abs(g1.getY() - this.getY()) < this.getFitHeight();
        else yCollision = Math.abs(this.getY() - g1.getY()) < g1.getFitHeight();
        return (xCollision && yCollision);

    }

    public boolean outOfBounds(){
        return (this.getX() > Controller.X_SIZE || this.getX() < -10 || this.getY() > Controller.Y_SIZE || this.getY() < -10);
    }

    public void decreaseHP(GamePiece g){
        System.out.print(this.hp);
        this.hp -= g.getDamage();
        if (this.hp <= 0) this.onScreen = false;
    }
    protected void shootBullets(boolean up){
        BulletPiece newBullet;
        if (up) {
            newBullet = new BulletPiece(this.getX(), this.getY() - this.getFitHeight(), true);
        }
        else {
            newBullet = new BulletPiece(this.getX(), this.getY() + this.getFitHeight(), false);
        }
        c.getModel().getOnScreen().add(newBullet);
        c.getRoot().getChildren().add(newBullet.getImageview());
    }

    public abstract void defaultMove();
}
