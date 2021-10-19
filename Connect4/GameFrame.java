import processing.core.PApplet;
import processing.core.PImage;

public class GameFrame {

    private PImage gameBoard;
    private int windowX;
    private int windowY;

    public GameFrame(int x, int y, PImage img) {
        this.windowX = x;
        this.windowY = y;
        this.gameBoard = img;
    }

    public int centeredX() {
        return (windowX / 2) - (gameBoard.width / 2);
    }
}
