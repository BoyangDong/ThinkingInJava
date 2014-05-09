package GUI.day22GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyMenuDemo {
	
	private Frame f;
	private MenuBar mb;
	private Menu m, subMenu;
	private TextArea ta;
	private MenuItem openItem, saveItem, closeItem, subItem;
	
	private FileDialog openDia, saveDia;
	private File file; 
	
	MyMenuDemo(){
		init(); 
	}
	public void init(){
		f = new Frame("my window");
		f.setBounds(300, 100, 650, 600);
		
		mb = new MenuBar();
		m = new Menu("File");
		openItem = new MenuItem("open");
		saveItem = new MenuItem("save");
		
		subMenu = new Menu("subMenu");
		
		closeItem = new MenuItem("exit");
		subItem = new MenuItem("subItem");
		ta = new TextArea();
		
		subMenu.add(subItem); 
		m.add(openItem);
		m.add(saveItem);
		m.add(subMenu);
		m.add(closeItem);
		mb.add(m);
		
		f.setMenuBar(mb);
		f.add(ta);
		openDia = new FileDialog(f,"file open",FileDialog.LOAD);
		saveDia = new FileDialog(f,"file save",FileDialog.SAVE);
		
		myEvent();
		f.setVisible(true);
	}
	private void myEvent(){
		
		saveItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				if(file == null){
					saveDia.setVisible(true);
					String dirPath = saveDia.getDirectory();
					String fileName = saveDia.getFile();
					if(dirPath==null || fileName==null) return; 
					
					file = new File(dirPath, fileName);
 				}
				try{
					BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
					String text = ta.getText();
					bufw.write(text);
					bufw.close();
				}catch(IOException e1){
					e1.printStackTrace();
				}			
			}			
		});		
		openItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				openDia.setVisible(true);
				String dirPath = openDia.getDirectory();
				String fileName = openDia.getFile();
				System.out.println(dirPath+"..."+fileName);
				
				if(dirPath==null || fileName ==null) return;
				
				ta.setText("");
				
			    file = new File(dirPath, fileName);
				
				try{
					BufferedReader bufr = new BufferedReader(new FileReader(file));
					String line = null;
					while((line = bufr.readLine()) != null){
						ta.append(line+"\r\n");
					}
					bufr.close();
				}catch(IOException e1){
					e1.printStackTrace();
				}
				
			}			
		});		
		closeItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMenuDemo(); 
	}
}
