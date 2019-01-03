
package game.world.tiles;

import game.world.tile;
import graphic.Screen;
import graphic.Sprite;
import graphic.Spritesheet;


public class bck_game_sad extends tile{
    
    public static final Sprite bck_game_sad = new Sprite (0, 0,  Spritesheet.bck_game_sad.WIDTH, Spritesheet.bck_game_sad.HEIGHT, Spritesheet.bck_game_sad);

    public bck_game_sad()
    {
    id=2;
    colider=true;
    ladder=false;
    }
    
    public void render (Screen s,int x, int y)
    {
        s.renderSprite(0, 0, bck_game_sad);
        
    }
}
