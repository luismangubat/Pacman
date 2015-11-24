/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;


import environment.ApplicationStarter;
import environment.Direction;
import grid.Grid;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import static javafx.scene.paint.Color.color;

/**
 *
 * @author Luis
 */
public class Pacman {

    public Pacman(int x, int y, Color color, int width, int height, int mouthWidth){
        this.x = x;
        this.y = y;
        
        this.color = color;
        this.width = width;
        this.height = height;
        this.mouthWidth = mouthWidth;
    }
    
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(235, 240, 0));
        
        //TODO - respect the direction
        graphics.fillArc(x, y, width, height, mouthWidth / 2, 360 - (mouthWidth));    
    }

//<editor-fold defaultstate="collapsed" desc="Properties">
    private int x;
    private int y;
    private Color color;
    
    private int width;
    private int height;
    private int mouthWidth;
    
    private Direction direction = Direction.LEFT;
    private ArrayList<Point>body;
    private Grid grid;
    private Color bodyColor = Color.MAGENTA;
    

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * @param bodyColor the bodyColor to set
     */
    public void setBodyColor(Color bodyColor) {
        this.bodyColor = bodyColor;
    }

    void setMouthWidth(int width) {

    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the mouthWidth
     */
    public int getMouthWidth() {
        return mouthWidth;
    }
//</editor-fold>
}
