package sample;

import Pieces.GamePiece;
import Pieces.MyPiece;

import java.util.ArrayList;
public class Model {
    private ArrayList<GamePiece> onScreen;
    public Model(){
        onScreen = new ArrayList<>();
        onScreen.add(new MyPiece());
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
    public static void main(String[] args){
        Model m = new Model();
        System.out.print(m.getOnScreen().get(0).getX());
    }


}
