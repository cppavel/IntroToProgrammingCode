import java.util.ArrayList;


public class Stack 
{
	private ArrayList<Integer> st;
	
	public Stack()
	{
		st = new ArrayList<Integer>();
	}
	
	public void push(int element)
	{
		st.add(element);
	}
	
	public void pop()
	{
		if(!st.isEmpty()) 
		{	
			st.remove(st.size()-1);
		}
	}
	
	public int peek()
	{
		int ret = -1;
		if(!st.isEmpty()) 
		{		
			ret = st.get(st.size()-1);
		}
		return ret;
	}
	
	public int search(int element)
	{
		for(int i = st.size()-1;i>=0;i--)
		{
			if(element==st.get(i))
			{
				return st.size()-1-i;
			}
		}
		
		return - 1;	
	}
	
	public void move(int element)
	{
		int index = this.search(element);
		if(index !=-1)
		{
			int actualIndex = st.size()-1-index;
			this.st.remove(actualIndex);
			this.st.add(element);
		}
	}
	
	public void print()
	{
		System.out.println();
		for(int i = st.size()-1;i>=0;i--)
		{
			System.out.println(st.get(i));
		}
		System.out.println();
		
	}
	
	
	
	
}
