//TCSS 305 - Winter 2016
//Assignment 6 - Tetris

package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import model.Block;

/**
 * 
 * @author Ryan Hansen
 * @version 1.0
 */
public class DrawBoardSquares {
    
    /**
     * Just a Number.
     */
    private static final int DEFAULT_YVALUE = 760;
    
    /**
     * Just a Number.
     */
    private static final int DEFFAULT_SQUARE_SIZE = 40;
    
    /**
     * Just a Number.
     */
    private static final int STROKE = 4;
    
    /**
     * my board panel.
     */
    private final BoardPanel myBoardPanel;
    
    /**
     * my board data.
     */
    private List<Block[]> myBoardData = new ArrayList<Block[]>();
    
    /**
     * constructor.
     * @param theBoardPanel board panel
     */
    public DrawBoardSquares(final BoardPanel theBoardPanel) {
        myBoardPanel = theBoardPanel;
    }
       
    /**
     * logic for painting the pieces.
     * @param theGraphics graphics 
     */
    public void paintBoard(final Graphics2D theGraphics) {
        int yValue = DEFAULT_YVALUE;
        
        for (final Block[] block : myBoardData) {
            int xValue = 0;

            for (int i = 0; i < block.length; i++) {
                if (block[i] != null) {
                    theGraphics.setColor(Color.GREEN);
                    theGraphics.fillRect(xValue, yValue,
                                         DEFFAULT_SQUARE_SIZE,
                                         DEFFAULT_SQUARE_SIZE);
                    theGraphics.setColor(Color.BLACK);
                    theGraphics.setStroke(new BasicStroke(STROKE));
                    theGraphics.drawRect(xValue, yValue,
                                         DEFFAULT_SQUARE_SIZE,
                                         DEFFAULT_SQUARE_SIZE);
                }
                xValue = xValue + DEFFAULT_SQUARE_SIZE;
            }
            yValue = yValue - DEFFAULT_SQUARE_SIZE;
            myBoardPanel.repaint();
        }
    }
    
    /**
     * sets the board data.
     * @param theBoardData board data
     */
    public void setBoardData(final List<Block[]> theBoardData) {
        myBoardData = theBoardData;
    }
}
