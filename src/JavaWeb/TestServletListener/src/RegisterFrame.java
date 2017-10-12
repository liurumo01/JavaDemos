import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class RegisterFrame extends ResetFrame { //�̳�RestFrame�Ŀؼ��Ͳ��ַ������������±�д���ô��ڣ�����д�¼���Ӧ����
	public RegisterFrame() {
		setTitle("�û�ע��");
		btnOK.setText("ע��");
		
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
							JOptionPane.showMessageDialog(null, "ע��ɹ�");
						}
						else {
							JOptionPane.showMessageDialog(null, "ע��ʧ��");
						}
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "�û����Ѿ����ڣ�");
					}
				}
			}
		});
	}
}
