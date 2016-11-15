package tool.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tool.view.Timer.MyActionListener;

public class SubRename
{
//	public JTextField subDir=new JTextField("subtitle DIR");
//	public JPanel basicPanel;
	public  static  JPanel panel=new JPanel();
	public JLabel videoDirLab=new JLabel("视频目录");
	public JTextField videoDir=new JTextField();
	public JButton videoButton=new JButton("浏览");
	public JLabel subDirLab=new JLabel("字幕目录");
	public JTextField subDir=new JTextField();
	public JButton SubButton=new JButton("浏览");
	public JButton button=new JButton("修改");
	public String videoPath;
	public String subPath;
	
//	public void getBasicPanel(JPanel panel)
//	{
//		this.basicPanel=panel;
//	}
	
	public void show()
	{
//		Container container=basicPanel.getRootPane();		
		GridLayout layout=new GridLayout(0,3);
		panel.setLayout(layout);
		panel.add(videoDirLab);
		panel.add(videoDir);
		videoButton.addActionListener(new FileChooser());
		panel.add(videoButton);
		panel.add(subDirLab);
		panel.add(subDir);
		SubButton.addActionListener(new FileChooser());
		panel.add(SubButton);
		button.addActionListener(new MyActionListener());
		panel.add(button);



//		panel.add(subDir);
		Basic.frame.add(panel);
		panel.setVisible(true);
	}
	
	public static void  hide()
	{
		panel.removeAll();
		panel.repaint();
		panel.setVisible(false);
	}
	
	class MyActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			// TODO Auto-generated method stub
			videoPath=videoDir.getText();
			System.out.println(videoPath);
			subPath=subDir.getText();
			System.out.println(subPath);
			subModel model=new subModel();
			try
			{
				model.model(videoPath, subPath);
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}
	
//	class dirActionListener implements ActionListener
//	{
//
//		@Override
//		public void actionPerformed(ActionEvent e)
//		{
//			if(e.getSource()==videoButton)
//			{
//				
//			}
//			else
//			{
//				if(e.getSource()==SubButton)
//				{
//					System.out.println("SubButton");
//				}
//			}
//
//		}
//		
//	}
	
	public class FileChooser extends JFrame implements ActionListener{  
//	    JButton open=null;  
//	    public static void main(String[] args) {  
//	        new FileChooser();  
//	    }  
//	    public FileChooser(){  
//	        open=new JButton("open");  
//	        this.add(open);  
//	        this.setBounds(400, 200, 100, 100);  
//	        this.setVisible(true);  
//	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//	        open.addActionListener(this);  
//	    }  
	    @Override  
	    public void actionPerformed(ActionEvent e) {  
	        // TODO Auto-generated method stub  
	    	if(e.getSource()==videoButton)
				{
		    		JFileChooser jfc=new JFileChooser();  
			        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
			        jfc.showDialog(new JLabel(), "选择");  
			        File file=jfc.getSelectedFile(); 
			        String videoTmp=file.getAbsolutePath();
			        videoDir.setText(videoTmp);
				}
				else
				{
					if(e.getSource()==SubButton)
					{
						JFileChooser jfc=new JFileChooser();  
				        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
				        jfc.showDialog(new JLabel(), "选择");  
				        File file=jfc.getSelectedFile(); 
				        String subTmp=file.getAbsolutePath();
				        subDir.setText(subTmp);
					}
				}
	    	
//	        JFileChooser jfc=new JFileChooser();  
//	        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
//	        jfc.showDialog(new JLabel(), "选择");  
//	        File file=jfc.getSelectedFile();  
//	        if(file.isDirectory()){  
//	            System.out.println("文件夹:"+file.getAbsolutePath());  
//	        }else if(file.isFile()){  
//	            System.out.println("文件:"+file.getAbsolutePath());  
//	        }  
//	        System.out.println(jfc.getSelectedFile().getName());  
	          
	    }  
	  
	}  

}
