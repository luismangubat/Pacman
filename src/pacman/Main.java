/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import environment.ApplicationStarter;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Luis
 */
public class Main {
    public static JFrame frame;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frame = ApplicationStarter.run("Luis The Man Pacman", new Arena());
    }
    
    public static Dimension getWindowSize() {
        if (frame != null) return frame.getContentPane().getSize();
        else return new Dimension(Arena.DEFAULT_WINDOW_WIDTH, Arena.DEFAULT_WINDOW_HEIGHT);
        
    }
}
