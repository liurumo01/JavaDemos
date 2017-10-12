public class Program {
	public static MainFrame mainFrame;
	
	public static void main(String[] args) {
		LoginFrame loginFrame = new LoginFrame();
		mainFrame = new MainFrame();
		loginFrame.setVisible(true);
	}
}
