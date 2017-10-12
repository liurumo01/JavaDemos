import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class RegisterFrame extends ResetFrame { //继承RestFrame的控件和部分方法，避免重新编写设置窗口，并重写事件响应方法
	public RegisterFrame() {
		setTitle("用户注册");
		btnOK.setText("注册");
		
		for(ActionListener listener : btnOK.getActionListeners()) {
			btnOK.removeActionListener(listener);
		}
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(check()) {
					Account account = JDBC.getAccount(txtUsername.getText());
					if(account == null) {
						account = new Account();
						account.setName(txtUsername.getText());
						account.setKey(String.valueOf(txtPassword.getPassword()));
						if(JDBC.addAccount(account) != 0) {							
							JOptionPane.showMessageDialog(null, "注册成功");
						}
						else {
							JOptionPane.showMessageDialog(null, "注册失败");
						}
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "用户名已经存在！");
					}
				}
			}
		});
	}
}
