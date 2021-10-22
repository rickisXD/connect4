import processing.core.PApplet;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Player {
    protected List<ArrayList<Integer>> markerColumns = Arrays.asList(new ArrayList<Integer>(),
            new ArrayList<Integer>(), new ArrayList<Integer>(), new ArrayList<Integer>(),
            new ArrayList<Integer>(), new ArrayList<Integer>(), new ArrayList<Integer>());
    protected PApplet screen;
    protected Color markerColor;
    protected boolean myTurn;
    public void toggleTurn() { this.myTurn = !this.myTurn; }

    public boolean checkWin() {
        // check vertical win '|'
        for (int col = 0; col < 7; col++) {
            for (int row = 6; row > 2; row--) {
                if (markerColumns.get(col).contains(row) && markerColumns.get(col).contains(row - 1)
                        && markerColumns.get(col).contains(row - 2) && markerColumns.get(col).contains(row - 3)) {
                    return true;
                }
            }
        }

        //check for horiz win '-'
        for (int col = 0; col < 4; col++) {
            for (int row = 1; row < 7; row++) {
                if (markerColumns.get(col).contains(row) && markerColumns.get(col + 1).contains(row) &&
                        markerColumns.get(col + 2).contains(row) && markerColumns.get(col + 3).contains(row)) {
                    return true;
                }
            }
        }

        //check diagonal '/'
        for (int col = 0; col < 4; col++) {
            for (int row = 6; row > 2; row--) {
                if (markerColumns.get(col).contains(row) && markerColumns.get(col + 1).contains(row - 1) &&
                        markerColumns.get(col + 2).contains(row - 2) && markerColumns.get(col + 3).contains(row - 3)) {
                    return true;
                }
            }
        }

        //check diagonal '\'
        for (int col = 6; col > 2; col--) {
            for (int row = 6; row > 2; row--) {
                if (markerColumns.get(col).contains(row) && markerColumns.get(col - 1).contains(row - 1) &&
                        markerColumns.get(col - 2).contains(row - 2) && markerColumns.get(col - 3).contains(row - 3)) {
                    return true;
                }
            }
        }

        return false;
    }

}
