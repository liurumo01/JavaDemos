import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {
	private JLabel lbUsername;
	private JLabel lbPassword;
	
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	
	private JButton btnLogin;
	private JButton btnReset;
	private JButton btnRegister;
	
	public LoginFrame()
	{
		initFont();
		setTitle("”√ªßµ«¬º");
		setSize(400,300);
		setResizable(false);
		initControls();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initFont()
	{
		FontUIResource fontUIResource = new FontUIResource(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN, 20));
	    for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
	        Object key = keys.nextElement();
	        Object value= UIManager.get(key);
	        if (value instanceof FontUIResource) {
	            UIManager.put(key, fontUIResource);
	        }  
	    }
	}
	
	private void initControls()
	{
		lbUsername = new JLabel("’À∫≈");
		lbPassword = new JLabel("√‹¬Î");
		txtUsername = new JTextField();
		txtPassword = new JPasswordField();
		txtPassword.setEchoChar('*');
		
		btnLogin = new JButton("µ«¬º");
		btnReset = new JButton("–ﬁ∏ƒ√‹¬Î");
		btnRegister = new JButton("◊¢≤·’À∫≈");
		
		lbUsername.setSize(50,40);
		lbPassword.setSize(50,40);
		txtUsername.setSize(200, 40);
		txtPassword.setSize(200, 40);
		btnLogin.setSize(150,40);
		btnReset.setSize(130,40);
		btnRegister.setSize(130,40);
		
		lbUsername.setLocation(50,40);
		lbPassword.setLocation(50,100);
		txtUsername.setLocation(150,40);
		txtPassword.setLocation(150,100);
		btnLogin.setLocation(125, 160);
		btnReset.setLocation(50, 210);
		btnRegister.setLocation(220, 210);
		
		setLayout(null);
		add(lbUsername);
		add(lbPassword);
		add(txtUsername);
		add(txtPassword);
		add(btnLogin);
		add(btnReset);
		add(btnRegister);
		
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = txtUsername.getText();
				String key = new String(txtPassword.getPassword());
				if((Account.account = JDBC.getAccount(name)) != null) {
					if(key.equals(Account.account.getKey())) {
						Program.mainFrame.setUser();
						Program.mainFrame.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "√‹¬Î¥ÌŒÛ£°");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "”√ªß≤ª¥Ê‘⁄£°");
				}
			}
		});
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResetFrame resetFrame = new ResetFrame();
				resetFrame.setVisible(true);
			}
		});
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterFrame registerFrame = new RegisterFrame();
				registerFrame.setVisible(true);
			}
		});
	}
}
