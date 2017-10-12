
@SuppressWarnings("serial")
public class ViewFrame extends UpdateFrame { //继承UpdateFrame的控件和部分方法
	public ViewFrame() {
		setTitle("查看详情");
		remove(btnOK);
		remove(btnCancel);
		setSize(400,360);
	}
}
