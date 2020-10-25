package sample;

import Pieces.GamePiece;
import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;

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
            ImageView screenChar = new ImageView(g.getImageLink());
            screenChar.setX(g.getX());
            //        System.out.print(g.getX());
            screenChar.setY(g.getY());
            screenChar.setFitWidth(g.getFitWidth());
            screenChar.setFitHeight(g.getFitHeight());
            onScreenChars.add(screenChar);
        }
        c.getRoot().getChildren().clear();
        c.getRoot().getChildren().addAll(onScreenChars);
    }

}
