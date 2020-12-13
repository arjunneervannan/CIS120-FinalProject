import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements Runnable {

    public static void main(String[] args) {
//        Board board = new Board(true);
//        board.printDisplay();
////        board.selectPiece(0, 4);
//
//        board.movePiece(1, 4, 2, 4);
//        board.printDisplay();
//        board.movePiece(6, 4, 5, 4);
//        board.printDisplay();
//        board.movePiece(1, 3, 2, 3);
//        board.printDisplay();
//        board.movePiece(7, 4, 4, 7);
//        board.printDisplay();
////        board.selectPiece(4, 7);
//        board.updateCurrentMoves();

        SwingUtilities.invokeLater(new Game());
    }

    @Override
    public void run() {
        final JFrame frame = new JFrame("Chess");
        frame.setLocation(0, 0);
        // Status panel
        final JPanel status_panel = new JPanel();
        frame.add(status_panel, BorderLayout.SOUTH);
        final JLabel status = new JLabel("Setting up...");
        status_panel.add(status);

        // Game board
        final GameBoard board = new GameBoard(status);
        frame.add(board, BorderLayout.CENTER);

        // Reset button
        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.NORTH);

        // Note here that when we add an action listener to the reset button, we define it as an
        // anonymous inner class that is an instance of ActionListener with its actionPerformed()
        // method overridden. When the button is pressed, actionPerformed() will be called.
        final JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.reset();
            }
        });
        control_panel.add(reset);

        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start the game
        board.reset();
    }
}
