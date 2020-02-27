
public class StackMain 
{

	public static void main(String[] args) 
	{
		Stack st = new Stack();
		for(int i = 1;i<=10;i++)
		{
			st.push(i);
		}
		st.print();
		st.pop();
		st.print();
		System.out.println(st.peek());
		System.out.println(st.search(3));
		st.move(3);
		st.print();
		
		

	}

}
