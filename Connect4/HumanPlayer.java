import processing.core.PApplet;

import java.awt.*;
import java.util.*;
import java.util.List;

public class HumanPlayer extends Player{

    public HumanPlayer(Color color, PApplet screen, boolean myTurn) {
        this.markerColor = color;
        this.screen = screen;
        this.myTurn = myTurn;
    }

    public void takeTurn(int col, GameFrame board) {
        screen.fill(this.markerColor.getRGB());
        screen.circle(board.centeredX() + 36 + 70 * (col - 1),
                238 + (board.lowestRow(col) - 1) * 70, 56);
        int row = board.lowestRow(col);
        Marker marker = new Marker(this.markerColor, row, col);
        board.addMarker(marker);
        this.markerColumns.get(col - 1).add(row);
    }

    public List<ArrayList<Integer>> getMarkers() {
        return markerColumns;
    }
}
