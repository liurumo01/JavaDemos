package plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import util.GameUtil;
import util.MyFrame;

public class PlaneGameFrame extends MyFrame
{
	private static final long serialVersionUID = 1L;
	
	Image bg = GameUtil.getImage("images/bg.jpg");
	Plane p = new Plane("images/plane.png", 50, 50);
	
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	
	Date startTime;
	Date endTime;
	
	Explode exp;

	public void paint(Graphics g)
	{
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		
		for(int i=0;i<bulletList.size();i++)
		{
			Bullet b = bulletList.get(i);
			b.draw(g);
						
			boolean crash = b.getRectangle().intersects(p.getRectangle());
			if(crash)
			{
				p.setAlive(false);
				if(exp == null)
				{
					endTime = new Date();
					exp = new Explode(p.x,p.y);
					exp.draw(g);
				}
				break;
			}
		}
		if(!p.isAlive())
		{
			//printInfo(g,"Game Over!",50,100,200,Color.WHITE);
			
			int period = (int) ((endTime.getTime() - startTime.getTime()) / 1000);
			
			switch(period / 10)
			{
			case 0:
			case 1:
				printInfo(g,"菜鸟",50,100,200,Color.WHITE);
				break;
			case 2:
				printInfo(g,"小鸟",50,100,200,Color.WHITE);
				break;
			case 3:
				printInfo(g,"大鸟",50,100,200,Color.WHITE);
				break;
			case 4:
				printInfo(g,"鸟王子",50,100,200,Color.WHITE);
				break;
			default:
				printInfo(g,"鸟人",50,100,200,Color.WHITE);
				break;
			}
			
			printInfo(g,"生存时间:" + period + "秒",20,100,260,Color.WHITE);			
		}
		//printInfo(g,"分数：100",20,50,50,Color.GREEN);
	}
	
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color)
	{
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("宋体",Font.BOLD,size);
		g.setFont(f);
		g.drawString(str,x,y);
		g.setColor(c);
	}
	
	public static void main(String[] args)
	{
		PlaneGameFrame f = new PlaneGameFrame();
		f.launchFrame();
	}
	
	public void launchFrame()
	{
		startTime = new Date();
		super.launchFrame();
		addKeyListener(new KeyMonitor());
		
		for(int i=0;i<20;i++)
		{
			Bullet b = new Bullet();
			bulletList.add(b);
		}
	}
	
	class KeyMonitor extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			p.addDirection(e);
		}

		public void keyReleased(KeyEvent e)
		{
			p.minusDirection(e);
		}
		
	}
}
