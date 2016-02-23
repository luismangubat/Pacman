/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import images.ResourceTools;
import java.awt.Graphics;

/**
 *
 * @author Luis
 */
public class Image { 
        public void draw(Graphics graphics) {
        graphics.drawImage(image,
                cellData.getSystemCoordX(x, y),
                cellData.getSystemCoordY(x, y),
                cellData.getCellWidth(),
                cellData.getCellHeight(), null);

    }


    public Image (int x, int y, String type, java.awt.Image image, CellDataProviderIntf cellData) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.image = image;
        this.cellData = cellData;
  if (type.equals(SCARY_PIC)) {
      image = ResourceTools.loadImageFromFile("/pacman/scary.jpg");
  }
    } 
    
    public static final String SCARY_PIC = "SCARY";
    
    
    
    
            

    private int x, y;
    private String type;
    private java.awt.Image image;
    private CellDataProviderIntf cellData;
    
    /**
     * @return the x
     */
//<editor-fold defaultstate="collapsed" desc="Properties">
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the image
     */
    public java.awt.Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(java.awt.Image image) {
        this.image = image;
    }

}
//</editor-fold>
