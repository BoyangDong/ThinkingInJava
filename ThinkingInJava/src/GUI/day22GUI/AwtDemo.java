package GUI.day22GUI;

import java.awt.*;
import java.awt.event.*;

public class AwtDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("my frame");
        f.setSize(500, 400);
        f.setLocation(300, 200);
        f.setLayout(new FlowLayout());
        Button b = new Button("Button");
        f.add(b);
        //f.addWindowListener(new MyWin());
        f.addWindowListener(new WindowAdapter(){
        	public void windowClosing(WindowEvent e){
        	//	System.out.println("closing..");
        		System.exit(0);
        	}        	
        	public void windowActivated(WindowEvent e){
        		
        	}
        	public void windowOpened(WindowEvent e){
        		
        	}
        });
        f.setVisible(true);        
	}
}
/*��ΪWindowListener������WindowAdapter�Ѿ�ʵ����WindowListener�ӿ�
 * ���������������з�������ôֻ��̳�WindowAapter���ǵķ������� * 
 * */
class MyWin extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		//System.out.println("closing---"+e.toString());
		System.exit(0);	
	}
}
