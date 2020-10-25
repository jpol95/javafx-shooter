package sample;

import Pieces.BulletPiece;
import Pieces.GamePiece;
import Pieces.MyPiece;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.*;


public final class Controller extends Application{

    public static final int X_SIZE = 500;
    public static final int Y_SIZE = 500;
    private final Model model;
    private Pane root;
    private final Scene theScene;

    public Controller() {
        model = new Model();
        root = new Pane();
        theScene = new Scene(root);
    }

    @Override
    public void start(Stage stage) throws Exception {
       stage.setTitle("Welcome to my game");
       stage.setScene(theScene);
       GameLoop game = new GameLoop(this);
       game.handle(System.nanoTime());
       root.setPrefSize(500,500);
       handleMovement(theScene);
       stage.show();
       game.start();

    }


    public void handleMovement(Scene scene) {
        scene.setOnKeyPressed(
                keyEvent -> {
                    KeyCode direction = keyEvent.getCode();
                    movePiece(direction);
                }
        );
    }

    private void movePiece(KeyCode direction){
        MyPiece mainChar = model.getMain();
       double currentX = mainChar.getX();
       double currentY = mainChar.getY();
       switch (direction){
           case LEFT:
               mainChar.updatePosition(currentX - 10, currentY);
               break;
           case UP:
               mainChar.updatePosition(currentX, currentY - 10);
               break;
           case RIGHT:
               mainChar.updatePosition(currentX + 10, currentY);
               break;
           case DOWN:
               mainChar.updatePosition(currentX, currentY + 10);
               break;
           case SPACE:
               model.add(new BulletPiece(mainChar.getX(), 100));
        }
    }

    public Model getModel() {
        return model;
    }
    public Pane getRoot() {
        return root;
    }

}




