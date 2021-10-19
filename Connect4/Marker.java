import java.awt.*;

public class Marker {

    private Color color;
    private int row;
    private int column;

    public Marker(Color color, int row, int column) {
        this.color = color;
        this.row = row;
        this.column = column;
    }

    public Color getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
