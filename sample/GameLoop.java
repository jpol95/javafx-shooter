package sample;

import Pieces.BulletPiece;
import Pieces.GamePiece;
import Pieces.MyPiece;
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
            for (int j = i + 1; j < onScreen.size(); j++){
                if (onScreen.get(i).collisionDetection(onScreen.get(j))){
                    handleCollisions(onScreen.get(i), onScreen.get(j));
                }
            }
        }
    }

    private void deleteOffScreen() {
        for (int i = 0; i < c.getModel().getOnScreen().size(); i++) {
            if (!c.getModel().getOnScreen().get(i).isOnScreen()) {
                c.getRoot().getChildren().remove(c.getModel().getOnScreen().get(i).getImageview());
                c.getModel().getOnScreen().remove(c.getModel().getOnScreen().get(i));
            }
        }
    }
    private void handleCollisions(GamePiece g1, GamePiece g2){
       g1.decreaseHP(g2);
       g2.decreaseHP(g1);
       }

private void handleMovement(){
    MyPiece mainChar = c.getModel().getMain();
    mainChar.go(c.getKeys());
    if (c.getKeys().contains("SPACE")){
        BulletPiece bullet = new BulletPiece(mainChar.getX() + mainChar.getFitWidth()/2.35, mainChar.getY());
        c.getModel().add(bullet);
        c.getRoot().getChildren().add(bullet.getImageview());
        c.getKeys().remove("SPACE");
    }
}


}
