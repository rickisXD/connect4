import java.awt.*;

public class SmartPlayer extends Player {

    public SmartPlayer(int turnNumber, boolean myTurn, Color color) {
        this.turnNumber = turnNumber;
        this.myTurn = myTurn;
        this.markerColor = color;
    }

    public void takeTurn() {

    }

    public boolean checkWin() {return true;}
}
