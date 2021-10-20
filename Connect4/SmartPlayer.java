import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SmartPlayer extends Player {

    private List<Marker> markers = new ArrayList<Marker>();

    public SmartPlayer(int turnNumber, Color color, PApplet screen) {
        this.turnNumber = turnNumber;
        this.markerColor = color;
        this.screen = screen;
        this.myTurn = false;
    }

    public void takeTurn(int col, GameFrame board) {
        col = (int)Math.floor(Math.random() * 6) + 1;
        screen.fill(this.markerColor.getRGB());
        screen.circle(board.centeredX() + 36 + 70 * (col - 1),
                238 + (board.lowestRow(col) - 1) * 70, 56);
        Marker marker = new Marker(this.markerColor, board.lowestRow(col), col);
        board.addMarker(marker);
        this.markers.add(marker);
    }

    public boolean checkWin() {return true;}

    public void toggleTurn() {this.myTurn = !this.myTurn;}
}
