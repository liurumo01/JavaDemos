import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private JLabel lbUser;
	private JLabel lbTime;	
	private JScrollPane dataPane;
	private JTable tb;	
	private JPanel jpPage;
	private JPanel jpOperation;	
	private JButton[] btnOperation;
	private JButton[] btnPage;
	
	public MainFrame()
	{
		initFont();
		setTitle("��Ŀ����");
		setSize(1000,800);
		initControls();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setData(JDBC.getPages());
	}
	
	private void initControls()
	{
		setLayout(null);
		
		String[] textOperation = new String[] {"����","ɾ��","�޸�","��ѯ","�˳�"};
		btnOperation = new JButton[5];
		jpOperation = new JPanel();
		jpOperation.setLayout(null);
		jpOperation.setSize(200, 500);
		jpOperation.setLocation(750, 200);
		for(int i=0;i<5;i++)
		{
			btnOperation[i] = new JButton(textOperation[i]);
			btnOperation[i].setSize(120,40);
			btnOperation[i].setLocation(40,50 + 90 * i);
			jpOperation.add(btnOperation[i]);
			btnOperation[i].addActionListener(new ButtonAction());
		}
		add(jpOperation);
		
		String[] textPage = new String[] {"��","��"};
		btnPage = new JButton[2];
		jpPage = new JPanel();
		jpPage.setLayout(null);
		jpPage.setSize(600, 100);
		jpPage.setLocation(75,600);
		for(int i=0;i<2;i++)
		{
			btnPage[i] = new JButton(textPage[i]);
			btnPage[i].setSize(150, 40);
			btnPage[i].setLocation(140 + 220 * i,30);
			jpPage.add(btnPage[i]);
		}
		add(jpPage);
		
		lbUser = new JLabel();
		lbUser.setSize(200,100);
		lbUser.setLocation(100,20);
		add(lbUser);
		
		lbTime = new JLabel();
		lbTime.setSize(450,100);
		lbTime.setLocation(500,20);
		add(lbTime);
		
		ActionListener taskPerformer = new ActionListener() //ʹ�ü�ʱ��ˢ��ʱ����ʾ
		{
			public void actionPerformed(ActionEvent evt)
			{
				Calendar calendar = Calendar.getInstance();
				lbTime.setText("����ʱ����  " + String.format("%d��%d��%d�� %2d:%02d:%02d",
						calendar.get(Calendar.YEAR),
						calendar.get(Calendar.MONTH),
						calendar.get(Calendar.DATE),
						calendar.get(Calendar.HOUR_OF_DAY),
						calendar.get(Calendar.MINUTE),
						calendar.get(Calendar.SECOND)));
			}
		};
		new Timer(1000, taskPerformer).start();
	}
	
	public void setUser() {
		lbUser.setText("��ӭ " + Account.account.getName());
	}
	
	private void initFont()
	{
		FontUIResource fontUIResource = new FontUIResource(new Font("΢���ź�",Font.PLAIN, 20));
	    for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
	        Object key = keys.nextElement();
	        Object value= UIManager.get(key);
	        if (value instanceof FontUIResource) {
	            UIManager.put(key, fontUIResource);
	        }  
	    }
	}
	
	public void setData(Object[][] data) //�������ݱ�������
	{
		if(dataPane != null)
		{
			remove(dataPane);
		}
		tb = new JTable(data,new String[] {"����","��֧","��Ǯ","��Ŀ"});
		tb.setRowHeight(30);
		tb.setVisible(true);
		dataPane = new JScrollPane(tb);
		dataPane.setSize(600,450);
		dataPane.setLocation(75,100);
		add(dataPane);
	}
	
	class ButtonAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int id;
			switch(e.getActionCommand()) {
			case "����":
				AddFrame addFrame = new AddFrame();
				addFrame.setVisible(true);
				break;
			case "ɾ��":
				id = tb.getSelectedRow() + 1;
				if(id == 0) {
					JOptionPane.showMessageDialog(null, "δѡ���κ��");
					return;
				}
				int result = JDBC.deletePage(id);
				if(result != 0) {					
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					setData(JDBC.getPages());
				}
				else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
				}
				break;
			case "�޸�":
				id = tb.getSelectedRow() + 1;
				if(id == 0) {
					JOptionPane.showMessageDialog(null, "δѡ���κ��");
					return;
				}
				UpdateFrame updateFrame = new UpdateFrame();
				updateFrame.setPage(id);
				updateFrame.setVisible(true);
				break;
			case "��ѯ":
				id = tb.getSelectedRow() + 1;
				if(id == 0) {
					JOptionPane.showMessageDialog(null, "δѡ���κ��");
					return;
				}
				ViewFrame viewFrame = new ViewFrame();
				viewFrame.setPage(id);
				viewFrame.setVisible(true);
				break;
			case "�˳�":
				dispose();
				break;
			}
		}
	}
}
