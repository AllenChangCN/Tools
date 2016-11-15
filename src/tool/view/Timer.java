package tool.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Timer
{
	public JTextField nowText=new JTextField("当前时间");
	public static  JPanel  panel=new JPanel();
	JTextField text;
	JTextField text1;
	JLabel shutTimeLable;
	private static Date dateFuture=new Date();
	
	public JPanel basicPanel;

	public void getBasicPanel(JPanel panel)
	{
		this.basicPanel=panel;
	}
	
	public void show()
	{
//		Container container=basicPanel.getRootPane();		
		GridLayout layout=new GridLayout(0,3);
		panel.setLayout(layout);
		
		
		JLabel label=new JLabel("几分钟之后关机");
		JLabel label1=new JLabel("当前时间以及下次关机时间");		
		text=new JTextField("");
		text1=new JTextField("");
		shutTimeLable=new JLabel("");
		JButton button=new JButton("确定");
		button.addActionListener(new MyActionListener());
		
		panel.add(label);
		panel.add(text);
		panel.add(button);
		panel.add(label1);
		panel.add(text1);	
		panel.add(shutTimeLable);
//		container.add(button1);
		Basic.frame.add(panel);
		addCurrentThread();
		panel.setVisible(true);
	}
	
	public void addCurrentThread()
	{
		Thread thread =new Thread(){
			public void run()
			{
				while(true){
					try
					{
						Thread.sleep(1000);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Date current_date=new Date();
					DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String current_time=format.format(current_date); 
					String future_time=format.format(dateFuture); 
					text1.setText(current_time);
					shutTimeLable.setText(future_time);
					
					System.out.println();
					System.out.println(dateFuture);
					System.out.println(current_date);
					System.out.println(current_time.equals(future_time));
//					System.out.println(format.format(current_date));
//					System.out.println(format.format(dateFuture));
					
					if(current_time.equals(future_time))
					{
						try
						{
							Runtime.getRuntime().exec("shutdown /s /t 0");
						} catch (IOException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
//						text1.setText("hellow");
//						try
//						{
//							Thread.sleep(5000);
//						} catch (InterruptedException e)
//						{
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
					}
				}
			}
//			thread.start();
		};
		thread.start();
	}
	public  static void   hide()
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
			String textStr=text.getText();
			System.out.println(textStr);
			int time=Integer.parseInt(textStr);
			Date dateStart=new Date();
			Calendar cal=Calendar.getInstance();
			cal.setTime(dateStart);
			cal.add(Calendar.MINUTE, time);
			dateFuture=cal.getTime();
			System.out.println(dateFuture);
			
		}
		
	}
	
}
