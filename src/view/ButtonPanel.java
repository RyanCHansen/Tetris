//TCSS 305 - Winter 2016
//Assignment 6 - Tetris

package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author Ryan Hansen
 * @version 1.0
 */
public class ButtonPanel extends JPanel {
    
    /**
     * Randomly generated serial Version UID.
     */
    private static final long serialVersionUID = -4856983418120853215L;
    
    /**
     * Just a number.
     */
    private static final int SIX = 6;
    
    /**
     * Just a number.
     */
    private static final int TEN = 10;
    
    /**
     * the board panel.
     */
    private final BoardPanel myBoardPanel;
    
    /**
     * the JFrame.
     */
    private final JFrame myJFrame;

    /**
     * constructor.
     * @param theJFrame JFrame
     * @param theBoardPanel the board panel
     */
    ButtonPanel(final JFrame theJFrame, final BoardPanel theBoardPanel) {
        super();
        myBoardPanel = theBoardPanel;
        myJFrame = theJFrame;
        this.setLayout(new GridLayout(SIX, 1, TEN, TEN)); 
        setBackground(Color.LIGHT_GRAY);
        
        createButtons();
    }      
    
    /**
     * creates the buttons.
     */
    private void createButtons() {
        //New Game Button
        final JButton newGame = new JButton("New Game");
        this.add(newGame);        
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myBoardPanel.startGame();
                myJFrame.requestFocus();
            }           
        });
        
        //End Game Button
        final JButton endGame = new JButton("End Game");
        this.add(endGame);        
        endGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myBoardPanel.endGame();
                myJFrame.requestFocus();
            }           
        });
               
        //pause Button
        final JButton pauseButton = new JButton("Pause");
        this.add(pauseButton);        
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myBoardPanel.pauseGame();
                myJFrame.requestFocus();
            }           
        });
        
        //Resume Button
        final JButton resumeButton = new JButton("Resume");
        this.add(resumeButton);        
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myBoardPanel.resumeGame();
                myJFrame.requestFocus();
            }           
        });
        
        //Help Button
        final JButton helpButton = new JButton("Scoring Rules");
        this.add(helpButton);        
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(myBoardPanel,
                                              "Scoring Chart"
                                              + "\n1 Line = (Difficulty level) x 40"
                                              + "\n2 Lines = (Difficulty level) x 100"
                                              + "\n3 Lines = (Difficulty level) x 300"
                                              + "\n4 Lines = (Difficulty level) x 1200");
                myJFrame.requestFocus();
            }           
        });
    }
}
    
    

