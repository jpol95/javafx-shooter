package Pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Controller;
import sample.Model;

import java.awt.*;
import java.util.ArrayList;

public class EnemyPiece extends GamePiece {
    private ArrayList<double[]> positions;
    private int index;
    Controller controller;

    public EnemyPiece(double x, double y, Controller controller) {
        super(x, y, 100, 100);
        this.damage = 10;
        this.hp = 1;
        this.controller = controller;
        this.imageview.setImage(new Image("file:///C:/Users/19548/Downloads/enemyship.jpg"));
        this.setPositions();
        index = 0;
    }

    public void defaultMove() {
        this.updatePosition(positions.get(index%positions.size())[0], positions.get(index%positions.size())[1]);
        if (index > 0 && index%50 == 0) shootBullets();
        index++;
    }

    private void setPositions() {
        positions = new ArrayList<>();
        for (int i = 0; i < Controller.X_SIZE/5*2-30; i++) {
        positions.add(new double[2]);
        positions.get(i)[1] = this.getY();
        if (i < Controller.X_SIZE/5-15)
        positions.get(i)[0] = i*5;
        else positions.get(i)[0] = positions.get(i - 1)[0] - 5;
    }

}

private void shootBullets(){
        BulletPiece newBullet = new BulletPiece(this.getX(), this.getY() + this.getFitHeight());
    controller.getModel().getOnScreen().add(newBullet);
    controller.getRoot().getChildren().add(newBullet.getImageview());
}
}
