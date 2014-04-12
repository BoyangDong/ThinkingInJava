package GUI;

import javax.swing.*;

import java.util.concurrent.*;

@SuppressWarnings("serial")
public class SumbitSwingProgram extends JFrame {
	
	JLabel label;
	public SumbitSwingProgram(){
		super("Hello Swing");
		label = new JLabel("A Label");
		add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,100);
		setVisible(true);
	}
	static SumbitSwingProgram ssp; 
	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){ssp = new SumbitSwingProgram();}
		});		// TODO Auto-generated method stub
		TimeUnit.SECONDS.sleep(1);
		//sleep is not inside the constructor, if we put it there, 
		//the JLabel text never appears, it'll messes the event dispatch thread 
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				ssp.label.setText("Hey, something different");
			}	
		});
	}
}
