package solar;

import java.awt.Color;
import java.awt.Graphics;

import util.GameUtil;

public class Planet extends Star
{
	double longAxis;
	double shortAxis;
	double speed;
	double degree;
	Star center;
	
	boolean satellite;
	
	public Planet(String imgPath, double longAxis,double shortAxis,double speed,Star center)
	{
		super(GameUtil.getImage(imgPath));
		this.center = center;
		this.x = center.x + longAxis;
		this.y = center.y;
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
	}
	
	public Planet(String imgPath, double longAxis,double shortAxis,double speed,Star center,boolean satellite)
	{
		this(imgPath,longAxis,shortAxis,speed,center);
		this.satellite = satellite;
	}
	
	public void draw(Graphics g)
	{
		super.draw(g);
		move();
		if(!satellite)
		{
			drawTrace(g);
		}
	}
	
	public void move()
	{
		x = center.x + center.width / 2 + longAxis * Math.cos(degree);
		y = center.y + + center.height / 2 + shortAxis * Math.sin(degree);
		
		degree += speed;
	}
	
	public void drawTrace(Graphics g)
	{
		double ovalX,ovalY,ovalWidth,ovalHeight;
		
		ovalWidth = longAxis * 2;
		ovalHeight = shortAxis * 2;
		ovalX = center.x + center.width / 2 - longAxis;
		ovalY = center.y + center.height / 2 - shortAxis;
		
		Color c = g.getColor();
		g.setColor(Color.BLUE);
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
		g.setColor(c);
	}
}
