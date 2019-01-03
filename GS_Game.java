
package gra.gamestates;


import gra.GameState;
import gra.GameStateManager;
import graphic.Screen;
import graphic.Sprite;
import graphic.Spritesheet;
import static graphic.Spritesheet.bck_game;
import input.Keyboard;
import input.Mouse;
import static input.Mouse.button_left;
import static input.Mouse.button_left_click;
import static input.Mouse.button_right_click;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GS_Game extends GameState  {
    
    int r=0,y=0,u=0,i=0,o=0,p=0, e=0;
   
  
    public Sprite ss;
    public Sprite bck;
    public Sprite food, food1, food3, food4, food5, food6;
    public Sprite p_punkt;
    public Sprite emoticon;

    int id;
    int a, b;
    int k=130;
    int m=0;
    int n=0;
    int control=0;
    boolean healthy=true;
  
   public GS_Game()
    {
        
       ss = new Sprite (98, 339, 80, 80, Spritesheet.def1);
       //wczytujmy tlo
       bck = new Sprite (0, 0,  bck_game.WIDTH, bck_game.HEIGHT, Spritesheet.bck_game);
       //wczytujemy siatke z punktacja
       p_punkt = new Sprite (0, 0, 130, 130, Spritesheet.punktacja);
     // boolean punkty_dodaj = false;
      emoticon=new Sprite (0,0,130,130,Spritesheet.punktacja);
       
  //wywolujemy metode i wycinamy z siatki w ktorej znajduja sie wszystkie produkty
        losuj_pole_x();
        losuj_pole_y();
        if (b>=630) healthy=false;
        else healthy=true;
       food = new Sprite(a, b, 126, 126, Spritesheet.produkty);
       
       
         losuj_pole_x();
        losuj_pole_y();
        if (b>=630) healthy=false;
        else healthy=true;
       food1 = new Sprite(a, b, 126, 126, Spritesheet.produkty);
       
        losuj_pole_x();
        losuj_pole_y();
        if (b>=630) healthy=false;
        else healthy=true;
       food3 = new Sprite(a, b, 126, 126, Spritesheet.produkty);
       
        losuj_pole_x();
        losuj_pole_y();
        if (b>=630) healthy=false;
        else healthy=true;  
       food4 = new Sprite(a, b, 126, 126, Spritesheet.produkty);
       
        losuj_pole_x();
        losuj_pole_y();
        if (b>=630) healthy=false;
        else healthy=true;
       food5 = new Sprite(a, b, 126, 126, Spritesheet.produkty);
       
        losuj_pole_x();
        losuj_pole_y();
        if (b>=630) healthy=false;
        else healthy=true;
       food6 = new Sprite(a, b, 126, 126, Spritesheet.produkty);
       
      // public Sprite produkty = new Spritesheet ("/produkty-kopia.png");
        
    }
   

      //funkcja losowania ktore pola wycinamy z tablicy produktow
      public int losuj_pole_x()
    {
        Random rand = new Random();
        a = rand.nextInt(7);
        a*=126;
        System.out.println(a);
        return a;
     }
    
        public int losuj_pole_y()
    {
        Random rand = new Random();
        b = rand.nextInt(7);
        b*=126;
        System.out.println(b);
        return b;
   
     }
      
        
     private void punkty_odejmij()
        {   if(m<=0) {  m=0;  }
        else {  m-=k;}
          
        }


        public int [] counting_points_table ()
        {
            switch(control){
                case 910:
                {     m=0;       n=130;     }
                case 1820:
                {    m=0;        n=260;     }  
                case 2730:
                {    m=0;        n=390;     }  
                case 3640:
                {    m=0;        n=520;     }
                case 4550:
                {    m=0;        n=650;     }
                case 5460:
                {    m=0;        n=780;     }
                default: 
                {
                     m+=k;
                     if (m>780 && n==780)
                     {
                         System.out.println("Tu bedzie koniec");
                          
                     }
                        
                        }
                control+=k;
                int tab[]={m,n};
                return tab;
                
            }
        }
                
                 
       
        
    public void update () 
    {
        //ustawianie roznej predkosci do kazdego produktu 
        double speed=2, speed1=1.111, speed2=1.555, speed3=1.9;
        double speed4=2.5, speed5=1.5, speed6=1;
        int Mouse_x=(int)Mouse.Xpixel;
        int Mouse_y=(int)Mouse.Ypixel;
        
      //pomoc//  
      if(Mouse.button_left_click==true)
        {
            System.out.println("Kliknelas, ale w : "+ (int)Mouse.Xpixel +" "+ (int)Mouse.Ypixel ) ;
            System.out.println(e);
        }
        
        //1//
        if(r<730) 
        { 
            r+=speed;
        
            if (Mouse.button_left_click==true && Mouse_y<=(r+60) && Mouse_y>=r && Mouse_x<100 && Mouse_x>20)
        {
         System.out.println("b wynosi: "+b);   
        if (b>=630) { System.out.println("Wiec jest wieksze niz 630 wiec niezdrowe");  healthy=false; }
      
        if(healthy==true)  {
            counting_points_table();
            p_punkt = new Sprite (m, n, 130, 130, Spritesheet.punktacja);
            losuj_pole_x();
            losuj_pole_y();
            food = new Sprite(a, b, 126, 126, Spritesheet.produkty);
           
        } 
        
        else { System.out.println("Tu beda odejmowane");
        losuj_pole_x();
        losuj_pole_y();
        food = new Sprite(a, b, 126, 126, Spritesheet.produkty);
        }
        
        
        }
        
        }
        
        else { r=0; }
        
        
        //2//
        if(y<730) 
        { 
            y+=speed1;
            
            
            if (Mouse.button_left_click==true && Mouse_y<=(y+60) && Mouse_y>=y && Mouse_x<260 && Mouse_x>150)
            {
                 counting_points_table();
                 p_punkt = new Sprite (m, n, 130, 130, Spritesheet.punktacja);
                losuj_pole_x();
                losuj_pole_y();
                 food1 = new Sprite(a, b, 126, 126, Spritesheet.produkty);
                
                
            }
        }
        
        else { y=0; }
        
        
        //3//
        if(u<730) 
        {
            u+=speed2;
            
            if (Mouse.button_left_click==true && Mouse_y<=(u+60) && Mouse_y>=u && Mouse_x<500 && Mouse_x>405)
            {
                counting_points_table();
                p_punkt = new Sprite (m, n, 130, 130, Spritesheet.punktacja);
                losuj_pole_x();
                losuj_pole_y();
                food3 = new Sprite(a, b, 126, 126, Spritesheet.produkty);
                
            }   
        }
        
        else { u=0; }
        
        
        //4//
        if(i<730) 
        {  
            i+=speed3;
            if (Mouse.button_left_click==true && Mouse_y<=(i+60) && Mouse_y>=i && Mouse_x<530 && Mouse_x>640)
            {
                counting_points_table();
                p_punkt = new Sprite (m, n, 130, 130, Spritesheet.punktacja);
                losuj_pole_x();
                losuj_pole_y();
                food4 = new Sprite(a, b, 126, 126, Spritesheet.produkty);
                
            }   
        
        
        }
        
        else { i=0; }
        
        
        //5//
        if(o<730) 
        {
            o+=speed4;
            if (Mouse.button_left_click==true && Mouse_y<=(o+120) && Mouse_y>=o && Mouse_x<530 && Mouse_x>650)
            {
                counting_points_table();
                 p_punkt = new Sprite (m, n, 130, 130, Spritesheet.punktacja);
                losuj_pole_x();
                losuj_pole_y();
                 food4 = new Sprite(a, b, 126, 126, Spritesheet.produkty);
                
            }   
        }
        
        else { o=0; }
        
        
        //6//
         if(p<730) 
        {
            p+=speed5;
        if (Mouse.button_left_click==true && Mouse_y<=(p+60) && Mouse_y>=p && Mouse_x<780 && Mouse_x>660)
            {
                counting_points_table();
                p_punkt = new Sprite (m, n, 130, 130, Spritesheet.punktacja);
                losuj_pole_x();
                losuj_pole_y();
                 food5 = new Sprite(a, b, 126, 126, Spritesheet.produkty);
            }   }
         
         else { p=0; }

         
         //7//
        if(e<730)
        { 
            e+=speed6;
        if (Mouse.button_left_click==true && Mouse_y<=(e+60) && Mouse_y>=e && Mouse_x<920 && Mouse_x>820)
            {
                counting_points_table();
                 p_punkt = new Sprite (m, n, 130, 130, Spritesheet.punktacja);
                losuj_pole_x();
                losuj_pole_y();
                 food6 = new Sprite(a, b, 126, 126, Spritesheet.produkty);
                
            }   
        }
        
        else { e=0; }
        
     
        
        
    }
    
  
    
    
    public void render (Screen s)
    {
        s.clear(0x0000ff);
          try {
            Thread.sleep(60);
          } catch (InterruptedException ex) {System.out.println("Wyjątek: "+ex);      }
        s.renderSprite((int)0, (int)0, this.bck);
        s.renderSprite(2*k-30, 3*k, p_punkt);
        s.renderSprite(0, r,food);
        s.renderSprite(k, y,food1);
        s.renderSprite(3*k, i, food3);
        s.renderSprite(4*k, o, food4);
        s.renderSprite(5*k, p, food5);
        s.renderSprite(6*k, e, food6);
         if(Keyboard.getKeyOnce(KeyEvent.VK_SPACE)) 
           {
               GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_HELP);
           }
        
        
     /*   if(Mouse.button_left)
        {
        s.renderSprite((int)Mouse.Xpixel - 8, (int)Mouse.Ypixel - 8, this.ss);
        }
        
      */
       
        
    }

   
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}  
