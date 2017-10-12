import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class UpdateFrame extends AddFrame { //�̳�AddFrame�Ŀؼ��Ͳ��ַ���
	Page page = null;
	public UpdateFrame() {
		super();
		setTitle("�޸ļ�¼");
		btnOK.setText("�޸�");
		
		for(ActionListener listener : btnOK.getActionListeners()) {
			btnOK.removeActionListener(listener);
		}
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "ȷ���޸ģ�") == JOptionPane.OK_OPTION) {
					if(btnIn.isSelected()){
						page.setType("����");
					}
					else if(btnOut.isSelected()){
						page.setType("֧��");
					}
					page.setItem(listItem.getSelectedIndex() == 0 ? 
							(String) listItem.getSelectedItem() : names[listItem.getSelectedIndex() - 1]);
					page.setAmount(Integer.valueOf(txtAmount.getText()));
					page.setInfo(txtInfo.getText());
					int result = JDBC.updatePage(page);
					if(result != 0) {
						JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
						Program.mainFrame.setData(JDBC.getPages());
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "�޸�ʧ��");
					}
				}
			}
		});
	}
	
	public void setPage(int id) {
		page = JDBC.getPage(id);
		if(page.getType().equals("����")) {
			btnIn.setSelected(true);
		}
		else {
			btnOut.setSelected(true);
		}
		listItem.setSelectedItem(page.getItem());
		txtAmount.setText(String.valueOf(page.getAmount()));
		txtInfo.setText(page.getInfo());
		
	}
}
