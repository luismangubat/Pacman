/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import images.Animator;
import images.ImageManager;
import images.ResourceTools;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Luis
 */
public class SpriteManager implements AnimatedImageProvidetIntf {

    //<editor-fold defaultstate="collapsed" desc="Static Identfiers">
    public static final String ORANGE_FREDDY_STAND_01 = "ORANGE_FREDDY_STAND";
    public static final String ORANGE_FREDDY_LEFT_01 = "ORANGE_FREDDY_WALK__LEFT_01";
    public static final String ORANGE_FREDDY_LEFT_02 = "ORANGE_FREDDY_WALK__LEFT_02";
    public static final String ORANGE_FREDDY_LEFT_03 = "ORANGE_FREDDY_WALK__LEFT_03";
    
    public static final String ORANGE_FREDDY_RIGHT_01 = "ORANGE_FREDDY_WALK__RIGHT_01";
    public static final String ORANGE_FREDDY_RIGHT_02 = "ORANGE_FREDDY_WALK__RIGHT_02";
    public static final String ORANGE_FREDDY_RIGHT_03 = "ORANGE_FREDDY_WALK__RIGHT_03";
    
    
   
    public static final String ORANGE_FREDDY_UP_01 = "ORANGE_FREDDY_WALK__UP_01";
    public static final String ORANGE_FREDDY_UP_02 = "ORANGE_FREDDY_WALK__UP_02";
    public static final String ORANGE_FREDDY_UP_03 = "ORANGE_FREDDY_WALK__UP_03";
    
    
    public static final String ORANGE_FREDDY_DOWN_01 = "ORANGE_FREDDY_WALK__DOWN_01";
    public static final String ORANGE_FREDDY_DOWN_02 = "ORANGE_FREDDY_WALK__DOWN_02";
    public static final String ORANGE_FREDDY_DOWN_03 = "ORANGE_FREDDY_WALK__DOWN_03";
    
    
    
    public static final String BLUE_BONNIE_STAND_01 = "BLUE_BONNIE_STAND";
    public static final String BLUE_BONNIE_LEFT_01 = "BLUE_BONNIE_WALK__LEFT";
    public static final String BLUE_BONNIE_LEFT_02 = "BLUE_BONNIE_WALK__LEFT";
    public static final String BLUE_BONNIE_LEFT_03 = "BLUE_BONNIE_WALK__LEFT";
    
    
    
  
    
    
    
    public static ArrayList<String> ORANGE_FREDDY_STAND;
    public static ArrayList<String> ORANGE_FREDDY_WALK_LEFT;
    public static ArrayList<String> ORANGE_FREDDY_WALK_RIGHT;
    public static ArrayList<String> ORANGE_FREDDY_WALK_UP;
    public static ArrayList<String> ORANGE_FREDDY_WALK_DOWN;
    
