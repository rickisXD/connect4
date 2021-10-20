import processing.core.PApplet;
import java.awt.*;

public abstract class Player {
    protected PApplet screen;
    protected Color markerColor;
    protected int turnNumber;
    protected boolean myTurn;
    protected abstract void takeTurn(int col, GameFrame board);
    protected abstract void toggleTurn();
    protected abstract boolean checkWin();
}
