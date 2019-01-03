
package gra;

import com.sun.glass.events.KeyEvent;
import graphic.Screen;
import graphic.Sprite;
import graphic.Spritesheet;
import input.Keyboard;
import input.Mouse;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;
import java.util.Timer;

import javax.swing.JFrame;

//to co zostalo do zrobienia do ogarniecie myszki ktora bedzie przydatna 
//przy produktach, menu, ogarnac minki przy punktacji i moment zakonczenia 
//inkrementacji w punktacji, jakis napis, ze super wiedza i elo 
// i przemyslec sytuacje jak uzytkownik ciagle przegrywa, 
// dodac punktacje ujemna i alarmy ze cos jest nie tak 
// i przemyslec czy to tlo zmieniac na smutne czy darowac sobie 
// dodac exita w grze lub po prostu cofniecie do menu 

public class Gra extends Canvas implements Runnable {
    
    public static final String TITLE="Healthy Pony";
    public static final int WIDTH = 1024, HEIGHT = 576;//jak w zalozeniach projektowych
    private static final int  FRAMERATE = 60; // ograniczamy klatki/sekunde do 60
    
    private boolean RUNNING = false;
    private JFrame frame;
    
    private Screen screen;
    private Keyboard keyboard = new Keyboard();
    private Mouse mouse = new Mouse();
    private GameStateManager gsm= new GameStateManager();
    
    // public static final Sprite s = new Sprite (1, 0, 16, Spritesheet.def1);
    
   
    
    public Gra () {
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        setMaximumSize(new Dimension(WIDTH,HEIGHT));
        
        frame = new JFrame();
        frame.setTitle(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//zamykamy exitem
        addKeyListener(keyboard);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        
        frame.add(this, new BorderLayout().CENTER);//ustawiamy na srodek 
// this odwoluje sie do canvas, musielibysmy dodac obiekt canvas = c... i potem wszedzie c//
        
        frame.pack();//"zastosuj" do canvas
        
        frame.setLocationRelativeTo(null); // domyslnie srodek ekranu
        frame.setResizable(false);//nierozszerzalne
        frame.setVisible(true);//okno pojawi sie
        int i = 64;
        screen = new Screen (16*i,9*i);
         
        gsm=new GameStateManager();
    }
    //glowny watek gry//
    
    private void start() {
        if(RUNNING) return; //jesli bedzie w trakcie, wyrzucamy z petli//
        RUNNING = true; //jesli nie, ustawiamy na "w trakcie"//
        
        new Thread (this, "Game " + TITLE).start();//this odnosi sie do implementacji po runnable//
        //od runnable mamy funckje run automatycznie wygenerowana//
    }
    
   
    
      private void stop() {
          if(!RUNNING) return; //jesli bedzie w trakcie, wyrzucamy z petli//
          RUNNING = false; //jesli nie, ustawiamy na "w trakcie"//
          frame.dispose();
          System.exit(0);
      }
    
      private double timer = System.currentTimeMillis();
      private int UPS = 0; 
      private int FPS = 0; // licznik, przechowuje ile klatek, ilosc klatek na sekunde
      private double delta;
      private double frametime = 1000000000 / FRAMERATE; //ile trwa jedna klatka? /w nanosekundach
      private long timeNOW = System.nanoTime(); //przed
      private long timeLAST = System.nanoTime(); // po aktualizacji
       
       public void run() {
        while (RUNNING && !gsm.exit)
        {
            timeNOW = System.nanoTime();
            delta += (timeNOW - timeLAST) / frametime;
            timeLAST = timeNOW;
            
            while (delta>=1)
            { 
             update();
            delta -= 1;
            UPS++;
            }
            
            render();
            FPS++;//klatki sie inkrementuja
            
            if (System.currentTimeMillis() - timer >= 1000)
            {
              timer = System.currentTimeMillis();
              frame.setTitle(TITLE+"-- FPS: " + FPS + "--- UPS: " + UPS); 
              FPS=0;
              UPS=0;
              
              //timer mierzy ilosc klatek na sekunde/
            }
        
        }
       stop();
    }
       
   
    private void update () {
       keyboard.update();
       mouse.update();
        gsm.update();
    }
    
     private void render ()
    { 
        BufferStrategy bs = getBufferStrategy();
        if (bs==null)
        {
            createBufferStrategy(3);//3 bufory stworzyc//
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH+10 , HEIGHT+10);
        
        screen.clear(0x000000);
        gsm.render(screen);
        
        g.drawImage(screen.getImage(), 0, 0, WIDTH+10, HEIGHT+10, null);
        
        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Gra().start();
      
    
      
    }
    
}
