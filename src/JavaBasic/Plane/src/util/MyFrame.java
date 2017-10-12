package util;

import javax.swing.JFrame;

public class MyFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	 protected PaintThread th;

	public void launchFrame() {
		
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(100,100);
		setVisible(true);
		
		th = new PaintThread();
		th.start();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public class PaintThread extends Thread {
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
