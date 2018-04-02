//TCSS 305 - Winter 2016
//Assignment 6 - Tetris

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Block;
import model.Board;

/**
 * Panel where the board pieces will be displayed.
 * 
 * @author Ryan Hansen
 * @version 1.0
 */
public class BoardPanel extends JPanel implements Observer, KeyListener {

    /**
     * Randomly generated serial Version UID.
     */
    private static final long serialVersionUID = 5955884825477886968L;
    
    /**
     * size of panel.
     */
    private static final Dimension DEFAULT_SIZE = new Dimension(400, 800);
    
    /**
     * Just a number.
     */
    private static final int THREE = 3;
    
    /**
     * Just a number.
     */
    private static final int FOUR = 4;
    
    /**
     * Just a number.
     */
    private static final int FIVE = 5;
    
    /**
     * Just a number.
     */
    private static final int SIX = 6;
    
    /**
     * Just a number.
     */
    private static final int SEVEN = 7;
    
    /**
     * Just a number.
     */
    private static final int EIGHT = 8;
    
    /**
     * Just a number.
     */
    private static final int NINE = 9;
    
    /**
     * Just a number.
     */
    private static final int TEN = 10;
    
    /**
     * Just a number.
     */
    private static final int FOURTEEN = 14;
    
    /**
     * Just a number.
     */
    private static final int FIFTEEN = 15;
    
    /**
     * Just a number.
     */
    private static final int NINETEEN = 19;
    
    /**
     * Just a number.
     */
    private static final int TWENTY = 20;
    
    /**
     * Just a number.
     */
    private static final int TWENTY_FOUR = 24;
    
    /**
     * Just a number.
     */
    private static final int TWENTY_FIVE = 25;
    
    /**
     * Just a number.
     */
    private static final int TWENTY_NINE = 29;
    
    /**
     * Just a number.
     */
    private static final int THIRTY = 30;
    
    /**
     * Just a number.
     */
    private static final int THIRTY_FOUR = 34;
    
    /**
     * Just a number.
     */
    private static final int THIRTY_FIVE = 35;
    
    /**
     * Just a number.
     */
    private static final int THIRTY_NINE = 39;
    
    /**
     * Just a number.
     */
    private static final int FOURTY = 40;
    
    /**
     * Just a number.
     */
    private static final int FOURTY_FOUR = 44;
    
    /**
     * Just a number.
     */
    private static final int FOURTY_FIVE = 45;
    
    /**
     * Just a number.
     */
    private static final int FIFTY = 50;
    
    /**
     * Just a number.
     */
    private static final int DEFAULT_TIMER = 1000;
    
    /**
     * Just a number.
     */
    private static final int ONE_HUNDRED = 100;
    
    /**
     * Just a number.
     */
    private static final int TWO_HUNDRED = 200;
    
    /**
     * Just a number.
     */
    private static final int THREE_HUNDRED = 300;
    
    /**
     * Just a number.
     */
    private static final int FOUR_HUNDRED = 400;
    
    /**
     * Just a number.
     */
    private static final int FIVE_HUNDRED = 500;
    
    /**
     * Just a number.
     */
    private static final int SIX_HUNDRED = 600;
    
    /**
     * Just a number.
     */
    private static final int SEVEN_HUNDRED = 700;
    
    /**
     * Just a number.
     */
    private static final int EIGHT_HUNDRED = 800;
    
    /**
     * Just a number.
     */
    private static final int NINE_HUNDRED = 900;
    
    /**
     * the game board.
     */
    private final Board myBoard;
    
    /**
     * the board data.
     */
    private List<Block[]> myBoardData = new ArrayList<Block[]>();
    
    /**
     * class for drawing the pieces.
     */
    private final DrawBoardSquares myDrawBoardSquares;
    
    /**
     * class for displaying the information.
     */
    private final InformationDisplayPanel myInformationDisplayPanel;
    
    /**
     * to tell if game is over.
     */
    private boolean myGameOver;
    
