//TCSS 305 - Winter 2016
//Assignment 6 - Tetris

package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Starts the building of the GUI.
 * 
 * @author Ryan Hansen
 * @version 1.0
 */
public class GUI {
    

    /**
     * starts building the GUI.
     */
    public void start() {
        
        //creates the frame
        final JFrame frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        final ImageIcon imageIcon = new ImageIcon("./support_files/tetris_icon.png");
        frame.setIconImage(imageIcon.getImage()); 
        
        //adds a new border layout to the east default border layout
        final JPanel eastBorderLayout = new JPanel(new BorderLayout());
        frame.getContentPane().add(eastBorderLayout, BorderLayout.EAST);
        
        //adds in the JLabels for Display
        final InformationDisplayPanel displayPanel = new InformationDisplayPanel();
        eastBorderLayout.add(displayPanel, BorderLayout.CENTER);
        
        //creates the board panel 
        final BoardPanel boardPanel = new BoardPanel(frame, displayPanel);
        frame.getContentPane().add(boardPanel, BorderLayout.CENTER);
        
        //creates the nexPiecePanel
        final NextPiecePanel nextPiecePanel = new NextPiecePanel(boardPanel);       
        eastBorderLayout.add(nextPiecePanel, BorderLayout.NORTH);
        
        //creates the button panel
        final ButtonPanel buttonPanel = new ButtonPanel(frame, boardPanel);
        eastBorderLayout.add(buttonPanel, BorderLayout.SOUTH); 
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.requestFocus();
    }



}
