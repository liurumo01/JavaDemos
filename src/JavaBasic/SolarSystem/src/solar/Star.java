package solar;

import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;

public class Star
{	
	Image img;
	double x;
	double y;
	int width;
	int height;
	
	public Star()
	{
		
	}
	
	public Star(Image img)
	{
		this.img = img;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
	public Star(String imgPath,double x,double y)
	{
		this(GameUtil.getImage(imgPath));
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(img, (int)x, (int)y, null);
	}
}
