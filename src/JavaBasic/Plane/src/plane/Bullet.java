package plane;

import java.awt.Color;
import java.awt.Graphics;

import util.Constant;

public class Bullet extends GameObject
{
	double degree;

	public Bullet()
	{
		degree = Math.random() * Math.PI * 2;
		x = Constant.GAME_WIDTH / 2;
		y = Constant.GAME_HEIGHT / 2;
		width = height = 8;
		speed = 3;
	}
	
	public void draw(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval((int)x, (int)y, width, height);
		
		x += speed * Math.cos(degree);
		y += speed * Math.sin(degree);
		
		if(y > Constant.GAME_HEIGHT - width || y < 30)
		{
			degree = -degree;
		}
		if(x < 0 || x > Constant.GAME_WIDTH - 30)
		{
			degree = Math.PI - degree;
		}
		
		g.setColor(c);
	}
}
