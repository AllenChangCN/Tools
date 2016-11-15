package tool.reference;
import java.io.File;
import java.io.IOException;

public class ReName1
{
	public static void main(String[] args) throws IOException
	{
		ReName1 rename = new ReName1();
		String vedioPath="D:/迅雷下载/The.Big.Bang.Theory.S03.720p.BluRay.x264-SiNNERS/vedio";
		String subPath="D:/迅雷下载/The.Big.Bang.Theory.S03.720p.BluRay.x264-SiNNERS/123";
		String[] newNames=rename.getFileNames(vedioPath);

		File[] filesSub=(new File(subPath)).listFiles();
		for(int i=0;i<filesSub.length;i++)
		{
			int markE=filesSub[i].getName().indexOf("E");		
			int EpondNum=Integer.parseInt(filesSub[i].getName().substring(filesSub[i].getName().indexOf("E")+1,filesSub[i].getName().indexOf("E")+3));
			StringBuffer strBuf=new StringBuffer();
			strBuf.append(newNames[EpondNum-1]);
			
			rename.changeNames(filesSub[i], strBuf.append(".ass").toString());
		}

		

	}
	
	public String[] getFileNames(String rootPath)
	{
//		String rootPath=new File("").getCanonicalPath();
		File[] files=(new File(rootPath)).listFiles();
		System.out.println(rootPath);
		String[] nameList=new String[files.length];
		System.out.println(files.length);
		for(int i=0;i<files.length;i++)
		{
			int markE=files[i].getName().indexOf("E");		
			int EpondNum=Integer.parseInt(files[i].getName().substring(files[i].getName().indexOf("E")+1,files[i].getName().indexOf("E")+3));
			int lastDot=files[i].getName().lastIndexOf(".");
			StringBuffer strBuf=new StringBuffer();
			strBuf.append(files[i].getName());
			strBuf.delete(lastDot, files[i].getName().length());
			
			nameList[EpondNum-1]=strBuf.toString();
			System.out.println("第"+EpondNum+"集");
			System.out.println("origin_name "+strBuf.toString());
		}
		return nameList;
		
	}
	
	public void  changeNames(File file,String newName)
	{
		File renameFile=new File(file.getParentFile(),newName);
		file.renameTo(renameFile);
	}
}