    /**
     * to tell if the game is paused.
     */
    private boolean myPausedGame;
    
    /**
     * to tell if the game just started.
     */
    private boolean myJustStarted = true;
    
    /**
     * to tell if the timer is active.
     */
    private boolean myTimerActive;
    
    /**
     * a timer for the game.
     */
    private Timer myTimer;
    
    /**
     * counter for my level.
     */
    private int myLevelCounter;

    /**
     * constructor.
     * @param theJFrame JFrame
     * @param theDisplayPanel DisplayPanel
     */
    public BoardPanel(final JFrame theJFrame, final InformationDisplayPanel theDisplayPanel) {
        super();
        setPreferredSize(DEFAULT_SIZE);
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        //creates the new game board and the
        //and the drawing class for the board
        myBoard = new Board();
        myInformationDisplayPanel = theDisplayPanel;
        myBoard.addObserver(this);
        myDrawBoardSquares = new DrawBoardSquares(this);   
        
        //adds the key listener to the Frame
        theJFrame.addKeyListener(this);   
    }
    
    /**
     * starts the game.
     */
    public void startGame() {
        if (!myTimerActive) {
            myTimerActive = true;
            myJustStarted = false;
            myPausedGame = false;
            myGameOver = false;
            resetGame();
            myBoard.newGame(); 
            myTimer = newTimer();  
        }
    }
    
    /**
     * resets the game.
     */
    private void resetGame() {
        myLevelCounter = 0;
        myInformationDisplayPanel.resetForNewGame();
    }

