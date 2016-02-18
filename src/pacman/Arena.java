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
    private ArrayList<Orb> orbs;
    private Enemy orangeFreddy;
    private SpriteManager spriteManager;
    private Enemy blueBonnie;
    private Enemy yellowChica;
    private Enemy redFoxy;
    private GameState state;
    private AudioManager am;
    private int score;
    
    public static final int DEFAULT_WINDOW_WIDTH = 900;
    public static final int DEFAULT_WINDOW_HEIGHT = 578;

    private static final int orbDiameter = 10;

    
    private ArrayList<Orb> getCopyOfOrbs(){
        ArrayList<Orb> copy = new ArrayList<>();
        for(Orb orb : orbs){
            copy.add(orb);
        }
        return copy;
    }
    
    
    public Arena() {
        this.setBackground(Color.black);

        pac = new Pacman(50, 235, Color.yellow, 25, 25);
        grid = new Grid(100, 200, 15, 15, new Point(5, 5), Color.black);

        barriers = new ArrayList<>();
//        barriers.add(new Barrier(10, 4, Color.GREEN, false, this));
//        barriers.add(new Barrier(11, 4, Color.GREEN, false, this));
//        barriers.add(new Barrier(12, 4, Color.GREEN, false, this));
        items = new ArrayList<>();

        orbs = new ArrayList<>();

        spriteManager = new SpriteManager();
        orangeFreddy = new Enemy(Enemy.ENEMY_TYPE_ORANGE_FREDDY, new Point(323, 232), spriteManager);
        blueBonnie = new Enemy(Enemy.ENEMY_TYPE_BLUE_BONNIE, new Point(298, 232), spriteManager);
        yellowChica = new Enemy(Enemy.ENEMY_TYPE_YELLOW_CHICA, new Point(273, 232), spriteManager);
        am = new AudioManager();
//        am.playAudio(AudioManager.BGMUSIC, true);

        setState(GameState.RUN);

//<editor-fold defaultstate="collapsed" desc="Orbs">
        orbs.add(new Orb(30, 30, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(30, 51, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(30, 72, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(30, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(30, 114, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(30, 135, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(51, 30, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(72, 30, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(93, 30, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(114, 30, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 30, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(156, 30, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(177, 30, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(198, 30, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(219, 30, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(240, 30, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(261, 30, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(282, 30, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(282, 51, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(282, 72, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(282, 93, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(51, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(72, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(93, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(114, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(156, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(177, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(198, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(219, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(240, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(261, 93, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(307, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(328, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(349, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(370, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(391, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(412, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(433, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(456, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(496, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(517, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(540, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(563, 93, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(584, 93, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(584, 30, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(584, 51, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(584, 72, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(328, 31, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(328, 51, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(328, 72, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(328, 31, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(349, 31, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(370, 31, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(391, 31, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(412, 31, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(433, 31, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(456, 31, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 31, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(496, 31, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(517, 31, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(540, 31, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(563, 31, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(478, 31, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 52, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 73, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(478, 94, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 113, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 134, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 155, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 176, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 197, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 218, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 239, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 260, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 281, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 302, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 325, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 367, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 412, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 434, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(157, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(180, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(203, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(226, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(247, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(268, 389, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(288, 368, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(288, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(310, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(331, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(352, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(373, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(394, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(415, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(436, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(457, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(478, 389, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(436, 410, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(436, 431, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(415, 431, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(394, 431, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(373, 431, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(352, 431, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(329, 431, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(329, 452, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(180, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(180, 412, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(180, 434, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(201, 434, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(222, 434, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(243, 434, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(264, 434, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(285, 434, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(285, 455, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(499, 434, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(520, 434, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(562, 434, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(583, 434, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(583, 455, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(583, 476, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(478, 134, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(499, 134, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(520, 134, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(541, 134, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(562, 134, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(583, 134, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(583, 113, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(478, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(496, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(517, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(540, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(563, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(584, 346, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(584, 367, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(584, 389, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(584, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(563, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(540, 389, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(540, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(540, 412, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(540, 434, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(51, 135, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(72, 135, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(93, 135, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(114, 135, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 135, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(135, 156, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 176, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 197, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 218, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 239, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 260, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 281, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 302, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 325, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 367, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 389, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 412, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 434, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(135, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(114, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(93, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(72, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(51, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(30, 346, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(30, 367, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(30, 388, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(51, 388, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(72, 388, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(72, 409, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(135, 434, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(114, 434, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(93, 434, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(72, 434, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(51, 434, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(30, 434, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(30, 455, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(30, 476, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(51, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(72, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(93, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(114, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(156, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(177, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(198, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(219, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(240, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(262, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(284, 476, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(305, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(328, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(349, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(370, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(391, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(412, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(433, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(454, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(475, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(496, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(517, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(538, 476, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(559, 476, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(135, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(158, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(179, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(200, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(221, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(242, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(264, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(287, 346, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(331, 346, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(331, 367, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(351, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(371, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(391, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(412, 346, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(433, 346, orbDiameter, Color.ORANGE));

        orbs.add(new Orb(135, 114, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 51, orbDiameter, Color.ORANGE));
        orbs.add(new Orb(135, 72, orbDiameter, Color.ORANGE));

//</editor-fold>
//        items.add(new Item(10, 5,"POWER UP", ResourceTools.loadImageFromResource"arena/pacman", this));
//<editor-fold defaultstate="collapsed" desc="Barriers">
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

        createBarrierRange(30, 7, 30, 24);

        createBarrierRange(20, 7, 20, 11);

        createBarrierRange(11, 10, 16, 10);

        createBarrierRange(24, 10, 30, 10);

        createBarrierRange(10, 17, 10, 21);

        createBarrierRange(30, 17, 30, 21);

        createBarrierRange(17, 17, 23, 17);

        createBarrierRange(17, 14, 17, 17);

        createBarrierRange(17, 14, 17, 14);

        createBarrierRange(23, 14, 23, 14);

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

        createBarrierRange(7, 3, 7, 4);

        createBarrierRange(7, 7, 7, 7);

        createBarrierRange(7, 10, 7, 14);

        createBarrierRange(7, 17, 7, 21);

        createBarrierRange(7, 24, 7, 27);

        createBarrierRange(3, 24, 3, 24);
        createBarrierRange(3, 3, 3, 4);
        createBarrierRange(3, 7, 3, 7);
        createBarrierRange(3, 30, 3, 30);
        createBarrierRange(13, 21, 13, 21);
        createBarrierRange(13, 7, 13, 7);

        createBarrierRange(13, 27, 13, 27);

        createBarrierRange(17, 3, 17, 4);
        createBarrierRange(17, 10, 17, 10);
        createBarrierRange(17, 24, 17, 24);
        createBarrierRange(17, 30, 17, 30);
        createBarrierRange(23, 30, 23, 30);
        createBarrierRange(23, 24, 23, 24);
        createBarrierRange(23, 10, 23, 10);

        createBarrierRange(23, 3, 23, 4);

        createBarrierRange(33, 3, 33, 4);
        createBarrierRange(33, 7, 33, 7);
        createBarrierRange(33, 10, 33, 14);
        createBarrierRange(33, 17, 33, 21);
        createBarrierRange(33, 24, 33, 27);
        createBarrierRange(27, 7, 27, 7);
        createBarrierRange(27, 27, 27, 27);
        createBarrierRange(37, 7, 37, 7);
        createBarrierRange(37, 3, 37, 4);
        createBarrierRange(37, 24, 37, 24);
        createBarrierRange(37, 30, 37, 30);

//</editor-fold>
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
    final int MOVE_DELAY_FAST = 1;
    final int MOVE_DELAY_MEDIUM = 3;
    final int MOVE_DELAY_SLOW = 5;

    int pacMoveDelay = 0;
    int pacMoveDelayLimit = MOVE_DELAY_FAST;

    int enemyMoveDelay = 0;
    int enemyMoveDelayLimit = MOVE_DELAY_FAST;
//    int counter;

    @Override
    public void timerTaskHandler() {
        if (state == GameState.RUN) {

            if (pac != null) {
                // if could to limit, then  move snake and reset counter,
                // else keep counting
                if (pacMoveDelay >= pacMoveDelayLimit) {
                    pacMoveDelay = 0;
                    pac.move();
                } else {
                    // else keep counting counting
                    pacMoveDelay++;
                }
//                checkIntersections();
            }

            if ((yellowChica != null) && (blueBonnie != null) && (orangeFreddy != null)) {
                // if could to limit, then  move snake and reset counter,
                // else keep counting
                if (enemyMoveDelay >= enemyMoveDelayLimit) {
                    enemyMoveDelay = 0;
                    yellowChica.move();
                    blueBonnie.move();
                    orangeFreddy.move();

                } else {
                    // else keep counting counting
                    enemyMoveDelay++;
                }
            }

//            if (yellowChica != null) {
//                // if could to limit, then  move snake and reset counter,
//                // else keep counting
//                if (enemyMoveDelay >= enemyMoveDelayLimit) {
//                    enemyMoveDelay = 0;
//                    yellowChica.move();
//                } else {
//                    // else keep counting counting
//                }
//            }
//            
//            if (orangeFreddy != null) {
//                // if could to limit, then  move snake and reset counter,
//                // else keep counting
//                if (enemyMoveDelay >= enemyMoveDelayLimit) {
//                    enemyMoveDelay = 0;
//                    orangeFreddy.move();
//                } else {
//                    // else keep counting counting
//                }
//            }
//            if (blueBonnie != null) {
//            // if could to limit, then  move snake and reset counter,
//                // else keep counting
//                if (enemyMoveDelay >= enemyMoveDelayLimit) {
//                    enemyMoveDelay = 0;
//                    blueBonnie.move();
//                } else {
//                    // else keep counting counting
//                }
//            }
//            enemyMoveDelay++;
            checkIntersections();
        }
    }

    public void checkIntersections() {
        ArrayList<Orb> removeOrbs = new ArrayList<>();
        for (Orb orb : orbs) {
            if (orb.isVisible() && (orb.getRectangle().intersects(pac.getHitBox()))) {
                //add points
                //make orb invisible
                removeOrbs.add(orb);
                score += 10;
                //make a funny sound
                //add points
                System.out.println("HIT");
            }
        }
        orbs.removeAll(removeOrbs);

        for (Barrier barrier : barriers) {
            int direction = (int) (Math.random() * 4);
            Direction newDirection;
            
            

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

            //exact the SAME code for EACH monster    
            if (barrier.getHitBox().intersects(yellowChica.getHitBox())) {

                //if the barrier is to the LEFT of the pacman, move the pac man 
                // the the RIGHT, and stop him moving left
//                if (barrier.getSystemCoordX() < pac.getX()) {
                if (yellowChica.getDirection() == Direction.LEFT) {

                    //we must have a barrier on out LEFT!!!
                    //  - push the pacman back to the right, so there is NO LONGER and intersection
                    yellowChica.setX(barrier.getSystemCoordX() + barrier.getWidth());

                } else if (yellowChica.getDirection() == Direction.RIGHT) {
                    //we must have a barrier on out RIGHT!!!
                    //  - push the pacman back to the right, so there is NO LONGER and intersection
                    yellowChica.setX(barrier.getSystemCoordX() - yellowChica.getWidth());

                } else if (yellowChica.getDirection() == Direction.UP) {
                    //we must have a barrier on out DOWN!!!
                    //  - push the pacman back to the right, so there is NO LONGER and intersection
                    yellowChica.setY(barrier.getSystemCoordY() + barrier.getWidth());

                } else if (yellowChica.getDirection() == Direction.DOWN) {
                    yellowChica.setY(barrier.getSystemCoordY() - yellowChica.getHeight());
                }

                if (direction == 1) {
                    newDirection = Direction.UP;
                } else if (direction == 2) {
                    newDirection = Direction.DOWN;
                } else if (direction == 3) {
                    newDirection = Direction.LEFT;
                } else {
                    newDirection = Direction.RIGHT;
                }

                yellowChica.setDirection(newDirection);

            }
            if (barrier.getHitBox().intersects(orangeFreddy.getHitBox())) {
                //if the barrier is to the LEFT of the pacman, move the pac man 
                // the the RIGHT, and stop him moving left
//                if (barrier.getSystemCoordX() < pac.getX()) {
                if (orangeFreddy.getDirection() == Direction.LEFT) {
                    //we must have a barrier on out LEFT!!!
                    //  - push the pacman back to the right, so there is NO LONGER and intersection
                    orangeFreddy.setX(barrier.getSystemCoordX() + barrier.getWidth());

                } else if (orangeFreddy.getDirection() == Direction.RIGHT) {
                    //we must have a barrier on out RIGHT!!!
                    //  - push the pacman back to the right, so there is NO LONGER and intersection
                    orangeFreddy.setX(barrier.getSystemCoordX() - orangeFreddy.getWidth());

                } else if (orangeFreddy.getDirection() == Direction.UP) {
                    //we must have a barrier on out DOWN!!!
                    //  - push the pacman back to the right, so there is NO LONGER and intersection
                    orangeFreddy.setY(barrier.getSystemCoordY() + barrier.getWidth());

                } else if (orangeFreddy.getDirection() == Direction.DOWN) {
                    orangeFreddy.setY(barrier.getSystemCoordY() - orangeFreddy.getHeight());
                }

                if (direction == 1) {
                    newDirection = Direction.UP;
                } else if (direction == 2) {
                    newDirection = Direction.DOWN;
                } else if (direction == 3) {
                    newDirection = Direction.LEFT;
                } else {
                    newDirection = Direction.RIGHT;
                }

                orangeFreddy.setDirection(newDirection);

//        if (barriers.contains(pac.getPosition())) {
//            pac.addHealth(-1000000);
//        }
            }
            if (barrier.getHitBox().intersects(blueBonnie.getHitBox())) {
                //if the barrier is to the LEFT of the pacman, move the pac man 
                // the the RIGHT, and stop him moving left
//                if (barrier.getSystemCoordX() < pac.getX()) {
                if (blueBonnie.getDirection() == Direction.LEFT) {
                    //we must have a barrier on out LEFT!!!
                    //  - push the pacman back to the right, so there is NO LONGER and intersection
                    blueBonnie.setX(barrier.getSystemCoordX() + barrier.getWidth());

                } else if (blueBonnie.getDirection() == Direction.RIGHT) {
                    //we must have a barrier on out RIGHT!!!
                    //  - push the pacman back to the right, so there is NO LONGER and intersection
                    blueBonnie.setX(barrier.getSystemCoordX() - blueBonnie.getWidth());

                } else if (blueBonnie.getDirection() == Direction.UP) {
                    //we must have a barrier on out DOWN!!!
                    //  - push the pacman back to the right, so there is NO LONGER and intersection
                    blueBonnie.setY(barrier.getSystemCoordY() + barrier.getWidth());

                } else if (blueBonnie.getDirection() == Direction.DOWN) {
                    blueBonnie.setY(barrier.getSystemCoordY() - blueBonnie.getHeight());
                }

                if (direction == 1) {
                    newDirection = Direction.UP;
                } else if (direction == 2) {
                    newDirection = Direction.DOWN;
                } else if (direction == 3) {
                    newDirection = Direction.LEFT;
                } else {
                    newDirection = Direction.LEFT;
                }

                blueBonnie.setDirection(newDirection);

            }
        }
    }

    final int SPEED_FAST = 8;
    final int SPEED_MEDIUM = 4;
    final int SLOW = 2;
    final int FROZEN = 0;

//<editor-fold defaultstate="collapsed" desc="Key and Mouse Handlers">
    @Override
    public void keyPressedHandler(KeyEvent e) {

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
            pac.setSpeed(SPEED_MEDIUM);
        } else if (e.getKeyCode() == KeyEvent.VK_4) {
            pac.setSpeed(SPEED_FAST);
            pac.setColor(Color.red);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            audio.AudioPlayer.play("/pacman/Bleat.wav");

        }
        if (e.getKeyCode() == KeyEvent.VK_A) {

            orangeFreddy.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {

            orangeFreddy.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            orangeFreddy.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            orangeFreddy.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_1) {
            orangeFreddy.setSpeed(FROZEN);

        } else if (e.getKeyCode() == KeyEvent.VK_2) {
            orangeFreddy.setSpeed(SLOW);

        } else if (e.getKeyCode() == KeyEvent.VK_3) {
            orangeFreddy.setSpeed(SPEED_MEDIUM);
        } else if (e.getKeyCode() == KeyEvent.VK_4) {
            orangeFreddy.setSpeed(SPEED_FAST);

        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            blueBonnie.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_L) {
            blueBonnie.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_K) {
            blueBonnie.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_I) {
            blueBonnie.setDirection(Direction.UP);

        }
        if (e.getKeyCode() == KeyEvent.VK_F) {
            yellowChica.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_H) {
            yellowChica.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_G) {
            yellowChica.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_T) {
            yellowChica.setDirection(Direction.UP);
        }
        if (e.getKeyCode() == KeyEvent.VK_P) {
            if (state == GameState.PAUSED) {
                setState(GameState.RUN);
            } else if (state == GameState.RUN) {
                setState(GameState.PAUSED);
            }
        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
        System.out.println("Mouse Click " + e.getX() + ", " + e.getY());
    }
//</editor-fold>

    @Override
    public void paintEnvironment(Graphics g) {

//        System.out.println(Main.getWindowSize());
        AffineTransform atWindow;
        Graphics2D graphics = (Graphics2D) g;
        atWindow = AffineTransform.getScaleInstance((double) Main.getWindowSize().width / DEFAULT_WINDOW_WIDTH, (double) Main.getWindowSize().height / DEFAULT_WINDOW_HEIGHT);
        if (atWindow != null) {
            graphics.setTransform(atWindow);
        }

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

        if (orbs != null) {
            for (Orb orb : getCopyOfOrbs()) {
                orb.draw(graphics);
            }
        }

        if (items != null) {
            for (int i = 0; i < items.size(); i++) {
                items.get(i).draw(graphics);

            }
            if (orangeFreddy != null) {
                orangeFreddy.draw(g);
            }
            if (blueBonnie != null) {
                blueBonnie.draw(g);
            }
            if (yellowChica != null) {
                yellowChica.draw(g);
            }
        }
        if (state == GameState.PAUSED) {
//            graphics.setFont();
            graphics.setColor(Color.WHITE);
            graphics.drawString("PAUSED", 290, 200);

        } 
        else if (state == GameState.RUN) {
            graphics.setColor(Color.WHITE);
            graphics.drawString("SCORE", 750, 50);
            graphics.drawString("" + score, 765, 75);
            graphics.draw3DRect(650, 10, 225, 500, true);
            
            
            
            
        
        } else if (state == GameState.RESET) {
            score = 0;
//            if (orangeFreddy.getHitBox().intersects(pac.getHitBox()))
           
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

    /**
     * @return the state
     */
    public GameState getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(GameState state) {
        this.state = state;
    }
}
