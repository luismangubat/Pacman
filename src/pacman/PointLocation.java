/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Luis
 */
public class PointLocation {

    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fill3DRect(cellData.getSystemCoordX(x, y), cellData.getSystemCoordY(x, y), cellData.getCellWidth(), cellData.getCellHeight(), true);
        
        //temp for debug
        graphics.setColor(Color.RED);
        graphics.drawRect(getHitBox().x, getHitBox().y, getHitBox().width, getHitBox().height);
    }

    public PointLocation (int x, int y, Color color, boolean breakable, CellDataProviderIntf cellData) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.breakable = breakable;
        this.cellData = cellData;
    }
    
    public Rectangle getHitBox(){
        return new Rectangle(cellData.getSystemCoordX(x, y), cellData.getSystemCoordY(x, y), cellData.getCellWidth(), cellData.getCellHeight());
    }

//<editor-fold defaultstate="collapsed" desc="Properties">
    private int x, y;
    private Color color;
    private boolean breakable = false;
    private CellDataProviderIntf cellData;
    
    public Point getLocation(){
        return new Point (x, y);
    }

    public int getWidth(){
        return cellData.getCellWidth();
    }
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the x
     */
    public int getSystemCoordY() {
        return cellData.getSystemCoordY(x, y);
    }

    /**
     * @return the x
     */
    public int getSystemCoordX() {
        return cellData.getSystemCoordX(x, y);
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
     * @return the Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param Color the Color to set
     */
    public void setColor(Color Color) {
        this.color = Color;
    }

    /**
     * @return the breakable
     */
    public boolean isBreakable() {
        return breakable;
    }

    /**
     * @param breakable the breakable to set
     */
    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }

    /**
     * @return the cellData
     */
    public CellDataProviderIntf getCellData() {
        return cellData;
    }

    /**
     * @param cellData the cellData to set
     */
    public void setCellData(CellDataProviderIntf cellData) {
        this.cellData = cellData;
    }
//</editor-fold>

    int getHeight() {
        return cellData.getCellHeight();    
    }
}
