/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import environment.Direction;
import environment.Environment;
import grid.Grid;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import audio.Playlist;
import audio.SoundManager;
import audio.Source;
import audio.Track;
import images.Animator;
import images.ImageManager;
import images.ResourceTools;
import java.awt.Graphics2D;
import static java.awt.PageAttributes.PrintQualityType.HIGH;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import sun.audio.*;

/**
 *
 * @author Luis
 */
class Arena extends Environment implements CellDataProviderIntf {

    private Grid grid;
    private Pacman pac;
    private ArrayList<Barrier> barriers;
    private ArrayList<Item> items;
    
    
    public static final int DEFAULT_WINDOW_WIDTH = 900;
    public static final int DEFAULT_WINDOW_HEIGHT = 578;
    
    

    public Arena() {
        this.setBackground(Color.black);

        pac = new Pacman(100, 100, Color.yellow, 20, 20);
        grid = new Grid(100, 200, 15, 15, new Point(5, 5), Color.black);

        barriers = new ArrayList<>();
//        barriers.add(new Barrier(10, 4, Color.GREEN, false, this));
//        barriers.add(new Barrier(11, 4, Color.GREEN, false, this));
//        barriers.add(new Barrier(12, 4, Color.GREEN, false, this));
        items = new ArrayList<>();
//        items.add(new Item(10, 5,"POWER UP", ResourceTools.loadImageFromResource"arena/pacman", this));

// x , y ,endx, endy
        createBarrierRange(0, 10, 6, 10);
        createBarrierRange(0, 0, 0, 10);
        createBarrierRange(0, 14, 6, 14);
        createBarrierRange(6, 10, 6, 13);

        createBarrierRange(0, 17, 6, 17);
        createBarrierRange(6, 17, 6, 20);
        createBarrierRange(0, 21, 6, 21);
        createBarrierRange(0, 21, 0, 32);
        // Bottom Edge Barrier
        createBarrierRange(0, 33, 40, 33);
        // Upper Edge Barrier
        createBarrierRange(0, 0, 40, 0);
        // Right Upper Edge Barrier
        createBarrierRange(40, 0, 40, 10);
        // Right Bottom Edge Barrier 
        createBarrierRange(40, 21, 40, 32);
//       Middle Bottom Edge Barrier
        createBarrierRange(34, 17, 40, 17);
        // Middle Upper Edge Barrier 
        createBarrierRange(34, 14, 40, 14);
        // Middle Upright Edge Barrier
        createBarrierRange(34, 10, 34, 14);
        // Middle LowerRight Edge Barrier 
        createBarrierRange(34, 17, 34, 21);
        // Middle Middle Upper Edge  Barrer
        createBarrierRange(35, 10, 40, 10);
        // Middle Middle Bottom Edge Barrier 
        createBarrierRange(35, 21, 40, 21);
        // Midle Vertical Upper Barrier 
        createBarrierRange(34, 3, 36, 4);
        // Middle Vertical Left Upper Barrier 
        createBarrierRange(4, 3, 6, 4);
        // Middle Bottom Left Barrer
        createBarrierRange(4, 7, 6, 7);

        createBarrierRange(34, 7, 36, 7);

        createBarrierRange(24, 3, 30, 4);

        createBarrierRange(10, 3, 16, 4);

        createBarrierRange(20, 1, 20, 4);

        createBarrierRange(14, 7, 26, 7);

        createBarrierRange(10, 7, 10, 14);

        createBarrierRange(30, 7, 30, 14);

        createBarrierRange(30, 7, 30, 14);

        createBarrierRange(20, 7, 20, 11);

        createBarrierRange(11, 10, 16, 10);

        createBarrierRange(24, 10, 30, 10);

        createBarrierRange(10, 17, 10, 21);

        createBarrierRange(30, 17, 30, 21);

        createBarrierRange(17, 17, 23, 17);
        
        createBarrierRange(17, 14, 17, 17);
        
        createBarrierRange(17, 14, 18, 14);
        
        createBarrierRange(22, 14, 23, 14);
        
        createBarrierRange(23, 14, 23, 16);
        
        createBarrierRange(20, 21, 20, 24); //middle
        
        createBarrierRange(14, 21, 26, 21);
        
        createBarrierRange(3, 24, 6, 24);
        
        createBarrierRange(6, 24, 6, 27);
        
        createBarrierRange(1, 27, 3, 27);
        
        createBarrierRange(4, 30, 16, 30);
        
//        createBarrierRange(14, 13, 14, 17);
        
         createBarrierRange(10, 27, 10, 30);
         
         createBarrierRange(10, 24, 16, 24);
       
         createBarrierRange(20, 27, 20, 30);
         
         createBarrierRange(14, 27, 26, 27);
        
         createBarrierRange(24, 30, 36, 30);
        
         createBarrierRange(30, 27, 30, 30);
      
         createBarrierRange(24, 24, 30, 24);
         
         createBarrierRange(34, 24, 36, 24);
        
         createBarrierRange(34, 24, 34, 27);
         
         createBarrierRange(37, 27, 39, 27);
        
        
         
    }

