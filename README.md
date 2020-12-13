For my CIS120 Final Project, I built chess


## Code Structure

Piece classes (Bishop, Queen, King, Rook, Pawn, Knight): These give the possible moves of each piece regardless of
any other blockages/conflicts, since the individual pieces do not have any knowledge of the other pieces in the game.
This means that the Bishop would give all the diagonal squares as moves regardless of whether or not they are already
occupied, and so on for other classes. Castling is also taken care of in these clases. All of these classes implemented
Piece.java, which is an interface.

Board.java: This handles the actual game using a 2D array of type Piece (which holds all of the pieces). This checks
for all collisions, captured pieces, checks, pawn promotions, checkmates, and more - this is basically responsible
for actually interacting the individual piece classes with each other. At each step, a HashMap that maps each piece to
a collection of possible moves is generated, and the user can select any one of those possible moves to move a piece.
In addition, check is handled by seeing if the king is in the "line of fire" - or if the king is in one of the moves
in the opposing possible moves.

GameBoard.java and Game.java: These are responsible for handling the graphics of the game. GameBoard.java interacts
directly with board.java by creating a Board object, and Game.java implements Runnable to actually run the game.
