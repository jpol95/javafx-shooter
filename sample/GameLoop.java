package sample;

import Pieces.BulletPiece;
import Pieces.GamePiece;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class GameLoop extends AnimationTimer {
   Controller c;
   public GameLoop(Controller c){
       this.c = c;
   }
    @Override
    public void handle(long l) {
       for (GamePiece g: c.getModel().getOnScreen()) {
           g.defaultMove();
       }
        render();
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    private void render(){
        ArrayList<ImageView> onScreenChars = new ArrayList<>();
        for (GamePiece g: c.getModel().getOnScreen()){
            g.defaultMove();
        }
        handleMovement();
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
