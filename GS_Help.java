
package gra.gamestates;

import gra.GameState;
import static graphic.Spritesheet.bck_help;
import graphic.Screen;
import graphic.Sprite;
import graphic.Spritesheet;
import input.Mouse;
import static input.Mouse.button_left;
import static input.Mouse.button_left_click;
import static input.Mouse.button_right_click;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import gra.GameStateManager;
import input.Keyboard;


public class GS_Help extends GameState {
    
    public Sprite help;
    private Sprite ss;
   
    
    public GS_Help()
    {
         help = new Sprite (0, 0,  bck_help.WIDTH, bck_help.HEIGHT, Spritesheet.bck_help);
    }
    

    public void update ()
    {
             
     if(Keyboard.getKeyOnce(KeyEvent.VK_ENTER)) 
        {
            
            GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_GRA);
        }
      
    }

public void render (Screen s)
    {
       
        s.clear(0x00ff00);
        s.renderSprite((int)0, (int)0, this.help);
      
   
        }
     

    

    
}


