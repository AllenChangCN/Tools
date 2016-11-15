package tool.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class subActionListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		Timer.hide();
		SubRename subRename=new SubRename();
		subRename.show();
	}

}
