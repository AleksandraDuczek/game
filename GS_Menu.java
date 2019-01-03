
package gra.gamestates;

import gra.GameState;
import gra.GameStateManager;
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


public class GS_Menu extends GameState {
    
     int i = 4;
     
     public static final Sprite s_menu = new Sprite    (0, 0,  Spritesheet.menu.WIDTH, Spritesheet.menu.HEIGHT, Spritesheet.menu);
     public static final Sprite s_start = new Sprite      (0, 0, 310, 240, Spritesheet.def1);
     public static final Sprite s_help = new Sprite   (0, 238 ,98, 101, Spritesheet.def1);
     public static final Sprite s_exit = new Sprite  (0, 476, 98, 103, Spritesheet.def1);


    
 
   
    public void update () 
    {
       
         
         int Mouse_x=(int)Mouse.Xpixel;
         int Mouse_y=(int)Mouse.Ypixel;
         
         if(Mouse_x>330 && Mouse_x<660 && Mouse_y>170 && Mouse_y<440 && Mouse.button_left_click) 
             GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_GRA);
         
         if (Mouse_x>0 && Mouse_x<130 && Mouse_y>450 && Mouse_y<570 && Mouse.button_left_click)
             GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_HELP);
         
         if (Mouse_x>890 && Mouse_x<1023 && Mouse_y>450 && Mouse_y<570 && Mouse.button_left_click)
         {    GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_EXIT);
          System.exit(0);}
         
         
    
         
 
    }
    


   
    public void render (Screen s)
    {
       
        s.clear(0x00ff00);
        s.renderSprite(0, 0, s_menu);
        s.renderSprite(82*i, 46*i, s_start);
        s.renderSprite(5*i, 115*i, s_help);
        s.renderSprite(227*i, 114*i, s_exit);
      
       
    }

    private void mouseReleased() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