    public static ArrayList<String> BLUE_BONNIE_STAND;
    public static ArrayList<String> BLUE_BONNIE_LEFT;
    public static ArrayList<String> BLUE_BONNIE_RIGHT;
    public static ArrayList<String> BLUE_BONNIE_UP;
    public static ArrayList<String> BLUE_BONNIE_DOWN;
    
    
    
    
    public static final String ORANGE_FREDDY_ANIMATOR = "ORANGE_FREDDY_ANIMATOR";
    public static final String YELLOW_BONNIE_ANIMATOR = "YELLOW_BONNIE_ANIMATOR";
    public static final String BLUE_BONNIE_ANIMATOR = "BLUE_BONNIE_ANIMATOR";
    
//</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private ImageManager imageManager;
    private HashMap<String, Animator> animators;
    
    
    
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructer">
    {
    
        
        
        
        ORANGE_FREDDY_STAND = new ArrayList<>();
        ORANGE_FREDDY_STAND.add(ORANGE_FREDDY_STAND_01);
        
        
        ORANGE_FREDDY_WALK_LEFT = new ArrayList<>();
        ORANGE_FREDDY_WALK_LEFT.add(ORANGE_FREDDY_LEFT_02);
        ORANGE_FREDDY_WALK_LEFT.add(ORANGE_FREDDY_LEFT_03);
        ORANGE_FREDDY_WALK_LEFT.add(ORANGE_FREDDY_LEFT_02);
        ORANGE_FREDDY_WALK_LEFT.add(ORANGE_FREDDY_LEFT_01);
        
        ORANGE_FREDDY_WALK_RIGHT = new ArrayList<>();
        ORANGE_FREDDY_WALK_RIGHT.add(ORANGE_FREDDY_RIGHT_02);
        ORANGE_FREDDY_WALK_RIGHT.add(ORANGE_FREDDY_RIGHT_03);
        ORANGE_FREDDY_WALK_RIGHT.add(ORANGE_FREDDY_RIGHT_02);
        ORANGE_FREDDY_WALK_RIGHT.add(ORANGE_FREDDY_RIGHT_01);
        
        
        ORANGE_FREDDY_WALK_UP = new ArrayList<>();
        ORANGE_FREDDY_WALK_UP.add(ORANGE_FREDDY_UP_01);
        ORANGE_FREDDY_WALK_UP.add(ORANGE_FREDDY_UP_02);
        ORANGE_FREDDY_WALK_UP.add(ORANGE_FREDDY_UP_03);
        ORANGE_FREDDY_WALK_UP.add(ORANGE_FREDDY_UP_02);
        ORANGE_FREDDY_WALK_UP.add(ORANGE_FREDDY_UP_01);
        
        
        ORANGE_FREDDY_WALK_DOWN = new ArrayList<>();
        ORANGE_FREDDY_WALK_DOWN.add(ORANGE_FREDDY_DOWN_01);
        ORANGE_FREDDY_WALK_DOWN.add(ORANGE_FREDDY_DOWN_02);
        ORANGE_FREDDY_WALK_DOWN.add(ORANGE_FREDDY_DOWN_03);
        ORANGE_FREDDY_WALK_DOWN.add(ORANGE_FREDDY_DOWN_02);
        ORANGE_FREDDY_WALK_DOWN.add(ORANGE_FREDDY_DOWN_01);
        
        
        
        
        
        
        
        
        
        BLUE_BONNIE_STAND = new ArrayList<>();
        BLUE_BONNIE_STAND.add(BLUE_BONNIE_STAND_01);
        
        
        BLUE_BONNIE_LEFT = new ArrayList<>();
        BLUE_BONNIE_LEFT.add(BLUE_BONNIE_LEFT_01);
        BLUE_BONNIE_LEFT.add(BLUE_BONNIE_LEFT_02);
        BLUE_BONNIE_LEFT.add(BLUE_BONNIE_LEFT_03);
        BLUE_BONNIE_LEFT.add(BLUE_BONNIE_LEFT_02);
        BLUE_BONNIE_LEFT.add(BLUE_BONNIE_LEFT_01);
        
        
        
        

        BufferedImage freddySprites = (BufferedImage) ResourceTools.loadImageFromResource("pacman/freddy_sprites.png");
        imageManager = new ImageManager();
        //<editor-fold defaultstate="collapsed" desc="ORANGE_FREDDY">
        imageManager.addImage(ORANGE_FREDDY_STAND_01, freddySprites.getSubimage(31, 0, 30, 32));
        
        imageManager.addImage(ORANGE_FREDDY_LEFT_01, freddySprites.getSubimage(0, 33, 26, 32));
        imageManager.addImage(ORANGE_FREDDY_LEFT_02, freddySprites.getSubimage(31, 33, 30, 32));
        imageManager.addImage(ORANGE_FREDDY_LEFT_03, freddySprites.getSubimage(61, 33, 30, 32));
        
        imageManager.addImage(ORANGE_FREDDY_RIGHT_01, freddySprites.getSubimage(0, 65, 26, 32));
        imageManager.addImage(ORANGE_FREDDY_RIGHT_02, freddySprites.getSubimage(31, 65, 30, 32));
        imageManager.addImage(ORANGE_FREDDY_RIGHT_03, freddySprites.getSubimage(61, 65, 30, 32));
        
        
        imageManager.addImage(ORANGE_FREDDY_UP_01, freddySprites.getSubimage(0, 98, 26, 31));
        imageManager.addImage(ORANGE_FREDDY_UP_02, freddySprites.getSubimage(32, 98, 30, 31));
        imageManager.addImage(ORANGE_FREDDY_UP_03, freddySprites.getSubimage(62, 98, 30, 31));
        
        
        
        imageManager.addImage(ORANGE_FREDDY_DOWN_01, freddySprites.getSubimage(0, 0, 26, 31));
        imageManager.addImage(ORANGE_FREDDY_DOWN_02, freddySprites.getSubimage(32, 0, 30, 31));
        imageManager.addImage(ORANGE_FREDDY_DOWN_03, freddySprites.getSubimage(62, 0, 30, 31));
//</editor-fold>
        
        imageManager.addImage(BLUE_BONNIE_STAND_01, freddySprites.getSubimage(90, 0, 30, 32));
        
        
        
        
        
        // create = new HashMap<>();
        animators =  new HashMap<>();
        animators.put(ORANGE_FREDDY_ANIMATOR, new Animator(imageManager, ORANGE_FREDDY_STAND, 100));
       
    }
//<editor-fold defaultstate="collapsed" desc="AnimatedImageProviderIntf">
    public BufferedImage getAnimatedImage(String animatorName){
        return (BufferedImage) animators.get(animatorName).getCurrentImage();
        
    }
    public void setAnimatorImageName(String animatorName, ArrayList<String> ImageNames){
        animators.get(animatorName).setImageNames(ImageNames);
    }
    
//</editor-fold>
}
