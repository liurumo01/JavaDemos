package plane;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject
{
	Image img;
	double x,y;
	int speed;
	
	int width;
	int height;
	
	public GameObject()
	{
		
	}
	
	public GameObject(Image img,double x,double y,int speed,int width,int height)
	{
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle getRectangle()
	{
		return new Rectangle((int)x,(int)y,width,height);
	}
}