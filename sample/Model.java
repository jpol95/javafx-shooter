package sample;

import Pieces.EnemyPiece;
import Pieces.GamePiece;
import Pieces.MyPiece;

import java.util.ArrayList;
public class Model {
    private ArrayList<GamePiece> onScreen;
    public Model(Controller controller){
        onScreen = new ArrayList<>();
        onScreen.add(new MyPiece(controller));
        onScreen.add(new EnemyPiece(0, 20, controller));
    }
    public void add(GamePiece g){
        onScreen.add(g);
    }
    public ArrayList<GamePiece> getOnScreen(){
        return onScreen;
    }


    public MyPiece getMain(){
        return (MyPiece) onScreen.get(0);
    }


}
