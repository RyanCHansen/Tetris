//TCSS 305 - Winter 2016
//Assignment 6 - Tetris

package starter;
import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.GUI;

/**
 * Starts the Tetris Program.
 * 
 * @author Ryan Hansen
 * @version 1.0
 */
public final class TetrisMain {

    /**
     * overrides public constructor.
     */
    private TetrisMain() {
        throw new IllegalStateException();
    }
    
    /**
     * Starts Tetris.
     * 
     * @param theArgs the arguments
     */
    public static void main(final String[] theArgs) {
        
        //Set the look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } catch (final InstantiationException e) {
            e.printStackTrace();
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        } catch (final UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        //Start the GUI
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().start();
            }
        });
    }   
}