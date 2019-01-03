
package graphic;


import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Spritesheet {

    public static final Spritesheet def1 = new Spritesheet ("/siatka_xpp.png");
    
    public static final Spritesheet menu = new Spritesheet ("/menu.png");
    
    public static final Spritesheet bck_game = new Spritesheet ("/background_test.png");
    
    public static final Spritesheet bck_game_sad = new Spritesheet ("/bcksad.png");
    
    public static final Spritesheet bck_help = new Spritesheet ("/help.png");
    
    public static final Spritesheet produkty = new Spritesheet ("/produkty_2.png");
    
    public static final Spritesheet punktacja = new Spritesheet ("/punkty.png");

    
    public int  WIDTH, HEIGHT;
    public int [] pixels;
    
    public Spritesheet (String path)  {
        try { 
            
        BufferedImage image = ImageIO.read(Spritesheet.class.getResource(path));
        WIDTH = image.getWidth();
        HEIGHT = image.getHeight();
        pixels = new int [WIDTH*HEIGHT];
        
        image.getRGB(0,0,WIDTH,HEIGHT,pixels,0,WIDTH);
            
        }
        
        catch (IOException e)
        {
        }
    }
        
}
