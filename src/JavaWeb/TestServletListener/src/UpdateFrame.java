import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class UpdateFrame extends AddFrame { //继承AddFrame的控件和部分方法
	Page page = null;
	public UpdateFrame() {
		super();
		setTitle("修改记录");
		btnOK.setText("修改");
		
		for(ActionListener listener : btnOK.getActionListeners()) {
			btnOK.removeActionListener(listener);
		}
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "确认修改？") == JOptionPane.OK_OPTION) {
					if(btnIn.isSelected()){
						page.setType("收入");
					}
					else if(btnOut.isSelected()){
						page.setType("支出");
					}
					page.setItem(listItem.getSelectedIndex() == 0 ? 
							(String) listItem.getSelectedItem() : names[listItem.getSelectedIndex() - 1]);
					page.setAmount(Integer.valueOf(txtAmount.getText()));
					page.setInfo(txtInfo.getText());
					int result = JDBC.updatePage(page);
					if(result != 0) {
						JOptionPane.showMessageDialog(null, "修改成功");
						Program.mainFrame.setData(JDBC.getPages());
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "修改失败");
					}
				}
			}
		});
	}
	
	public void setPage(int id) {
		page = JDBC.getPage(id);
		if(page.getType().equals("收入")) {
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
