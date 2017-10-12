package solar;

import java.awt.Graphics;
import java.awt.Image;

import util.Constant;
import util.GameUtil;
import util.MyFrame;

public class SolarFrame extends MyFrame
{
	private static final long serialVersionUID = 1L;
	
	Image bg;
	Star sun;
	
	Planet earth;
	Planet mars;
	
	Planet moon;
	
	public SolarFrame()
	{
		bg = GameUtil.getImage("images/bg.jpg");
		
		sun = new Star("images/sun.jpg", Constant.GAME_WIDTH / 2, Constant.GAME_HEIGHT / 2);
		earth = new Planet("images/earth.jpg", 150, 100, 0.1, sun);
		mars = new Planet("images/mars.jpg", 200, 130, 0.08, sun);
		
		moon = new Planet("images/moon.jpg", 15, 20, 0.1, earth, true);
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(bg, 0, 0, null);
		sun.draw(g);
		earth.draw(g);
		mars.draw(g);
		moon.draw(g);
		/*for(int i=0;i<8;i++)
		{
			planets[i].draw(g);
			planets[i].track.draw(g, sun.center.x, sun.center.y);
		}
		moon.draw(g);*/
	}
	
	public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}
}
