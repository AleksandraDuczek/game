
package game.world;


import game.world.tiles.background_game;
import game.world.tiles.bck_game_sad;
import graphic.Screen;
import static graphic.Spritesheet.bck_game;
import static graphic.Spritesheet.bck_game_sad;

public class tile {

    public int id;
    public boolean colider, ladder;
    
public static  tile getTile(int id)
{
    if (id==1) return new background_game();
    else if (id==2) return new bck_game_sad();
        return null;
   
}
    
public void update () {} 

public void render(Screen s, int x, int y)  {

    if (id==1) s.renderSprite(bck_game.WIDTH, bck_game.HEIGHT, bck_game);
    if (id==2) s.renderSprite(bck_game_sad.WIDTH, bck_game_sad.HEIGHT, bck_game_sad);
    
}

}