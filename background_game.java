
package game.world.tiles;

import game.world.tile;
import graphic.Screen;
import graphic.Sprite;
import graphic.Spritesheet;


public class background_game extends tile{
    
    public static final Sprite bck_game = new Sprite (0, 0,  Spritesheet.bck_game.WIDTH, Spritesheet.bck_game.HEIGHT, Spritesheet.bck_game);

    public background_game()
    {
    id=1;
    colider=true;
    ladder=false;
    }
    
    public void render (Screen s,int x, int y)
    {
        s.renderSprite(0, 0, bck_game);
        
    }
}
