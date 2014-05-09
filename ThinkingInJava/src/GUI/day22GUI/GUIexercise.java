package GUI.day22GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class GUIexercise {

	private Dialog d; 
	private Label lab; 
	private Button okButton; 

	private Frame f;
	private TextField tf;
	private TextArea ta;
	private Button but; 
	String text = "";

	GUIexercise(){
		init();
		myEvent();
	}
	private void myEvent(){

		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				d.setVisible(false);				
			}
		});

		but.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				showDir(); 			
			}    		
		}); 	
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}    		
		});
		d.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				d.setVisible(false);
			}
		});
		tf.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					showDir();
				}
			}
		});
	}    
	private void showDir(){
		String dirPath = tf.getText();
		File dir = new File(dirPath);
		if(dir.exists() && dir.isDirectory()){
			tf.setText("");
			String[] names = dir.list();
			for(String name:names){
				ta.append(name+"\r\n");
			}
		}else{
			String info = "Ya directory "+"\'"+dirPath+"\'"+" is wrong";
			lab.setText(info);
			d.setVisible(true);
		}	
	}
	void init(){
		d = new Dialog(f,"prompt",true);
		lab = new Label();
		d.setBounds(400,300,240,150);
		d.setLayout(new FlowLayout());
		okButton = new Button("Yes"); 
		d.add(lab);
		d.add(okButton);

		f = new Frame("my frame");
		tf = new TextField(60);
		ta = new TextArea(25,70);
		but = new Button("act");
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());
		f.add(tf);
		f.add(but);
		f.add(ta);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUIexercise(); 
	}
}


