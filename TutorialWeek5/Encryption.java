import java.util.Random;
import java.lang.Short;
public class Encryption 
{
	short[] keys;
	static Random rnd = new Random();
	
	
	short getKey()
	{
		return (short)(rnd.nextInt()%Short.MAX_VALUE); 
	}
	
	public String encrypt(String p)
	{
		keys = new short[p.length()];
		char[] array_p = p.toCharArray();
		
		for(int i = 0; i < array_p.length; i++)
		{
			keys[i] = getKey();
			array_p[i] = (char)(array_p[i]^keys[i]);
		}
		
		return new String(array_p);
	}
	
	public String decrypt(String p)
	{
		char[] array_p = p.toCharArray();
		
		for(int i = 0; i <array_p.length;i++)
		{
			array_p[i] = (char)(array_p[i]^keys[i]);
		}
		
		return new String(array_p);
	}
	
	

	public static void main(String[] args) 
	{
		String str = "QWERTYUIOP";
		
		Encryption enc = new Encryption();
		String enc_str = enc.encrypt(str);
		System.out.println(enc_str);
		System.out.println(enc.decrypt(enc_str));
		

	}

}