    /**
     * creates a new timer.
     * @return timer
     */
    private Timer newTimer() {
        final Timer timer = new Timer(DEFAULT_TIMER, new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myBoard.step();
            }            
        });
        timer.setInitialDelay(0);
        timer.start();
        return timer;
    }
    
    /**
     * ends the game.
     */
    public void endGame() {
        if (myTimerActive) {
            myTimer.stop();
            myTimerActive = false;
            gameOver();
        }
    }
    
    /**
     * pauses the game.
     */
    public void pauseGame() {
        if (myTimerActive) {
            myTimer.stop();
            myPausedGame = true;
        }
    }
    
    /**
     * resumes the game.
     */
    public void resumeGame() {
        if (!myGameOver && myPausedGame) {
            myPausedGame = false;
            myTimer = newTimer();
        }
    }
    
    /**
     * for ending the game.
     */
    public void gameOver() {
        JOptionPane.showMessageDialog(this, "GAME OVER!");
        myTimer.stop();
        myGameOver = true;
        myPausedGame = true;
        myTimerActive = false;
    }
    
    /**
     * returns the board being used.
     * @return my board
     */
    public Board getMyBoard() {
        return myBoard;
    }
    
    /**
     * to check if game is over.
     * @return boolean
     */
    public boolean isMyGameOver() {
        return myGameOver;
    }
    
    /**
     * to check if game just started.
     * @return boolean
     */
    public boolean isMyJustStarted() {
        return myJustStarted;
    }
       
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);        
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);  
        if (myJustStarted) {
            repaint(); 
        } else {
            myDrawBoardSquares.paintBoard(g2d);
        }
    }
       
    @Override
    public void update(final Observable theObservable, final Object theObject) {
        
        if (theObject instanceof ArrayList<?>) {
            
            if ((((ArrayList<?>) theObject).get(0)) instanceof Block[]) {
                final List<Block[]> tempBoardData = new ArrayList<Block[]>();
                
                for (int i = 0; i < ((ArrayList<?>) theObject).size(); i++) {
                    final Block[] blockArray = (Block[]) ((ArrayList<?>) theObject).get(i);
                    tempBoardData.add(blockArray);
                }
                myBoardData = tempBoardData;                
            }
            
            if (!myJustStarted) {
                myDrawBoardSquares.setBoardData(myBoardData);
            }
            
        } else if (theObject instanceof Boolean) {
            myGameOver = (Boolean) theObject;
            gameOver();
        } else if (theObject instanceof Integer[]) {            
            myInformationDisplayPanel.updateMyScore(((Integer[])
                            theObject).length);                    
            myLevelCounter = myLevelCounter + ((Integer[]) theObject).length;
            checkMyLevelCounter();
        }
    }
    
    /**
     * checks which level you are on and changes to timer to
     * adjust for difficulty while calling another class
     * to update the display.
     */
    private void checkMyLevelCounter() {
        
        if (myLevelCounter < FIVE) {
            myInformationDisplayPanel.updateMyLevel(1);
        } else if (myLevelCounter > FOUR && myLevelCounter < TEN) {
            myInformationDisplayPanel.updateMyLevel(2);
            myTimer.setDelay(DEFAULT_TIMER - ONE_HUNDRED);
        } else if (myLevelCounter > NINE && myLevelCounter < FIFTEEN) {
            myInformationDisplayPanel.updateMyLevel(THREE);
            myTimer.setDelay(DEFAULT_TIMER - TWO_HUNDRED);
        } else if (myLevelCounter > FOURTEEN && myLevelCounter < TWENTY) {
            myInformationDisplayPanel.updateMyLevel(FOUR);
            myTimer.setDelay(DEFAULT_TIMER - THREE_HUNDRED);
        } else {
            checkMyLevelCounterHelperOne();
        }
    }

    /**
     * helper method.
     */
    private void checkMyLevelCounterHelperOne() {
        
        if (myLevelCounter > NINETEEN && myLevelCounter < TWENTY_FIVE) {
            myInformationDisplayPanel.updateMyLevel(FIVE);
            myTimer.setDelay(DEFAULT_TIMER - FOUR_HUNDRED);
        } else if (myLevelCounter > TWENTY_FOUR && myLevelCounter < THIRTY) {
            myInformationDisplayPanel.updateMyLevel(SIX);
            myTimer.setDelay(DEFAULT_TIMER - FIVE_HUNDRED);
        } else if (myLevelCounter > TWENTY_NINE && myLevelCounter < THIRTY_FIVE) {
            myInformationDisplayPanel.updateMyLevel(SEVEN);
            myTimer.setDelay(DEFAULT_TIMER - SIX_HUNDRED);
        } else {
            checkMyLevelCounterHelperTwo();
        }
    }
    
    /**
     * helper method.
     */
    private void checkMyLevelCounterHelperTwo() {
        if (myLevelCounter > THIRTY_FOUR && myLevelCounter < FOURTY) {
            myInformationDisplayPanel.updateMyLevel(EIGHT);
            myTimer.setDelay(DEFAULT_TIMER - SEVEN_HUNDRED);
        } else if (myLevelCounter > THIRTY_NINE && myLevelCounter < FOURTY_FIVE) {
            myInformationDisplayPanel.updateMyLevel(NINE);
            myTimer.setDelay(DEFAULT_TIMER - EIGHT_HUNDRED);
        } else if (myLevelCounter > FOURTY_FOUR && myLevelCounter < FIFTY) {
            myInformationDisplayPanel.updateMyLevel(TEN);
            myTimer.setDelay(DEFAULT_TIMER - NINE_HUNDRED);
        }   
    }

    @Override
    public void keyPressed(final KeyEvent theEvent) {
        final int keyCode = theEvent.getKeyCode();
        
        if (!myPausedGame && !myJustStarted) {
            if (keyCode == KeyEvent.VK_LEFT) {
                myBoard.left();
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                myBoard.right();
            } else if (keyCode == KeyEvent.VK_UP) {
                myBoard.rotateCW();
            } else if (keyCode == KeyEvent.VK_Z) {
                myBoard.rotateCCW();
            } else if (keyCode == KeyEvent.VK_DOWN) {
                myBoard.down();
            } else if (keyCode == KeyEvent.VK_SPACE) {
                myBoard.drop();
            }
        }
    }

    @Override
    public void keyReleased(final KeyEvent theEvent) {     
    }

    @Override
    public void keyTyped(final KeyEvent theEvent) {       
    }
}
