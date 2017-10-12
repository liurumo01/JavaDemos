import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
public class AddFrame extends JFrame{
	protected JLabel lbType;
	protected JLabel lbItem;
	protected JLabel lbAmount;
	protected JLabel lbInfo;
	
	protected ButtonGroup groupType;
	protected JRadioButton btnIn;
	protected JRadioButton btnOut;
	
	protected JComboBox<String> listItem;
	protected JTextField txtAmount;
	protected JTextArea txtInfo;
	
	protected JButton btnOK;
	protected JButton btnCancel;
	
	protected String[] names = { "娱乐","饮食"}; //选项数组
	
	public AddFrame() {
		super(); // 继承父类的构造方法
		initFont(); //设置字体
		setTitle("添加记录"); // 设置窗体的标题
		setBounds(100, 100, 400, 400); // 设置窗体的显示位置及大小
		initControls(); //加载控件
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置窗体关闭按钮的动作为关闭当前窗口
		setResizable(false); //禁止改变大小
	}
	
	private void initControls() {
		setLayout(null); // 设置为不采用任何布局管理器
		
		lbType = new JLabel("类型："); // 创建控件对象
		lbItem = new JLabel("项目：");
		lbAmount = new JLabel("金额：");
		lbInfo = new JLabel("备注：");
		groupType = new ButtonGroup();
		btnIn = new JRadioButton("收入");
		btnOut = new JRadioButton("支出");
		listItem = new JComboBox<String>(names);
		txtAmount = new JTextField();
		txtInfo = new JTextArea();
		btnOK = new JButton("确认");
		btnCancel = new JButton("取消");
		
		lbType.setBounds(20, 20, 100, 40); // 设置控件的显示位置及大小
		lbItem.setBounds(20, 70, 100, 40);
		lbAmount.setBounds(20, 120, 100, 40);
		lbInfo.setBounds(20, 170, 100, 40);
		btnIn.setBounds(150, 20, 80, 40);
		btnOut.setBounds(250, 20, 80, 40);
		listItem.setBounds(150, 70, 200, 40);
		txtAmount.setBounds(150, 120, 200, 40);
		txtInfo.setBounds(150, 170, 200, 120);
		btnOK.setBounds(50, 310, 120, 40);
		btnCancel.setBounds(200, 310, 120, 40);
		
		txtInfo.setColumns(15); //补充设置控件信息
		txtInfo.setRows(3);
		
		groupType.add(btnIn);
		groupType.add(btnOut);
		btnIn.setSelected(true);
		
		listItem.setEditable(true);
		
		add(lbType); //将控件添加到窗口
		add(lbItem);
		add(lbAmount);
		add(lbInfo);
		add(btnIn);
		add(btnOut);
		add(listItem);
		add(txtAmount);
		add(txtInfo);
		add(btnOK);
		add(btnCancel);
		
		btnOK.addActionListener(new ActionListener() { //给按钮添加事件监听
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "确认添加？") == JOptionPane.OK_OPTION) {
					Page page = new Page();
					if(btnIn.isSelected()){
						page.setType("收入");
					}
					else if(btnOut.isSelected()){
						page.setType("支出");
					}
					page.setItem((String) listItem.getSelectedItem());
					page.setAmount(Integer.valueOf(txtAmount.getText()));
					page.setInfo(txtInfo.getText());
					int result = JDBC.addPage(page);
					if(result != 0) {
						Program.mainFrame.setData(JDBC.getPages());
						JOptionPane.showMessageDialog(null, "添加成功");
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "添加失败");
					}
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	private void initFont()
	{
		FontUIResource fontUIResource = new FontUIResource(new Font("微软雅黑",Font.PLAIN,20));
	    for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) { //遍历属性
	        Object key = keys.nextElement();
	        Object value= UIManager.get(key);
	        if (value instanceof FontUIResource) { //设置字体
	            UIManager.put(key, fontUIResource);
	        }  
	    }
	}
}
