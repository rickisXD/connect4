import processing.core.PImage;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameFrame {

    private PImage gameBoard;
    private int windowX;
    private int windowY;
    private List<Marker> markers = new ArrayList<Marker>();
    private boolean rendered = false;

    public GameFrame(int x, int y, PImage img) {
        this.windowX = x;
        this.windowY = y;
        this.gameBoard = img;
    }

    public PImage getGameBoard() {
        return gameBoard;
    }

    public List<Marker> getMarkers() {return this.markers;}

    public int centeredX() {
        return (windowX / 2) - (gameBoard.width / 2);
    }

    public boolean isRendered() {return this.rendered;}

    public void setRendered() {this.rendered = true;}

    public int lowestRow(int col) {
        if (markers.size() == 0) {
            return 6;
        }
        int counter = 0;
        for (Marker marker : markers) {
            if (marker.getColumn() == col) {
                counter++;
            }
        }
        if (counter < 6) {
            return 6 - counter;
        }
        return -1;
    }

    public void addMarker(Marker marker) {
        this.markers.add(marker);
    }
}
