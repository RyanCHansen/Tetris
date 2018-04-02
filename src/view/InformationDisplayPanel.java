//TCSS 305 - Winter 2016
//Assignment 6 - Tetris

package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel where the information and scores will be displayed.
 * 
 * @author Ryan Hansen
 * @version 1.0
 */
public class InformationDisplayPanel extends JPanel {

    /**
     * Randomly generated serial Version UID.
     */
    private static final long serialVersionUID = 1446427779646464021L;
    
    /**
     * Just a Number.
     */
    private static final int THREE = 3;
    
    /**
     * Just a Number.
     */
    private static final int FOUR = 4;
    
    /**
     * Just a Number.
     */
    private static final int FIVE = 5;
    
    /**
     * Just a Number.
     */
    private static final int SIX = 6;
    
    /**
     * Just a Number.
     */
    private static final int SEVEN = 7;
    
    /**
     * Just a Number.
     */
    private static final int EIGHT = 8;
    
    /**
     * Just a Number.
     */
    private static final int NINE = 9;
    
    /**
     * Just a Number.
     */
    private static final int TEN = 10;
    
    /**
     * Just a Number.
     */
    private static final int FIFTEEN = 15;
    
    /**
     * Just a Number.
     */
    private static final int TWENTY = 20;
    
    /**
     * Just a Number.
     */
    private static final int TWENTY_FIVE = 25;
    
    /**
     * Just a Number.
     */
    private static final int THIRTY = 30;
    
    /**
     * Just a Number.
     */
    private static final int THIRTY_FIVE = 35;
    
    /**
     * Just a Number.
     */
    private static final int FOURTY = 40;
    
    /**
     * Just a Number.
     */
    private static final int FOURTY_FIVE = 45;
    
    /**
     * Just a Number.
     */
    private static final int ONE_HUNDRED = 100;
    
    /**
     * Just a Number.
     */
    private static final int THREE_HUNDRED = 300;
    
    /**
     * Just a Number.
     */
    private static final int TWELVE_HUNDRED = 1200;
    
    /**
     * Just a String.
     */
    private static final String SCORE = "Score: ";
    
    /**
     * Just a String.
     */
    private static final String DIFFICULTY_LEVEL = "Difficulty Level: ";
    
    /**
     * Just a String.
     */
    private static final String NEXT_LEVEL_ONE = "Rows Cleared Needed";
    
    /**
     * Just a String.
     */
    private static final String NEXT_LEVEL_TWO = "Until Next Level: ";
    
    /**
     * Just a String.
     */
    private static final String LINES_CLEARED = "Lines Cleared: ";
    
    /**
     * Number of lines cleared.
     */
    private int myLinesCleared;
    
    /**
     * Total Score.
     */
    private int myScore;
    
    /**
     * current Level.
     */
    private int myLevel = 1;
    
    /**
     * JLabel.
     */
    private JLabel myScoreLabel;
    
    /**
     * JLabel.
     */
    private JLabel myLevelLabel;
    
    /**
     * JLabel.
     */
    private JLabel myLinesClearedLabel;
    
    /**
     * JLabel.
     */
    private JLabel myNextLevelLabelTwo;

    /**
     * constructor.
     */
    InformationDisplayPanel() {
        super();
        this.setLayout(new GridLayout(TWENTY, 2, FIVE, FIVE));
        setBackground(Color.LIGHT_GRAY);
        
        createLabels();
    }
    
    /**
     * creates the JLabels for the panel.
     */
    private void createLabels() {
        final JLabel lable1 = new JLabel("Move Left: Left Arrow", JLabel.LEFT);
        this.add(lable1);
        
        final JLabel lable2 = new JLabel("Move Right: Right Arrow", JLabel.LEFT);
        this.add(lable2);
        
        final JLabel lable3 = new JLabel("Move Down: Down Arrow", JLabel.LEFT);
        this.add(lable3);
        
        final JLabel lable4 = new JLabel("Rotate CW: Up Arrow", JLabel.LEFT);
        this.add(lable4);
        
        final JLabel lable5 = new JLabel("Rotate CCW: X", JLabel.LEFT);
        this.add(lable5);
        
        final JLabel lable6 = new JLabel("Drop Piece: Spacebar", JLabel.LEFT);
        this.add(lable6);
        
        final JLabel lableFiller = new JLabel("", JLabel.LEFT);
        this.add(lableFiller);
        
        final JLabel lableFiller2 = new JLabel("", JLabel.LEFT);
        this.add(lableFiller2);
        
        myLevelLabel = new JLabel(DIFFICULTY_LEVEL + myLevel, JLabel.LEFT);
        this.add(myLevelLabel);
        
        final JLabel nextLevelLabelOne = new JLabel(NEXT_LEVEL_ONE, JLabel.LEFT);
        this.add(nextLevelLabelOne);
        
        myNextLevelLabelTwo = new JLabel(NEXT_LEVEL_TWO + FIVE, JLabel.LEFT);
        this.add(myNextLevelLabelTwo);
        
        final JLabel lableFiller3 = new JLabel("", JLabel.LEFT);
        this.add(lableFiller3);
        
        final JLabel lableFiller4 = new JLabel("", JLabel.LEFT);
        this.add(lableFiller4);
        
        myLinesClearedLabel = new JLabel(LINES_CLEARED + myLinesCleared, JLabel.LEFT);
        this.add(myLinesClearedLabel);
        
        myScoreLabel = new JLabel(SCORE + myScore, JLabel.LEFT);
        this.add(myScoreLabel);
        
    }
    
