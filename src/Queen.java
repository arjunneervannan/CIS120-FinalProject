import java.util.Collection;
import java.util.TreeSet;

public class Queen implements Piece {
    private int xPos;
    private int yPos;
    private boolean isCaptured;
    private boolean isWhite;

    public Queen(int xIn, int yIn, boolean white) {
        xPos = xIn;
        yPos = yIn;
        isCaptured = false;
        isWhite = white;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public boolean isCaptured() {
        return isCaptured;
    }

    public void setCapture(boolean captured) {
        isCaptured = captured;
    }

    @Override
    public boolean isWhite() {
        return isWhite;
    }

    public boolean checkOutOfBounds(int x, int y) {
        return ((x > -1 && x < 8) && (y > -1 && y < 8));
    }

    public Collection<Move> getMoves(int x, int y) {
        Collection<Move> moves = new TreeSet<>();
        for (int i = -7; i < 8; i++) {
            int newX = x + i;
            int newY = y + i;
            int newX2 = x - i;
            // check top left bottom right diagonal
            if (newX != x && newY != y) {
                if (checkOutOfBounds(newX, newY)) {
                    moves.add(new Move(newX, newY));
                }
            }
            // check bottom left top right diagonal
            if (newX2 != x && newY != y) {
                if (checkOutOfBounds(newX2, newY)) {
                    moves.add(new Move(newX2, newY));
                }
            }
            if (i != x) {
                if (checkOutOfBounds(i, y)) {
                    moves.add(new Move(i, y));
                }
            }
            if (i != y) {
                if (checkOutOfBounds(x, i)) {
                    moves.add(new Move(x, i));
                }
            }
        }
        return moves;
    }

    public String toString() {
        return " Q ";
    }

    public void setX(int x) {
        xPos = x;
    }

    public void setY(int y) {
        yPos = y;
    }

    @Override
    public Piece clone() {
        return new Queen(xPos, yPos, isWhite);
    }

    public String getType() {
        return "Queen";
    }
}