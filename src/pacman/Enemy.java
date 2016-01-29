/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import environment.Direction;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class Enemy {
    public void draw(Graphics graphics) {
        graphics.drawImage(getImage(), x, y, width, height, null);
        
    }
    {
        x = 700;  // 100
        y = 100;  // 100
        width = 30;
        height = 32;
        
    }
    public Enemy (String type, AnimatedImageProvidetIntf imageProvider) {
        this.imageProvider = imageProvider;
        if (type.equals(ENEMY_TYPE_ORANGE_FREDDY)) {
            animatorName = SpriteManager.ORANGE_FREDDY_ANIMATOR;
        
            STAND = SpriteManager.ORANGE_FREDDY_STAND;
            WALK_LEFT = SpriteManager.ORANGE_FREDDY_WALK_LEFT;
            WALK_RIGHT = SpriteManager.ORANGE_FREDDY_WALK_RIGHT;
            WALK_UP = SpriteManager.ORANGE_FREDDY_WALK_UP;
            WALK_DOWN = SpriteManager.ORANGE_FREDDY_WALK_DOWN;
            
        } else if (type.equals(ENEMY_TYPE_BLUE_BONNIE)) {
            animatorName = SpriteManager.BLUE_BONNIE_ANIMATOR;
        }
    
        
        
    }
    public static final String ENEMY_TYPE_ORANGE_FREDDY = "ORANGE_FREDDY";
    public static final String ENEMY_TYPE_YELLOW_FREDDY = "YELLOW_FREDDY";
    public static final String ENEMY_TYPE_BLUE_BONNIE = "BLUE_BONNIE";
//    public static final String ENEMY_TYPE_ORANGE_FREDDY = "ORANGE_FREDDY";
            
    private int x, y, width, height;
    private ArrayList<String> STAND, WALK_LEFT, WALK_RIGHT, WALK_UP, WALK_DOWN;
    private String animatorName;
    private Direction direction;
    private AnimatedImageProvidetIntf imageProvider;
    
    public BufferedImage getImage(){
        return imageProvider.getAnimatedImage(animatorName);
        
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
        
        switch (direction){
            case LEFT:
                imageProvider.setAnimatorImageName(animatorName, this.WALK_LEFT);
                break;
                
        
            case RIGHT:
                imageProvider.setAnimatorImageName(animatorName, this.WALK_RIGHT);
                break;
                
            case UP:
                 imageProvider.setAnimatorImageName(animatorName, this.WALK_UP);
                break;
                
            case DOWN:
                 imageProvider.setAnimatorImageName(animatorName, this.WALK_DOWN);
                break;
                
                
                
//            default:
//            case DOWN:
//                imageProvider.setAnimatorImageName(animatorName, this.STAND);
//                break;
                
           
                
        
        }
    }
    
}
