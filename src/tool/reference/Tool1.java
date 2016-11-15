package tool.reference;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Tool1
{
	private int time=0;
	private JTextField text;
	private static JTextField text1;
	private static Date dateFuture=new Date();
//	private  Date dateStart=new Date();
	void init() throws IOException
	{
//		创建底层窗口、获取容器、指定布局管理器
//		Image icon = new Image("./icon/title.jpg");
//		Image img = Toolkit.getDefaultToolkit().getImage ("D:\\我的坚果云\\workstation\\PCTools\\src\\icon\\title.jpg");
		Image img = Toolkit.getDefaultToolkit().getImage("./src/icon/title.jpg");
//		Image img = Toolkit.getDefaultToolkit().getImage(((new File("")).getCanonicalPath())+"/icon/title.jpg");
		JFrame frame=new JFrame("Tools For Better Life");
		System.out.println((new File("")).getAbsolutePath());
		try
		{
			System.out.println((new File("")).getCanonicalPath());
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setIconImage(img);  
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
		button.addActionListener(new MyActionListener()
//		{
//			public void actionPerformed(ActionEvent arg0)
//			{
//			String textStr=text.getText();
//			}
//		}
		);
		JButton button1=new JButton("确定");
		
		container.add(label);
		container.add(text);
		container.add(button);
		container.add(label1);
		container.add(text1);
		
		container.add(button1);
		frame.setVisible(true);
	}
	
	class MyActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			// TODO Auto-generated method stub
			String textStr=text.getText();
			System.out.println(textStr);
			time=Integer.parseInt(textStr);
			Date dateStart=new Date();
			Calendar cal=Calendar.getInstance();
			cal.setTime(dateStart);
			cal.add(Calendar.MINUTE, time);
			dateFuture=cal.getTime();
			System.out.println(dateFuture);
			
		}
		
	}
	
	public static void main(String []args) throws IOException
	{
		Tool1 tool=new Tool1();
		tool.init();
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
					
					System.out.println();
					System.out.println(dateFuture);
					System.out.println(current_date);
					System.out.println(current_time.equals(future_time));
//					System.out.println(format.format(current_date));
//					System.out.println(format.format(dateFuture));
					
					if(current_time.equals(future_time))
					{
						text1.setText("hellow");
						try
						{
							Thread.sleep(5000);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
//			thread.start();
		};
		thread.start();
		
	}
}
