//TCSS 305 - Winter 2016
//Assignment 6 - Tetris

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Board;
import model.TetrisPiece;

/**
 * 
 * @author Ryan Hansen
 * @version 1.0
 */
public class NextPiecePanel extends JPanel implements Observer {

    /**
     * Randomly generated serial Version UID.
     */
    private static final long serialVersionUID = 168426035370641970L;
    
    /**
     * panel size.
     */
    private static final Dimension DEFAULT_SIZE = new Dimension(160, 160);
    
    /**
     * next Tetris piece.
     */
    private TetrisPiece myNextPiece;
    
    /**
     * class for drawing the pieces.
     */
    private final DrawNextPiece myDrawNextPiece;
    
    /**
     * the board panel.
     */
    private final BoardPanel myBoardPanel;

    /**
     * constructor.
     * @param theBoardPanel board panel
     */
    public NextPiecePanel(final BoardPanel theBoardPanel) {
        super();
        myBoardPanel = theBoardPanel;
        setPreferredSize(DEFAULT_SIZE);
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
             
        final Board board = theBoardPanel.getMyBoard();
        board.addObserver(this);
        myDrawNextPiece = new DrawNextPiece(this);
    }
      
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);        
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (myBoardPanel.isMyJustStarted()) {
            repaint();
        } else {
            repaint();
            myDrawNextPiece.paintNextPiece(g2d);
        }
    }
       
    @Override
    public void update(final Observable theObservable, final Object theObject) {
        
        if (theObject instanceof TetrisPiece) {
            myNextPiece = (TetrisPiece) theObject; 
            myDrawNextPiece.setNextPiece(myNextPiece);
        } 
    }
}
