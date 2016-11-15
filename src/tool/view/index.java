package tool.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class index
{
	private int time=0;
	private JTextField text;
	private static JTextField text1;
	private static Date dateFuture=new Date();
	JFrame frame=new JFrame("Tools For Better Life");
	
	public Container init()
	{
		
		System.out.println((new File("")).getAbsolutePath());
		try
		{
			System.out.println((new File("")).getCanonicalPath());
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setSize(600, 160);
//		frame.setLocation(700,250);
		frame.setLocation(new Point(700,500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container=frame.getContentPane();		
		GridLayout layout=new GridLayout(0,3);
		container.setLayout(layout);
		
		JLabel label=new JLabel("几分钟之后关机");
		JLabel label1=new JLabel("当前时间");		
	    text=new JTextField("");
		 text1=new JTextField("");
		JButton button=new JButton("确定");
		JButton button1=new JButton("确定");
		
		container.add(label);
		container.add(text);
		container.add(button);
		container.add(label1);
		container.add(text1);
		
		container.add(button1);
		frame.setVisible(true);
		System.out.println("init()");
		return container;
	}
	
	public void hideV()
	{
		frame.setVisible(false);
	}
	

	
//	public static void main(String[] args) throws InterruptedException
//	{
//		index ind=new index();
//		ind.init();
//		Thread.sleep(3000);
////		ind.hideV();
//		SubRename subR=new SubRename();
////		subR.init();
//
//		
//	}

}
