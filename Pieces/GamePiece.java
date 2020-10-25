package Pieces;

import com.sun.javafx.geom.Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GamePiece {
    private double xPosition;
    private double yPosition;
    protected int hp;
    protected int damage;
    protected Image image;
    private int fitHeight;
    private int fitWidth;
    public GamePiece(double xPosition, double yPosition, int fitWidth, int fitHeight){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.fitWidth = fitWidth;
        this.fitHeight = fitHeight;

    }
    public void updatePosition(double x, double y){
        xPosition = x;
        yPosition = y;
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

    public void render(GraphicsContext gc){
        gc.drawImage(this.image, this.getX(), this.getY());
    }


    public int getFitHeight() {
        return fitHeight;
    }

    public int getFitWidth() {
        return fitWidth;
    }
    public abstract void defaultMove();
}