    private void createBarrierRange(int startX, int startY, int endX, int endY) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                barriers.add(new Barrier(x, y, Color.BLUE, true, this));
            }
        }
    }

    @Override
    public void initializeEnvironment() {
    }
    int moveDelay = 0;
    int moveDelayLimit = 0;
    int counter;

    @Override
    public void timerTaskHandler() {
        if (pac != null) {
            // if could to limit, then  move snake and reset counter,
            // else keep counting
            if (moveDelay >= moveDelayLimit) {
                moveDelay = 0;
                pac.move();
            } else {
                // else keep counting counting
            }
            checkIntersections();
        }
    }

    public void checkIntersections() {
        for (Barrier barrier : barriers) {
            if (barrier.getHitBox().intersects(pac.getHitBox())) {
                //if the barrier is to the LEFT of the pacman, move the pac man 
                // the the RIGHT, and stop him moving left
//                if (barrier.getSystemCoordX() < pac.getX()) {
                if (pac.getDirection() == Direction.LEFT) {
                    //we must have a barrier on out LEFT!!!
                    //  - push the pacman back to the right, so there is NO LONGER and intersection
                    pac.setX(barrier.getSystemCoordX() + barrier.getWidth());

                } else if (pac.getDirection() == Direction.RIGHT) {
                    //we must have a barrier on out RIGHT!!!
                    //  - push the pacman back to the right, so there is NO LONGER and intersection
                    pac.setX(barrier.getSystemCoordX() - pac.getWidth());

                } else if (pac.getDirection() == Direction.UP) {
                    //we must have a barrier on out DOWN!!!
                    //  - push the pacman back to the right, so there is NO LONGER and intersection
                    pac.setY(barrier.getSystemCoordY() + barrier.getWidth());

                } else if (pac.getDirection() == Direction.DOWN) {
                    pac.setY(barrier.getSystemCoordY() - pac.getHeight());
                }
                
                pac.setDirection(Direction.STOP);

//stop the pac
//                pac.setSpeed(FROZEN);
//                System.out.println("CRASH!!!!");
                //kill the pac
                //play a sound
            }
        }
//        if (barriers.contains(pac.getPosition())) {
//            pac.addHealth(-1000000);
//        }
    }

//        if (pac != null) {
//            if (width <= 0) {
//                widthChange = +8;
//            } else if (width >= 80) {
//                widthChange = -8;
//            }
//            width = width + widthChange;
//            pac.setMouthWidth(width);
//        }
//
//        if (fred != null) {
//            width = width + widthChange;
//            fred.setMouthWidth(width);
//        }
//        if (pac != null) {
//            if (pacX >= 160) {
//                pacX = pacX + 3;
//            } else {
//                pacX = 900;
//            }
//            pac.setX(pacX);
    @Override
    public void keyPressedHandler(KeyEvent e) {
//        System.out.println("Keyp Press" + e.getKeyChar());
//        System.out.println("Keyp Press" + e.getKeyCode());

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pac.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pac.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pac.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pac.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_1) {
            pac.setSpeed(FROZEN);
            pac.setColor(Color.yellow);
        } else if (e.getKeyCode() == KeyEvent.VK_2) {
            pac.setSpeed(SLOW);
            pac.setColor(Color.yellow);
        } else if (e.getKeyCode() == KeyEvent.VK_3) {
            pac.setSpeed(MEDIUM);
        } else if (e.getKeyCode() == KeyEvent.VK_4) {
            pac.setSpeed(FAST);
            pac.setColor(Color.red);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            audio.AudioPlayer.play("/pacman/Bleat.wav");

        }
    }

    final int FAST = 8;
    final int MEDIUM = 4;
    final int SLOW = 2;
    final int FROZEN = 0;

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics g) {
        
//        System.out.println(Main.getWindowSize());
        
        AffineTransform atWindow;
        Graphics2D graphics = (Graphics2D) g;
        atWindow = AffineTransform.getScaleInstance((double) Main.getWindowSize().width / DEFAULT_WINDOW_WIDTH, (double) Main.getWindowSize().height / DEFAULT_WINDOW_HEIGHT);
        if (atWindow != null) graphics.setTransform(atWindow);
        
 
        if (grid != null) {
            grid.paintComponent(graphics);

        }
        if (pac != null) {
            pac.draw(graphics);
        }
        if (barriers != null) {
            for (int i = 0; i < barriers.size(); i++) {
                barriers.get(i).draw(graphics);

            }

        }
        if (items != null) {
            for (int i = 0; i < items.size(); i++) {
                items.get(i).draw(graphics);

            }
        }

//        if (myBarriers != null) {
//            myBarriers.draw(graphics);
//        }
    }

//<editor-fold defaultstate="collapsed" desc="CellDataProviderIntf">
    @Override
    public int getCellWidth() {
        return grid.getCellWidth();
    }

    @Override
    public int getCellHeight() {
        return grid.getCellHeight();
    }

    @Override
    public int getSystemCoordX(int x, int y) {
        return grid.getCellSystemCoordinate(x, y).x;
    }

    @Override
    public int getSystemCoordY(int x, int y) {
        return grid.getCellSystemCoordinate(x, y).y;
    }
//</editor-fold>
}
