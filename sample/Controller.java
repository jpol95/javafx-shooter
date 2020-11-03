package sample;

import Pieces.BulletPiece;
import Pieces.EnemyPiece;
import Pieces.GamePiece;
import Pieces.MyPiece;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


import java.util.*;


public final class Controller extends Application{

    public static final int X_SIZE = 500;
    public static final int Y_SIZE = 500;
    private final Model model;
    private Scene theScene;
    AnchorPane root;



    private Set<String> keys;

    public Controller() {
        model = new Model(this);
        keys= new HashSet<>();
    }

    @Override
    public void start(Stage stage) throws Exception {
       root = FXMLLoader.load(getClass().getResource("hello.fxml"));
       stage.setTitle("Welcome to my game");
       theScene = new Scene(root, X_SIZE, Y_SIZE);
       stage.setScene(theScene);
       GameLoop game = new GameLoop(this);
       game.handle(System.nanoTime());
       for (int i = 0; i < model.getOnScreen().size(); i++) {
           root.getChildren().add(model.getOnScreen().get(i).getImageview());
       }
       handleMovement(theScene);
       stage.show();
       game.start();
    }



    public void handleMovement(Scene scene) {
        scene.setOnKeyPressed(
                keyEvent -> {
                    String direction = keyEvent.getCode().toString();
                    keys.add(direction);
                }
        );
        scene.setOnKeyReleased(
                keyEvent -> {
                    String direction = keyEvent.getCode().toString();
                    keys.remove(direction);
                }
        );
    }

    private void movePiece(KeyCode direction){
       MyPiece mainChar = model.getMain();

    }
//    public void handleHealthBar(){
//        MyPiece mainChar = model.getMain();
//        System.out.println(mainChar.getHp());
//        health.setWidth(10);
//    }

    public Set<String> getKeys() {
        return keys;
    }

    public Model getModel() {
        return model;
    }
    public Pane getRoot() {
        return root;
    }

}




