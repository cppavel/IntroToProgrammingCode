import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public class WorkWithFiles {

	public static void toDocument(FileWriter fw)
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter file = new BufferedWriter(fw);
		try
		{
			String line;
			while((line = input.readLine())!=null&&!line.equals("quit"))
			{
				file.write(line+" ");
			}	
			file.close();
			input.close();
			
		}
		catch(Exception e)
		{
			System.err.print(e);
		}
	
		
		
	}
	
	public static void ls(String inputDir) throws NullPointerException
	{
		File dir = new File(inputDir);
		
		File [] files = dir.listFiles();
		
		for(int i = 0 ;i<files.length;i++)
		{
			System.out.println(files[i].getName()+ " " +files[i].length());
		}
	}
	public static void main(String[] args) 
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			String fileName = input.readLine();
			FileWriter fw = new FileWriter(fileName);
			toDocument(fw);
			fw.close();
			String dir = "C:\\Users\\HYPER\\Pictures\\Новая папка";
			ls(dir);
		}
		catch(Exception e)
		{
			System.err.print(e);
		}
		
	
	}

}
