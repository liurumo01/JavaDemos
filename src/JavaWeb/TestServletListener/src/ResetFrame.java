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
public class ResetFrame extends JFrame {
	protected JLabel lbUsername;
	protected JLabel lbPassword;
	protected JLabel lbComfirmPassword;
	
	protected JTextField txtUsername;
	protected JPasswordField txtPassword;
	protected JPasswordField txtConfirmPassword;
	
	protected JButton btnOK;
	protected JButton btnCancel;
	
	public ResetFrame(){
		super("�޸�����");
		initFont();
		setSize(400,300);
		initControls();
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initControls() {
		lbUsername = new JLabel("�û���");
		lbPassword = new JLabel("����");
		lbComfirmPassword = new JLabel("ȷ������");
		txtUsername = new JTextField();
		txtPassword = new JPasswordField();
		txtConfirmPassword = new JPasswordField();
		btnOK = new JButton("����");
		btnCancel = new JButton("ȡ��");
		
		setLayout(null);
		lbUsername.setBounds(50, 20, 80, 40);
		lbPassword.setBounds(50, 80, 80, 40);
		lbComfirmPassword.setBounds(50, 140, 80, 40);
		txtUsername.setBounds(150, 20, 180, 40);
		txtPassword.setBounds(150,80,180,40);
		txtConfirmPassword.setBounds(150,140,180,40);
		btnOK.setBounds(80,200,100,40);
		btnCancel.setBounds(220,200,100,40);
		
		add(lbUsername);
		add(lbPassword);
		add(lbComfirmPassword);
		add(txtUsername);
		add(txtPassword);
		add(txtConfirmPassword);
		add(btnOK);
		add(btnCancel);
		
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(check()) {
					Account account = JDBC.getAccount(txtUsername.getText());
					if(account == null) {
						JOptionPane.showMessageDialog(null, "�û������ڣ�");
						return;
					}
					else {
						account.setKey(String.valueOf(txtPassword.getPassword()));
						JDBC.updateAccount(account);
						dispose();
					}
				}
			}
		});
	}
	
	private void initFont()
	{
		FontUIResource fontUIResource = new FontUIResource(new Font("΢���ź�",Font.PLAIN,20));
	    for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
	        Object key = keys.nextElement();
	        Object value= UIManager.get(key);
	        if (value instanceof FontUIResource) {
	            UIManager.put(key, fontUIResource);
	        }  
	    }
	}
	
	protected boolean check() { //����û���Ϣ�Ƿ�Ϸ�
		if(txtUsername.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "�������û�����");
			return false;
		}
		if(String.valueOf(txtPassword.getPassword()).equals("")) {
			JOptionPane.showMessageDialog(null, "���������룡");
			return false;
		}
		if(String.valueOf(txtConfirmPassword.getPassword()).equals("")) {
			JOptionPane.showMessageDialog(null, "��ȷ�����룡");
			return false;
		}
		if(!String.valueOf(txtPassword.getPassword()).equals(String.valueOf(txtConfirmPassword.getPassword()))) {
			JOptionPane.showMessageDialog(null, "������������벻һ����");
			return false;
		}
		return true;
	}
}
