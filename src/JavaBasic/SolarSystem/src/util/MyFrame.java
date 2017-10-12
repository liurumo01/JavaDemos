package util;

import javax.swing.JFrame;

public class MyFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	public void launchFrame() {
		
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(100,100);
		setVisible(true);
		
		new PaintThread().start();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class PaintThread extends Thread {
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
