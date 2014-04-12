package codes;

import java.util.concurrent.*;
import javax.swing.*;

public class HelloWorld {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Hello Swing");
		final JLabel label = new JLabel("A Label");
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this tells the JFrame what to do when the user executes a shutdown
		//maneuver, the Exit_On_Close constant tells it to exit the program  
		frame.setSize(300,100);
		//set the size of window in pixels 
		frame.setVisible(true);
		TimeUnit.SECONDS.sleep(3);
		//with this function, user is no longer manipulating the JLable
		//directly, instead, submit a Runnable, and event dispatch thread will 
		//do the actual manipulation, when it gets to that task in the event queue
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				label.setText("Hey this is different");
			}
		});
		
	}

}
