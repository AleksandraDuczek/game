
package game.world;

import graphic.Screen;

public class Map {
    public final int WIDTH, HEIGHT;
    public tile[][] tiles;
    
    public Map (int w, int h)
    {
        WIDTH = w;
        HEIGHT = h;
        tiles = new tile[w][h];

        
    }
    
    
    public void clear (int id) {
        for (int y=0; y<HEIGHT; y++) {
            for (int x=0; x<WIDTH; x++ ) {
                tiles[x][y]=tile.getTile(id);
            }
        }
    }
    
    //if punkty < iles to wybierz id==2
    
    public void render (Screen s) {
        for (int y=0; y<HEIGHT; y++) {
            for (int x=0; x<WIDTH; x++ ) {
                tiles[x][y].render(s,x,y);
            }
        }
    }
             
    
}
