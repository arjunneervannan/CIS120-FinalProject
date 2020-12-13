README:

The game that I implemented is chess - I implemented all of the rules. I did not have
to make any other major changes to the game; everything works, including checkmate, check, revealed check,
moving pieces, and all of the rules.

The code is broken up into 3 main components:

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

Four concepts:

2D array - the state at each point is modeled using a 2D array of Pieces. This is an 8x8 grid that contains the pieces
of the game, and at each move the pieces within the board are also updated.

Collections - collections are used in a variety of places here, including to find the appopriate moves at each step
(this is in the HashMap) as well as the current pieces that have been captured (this is displayed on the screen).
TreeSets are used to store the possible moves (the use of a sorted TreeSet was useful for debugging as it makes sense
to go through the moves in order), and a regular List was used to store all of the pieces that have been caputred.
In addition, as mentioned above, a Hashmap was updated at each step to generate the possible moves. This makes it easier
for the user to select a piece as the program doesn't have to generate all possible moves at every step.

Inheritance - the 6 pieces in the game all implement the Piece interface, which has a couple common moves (set the
x position, set the y position, etc), but each piece implements its own moving rules since the possible moves for each
piece are different. In addition, some pieces also implement their own methods (such as castling, en passant, etc.)

Complex Game Logic - I implemented all of the rules in chess, including caslting, en passant, checking for valid moves,
and more. While there are a few edge cases that I wasn't able to get to because of time constraints, all of the rules
were implemented correctly.

