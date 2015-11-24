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
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import sun.audio.*;

/**
 *
 * @author Luis
 */
class Arena extends Environment implements CellDataProviderIntf {

    private Grid grid;
    private Pacman pac;
//    private Pacman fred;
//    private int width = 80;
//    private int widthChange = -1;

    public Arena() {
        this.setBackground(Color.black);

        pac = new Pacman(100, 100, Color.yellow, 40, 40, 90);
        grid = new Grid(25, 30, 40, 40, new Point(5, 5), Color.yellow);
    }

    @Override
    public void initializeEnvironment() {
    }

    int counter;

    @Override
    public void timerTaskHandler() {

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
        System.out.println("Hey Dude..." + counter);
//    }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        System.out.println("Keyp Press" + e.getKeyChar());
        System.out.println("Keyp Press" + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            grid.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            grid.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            grid.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pac.setDirection(Direction.UP);
        }

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (grid != null) {
            grid.paintComponent(graphics);

        }
        if (pac != null) {
            pac.draw(graphics);
        }

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
