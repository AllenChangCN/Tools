package tool.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Basic
{
	public static JFrame frame=new JFrame("Tools For Better Life");
	public JMenuBar menuBar=new JMenuBar();
//	public static JPanel panel=new JPanel();
	
	public void init()
	{
		frame.setSize(600, 200);
//		panel.setSize(500, 200);
//		panel.setBackground(Color.pink);
//		frame.setLocation(700,250);
		frame.setLocation(new Point(600,400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container=frame.getContentPane();	
		JMenu menu=new JMenu("menu");
		JMenuItem menuItem1=new JMenuItem("定时关机");
		JMenuItem menuItem2=new JMenuItem("字幕修改");
		menuItem1.addActionListener(new timeAction());
		menuItem2.addActionListener(new subActionListener());
		frame.setJMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(menuItem1);
		menu.add(menuItem2);

//		container.add(panel);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		Basic basic=new Basic();
		basic.init();
		Timer timer=new Timer();
//		timer.getBasicPanel(basic.panel);
//		frame.add(timer.panel);
		timer.show();
//		Thread.sleep(5000);
//		timer.hide();
	}
	

}
