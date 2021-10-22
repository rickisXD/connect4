import processing.core.PApplet;

import java.awt.*;
import java.util.*;
import java.util.List;

public class SmartPlayer extends Player {

    public SmartPlayer(Color color, PApplet screen) {
        this.markerColor = color;
        this.screen = screen;
        this.myTurn = false;
    }

    public void takeTurn(List<ArrayList<Integer>> opponentMarkers, GameFrame board) {
        int column = (int)Math.floor(Math.random() * 7) + 1;
        // defensive first

        // check vertical column threat
        for (int col = 0; col < 7; col++) {
            for (int row = 6; row > 2; row--) {
                if (opponentMarkers.get(col).contains(row) && opponentMarkers.get(col).contains(row - 1)
                        && opponentMarkers.get(col).contains(row - 2) && !markerColumns.get(col).contains(row - 3)) {
                    column = col + 1;
                    break;
                }
            }
        }

        //check for horiz row threat
        for (int col = 0; col < 4; col++) {
            for (int row = 1; row < 7; row++) {
                if (opponentMarkers.get(col).contains(row) && opponentMarkers.get(col + 1).contains(row) &&
                        opponentMarkers.get(col + 2).contains(row) && !markerColumns.get(col + 3).contains(row)) {
                    column = col + 4;
                    break;
                }
                else if (!markerColumns.get(col).contains(row) && opponentMarkers.get(col + 1).contains(row) &&
                            opponentMarkers.get(col + 2).contains(row) && opponentMarkers.get(col + 3).contains(row)) {
                    column = col + 1;
                    break;
                }
                else if (opponentMarkers.get(col).contains(row) && opponentMarkers.get(col + 1).contains(row) &&
                        opponentMarkers.get(col + 3).contains(row) && !markerColumns.get(col + 2).contains(row)) {
                    column = col + 3;
                    break;
                }
                else if (opponentMarkers.get(col).contains(row) && opponentMarkers.get(col + 2).contains(row) &&
                        opponentMarkers.get(col + 3).contains(row) && !markerColumns.get(col + 1).contains(row)) {
                    column = col + 2;
                    break;
                }
            }
        }

        //check diagonal '/'
        for (int col = 0; col < 4; col++) {
            for (int row = 6; row > 2; row--) {
                if (opponentMarkers.get(col).contains(row) && opponentMarkers.get(col + 1).contains(row - 1) &&
                        opponentMarkers.get(col + 2).contains(row - 2) && !markerColumns.get(col + 3).contains(row - 3)
                        && board.lowestRow(col + 4) == row - 3) {
                    column = col + 4;
                    break;
                }
                else if (opponentMarkers.get(col).contains(row) && opponentMarkers.get(col + 1).contains(row - 1) &&
                        opponentMarkers.get(col + 3).contains(row - 3) && !markerColumns.get(col + 2).contains(row - 2)
                        && board.lowestRow(col + 3) == row - 2) {
                    column = col + 3;
                    break;
                }
                else if (opponentMarkers.get(col).contains(row) && opponentMarkers.get(col + 2).contains(row - 2) &&
                        opponentMarkers.get(col + 3).contains(row - 3) && !markerColumns.get(col + 1).contains(row - 1)
                        && board.lowestRow(col + 2) == row - 1) {
                    column = col + 2;
                    break;
                }
                else if (opponentMarkers.get(col + 1).contains(row - 1) && opponentMarkers.get(col + 2).contains(row - 2) &&
                        opponentMarkers.get(col + 3).contains(row - 3) && !markerColumns.get(col).contains(row)
                        && board.lowestRow(col + 1) == row) {
                    column = col + 1;
                    break;
                }
            }
        }

        //check diagonal '\'
        for (int col = 6; col > 2; col--) {
            for (int row = 6; row > 2; row--) {
                if (opponentMarkers.get(col).contains(row) && opponentMarkers.get(col - 1).contains(row - 1) &&
                        opponentMarkers.get(col - 2).contains(row - 2) && !markerColumns.get(col - 3).contains(row - 3)
                        && board.lowestRow(col - 2) == row - 3) {
                    column = col - 2;
                    break;
                }
                else if (opponentMarkers.get(col).contains(row) && opponentMarkers.get(col - 1).contains(row - 1) &&
                        opponentMarkers.get(col - 3).contains(row - 3) && !markerColumns.get(col - 2).contains(row - 2)
                        && board.lowestRow(col - 1) == row - 2) {
                    column = col - 1;
                    break;
                }
                else if (opponentMarkers.get(col).contains(row) && opponentMarkers.get(col - 2).contains(row - 2) &&
                        opponentMarkers.get(col - 3).contains(row - 3) && !markerColumns.get(col - 1).contains(row - 1)
                        && board.lowestRow(col) == row - 1) {
                    column = col;
                    break;
                }
                else if (opponentMarkers.get(col - 1).contains(row - 1) && opponentMarkers.get(col - 2).contains(row - 2) &&
                        opponentMarkers.get(col - 3).contains(row - 3) && !markerColumns.get(col).contains(row)
                        && board.lowestRow(col + 1) == row) {
                    column = col + 1;
                    break;
                }
            }
        }

        //offensive second

        for (int col = 0; col < 7; col++) {
            for (int row = 6; row > 2; row--) {
                if (markerColumns.get(col).contains(row) && markerColumns.get(col).contains(row - 1)
                        && markerColumns.get(col).contains(row - 2) && !markerColumns.get(col).contains(row - 3)) {
                    column = col + 1;
                    break;
                }
            }
        }

        //check for horiz row threat
        for (int col = 0; col < 4; col++) {
            for (int row = 1; row < 7; row++) {
                if (markerColumns.get(col).contains(row) && markerColumns.get(col + 1).contains(row) &&
                        markerColumns.get(col + 2).contains(row) && !markerColumns.get(col + 3).contains(row)) {
                    column = col + 4;
                    break;
                }
                else if (!markerColumns.get(col).contains(row) && markerColumns.get(col + 1).contains(row) &&
                        markerColumns.get(col + 2).contains(row) && markerColumns.get(col + 3).contains(row)) {
                    column = col + 1;
                    break;
                }
                else if (markerColumns.get(col).contains(row) && markerColumns.get(col + 1).contains(row) &&
                        markerColumns.get(col + 3).contains(row) && !markerColumns.get(col + 2).contains(row)) {
                    column = col + 3;
                    break;
                }
                else if (markerColumns.get(col).contains(row) && markerColumns.get(col + 2).contains(row) &&
                        markerColumns.get(col + 3).contains(row) && !markerColumns.get(col + 1).contains(row)) {
                    column = col + 2;
                    break;
                }
            }
        }

        //check diagonal '/'
        for (int col = 0; col < 4; col++) {
            for (int row = 6; row > 2; row--) {
                if (markerColumns.get(col).contains(row) && markerColumns.get(col + 1).contains(row - 1) &&
                        markerColumns.get(col + 2).contains(row - 2) && !markerColumns.get(col + 3).contains(row - 3)
                        && board.lowestRow(col + 4) == row - 3) {
                    column = col + 4;
                    break;
                }
                else if (markerColumns.get(col).contains(row) && markerColumns.get(col + 1).contains(row - 1) &&
                        markerColumns.get(col + 3).contains(row - 3) && !markerColumns.get(col + 2).contains(row - 2)
                        && board.lowestRow(col + 3) == row - 2) {
                    column = col + 3;
                    break;
                }
                else if (markerColumns.get(col).contains(row) && markerColumns.get(col + 2).contains(row - 2) &&
                        markerColumns.get(col + 3).contains(row - 3) && !markerColumns.get(col + 1).contains(row - 1)
                        && board.lowestRow(col + 2) == row - 1) {
                    column = col + 2;
                    break;
                }
                else if (markerColumns.get(col + 1).contains(row - 1) && markerColumns.get(col + 2).contains(row - 2) &&
                        markerColumns.get(col + 3).contains(row - 3) && !markerColumns.get(col).contains(row)
                        && board.lowestRow(col + 1) == row) {
                    column = col + 1;
                    break;
                }
            }
        }


        //check diagonal '\'
        for (int col = 6; col > 2; col--) {
            for (int row = 6; row > 2; row--) {
                if (markerColumns.get(col).contains(row) && markerColumns.get(col - 1).contains(row - 1) &&
                        markerColumns.get(col - 2).contains(row - 2) && !markerColumns.get(col - 3).contains(row - 3)
                        && board.lowestRow(col - 2) == row - 3) {
                    column = col - 2;
                    break;
                }
                else if (markerColumns.get(col).contains(row) && markerColumns.get(col - 1).contains(row - 1) &&
                        markerColumns.get(col - 3).contains(row - 3) && !markerColumns.get(col - 2).contains(row - 2)
                        && board.lowestRow(col - 1) == row - 2) {
                    column = col - 1;
                    break;
                }
                else if (markerColumns.get(col).contains(row) && markerColumns.get(col - 2).contains(row - 2) &&
                        markerColumns.get(col - 3).contains(row - 3) && !markerColumns.get(col - 1).contains(row - 1)
                        && board.lowestRow(col) == row - 1) {
                    column = col;
                    break;
                }
                else if (markerColumns.get(col - 1).contains(row - 1) && markerColumns.get(col - 2).contains(row - 2) &&
                        markerColumns.get(col - 3).contains(row - 3) && !markerColumns.get(col).contains(row)
                        && board.lowestRow(col + 1) == row) {
                    column = col + 1;
                    break;
                }
            }
        }

        while (board.lowestRow(column) == -1) {
            column = (int) Math.floor(Math.random() * 7) + 1;
        }

        int row = board.lowestRow(column);
        screen.fill(this.markerColor.getRGB());
        screen.circle(board.centeredX() + 36 + 70 * (column - 1),
                238 + (board.lowestRow(column) - 1) * 70, 56);
        Marker marker = new Marker(this.markerColor, row, column);
        board.addMarker(marker);
        this.markerColumns.get(column - 1).add(row);
    }

}
