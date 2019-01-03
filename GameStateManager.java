
package gra;

import gra.gamestates.GS_Game;
import gra.gamestates.GS_Help;
import gra.gamestates.GS_Menu;
import graphic.Screen;


public class GameStateManager {
    
    public static final int GAME_STATE_EXIT=-1;
    public static final int GAME_STATE_MENU=0;
    public static final int GAME_STATE_GRA=1;
    public static final int GAME_STATE_HELP=2;
    
    
    private static GameState gs ; //nasz stan gry
    public static boolean exit=false;
    
     public static void ChangeGameState (int ID)
   {
       if(ID == GAME_STATE_MENU)gs = new GS_Menu();
       if(ID == GAME_STATE_GRA)gs = new GS_Game();
       if(ID == GAME_STATE_EXIT)exit = true;
       if(ID == GAME_STATE_HELP)gs = new GS_Help();
       
   }
    
    public GameStateManager ()
   {
       ChangeGameState(GAME_STATE_MENU);
       
   }
    
    
    
    public void update ()
    {
        
        gs.update();
    }
    
    public void render (Screen s)
            
    {
        gs.render(s);
        
    }
    
}
