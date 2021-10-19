import java.awt.*;

public abstract class Player {
    public Color markerColor;
    public int turnNumber;
    public boolean myTurn;
    public abstract void takeTurn();
    public abstract boolean checkWin();
}
