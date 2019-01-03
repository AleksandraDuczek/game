
package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//obsluga klawiatury
public class Keyboard implements KeyListener  {

    private static final int Count = 200; //przechowuje ilosc el tablicy
    private static boolean keys[] = new boolean [Count]; 
    private static boolean keys_prev[] = new boolean [Count]; //czy klawisz byl wczesniej wcisniety?
    
    //wylaczamy wszystkie klawisze
    public Keyboard () {
        for (int i=0; i<Count; i++)
            keys[i]=false;
        for (int i=0; i<Count; i++)
            keys_prev[i]=false;
    }
    
    public void keyTyped(KeyEvent arg0) {
    
    }


    public void keyPressed(KeyEvent arg0) {
          keys[arg0.getKeyCode()]=true;
    }

    public void update () {
        for (int i=0; i< Count; i++)
        {
            if(!keys[i])
            {
                keys_prev[i]=false;
            }
                
        }
    }
    
     
    public static boolean getKey (int Key)
    {
       return keys[Key];
        
    }
         
    
    //static dostepne z kazdego miejsca w kodzie
    public static boolean getKeyOnce (int Key)
    {
        
        if(!keys_prev[Key] && keys[Key]) {
            keys_prev[Key] = true;
            return true;
        }
        
        return false;
     
    }
    
  
       
 
    public  void keyReleased(KeyEvent arg0) {
       keys[arg0.getKeyCode()]=false;
    }
    
    
}
