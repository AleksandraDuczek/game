
package input;

import gra.Gra;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import org.w3c.dom.events.MouseEvent;

 
public class Mouse implements MouseListener, MouseMotionListener   {

    //x, y gdzie myszka na ekranie
    //xpixel, ypixel na obrazie
    public static int X, Y, Xpixel, Ypixel;
    private static boolean b1 = false, b2=false;//sprawdza czy w poprzedniej aktualizacji klawisz wcisniety
    public static boolean button_left, button_right, button_left_click, button_right_click ;
    
   
    
    
    public static void update() {
        
        //Klikanie lewym
         if(!b1 && button_left){
            b1=true;
            button_left_click=true;
             }
         else  {
             button_left_click = false;
         }
         
         if(button_left) {
             b1 = false;
         }
         
         //Klikanie prawym
           if(!b2 && button_right){
            b2=true;
            button_right_click=true;
             }
         else  {
             button_right_click = false;
         }
         
         if(button_right) {
             b2 = false;
         }
         
    }

    
    
    @Override//klikniety
    public void mouseClicked(java.awt.event.MouseEvent e) {
      mouseMoved(e);
        if(e.getButton() == e.BUTTON1)
        {
            button_left_click = true;
        }
        
         if(e.getButton() == e.BUTTON3)
        {
            button_right_click = true;
        }
     
       
    }

    @Override//przytrzymany
    public void mousePressed(java.awt.event.MouseEvent e) {
        mouseMoved(e);
          if(e.getButton() == e.BUTTON1)
        {
            button_left = true;
        }
        
         if(e.getButton() == e.BUTTON3)
        {
            button_right = true;
        }
       
     
    }

    @Override//puszczony
    public void mouseReleased(java.awt.event.MouseEvent e) {
      
        mouseMoved(e);
        if(e.getButton() == e.BUTTON1)
        {
            button_left = false;
        }
        
         if(e.getButton() == e.BUTTON3)
        {
            button_right = false;
        }
        
    } 

    @Override//kursor w naszym oknie
    public void mouseEntered(java.awt.event.MouseEvent e) {
        mouseMoved(e);  
    }

    @Override//poza oknem
    public void mouseExited(java.awt.event.MouseEvent e) {
       
    }

    @Override //przytrzymany
    public void mouseDragged(java.awt.event.MouseEvent e) {
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
       
       X = e.getX();
       Y = e.getY();
       Xpixel=(int)((float)X*((16.0f*64.0f)/(float)Gra.WIDTH));//dokladniej
       Ypixel=(int)((float)Y*((9.0f*64.0f)/(float)Gra.HEIGHT));
    }

    public static class button_left {

        public button_left() {
        }
    }
     
}
