import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartPlayer extends Player {

    private Map<Integer, Integer> markerColumns = new HashMap<>();

    public SmartPlayer(int turnNumber, Color color, PApplet screen) {
        this.turnNumber = turnNumber;
        this.markerColor = color;
        this.screen = screen;
        this.myTurn = false;
    }

    public void takeTurn(int col, GameFrame board) {
        col = (int)Math.floor(Math.random() * 7) + 1;
        while (board.lowestRow(col) == -1) {
            col = (int)Math.floor(Math.random() * 7) + 1;
        }
        int row = board.lowestRow(col);
        screen.fill(this.markerColor.getRGB());
        screen.circle(board.centeredX() + 36 + 70 * (col - 1),
                238 + (board.lowestRow(col) - 1) * 70, 56);
        Marker marker = new Marker(this.markerColor, row, col);
        board.addMarker(marker);
        this.markerColumns.put(col, row);
    }

    public boolean checkWin() {return true;}

    public void toggleTurn() {this.myTurn = !this.myTurn;}
}
