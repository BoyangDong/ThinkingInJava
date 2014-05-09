package GUI.day22GUI;
import java.awt.*;
import java.awt.event.*;

class FrameDemo {
	
	private Frame f;
	private Button but;

	FrameDemo(){
		init();		
	}
	public void init(){
		//对frame进行基本设置
		f = new Frame("my frame");
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());
		but = new Button("My Button");
		//将组件添加到frame中
		f.add(but);
		//加载窗体上的事件
		myEvent();
		//显示窗体
		f.setVisible(true);		
	}
	private void myEvent(){
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}			
		});
		//让按钮具备退出程序的功能
		//按钮就是事件源
		/*选择哪一个监听器？
		 * 通过关闭窗体了解到，想要知道哪个组件具备什么样的特有监听器
		 * 需要查看该组件对象的功能
		 * 通过查阅button的描述 发现按钮支持一个特有的监听 addActionListener
		 * */
		/*匿名内部类*/
		but.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println();
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FrameDemo(); 
	}

}
