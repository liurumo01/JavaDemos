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
	
	protected String[] names = { "����","��ʳ"}; //ѡ������
	
	public AddFrame() {
		super(); // �̳и���Ĺ��췽��
		initFont(); //��������
		setTitle("��Ӽ�¼"); // ���ô���ı���
		setBounds(100, 100, 400, 400); // ���ô������ʾλ�ü���С
		initControls(); //���ؿؼ�
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// ���ô���رհ�ť�Ķ���Ϊ�رյ�ǰ����
		setResizable(false); //��ֹ�ı��С
	}
	
	private void initControls() {
		setLayout(null); // ����Ϊ�������κβ��ֹ�����
		
		lbType = new JLabel("���ͣ�"); // �����ؼ�����
		lbItem = new JLabel("��Ŀ��");
		lbAmount = new JLabel("��");
		lbInfo = new JLabel("��ע��");
		groupType = new ButtonGroup();
		btnIn = new JRadioButton("����");
		btnOut = new JRadioButton("֧��");
		listItem = new JComboBox<String>(names);
		txtAmount = new JTextField();
		txtInfo = new JTextArea();
		btnOK = new JButton("ȷ��");
		btnCancel = new JButton("ȡ��");
		
		lbType.setBounds(20, 20, 100, 40); // ���ÿؼ�����ʾλ�ü���С
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
		
		txtInfo.setColumns(15); //�������ÿؼ���Ϣ
		txtInfo.setRows(3);
		
		groupType.add(btnIn);
		groupType.add(btnOut);
		btnIn.setSelected(true);
		
		listItem.setEditable(true);
		
		add(lbType); //���ؼ���ӵ�����
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
		
		btnOK.addActionListener(new ActionListener() { //����ť����¼�����
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "ȷ����ӣ�") == JOptionPane.OK_OPTION) {
					Page page = new Page();
					if(btnIn.isSelected()){
						page.setType("����");
					}
					else if(btnOut.isSelected()){
						page.setType("֧��");
					}
					page.setItem((String) listItem.getSelectedItem());
					page.setAmount(Integer.valueOf(txtAmount.getText()));
					page.setInfo(txtInfo.getText());
					int result = JDBC.addPage(page);
					if(result != 0) {
						Program.mainFrame.setData(JDBC.getPages());
						JOptionPane.showMessageDialog(null, "��ӳɹ�");
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "���ʧ��");
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
		FontUIResource fontUIResource = new FontUIResource(new Font("΢���ź�",Font.PLAIN,20));
	    for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) { //��������
	        Object key = keys.nextElement();
	        Object value= UIManager.get(key);
	        if (value instanceof FontUIResource) { //��������
	            UIManager.put(key, fontUIResource);
	        }  
	    }
	}
}
