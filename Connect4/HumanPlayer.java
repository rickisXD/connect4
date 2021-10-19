import java.awt.*;

public class HumanPlayer extends Player{

    public HumanPlayer(int turnNumber, boolean myTurn, Color color) {
        this.turnNumber = turnNumber;
        this.myTurn = myTurn;
        this.markerColor = color;
    }

    public void takeTurn() {

    }

    public boolean checkWin() {return true;}
}
