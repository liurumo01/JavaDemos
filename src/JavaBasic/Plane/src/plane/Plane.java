package plane;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import util.GameUtil;

public class Plane extends GameObject
{
	private boolean left;
	private boolean up;
	private boolean right;
	private boolean down;
	
	private boolean alive;

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void draw(Graphics g)
	{
		if(alive)
		{
			g.drawImage(img, (int)x, (int)y, null);
			move();
		}
	}
	
	public Plane(String imgPath, double x, double y)
	{
		super();
		alive = true;
		this.img = GameUtil.getImage(imgPath);
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.x = x;
		this.y = y;
		speed = 10;
	}
	
	public void addDirection(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		}
	}
	
	public void minusDirection(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		}
	}
	
	public void move()
	{
		if(left)
		{
			x -= speed;
		}
		if(right)
		{
			x += speed;
		}
		if(up)
		{
			y -= speed;
		}
		if(down)
		{
			y += speed;
		}
	}
}
