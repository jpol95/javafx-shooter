package sample;

import Pieces.BulletPiece;
import Pieces.GamePiece;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameLoop extends AnimationTimer {
   private Controller c;
   private List<GamePiece> onScreen;
   public GameLoop(Controller c){
       this.c = c;
       onScreen = c.getModel().getOnScreen();
   }
    @Override
    public void handle(long l) {
        handleDefault();
        handleMovement();
        deleteOffScreen();
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    private void handleDefault() {
        for (int i = 0; i < onScreen.size(); i++) {
            onScreen.get(i).defaultMove();
            for (int j = i + 1; i < onScreen.size(); i++){
                if (onScreen.get(i).collisionDetection(onScreen.get(j))){
                    handleCollisions(onScreen.get(i), onScreen.get(j));
                }
            }
        }
    }

    private void deleteOffScreen(){
       for (GamePiece g: c.getModel().getOnScreen()) {
           c.getModel().getOnScreen().remove(g);
           c.getRoot().getChildren().remove(g.getImageview());
       }
    }
    private void handleCollisions(GamePiece g1, GamePiece g2){
       g1.decreaseHP(g2);
       g2.decreaseHP(g1);
       }

private void handleMovement(){
    GamePiece mainChar = c.getModel().getMain();
    double currentX = c.getModel().getMain().getX();
    double currentY = c.getModel().getMain().getY();
    if (c.getKeys().contains("LEFT"))
        mainChar.updatePosition(currentX - 10, currentY);
    //break;
    if (c.getKeys().contains("UP"))
        mainChar.updatePosition(currentX, currentY - 10);
    //break;
    if (c.getKeys().contains("RIGHT"))
        mainChar.updatePosition(currentX + 10, currentY);
    //break;
    if (c.getKeys().contains("DOWN"))
        mainChar.updatePosition(currentX, currentY + 10);
    if (c.getKeys().contains("SPACE")){
        BulletPiece bullet = new BulletPiece(mainChar.getX() + mainChar.getFitWidth()/2.35, mainChar.getY());
        c.getModel().add(bullet);
        c.getRoot().getChildren().add(bullet.getImageview());
        c.getKeys().remove("SPACE");
    }
}


}
