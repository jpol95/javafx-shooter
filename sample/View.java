package sample;

import Pieces.MyPiece;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;

public class View {
    private static Pane pane;
    private MyPiece protag;
    private static Controller myController;
    View(Text title) throws FileNotFoundException {

    }

    public Pane getPane(){
        return this.pane;
    }


}

//figure out how to position and resize an image on javafx!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
