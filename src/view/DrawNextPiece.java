//TCSS 305 - Winter 2016
//Assignment 6 - Tetris

package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import model.Point;
import model.TetrisPiece;

/**
 * 
 * @author Ryan Hansen
 * @version 1.0
 */
public class DrawNextPiece {
    
    /**
     * Just a Number.
     */
    private static final int DEFFAULT_SQUARE_SIZE = 40;
    
    /**
     * Just a Number.
     */
    private static final int STROKE = 4;
    
    /**
     * Just a Number.
     */
    private static final int ONE_TWENTY = 80;
    
    /**
     * Just a Number.
     */
    private static final int EIGHTY = 80;
    
    /**
     * Just a Number.
     */
    private static final int FORTY = 40;
    
    /**
     * Just a Number.
     */
    private static final int THREE = 3;
    
    /**
     * next piece panel.
     */
    private final NextPiecePanel myNextPiecePanel;
    
    /**
     * next piece to draw.
     */
    private TetrisPiece myNextPiece;
    
    /**
     * constructor.
     * @param theNextPiecePanel next piece panel
     */
    public DrawNextPiece(final NextPiecePanel theNextPiecePanel) {
        myNextPiecePanel = theNextPiecePanel;      
    }

    /**
     * logic for painting the pieces.
     * @param theGraphics graphics 
     */
    public void paintNextPiece(final Graphics2D theGraphics) {

        final Point[] points = myNextPiece.getPoints();
        
        for (final Point point : points) {
            int x = point.x();
            int y = point.y();                        
            x = x * FORTY;
            
            if (y == 0) {
                y = ONE_TWENTY;
            } else if (y == 1) {
                y = EIGHTY;
            } else if (y == 2) {
                y = FORTY;
            } else if (y == THREE) {
                y = 0;
            }
            
            theGraphics.setColor(Color.GREEN);
            theGraphics.fillRect(x, y,
                                 DEFFAULT_SQUARE_SIZE,
                                 DEFFAULT_SQUARE_SIZE);
            theGraphics.setColor(Color.BLACK);
            theGraphics.setStroke(new BasicStroke(STROKE));
            theGraphics.drawRect(x, y,
                                 DEFFAULT_SQUARE_SIZE,
                                 DEFFAULT_SQUARE_SIZE);      
        }        
        myNextPiecePanel.repaint();  
    }
    
    /**
     * sets the next piece.
     * @param theTetrisPiece Tetris piece
     */
    public void setNextPiece(final TetrisPiece theTetrisPiece) {
        myNextPiece = theTetrisPiece;
    }
    
}
