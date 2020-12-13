import java.util.Collection;
import java.util.TreeSet;

public class King implements Piece {
    private int xPos;
    private int yPos;
    private boolean isCaptured;
    private boolean isWhite;
    private boolean eligibleCastle;

    public King(int xIn, int yIn, boolean white) {
        xPos = xIn;
        yPos = yIn;
        isCaptured = false;
        isWhite = white;
        eligibleCastle = true;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void updateCastle() {
        if (eligibleCastle) {
            if (isWhite) {
                eligibleCastle = xPos == 0 && yPos == 3;
            } else {
                eligibleCastle = xPos == 7 && yPos == 3;
            }
        }
    }

    public boolean eligibleForCastle() {
        return eligibleCastle;
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

    public boolean checkOutOfBounds(int x, int y) {
        return ((x > -1 && x < 8) && (y > -1 && y < 8));
    }

    public Collection<Move> getMoves(int x, int y) {
        Collection<Move> moves = new TreeSet<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = i + x;
                int newY = j + y;
                if (newX != x || newY != y) {
                    if (checkOutOfBounds(newX, newY)) {
                        moves.add(new Move(newX, newY));
                    }
                }
            }
        }
        return moves;
    }

    public String toString() {
        return " K ";
    }

    public void setX(int x) {
        xPos = x;
    }

    public void setY(int y) {
        yPos = y;
    }

    @Override
    public Piece clone() {
        return new King(xPos, yPos, isWhite);
    }

    public String getType() {
        return "King";
    }
}
