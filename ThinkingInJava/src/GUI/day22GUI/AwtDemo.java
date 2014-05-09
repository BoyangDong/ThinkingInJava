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
/*因为WindowListener的子类WindowAdapter已经实现了WindowListener接口
 * 并覆盖了其中所有方法，那么只需继承WindowAapter覆盖的方法即可 * 
 * */
class MyWin extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		//System.out.println("closing---"+e.toString());
		System.exit(0);	
	}
}
