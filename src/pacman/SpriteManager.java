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
public class SpriteManager {

    public static final String ORANGE_FREDDY_STAND_01 = "ORANGE_FREDDY_STAND";
    public static final String ORANGE_FREDDY_LEFT_01 = "ORANGE_FREDDY_WALK__LEFT_01";
    public static final String ORANGE_FREDDY_LEFT_02 = "ORANGE_FREDDY_WALK__LEFT_02";
    public static final String ORANGE_FREDDY_LEFT_03 = "ORANGE_FREDDY_WALK__LEFT_03";

    public static final String ORANGE_FREDDY_RIGHT_01 = "ORANGE_FREDDY_WALK__RIGHT_01";
    public static final String ORANGE_FREDDY_RIGHT_02 = "ORANGE_FREDDY_WALK__RIGHT_02";
    public static final String ORANGE_FREDDY_RIGHT_03 = "ORANGE_FREDDY_WALK__RIGHT_03";

    public static ArrayList<String> ORANGE_FREDDY_STAND;
    public static ArrayList<String> ORANGE_FREDDY_WALK_LEFT;
    public static ArrayList<String> ORANGE_FREDDY_WALK_RIGHT;

    public static final String ORANGE_FREDDY_ANIMATOR = "ORANGE_FREDDY_ANIMATOR";
    public static final String YELLOW_FREDDY_ANIMATOR = "YELLOW_FREDDY_ANIMATOR";
    public static final String BLUE_FREDDY_ANIMATOR = "BLUE_FREDDY_ANIMATOR";
    
    
    
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
        

        BufferedImage freddySprites = (BufferedImage) ResourceTools.loadImageFromResource("Arena/freddy_sprites.png");
        imageManager = new ImageManager();
        imageManager.addImage(ORANGE_FREDDY_STAND_01, freddySprites.getSubimage(31, 0, 30, 32));
        
        imageManager.addImage(ORANGE_FREDDY_LEFT_01, freddySprites.getSubimage(0, 33, 26, 32));
        imageManager.addImage(ORANGE_FREDDY_LEFT_02, freddySprites.getSubimage(31, 33, 30, 32));
        imageManager.addImage(ORANGE_FREDDY_LEFT_03, freddySprites.getSubimage(61, 33, 30, 32));
        
        imageManager.addImage(ORANGE_FREDDY_RIGHT_01, freddySprites.getSubimage(0, 65, 26, 32));
        imageManager.addImage(ORANGE_FREDDY_RIGHT_02, freddySprites.getSubimage(31, 65, 30, 32));
        imageManager.addImage(ORANGE_FREDDY_RIGHT_03, freddySprites.getSubimage(61, 65, 30, 32));
        
        // create = new HashMap<>();
        animators =  new HashMap<>();
        animators.put(ORANGE_FREDDY_ANIMATOR, new Animator(imageManager, ORANGE_FREDDY_STAND, 100));
       
    }
public BufferedImage getAnimatedImage(String animatorName){
    return (BufferedImage) animators.get(animatorName).getCurrentImage();
    
}
public void setAnimatorImageName(String animatorName, ArrayList<String> ImageNames){
    animators.get(animatorName).setImageNames(ImageNames);
}


}
