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
    private final int mouthMaxWidth;

    public Pacman(int x, int y, Color color, int width, int height){
        this.x = x;
        this.y = y;
        
        this.color = color;
        this.width = width;
        this.height = height;

        mouthWidth = 0;
        mouthMaxWidth = 90;
        mouthChangeRate = 8;
        mouthOpening = true;
    }
    
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(235, 240, 0));
        
        //TODO - respect the direction
        graphics.fillArc(x, y, width, height, mouthWidth / 2, 360 - (mouthWidth));    
    }
    
    
    public void move(){
        if (direction == Direction.LEFT) {
            x -= getSpeed();
        } else if (direction == Direction.RIGHT) {
            x += getSpeed();
        } else if (direction == Direction.UP) {
            y -= getSpeed();
        } else if (direction == Direction.DOWN) {
            y += getSpeed();
        }
        
        changeMouthWidth();
    }
    
    public void changeMouthWidth(){
        if (mouthOpening && (mouthWidth >= mouthMaxWidth)) {
            mouthOpening = false;
        } else if (!mouthOpening && (mouthWidth <= 0)) {
            mouthOpening = true;
        }
        
        if (mouthOpening) {
            mouthWidth += mouthChangeRate;
        } else {
            mouthWidth -= mouthChangeRate;
        }
    }
    

//<editor-fold defaultstate="collapsed" desc="Properties">
    private int x;
    private int y;
    private int speed = 4;
    private Color color;
    
    private int width;
    private int height;
    
    private int mouthWidth;
    private int mouthChangeRate;
    private boolean mouthOpening;
    
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

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
//</editor-fold>
}
