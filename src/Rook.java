import java.util.Collection;
import java.util.TreeSet;

public class Rook implements Piece {
    private int xPos;
    private int yPos;
    private boolean isCaptured;
    private boolean isWhite;
    private boolean eligibleCastle;

    public Rook(int xIn, int yIn, boolean white) {
        xPos = xIn;
        yPos = yIn;
        isCaptured = false;
        isWhite = white;
        eligibleCastle = true;
    }

    public void updateCastle() {
        if (eligibleCastle) {
            eligibleCastle = ((xPos == 0) && (yPos == 0)) ||
                    ((xPos == 0) && (yPos == 7)) ||
                    ((xPos == 7) && (yPos == 0)) ||
                    ((xPos == 7) && (yPos == 7));
        }
    }

    public boolean eligibleForCastle() {
        return eligibleCastle;
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

    public boolean isWhite() {
        return isWhite;
    }

    public Collection<Move> getMoves(int x, int y) {
        Collection<Move> moves = new TreeSet<>();
        for (int i = 0; i < 8; i++) {
            if (i != x) {
                moves.add(new Move(i, y));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (i != y) {
                moves.add(new Move(x, i));
            }
        }
        return moves;
    }

    public String toString() {
        return " R ";
    }

    public void setX(int x) {
        xPos = x;
    }

    public void setY(int y) {
        yPos = y;
    }

    @Override
    public Piece clone() {
        return new Rook(xPos, yPos, isWhite);
    }

    public String getType() {
        return "Rook";
    }
}