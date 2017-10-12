package plane;

import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;

public class Explode
{
	double x,y;
	static Image[] imgs;
	int count;
	
	static {
		imgs = new Image[16];
		for (int i = 0; i < imgs.length; i++) {
			imgs[i] = GameUtil.getImage("images/explode/e" + (i + 1) + ".gif");
			imgs[i].getWidth(null);
		}
	}
	
	public Explode(double x,double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g)
	{
		for(count = 0; count < 16; count++)
		{
			g.drawImage(imgs[count],(int)x,(int)y,null);
		}
	}
}
