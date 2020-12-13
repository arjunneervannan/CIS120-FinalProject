import java.util.Collection;
import java.util.TreeSet;

public class Pawn implements Piece {
    private int xPos;
    private int yPos;
    private boolean isCaptured;
    private boolean isWhite;
    private boolean captureByEnPassant;

    public Pawn(int xIn, int yIn, boolean white) {
        xPos = xIn;
        yPos = yIn;
        isCaptured = false;
        isWhite = white;
        captureByEnPassant = false;
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

    public String toString() {
        return " P ";
    }

    public void setX(int x) {
        xPos = x;
    }

    public void setY(int y) {
        yPos = y;
    }

    public void setCaptureByEnPassant(boolean enPassant) {
        captureByEnPassant = enPassant;
    }

    public boolean isCaptureByEnPassant() {
        if (isWhite) {
            return xPos == 3;
        } else {
            return xPos == 4;
        }
    }

    @Override
    public Piece clone() {
        return new Pawn(xPos, yPos, isWhite);
    }

    public String getType() {
        return "Pawn";
    }

    public Collection<Move> getMoves(int x, int y) {
        Collection<Move> moves = new TreeSet<>();
        if (x == 1) {
            if (isWhite) {
                // pawn can move two places at start of game
                moves.add(new Move(x + 1, y));
                moves.add(new Move(x + 2, y));
            } else {
                moves.add(new Move(x - 1, y));
            }
        } else if (x == 6) {
            if (isWhite) {
                moves.add(new Move(x + 1, y));
            } else {
                moves.add(new Move(x - 1, y));
                moves.add(new Move(x - 2, y));
            }
        } else {
            if (isWhite) {
                int newX = x + 1;
                if (newX <= 6) {
                    moves.add(new Move(newX, y));
                    // have to handle promotion if new position is
                }
            } else {
                int newX = x - 1;
                if (newX >= 1) {
                    moves.add(new Move(newX, y));
                }
            }
        }
        return moves;
    }

}
