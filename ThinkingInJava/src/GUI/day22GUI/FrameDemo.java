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
		//��frame���л�������
		f = new Frame("my frame");
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());
		but = new Button("My Button");
		//�������ӵ�frame��
		f.add(but);
		//���ش����ϵ��¼�
		myEvent();
		//��ʾ����
		f.setVisible(true);		
	}
	private void myEvent(){
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}			
		});
		//�ð�ť�߱��˳�����Ĺ���
		//��ť�����¼�Դ
		/*ѡ����һ����������
		 * ͨ���رմ����˽⵽����Ҫ֪���ĸ�����߱�ʲô�������м�����
		 * ��Ҫ�鿴���������Ĺ���
		 * ͨ������button������ ���ְ�ť֧��һ�����еļ��� addActionListener
		 * */
		/*�����ڲ���*/
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
