package GUI.day22GUI;

import java.awt.*;
import java.awt.event.*;

class MouseAndKeyEvent {
	
	private Frame f;
	private Button but;
	private TextField tf; 

	MouseAndKeyEvent(){
		init();		
	}
	public void init(){
		//对frame进行基本设置
		f = new Frame("my frame");
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());
		tf = new TextField(10);
		
		
		but = new Button("My Button");
		//将组件添加到frame中
		f.add(but);
		f.add(tf);
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
		
		
		
		tf.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				int code = e.getKeyCode();
				if(!(code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9)){
					System.out.println("illegal");
					e.consume();
				}
			}			
		});
		
		but.addMouseListener(new MouseAdapter(){
			private int i = 0; 
			public void mouseEntered(MouseEvent e){
				if(e.getClickCount()==2){
					System.out.println("double clicks");
				}
				System.out.println("mouse "+(i++));
			}			
		});
		but.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if(e.isControlDown() &&	e.getKeyCode()==KeyEvent.VK_ESCAPE)
					System.exit(0);
				System.out.println(KeyEvent.getKeyText(e.getKeyCode())
						+"...."+e.getKeyCode());
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseAndKeyEvent(); 
	}

}