    /**
     * calculates how many turns until the next level.
     */
    private void howFarTillNextLevel() {
        int result = 0;
        
        if (myLevel == 1) {
            result = FIVE - myLinesCleared;
            if (result == 0) {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + FIVE);
            } else {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + result);
            }
        } else if (myLevel == 2) {
            result = TEN - myLinesCleared;
            if (result == 0) {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + FIVE);
            } else {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + result);
            }
        } else if (myLevel == THREE) {
            result = FIFTEEN - myLinesCleared;
            if (result == 0) {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + FIVE);
            } else {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + result);
            }
        } else if (myLevel == FOUR) {
            result = TWENTY - myLinesCleared;
            if (result == 0) {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + FIVE);
            } else {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + result);
            }
        } else {
            howFarTillNextLevelHelper();
        }

    }
    
    /**
     * helper method.
     */
    private void howFarTillNextLevelHelper() {
        int result = 0;
        
        if (myLevel == FIVE) {
            result = TWENTY_FIVE - myLinesCleared;
            if (result == 0) {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + FIVE);
            } else {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + result);
            }
        } else if (myLevel == SIX) {
            result = THIRTY - myLinesCleared;
            if (result == 0) {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + FIVE);
            } else {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + result);
            }
        } else if (myLevel == SEVEN) {
            result = THIRTY_FIVE - myLinesCleared;
            if (result == 0) {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + FIVE);
            } else {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + result);
            }
        } else {
            howFarTillNextLevelHelperAgain();
        }
    }
    
    /**
     * helper method.
     */
    private void howFarTillNextLevelHelperAgain() {
        int result = 0;
        
        if (myLevel == EIGHT) {
            result = FOURTY - myLinesCleared;
            if (result == 0) {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + FIVE);
            } else {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + result);
            }
        } else if (myLevel == NINE) {
            result = FOURTY_FIVE - myLinesCleared;
            if (result == 0) {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + FIVE);
            } else {
                myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + result);
            }
        } else if (myLevel == TEN) {
            myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + 0);
        }
        
    }
    
    /**
     * updates the scoring.
     * @param theInt integer
     */
    public void updateMyScore(final int theInt) {  
        myLinesCleared = myLinesCleared + theInt;
        myLinesClearedLabel.setText(LINES_CLEARED + myLinesCleared);
        myScore = myScore + calculateScore(theInt);      
        myScoreLabel.setText(SCORE + myScore);
    }
    
    /**
     * updates the level.
     * @param theInt integer
     */
    public void updateMyLevel(final int theInt) {
        myLevel = theInt;
        myLevelLabel.setText(DIFFICULTY_LEVEL + myLevel);
        howFarTillNextLevel();
    }
    
    /**
     * resets the scores for a new game.
     */
    public void resetForNewGame() {
        myLinesCleared = 0;
        myScore = 0;
        myLevel = 1;
        myLevelLabel.setText(DIFFICULTY_LEVEL + myLevel);
        myLinesClearedLabel.setText(LINES_CLEARED + myLinesCleared);
        myNextLevelLabelTwo.setText(NEXT_LEVEL_TWO + FIVE);
        myScoreLabel.setText(SCORE + myScore);
    }

    /**
     * calculates how much to add to the score.
     * @param theInt integer
     * @return an integer
     */
    private int calculateScore(final int theInt) {
        int result = 0;
        
        if (theInt == 1) {
            result = myLevel * FOURTY;
        } else if (theInt == 2) {
            result = myLevel * ONE_HUNDRED;
        } else if (theInt == THREE) {
            result = myLevel * THREE_HUNDRED;
        } else if (theInt == FOUR) {
            result = myLevel * TWELVE_HUNDRED;
        }       
        return result;
    }

}
