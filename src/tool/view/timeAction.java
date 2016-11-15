package tool.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class timeAction implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		SubRename.hide();
		Timer timer=new Timer();
		timer.show();
	}

}
