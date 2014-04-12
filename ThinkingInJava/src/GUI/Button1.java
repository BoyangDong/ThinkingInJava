package GUI;

import javax.swing.*;
import java.awt.*;
import static GUI.SwingConsole.*;

@SuppressWarnings("serial")
public class Button1 extends JFrame {
	private JButton
		b1 = new JButton("button 1"),
		b2 = new JButton("button 2");
	public Button1(){
		setLayout(new FlowLayout());
		//setLayOut() causes the controls to flow evenly
		//onto the form, left to right and top to bottom 
		add(b1);
		add(b2);
	}
	public static void main(String[] args) {
		run(new Button1(), 200,100);
	}

}
